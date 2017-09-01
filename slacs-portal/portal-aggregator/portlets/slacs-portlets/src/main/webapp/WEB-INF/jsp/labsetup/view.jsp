<%@ include file="../init.jsp"%>

<%


	if(themeDisplay.isSignedIn()) { %>

	<liferay-portlet:renderURL varImpl="iteratorURL" />
	
	<portlet:actionURL var="deleteAllURL">
		<portlet:param name="action" value="deleteAll"/>
	</portlet:actionURL>
	<portlet:renderURL var="addLabURL">
		<portlet:param name="action" value="labRecord"/>
	</portlet:renderURL>
	<form action="${deleteAllURL }" method="POST" >
		<div>
			<input type="button" onclick="location.href='${addLabURL}'" value="Add Lab" />
			<input type="submit" value="Delete" />
		</div>
	<liferay-ui:search-container emptyResultsMessage="there-are-no-records"
		iteratorURL="<%=iteratorURL%>" delta="10" rowChecker="<%=new RowChecker(renderResponse)%>">
		<liferay-ui:search-container-results total="${total }" results="${labDetails }" />
			
		<liferay-ui:search-container-row className="com.netcracker.scp.model.LabDetails" keyProperty="labId"
			modelVar="labRecord">
			<liferay-portlet:renderURL varImpl="rowURL">
				<portlet:param name="backURL" value="<%=currentURL%>" />
				<portlet:param name="action" value="labRecord" />
				<portlet:param name="labId" value="<%=String.valueOf(labRecord.getLabId())%>" />
			</liferay-portlet:renderURL>
			<liferay-ui:search-container-row-parameter name="rowURL"
				value="<%=rowURL.toString()%>" />
			<liferay-ui:search-container-column-text href="<%=rowURL%>"
				 property="title" />
	
			<liferay-ui:search-container-column-text href="<%=rowURL%>"
				property="description" />
	
			
			<liferay-ui:search-container-column-jsp align="left"
				name="Actions" path="/jsp/labsetup/actions.jsp" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" />
	</liferay-ui:search-container>
	</form>

<% } else { %>
	<div class="alert alert-info"> <liferay-ui:message key="available-for-signed-in-users" /></div>
<% } %>