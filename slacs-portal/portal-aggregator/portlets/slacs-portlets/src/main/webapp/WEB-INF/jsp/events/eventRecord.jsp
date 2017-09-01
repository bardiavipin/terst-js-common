<%@page import="com.liferay.portal.kernel.util.CalendarFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="java.util.TimeZone"%>
<%@ include file="/jsp/init.jsp"%>

<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title"><liferay-ui:message key="add-event" /></h4>
			</div>
			<div class="modal-body">
				<portlet:resourceURL id="event.add.update" var="addEventURL"/>

				<div>
					<div class="widget-content">
						<aui:form method="post" action="${addEventURL}">
							<input type="hidden" name="labId" value="${labDetail.labId }" />
							<input type="hidden" name="eventId" value="${event.eventId }" />
							<input type="hidden" name="timeZone" value="${timeZone1 }" />
							<span class="label label-info separator"><liferay-ui:message key="event-info" />:</span>
							<br />

							<div class="input-prepend">
								<span class="add-on"><i class="icon-edit"></i></span>
								<select id="selLab" name="selLab" class="width250">
									<option value="-1"><liferay-ui:message key="select-lab" /></option>
									<c:forEach items="${labDetails}" var="labDetailVar">
										<c:if test="${labDetailVar.status }">
											<option value="${labDetailVar.labId}"
												<c:if test="${labDetailVar.labId eq labDetail.labId}">selected</c:if>>${labDetailVar.title}</option>
										</c:if>
									</c:forEach>
								</select>
							</div>

							<div class="input-prepend display-block">
								<span class="add-on"><i class="icon-edit"></i></span>
								<input class="width250" type="text" name="title" id="title"
									placeholder='<liferay-ui:message key="event-title" />'
									value="${event.title }" />
							</div>

							<div class="input-prepend display-block">
								<span class="add-on" style="height: 40px;"><i class="icon-edit"></i></span>
								<textarea style="resize:horizontal" class="width250" name="description" id="description"
									placeholder="<liferay-ui:message key='event-desc' />">${event.description } </textarea>
							</div>

							<div class="input-prepend">
								<span class="add-on"><i class="icon-edit"></i></span>
								<select id="activityType" name="selActivity" class="width250">
									<option value="-1"><liferay-ui:message key='activity-type' /></option>
									<c:forEach items="${activityType }" var="type">
										<option value="${type }"
											<c:if test="${type eq event.activityType}">selected</c:if>>${type }</option>
									</c:forEach>
								</select>
							</div>
							<div id="timeDetails">
								<span class="label label-info separator"><liferay-ui:message
										key="duration" />:</span> <br />
								<div>
									<input type="checkbox" name="fullDay" id="fullDay"
										<c:if test="${event.fullDay}">checked</c:if> value="fullDay" />
									<span><liferay-ui:message key="full-day" /></span>
								</div>

								<div class="input-prepend margin-top">
									<label class="control-label" for="from"> <liferay-ui:message
										key="start-date" /> </label>
									<span class="add-on"><i class="icon-edit"></i></span>
									<input class="datepicker span4" type="text" name="from" id="from"
										placeholder='<liferay-ui:message key="date" />'
										value="<fmt:formatDate pattern="MM/dd/yyyy" value="${event.startTime }" />" />
										<input class="timepicker span3 margin-left" type="text" name="fromTime" id="fromTime"
										placeholder='<liferay-ui:message key="time" />'
										value="<fmt:formatDate pattern="HH:mm" value="${event.startTime }" />" />
								</div>

								<div class="input-prepend to-details">
									<label class="control-label" for="from"> <liferay-ui:message
										key="end-date" /> </label>
									<span class="add-on"><i class="icon-edit"></i></span>
									<input class="datepicker span4" type="text" name="to" id="to"
										placeholder='<liferay-ui:message key="date" />'
										value="<fmt:formatDate pattern="MM/dd/yyyy" value="${event.endTime }" />" />
										<input class="timepicker span3 margin-left" type="text" name="toTime" id="toTime"
										placeholder='<liferay-ui:message key="time" />'
										value="<fmt:formatDate pattern="HH:mm" value="${event.endTime }" />" />
								</div>
							</div>
							<c:if test="${event.eventId ne 0}">
								<div>
									<span class="label label-info separator"><liferay-ui:message
											key="portal-crendetials" />:</span> <br />
									<div>
										<div class="input-prepend display-block float-left margin-right">
											<span class="add-on"></span>
											<input class="width250" type="text" name="portalUser"
												id="portalUser" readonly="readonly" value="${event.portalUser }" />
										</div>
		
										<div class="input-prepend">
											<span class="add-on"></span>
											<input class="width100" type="text" name="portalPass"
												id="portalPass" readonly="readonly" value="${event.portalPass }" />
										</div>
									</div>
		
									<span class="label label-info separator"><liferay-ui:message
												key="nc-crendetials" />:</span> <br />
									<div>
										<div class="input-prepend display-block float-left margin-right">
											<span class="add-on"></span>
											<input class="width250" type="text" name="ncUser" id="ncUser" readonly="readonly" value="${event.ncUser }" />
										</div>
		
										<div class="input-prepend">
											<span class="add-on"></span>
											<input class="width100" type="text" name="ncPass" id="ncPass" readonly="readonly" value="${event.ncPass }" />
										</div>
									</div>
								</div>
							</c:if>

							<div>
								<button id="btnSubmit" type="submit" onclick="Liferay.fire('event.add.update', {sender: $(this)});return false;" class="btn btn-success btn-block">
									<liferay-ui:message key="event-register" />
									<i class="icon-ok"></i>
								</button>
							</div>
						</aui:form>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			</div>
		</div>

	</div>
