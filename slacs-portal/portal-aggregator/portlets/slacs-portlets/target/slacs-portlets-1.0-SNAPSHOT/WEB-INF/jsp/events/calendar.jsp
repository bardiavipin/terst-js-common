<%@page import="java.util.ArrayList"%>
<%@page import="com.netcracker.scp.model.Events"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>
<portlet:defineObjects />
<%
List<Events> events = new ArrayList<Events>();
String strTimeZone = "";
if(renderRequest !=null){
	events = (List<Events>)renderRequest.getAttribute("events");
	strTimeZone = (String)renderRequest.getAttribute("timeZone1");
} else {
	events = (List<Events>)resourceRequest.getAttribute("events");
	strTimeZone = (String)resourceRequest.getAttribute("timeZone1");
}
DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
TimeZone timeZone1 = TimeZone.getTimeZone(strTimeZone);
Calendar calendar = new GregorianCalendar();
calendar.setTimeZone(timeZone1);
%>
<script type="text/javascript">

	$(document).ready(function() {
		var currentTimezone = false;
		// when the timezone selector changes, rerender the calendar
		$('#timezone-selector').on('change', function() {
			currentTimezone = this.value || false;
			$('#calendar').fullCalendar('destroy');
			renderCalendar();
		});
	
		function renderCalendar() {
			console.log("renderCalendar : " + currentTimezone);
			$('#calendar').fullCalendar({
				header: {
					left: 'prev,next today',
					center: 'title',
					right: 'month,agendaWeek,agendaDay'
				},
				defaultDate: new Date(),
				timezone: currentTimezone,
				editable: true,
				selectable: true,
				eventStartEditable : false,
				eventDurationEditable : false,
				eventLimit: true, // allow "more" link when too many events
				events: [
				         <%
				         	for(Events event : events){
				         		String start = null;
				         		String end = null;
				         		if(event.getFullDay()){
					         		start = dateFormat.format(event.getStartTime());
					         		end = dateFormat.format(event.getEndTime());
				         		} else {
				         			calendar.setTime(event.getStartTime());
				         			start =String.valueOf(calendar.getTime());
				         			
				         			calendar.setTime(event.getEndTime());
				         			end = String.valueOf(calendar.getTime());
				         		}
				         %>
				         	{
				         		id: <%=event.getEventId() %>,
								title: "<%=event.getTitle() %>"
								,start: "<%=start %>"
								<% if(event.getEndTime()!=null){%>
								,end: "<%=end %>"
								<% } %>
								},
				         <% } %>
							
				         ],
				loading: function(bool) {
					$('#loading').toggle(bool);
				},
				eventRender: function(event, el) {
					// render the timezone offset below the event title
					if (event.start.hasZone()) {
						el.find('.fc-title').after(
							$('<div class="tzo"/>').text(event.start.format('Z'))
						);
					}
				},
				dayClick: function(date) {
					console.log('dayClick', date.format());
				},
				select: function(startDate, endDate) {
					console.log('select', startDate.format(), endDate.format());
				},
				eventClick: function(calEvent, jsEvent, view) {

			       /*  alert('Event: ' + calEvent.title);
			        alert('Coordinates: ' + jsEvent.pageX + ',' + jsEvent.pageY);
			        alert('View: ' + view.name); */
			        Liferay.fire('add.edit.event.popup',{'eventId': calEvent.id})
			        // change the border color just for fun
			        $(this).css('border-color', 'red');

			    }
			});
		}
	
		renderCalendar();
	});
</script>

<style>
	#script-warning, #loading { display: none }
	#script-warning { font-weight: bold; color: red }

	#calendar {
		max-width: 900px;
		margin: 40px auto;
		padding: 0 10px;
	}

	.tzo {
		color: #000;
	}
	.fc-content{
		color : white;
	}
</style>

<div class='right'>
	<span id='loading'>loading...</span> <span id='script-warning'>Some
		issue while fetching records.</span>
</div>

<div id='calendar'></div>