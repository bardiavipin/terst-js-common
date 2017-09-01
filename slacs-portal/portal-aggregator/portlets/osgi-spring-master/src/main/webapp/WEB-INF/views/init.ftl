<#assign portlet=JspTaglibs["http://java.sun.com/portlet_2_0"]/>
<#assign aui=JspTaglibs["http://liferay.com/tld/aui"]/>
<#assign liferay_theme=JspTaglibs["http://liferay.com/tld/theme"]/>
<#assign liferay_ui=JspTaglibs["http://liferay.com/tld/ui"]/>
<#assign liferay_portlet=JspTaglibs["http://liferay.com/tld/portlet"]/>
<#assign liferay_security=JspTaglibs["http://liferay.com/tld/security"] />
<#assign liferay_util=JspTaglibs["http://liferay.com/tld/util"] />
<#setting locale="en_US" />
<@portlet.defineObjects/>
<@liferay_theme.defineObjects />

<#assign ns>
    <@portlet.namespace/>
</#assign>