<%@ include file="../init.jsp"%>

<portlet:actionURL var="editEventURL">
	<portlet:param name="action" value="editEvents" />
</portlet:actionURL>

<aui:form method="post" action="${editEventURL}">

	<div id="status-fields">
		<c:set var="count" value="0" scope="page" />
		<c:forEach items="${statuses }" var="status">
			<c:if test="${not empty status }">
				<c:set var="count" value="${count + 1}" scope="page"/>
				<div class="lfr-form-row lfr-form-row-inline">
					<div class="row-fields">
						<div class="input-prepend">
							<aui:input type="text" name='status${count }'
								id='status${count }' label="" placeholder="Status"
								value="${status }" />
						</div>
					</div>
				</div>
			</c:if>
		</c:forEach>
	</div>
	<div>
		<button type="submit" class="btn btn-success btn-block">
			<liferay-ui:message key="submit" />
			<i class="icon-ok"></i>
		</button>
	</div>
</aui:form>


<aui:script use="liferay-auto-fields">
 new Liferay.AutoFields(
       {
           contentBox: '#status-fields',
           fieldIndexes: '<portlet:namespace />statusIndexes'
       }
   ).render();
</aui:script>