<#include "../init.ftl">
<#if themeDisplay.isSignedIn()>

<table id="${ns}" >

        <#list mapObj?keys as prop>
        <tr>
            <td>${prop}</td>
            <td>${mapObj[prop]}</td>
        </tr>
        </#list>


</table>
<#else>
<h1>hellooo</h1>
</#if>