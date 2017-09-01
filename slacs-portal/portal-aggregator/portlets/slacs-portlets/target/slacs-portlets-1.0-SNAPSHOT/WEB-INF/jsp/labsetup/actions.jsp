<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@ include file="../init.jsp"%>
<%      
 ResultRow row = (ResultRow)
        request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW); 

 
 LabDetails lab= (LabDetails) row.getObject();
 
%>

<liferay-portlet:renderURL varImpl="rowURL">
	<portlet:param name="backURL" value="<%=currentURL%>" />
	<portlet:param name="action" value="labRecord" />
	<portlet:param name="labId" value="<%=String.valueOf(lab.getLabId()) %>" />
</liferay-portlet:renderURL>
<portlet:actionURL var="deleteURL">
	<portlet:param name="labId" value="<%=String.valueOf(lab.getLabId()) %>" />
	<portlet:param name="action" value="delete"/>
</portlet:actionURL>
<portlet:actionURL var="activateURL">
	<portlet:param name="labId" value="<%=String.valueOf(lab.getLabId()) %>" />
	<portlet:param name="action" value="activation"/>
	<portlet:param name="activate" value="<%=String.valueOf(!lab.getStatus()) %>"/>
</portlet:actionURL>
<liferay-ui:icon-menu>
 <liferay-ui:icon image="edit" message="edit"
  url="${rowURL }" />
  <liferay-ui:icon-delete url="${deleteURL }"></liferay-ui:icon-delete>
  <% if(lab.getStatus()) { %>
   	<liferay-ui:icon-deactivate label="deactivate" url="${activateURL }"></liferay-ui:icon-deactivate>
  <% } else { %>
  	<liferay-ui:icon image="activate" message="activate" url="${activateURL }" />
  <% } %>
</liferay-ui:icon-menu>
