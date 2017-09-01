<%@include file="init.jsp" %>


<portlet:renderURL var="test">
    <portlet:param name="action" value="test"/>
</portlet:renderURL>

<%-- <portlet:renderURL var="test2">
<portlet:param name="action" value="test2"/>
</portlet:renderURL> --%>
<portlet:actionURL var="actionOneMethodURL">
    <portlet:param name="action" value="actionOne"/>
</portlet:actionURL>


<aui:form action="<%=actionOneMethodURL%>" name="addClaim" method="post">
    <aui:input name="name"/>
    <aui:input name="desig"/>
    <aui:input name="" type="submit" value="Submit"/>
</aui:form>


<p id="context"></p>

<aui:script require="js-module/logger.es">
    console.log("kkuch to call ho ja");
    var Logger = jsModuleLoggerEs.default;

    var loggerOne = new Logger('*** -> ');
    loggerOne.log('Hello');

    var loggerDefault = new Logger();
    loggerDefault.log('World');
</aui:script>
<%--<aui:script >--%>

    <%--AUI().use('liferay-portlet-url', 'aui-modal', 'aui-tabview','aui-dropdown', 'aui-tooltip', 'aui-ace-autocomplete-plugin', 'aui-ace-autocomplete-freemarker', function(Y) {--%>
        <%--$("#context").append("vipin");--%>
        <%--console.log("vipinbardia");--%>
        <%--var Logger = jsModuleLoggerEs.default;--%>

        <%--var loggerOne = new Logger('*** -> ');--%>
        <%--loggerOne.log('Hello');--%>

        <%--var loggerDefault = new Logger();--%>
        <%--loggerDefault.log('World');--%>
    <%--});--%>


<%--</aui:script>--%>
<%--<aui:script require="js-logger/logger.es">--%>
    <%--var Logger = jsLoggerLoggerEs.default;--%>

    <%--var loggerOne = new Logger('*** -> ');--%>
    <%--loggerOne.log('Hello');--%>

    <%--var loggerDefault = new Logger();--%>
    <%--loggerDefault.log('World');--%>
<%--</aui:script>--%>