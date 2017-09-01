<%@page import="com.netcracker.scp.vo.DescUrlVO"%>
<%@page import="java.util.List"%>
<%@page import="com.netcracker.scp.lab.setup.businessdelegate.LabSetupBusinessDelegate"%>
<%@ include file="../init.jsp"%>


<portlet:actionURL var="addLabURL">
	<portlet:param name="action" value="addUpdateLab"/>
</portlet:actionURL>
<%
	LabDetails labdetail = (LabDetails)renderRequest.getAttribute("labDetail");
	List<DescUrlVO> descUrlVOs = LabSetupBusinessDelegate.convertObjectFromJson(labdetail.getOtherUrl());
%>

<div id="widget-box-${ns}" class="widget-box registration">
    <div class="widget-title">
        <h5><liferay-ui:message key="add-lab-record" /></h5>
    </div>

    <div class="widget-content">
	<aui:form method="post" action="${addLabURL}">
		<input type="hidden" name="labId" value="${labDetail.labId }" />
	    <br/>
	    <span class="label label-info separator"><liferay-ui:message key="lab-info" />:</span>
	    <br/>
	
	    <div class="input-prepend">
	          <span class="add-on">
	            <i class="icon-briefcase"></i>
	          </span>
	        <input class="span5" type="text" name="title" id="title" placeholder='<liferay-ui:message key="lab-title" />' value="${labDetail.title }" />
	    </div>
	    
	     <div class="input-prepend">
	          <span class="add-on" style="height:40px;">
	            <i class="icon-briefcase"></i>
	          </span>
	          <textarea class="span5" name="description" id="description"  placeholder='<liferay-ui:message key="lab-desc" />'>${labDetail.description } </textarea>
	    </div>
	    
	     <div class="input-prepend">
	          <span class="add-on">
	            <i class="icon-briefcase"></i>
	          </span>
	        <input class="span5" type="text" name="portalUrl" id="portalUrl" placeholder='<liferay-ui:message key="lab-portal-url" />' value="${labDetail.portalUrl }" />
	    </div>
	    
	     <div class="input-prepend">
	          <span class="add-on">
	            <i class="icon-briefcase"></i>
	          </span>
	        <input class="span5" type="text" name="ncUrl" id="ncUrl" placeholder='<liferay-ui:message key="lab-nc-url" />' value="${labDetail.ncUrl }" />
	    </div>
	    
	    <div class="input-prepend">
	          <span class="add-on">
	            <i class="icon-briefcase"></i>
	          </span>
	        <input class="span5" type="text" name="bassLink" id="bassLink"  placeholder='<liferay-ui:message key="lab-bass-url" />' value="${labDetail.bassLink }" />
	    </div>
	    
	    <div>
	    
	    <br/>
	    <span class="label label-info separator"><liferay-ui:message key="other-url" />:</span>
	    <br/>
	
		
		<div id="url-fields">
				<%
					for(int itr=0; itr<descUrlVOs.size();itr++) {
						DescUrlVO descUrlVO = descUrlVOs.get(itr);
								
				%>
					<div class="lfr-form-row lfr-form-row-inline">
			      			<div class="row-fields" style="margin-bottom:-67px;">
							   	 <div class="input-prepend">
							          <span class="add-on float-left">
							            <i class="icon-envelope"></i>
							          </span>
							          <aui:input cssClass="span3 float-left" type="text" name='<%="urlDesc" + itr %>' id='<%="urlDesc" + itr %>' placeholder="url-description" label="" value="<%=descUrlVO.getDescription() %>" />
							    </div>
							
							    <div class="input-prepend">
							          <span class="add-on float-left">
							            <i class="icon-phone"></i>
							          </span>
							          <aui:input cssClass="span3" type="text" name='<%="url" + itr %>' id='<%="url" + itr %>' label="" placeholder="url" value="<%=descUrlVO.getUrl() %>" />
							    </div>
					    	</div>
				    </div>
		    	<% } %>
	  	</div>
	    
	    <br/>
	    <span class="label label-info separator"><liferay-ui:message key="vim-credentials" />:</span>
	    <br/>
	
	    <div class="input-prepend">
	          <span class="add-on">
	            <i class="icon-envelope"></i>
	          </span>
	        <input class="span3" type="text" name="vimUser" id="vimUser" placeholder='<liferay-ui:message key="vim-user" />' value="${labDetail.vimUser }" />
	    </div>
	
	    <div class="input-prepend">
	          <span class="add-on">
	            <i class="icon-phone"></i>
	          </span>
	        <input class="span3" type="text" name="vimPass" id="vimPass" placeholder='<liferay-ui:message key="vim-pass" />' value="${labDetail.vimPass }" />
	    </div>
	
	
		<br/>
	    <span class="label label-info separator"><liferay-ui:message key="sdn-credentials" />:</span>
	    <br/>
	
	    <div class="input-prepend">
	          <span class="add-on">
	            <i class="icon-envelope"></i>
	          </span>
	        <input class="span3" type="text" name="sdnUser" id="sdnUser" placeholder='<liferay-ui:message key="sdn-user" />' value="${labDetail.sdnUser }" />
	    </div>
	
	    <div class="input-prepend">
	          <span class="add-on">
	            <i class="icon-phone"></i>
	          </span>
	        <input class="span3" type="text" name="sdnPass" id="sdnPass" placeholder='<liferay-ui:message key="sdn-pass" />' value="${labDetail.sdnPass }" />
	    </div>
	    
	    <div>
	        <button type="submit" class="btn btn-success btn-block"><liferay-ui:message key="lab-register" /> <i class="icon-ok"></i></button>
	        <button type="cancel" class="btn btn-block" onclick="javascript:window.history.back();"><liferay-ui:message key="cancel" /></button>
	    </div>
	    </div>
	</aui:form>
    </div>
</div>

<aui:script use="liferay-auto-fields">
 new Liferay.AutoFields(
       {
           contentBox: '#url-fields',
           fieldIndexes: '<portlet:namespace />urlIndexes'
       }
   ).render();
</aui:script>