</div>

<aui:script>

	$( document ).ready(function() {
		disableTime();
	});

	YUI().use(
		  'aui-datepicker',
		  function(Y) {
		    new Y.DatePicker(
		      {
		        trigger: '.datepicker',
		        popover: {
		          zIndex: 9999
		        },
		        on: {
		          selectionChange: function(event) {/* 
		        	  var date = new Date(event.newSelection);
		        	  var now = new Date();
		        	  if(date < now){
		        		 $("#from").val('');
		        		 $("#from").addClass("error-input");
		        	  }
		        	  if($("#to").val()!=''){
			        	  var toDate = new Date($("#to").val());
			        	  var fromDate = new Date($("#from").val());
			        	  if(fromDate >= toDate){
			        		  console.log("result");
			        		 $("#from").val('');
			        		 $("#from").addClass("error-input");
			        	  }
		        	   }*/
		          }
		        }
		      }
		    );
		  }
		);
	YUI().use(
			  'aui-timepicker',
			  function(Y) {
			    new Y.TimePicker(
			      {
			        trigger: '.timepicker',
			        mask: '%H:%M',
			        popover: {
			          zIndex: 9999
			        },
			        on: {
			          selectionChange: function(event) {
			            //console.log(event.newSelection);
			          }
			        }
			      }
			    );
			  }
			);

	$("#fullDay").change(function () {
		disableTime();
     });
	
	function disableTime(){
		if($("#fullDay").is(":checked")){
			$(".timepicker").each(function () {
				$(this).attr("disabled", "disabled");
			});
		} else {
			$(".timepicker").each(function () {
				$(this).removeAttr("disabled");
			});
		}
	}
	
	Liferay.on('event.add.update', function (event) {
		var err=false;
		var notCheck = "";
		if($("#fullDay").is(":checked")){
			notCheck = ".timepicker";
		}
		$('#myModal input:text, #myModal select').not(notCheck).each(function () {
			if($(this).val()=='' || $(this).val()=='-1'){
				err = true;
				$(this).addClass("error-input");
			} else {
				$(this).removeClass("error-input");
			}
		});
		console.log("err : " +err);
		if(!err){
			$("#btnSubmit").attr("disabled",true);
            var sender = event.sender;
            var form = sender.closest('.modal').find('form');
            $.ajax({
                url: form.attr("action"),
                type: form.attr("method"),
                data: form.serialize(),
                success: function (data) {
                   if(data!="SUCCESS"){
                	   alert("Operation failed");
                   } else {
	                   Liferay.fire("change.calendar", {"labId": $("#selLab").val(), "timeZone" : $("#timezone-selector").val()});
                   }
                   $(".modal-footer .btn.btn-default").trigger("click");
                }
            }).done(function () {
                });
		} else {
			return false;
		}
	});
</aui:script>

<style type="text/css">
	.width250{
	    width: 250px;
	}
	.width100{
	    width: 100px;
	}
	.display-block{
		display: block;
	}
	.error-input{
		border-color :red !important;
	}
	.margin-left{
		margin-left: 10px !important;
	}
	.margin-right{
		margin-right: 10px !important;
	}
	.margin-top{
		margin-top: 10px !important;
	}
	.float-left{
		float:left !important;
	}
</style>