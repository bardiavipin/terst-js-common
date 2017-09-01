<#include "../init.ftl">
<#if themeDisplay.isSignedIn()>
    <@liferay_portlet["renderURL"] varImpl="iteratorURL" />

    <@portlet.actionURL var="deleteAllURL">
        <@portlet.param name="action" value="deleteAll"></@portlet.param>
    </@portlet.actionURL>
    <@portlet.renderURL var="addLabURL">
        <@portlet.param name="action" value="labRecord"></@portlet.param>
    </@portlet.renderURL>

    <#assign labDetail = labDetails />
<form action="${deleteAllURL }" method="POST" >
    <div>
        <input type="button" onclick="location.href='${addLabURL}'" value="Add Lab" />
        <input type="submit" value="Delete" />
    </div>
    <@liferay_ui["search-container"] emptyResultsMessage="there-are-no-records"
    iteratorURL=(iteratorURL) >

    <@liferay_ui["search-container-results"]  results=(labDetail)  />
      <@liferay_ui["search-container-row"] className="com.netcracker.scp.model.LabDetails" keyProperty="labId"
                                   modelVar="labRecord">
     <#--<liferay-portlet:renderURL varImpl="rowURL">
          <portlet:param name="backURL" value="<%=currentURL%>" />
          <portlet:param name="action" value="labRecord" />
          <portlet:param name="labId" value="<%=String.valueOf(labRecord.getLabId())%>" />
      </liferay-portlet:renderURL>-->

      <<#--@liferay_ui["search-container-row-parameter"] name="Title" name="rowURL" />-->
      <@liferay_ui["search-container-row-parameter"] name="Title"
                                               property="title" />

      <@liferay_ui["search-container-column-text"] property="description"/>

      </@>
  <@liferay_ui["search-iterator"]  searchContainer="${searchContainer }" />


    </@>
</form>
<#else>
<div class="alert alert-info"> <@liferay_ui.message key= "available-for-signed-in-users"/></div>
</#if>




