<%@ include file="../init.jsp" %>
<script type="text/javascript" src="<%=contextPath %>/js/jquery-1.12.1.min.js" ></script>
<script type="text/javascript" src="<%=renderRequest.getContextPath() %>/js/jquery-ui.custom.min.js" ></script>
<script type="text/javascript" src="<%=renderRequest.getContextPath() %>/js/moment.min.js" ></script>
<script type="text/javascript" src="<%=renderRequest.getContextPath() %>/js/fullcalendar.min.js" ></script>
<script type="text/javascript" src="//maxcdn.bootstrapcdn.com/bootstrap/2.3.2/js/bootstrap.min.js"></script>
<link href="<%=renderRequest.getContextPath() %>/css/fullcalendar.css" rel="stylesheet" />
  
<% if(themeDisplay.isSignedIn()) { %>
<div>
	<select id="selLab" name="selLab">
		<option disabled="disabled"><liferay-ui:message key="event-select-lab" /></option>
		<c:forEach items="${labDetails}" var="labDetail">
			<c:if test="${labDetail.status }">
				<option value="${labDetail.labId}">${labDetail.title}</option>
			</c:if>
		</c:forEach>
	</select>
	<%@ include file="../events/select.jsp" %>
	<%-- <aui:input cssClass="calendar-portlet-time-zone-field" label="time-zone" name="timeZoneId" type="timeZone" value="" /> --%>
</div>
<div>
	<button type="button" class="btn btn-info btn-lg" onclick="Liferay.fire('add.edit.event.popup',{'eventId': 0})"><liferay-ui:message key="add-event" /></button>
</div>
<div id="modalEvent"></div>
<div id="calendar_replace">
	<%@ include file="../events/calendar.jsp" %>
</div>

<script type="text/javascript">

	$(function () {
		 $("#selLab").change(function () {
	         Liferay.fire("change.calendar", {"labId": $(this).val(), "timeZone" : $("#timezone-selector").val()});
	     });
		 $("#timezone-selector").change(function () {
	         Liferay.fire("change.calendar", {"labId": $("#selLab").val(), "timeZone" : $(this).val()});
	     });
		Liferay.on("change.calendar", function (event) {
		    //$shoppingcart.loader();
		    var labId = event['labId'];
		    var timeZone = event['timeZone'];
		    $.ajax({
		        type: "POST",
		        data: {labId: labId, timeZone:timeZone},
		        url: "<portlet:resourceURL id="change.calendar"/>",
		        success: function (data) {
		            $("#calendar_replace").html(data);
		        }
		    });
		});
		
		Liferay.on("add.edit.event.popup", function (event) {
		    //$shoppingcart.loader();
		    var eventId = event['eventId'];
		    $.ajax({
		        type: "POST",
		        data: {
		        	eventId: eventId,
		        	labId : $("#selLab").val(),
		        	timeZone : $("#timezone-selector").val()
		        	},
		        url: "<portlet:resourceURL id="add.edit.event.popup"/>",
		        success: function (data) {
		            $("#modalEvent").html(data);
		            $('#myModal').modal({ backdrop: 'static' });
		        }
		    });
		});
	});

</script>

<% } else { %>
	<div class="alert alert-info"> <liferay-ui:message key="available-for-signed-in-users" /></div>
<% } %>
