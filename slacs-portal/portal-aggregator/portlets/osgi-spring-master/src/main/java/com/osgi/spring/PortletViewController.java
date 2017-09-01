/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.osgi.spring;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ReleaseInfo;


import com.netcracker.scp.lab.servicetracker.EventServiceTracker;
import org.apache.commons.lang3.text.WordUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Controller
@RequestMapping("VIEW")
public class PortletViewController {





	EventServiceTracker eventServiceTracker=null;
	@PostConstruct
	public void init() {
		System.out.println(" PostConstruct ");
		eventServiceTracker = new EventServiceTracker(this);
		eventServiceTracker.open();

	}

	@RenderMapping
	public String question(Model model) {
		model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());

		String className = WordUtils.capitalize("js-common/portlets/metricOperations.es", '/', '.', '-');
		System.out.println("classname "+className);
		className = WordUtils.uncapitalize(className).replaceAll("[\\W]", "");
		System.out.println("classname "+className);



		return "osgi-spring/view";
	}

	@ActionMapping(params = "action=actionOne")
	public void claimAgentUrl(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("tracker object : " + eventServiceTracker);

	}
	@PreDestroy
	public void destroy() {
		eventServiceTracker.close();
	}

}