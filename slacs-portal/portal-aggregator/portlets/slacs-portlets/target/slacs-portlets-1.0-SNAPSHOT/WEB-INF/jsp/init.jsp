
<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="portlet" uri="http://java.sun.com/portlet" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker"%>
<%@page import="com.netcracker.scp.model.LabDetails"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.netcracker.scp.model.LabDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.netcracker.scp.model.Events"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />

<c:set var="ns">
	<portlet:namespace />
</c:set>

<%

	String currentURL = PortalUtil.getCurrentURL(request);
	String contextPath = "";
	if(renderRequest !=null){
		contextPath = renderRequest.getContextPath();
	} else {
		contextPath = resourceRequest.getContextPath();
	}
%>

