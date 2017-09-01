package com.netcracker.scp.lab.events;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.util.portlet.PortletProps;
import com.netcracker.scp.lab.constants.Constants;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ValidatorException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

@Controller
@RequestMapping("EDIT")
public class EventEditController {

	public static final Log LOGGER = LogFactoryUtil
			.getLog(EventEditController.class);

	@RenderMapping
	public String render(Model model, RenderRequest request,
			RenderResponse response) {
		LOGGER.info("stringConversionFromRequest : " + Constants.START);
		PortletPreferences preferences = request.getPreferences();
		List<String> statuses = new ArrayList<String>();
		String status = preferences.getValue("status", PortletProps.get("activity.type"));
		statuses = Arrays.asList(status.split(","));
		 
		model.addAttribute("statuses", statuses);
		LOGGER.info("stringConversionFromRequest : " + Constants.END);
		return "events/edit";
	}

	private String stringConversionFromRequest(ActionRequest request) {
		LOGGER.info("stringConversionFromRequest : " + Constants.START);
		String statusIndexesString = ParamUtil.getString(request,
				"statusIndexes");

		int[] statusIndexes = StringUtil.split(statusIndexesString, 0);

		StringBuilder builder = new StringBuilder();
		for (int statusIndex = 0; statusIndex < statusIndexes.length; statusIndex++) {
			String status = ParamUtil.getString(request, "status"
					+ statusIndexes[statusIndex]);
			if (!status.isEmpty()) {
				builder.append(statusIndexes[statusIndex]).append(",");
			}
		}

		LOGGER.info("stringConversionFromRequest : " + Constants.END);
		return builder.toString();
	}

	@ActionMapping(params = "action=editEvents")
	public void editEvents(Model model, ActionRequest request,
			ActionResponse response) throws ReadOnlyException,
			ValidatorException, IOException {
		LOGGER.info("editEvents : " + Constants.START);
		PortletPreferences preferences = request.getPreferences();
		preferences.setValue("status", stringConversionFromRequest(request));
		preferences.store();
		LOGGER.info("editEvents : " + Constants.END);
	}
}
