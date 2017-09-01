package com.netcracker.scp.lab.events;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import com.liferay.util.portlet.PortletProps;
import com.netcracker.scp.lab.constants.Constants;
import com.netcracker.scp.lab.events.businessdelegate.EventsSetupBusinessDelegate;
import com.netcracker.scp.lab.servicetracker.EventServiceTracker;
import com.netcracker.scp.lab.servicetracker.LabDetailsServiceTracker;
import com.netcracker.scp.model.Events;
import com.netcracker.scp.model.LabDetails;
import com.netcracker.scp.service.EventsLocalService;
import com.netcracker.scp.service.EventsLocalServiceUtil;
import com.netcracker.scp.service.LabDetailsLocalService;
import com.netcracker.scp.service.LabDetailsLocalServiceUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

@Controller
@RequestMapping("VIEW")
public class EventsController {

	public static final Log LOGGER = LogFactoryUtil.getLog(EventsController.class);
	

	private EventsSetupBusinessDelegate eventsSetupBusinessDelegate;
	public void setEventsSetupBusinessDelegate(EventsSetupBusinessDelegate eventsSetupBusinessDelegate) {
		this.eventsSetupBusinessDelegate = eventsSetupBusinessDelegate;
	}

	EventServiceTracker eventServiceTracker=null;
	LabDetailsServiceTracker labDetailsServiceTracker=null;
	@PostConstruct
	public void init() {
		System.out.println(" PostConstruct ");
		eventServiceTracker = new EventServiceTracker(this);
		eventServiceTracker.open();

		labDetailsServiceTracker=new LabDetailsServiceTracker(this);
		labDetailsServiceTracker.open();
	}




    @RenderMapping
    public String render(Model model, RenderRequest request, RenderResponse response) throws SystemException, PortalException {
		List<LabDetails> labDetails=null;
		if(!labDetailsServiceTracker.isEmpty()){
			LabDetailsLocalService labDetailsLocalService =labDetailsServiceTracker.getService();
			labDetails= labDetailsLocalService.getLabDetailses(-1, -1);
			model.addAttribute("labDetails", labDetails);
		}
		if(!eventServiceTracker.isEmpty()){
			EventsLocalService eventsLocalService=eventServiceTracker.getService();
			if(labDetails!=null && labDetails.size()>0){
				model.addAttribute("events", eventsLocalService.findByLab(labDetails.get(0).getLabId(), labDetails.get(0).getCompanyId(), -1, -1));
			} else {
				model.addAttribute("events", new ArrayList<Events>());
			}
		}
    	model.addAttribute("timeZone1", "Asia/Calcutta");
        return "events/view";
    }
    
    @ResourceMapping("change.calendar")
    public String changeCalendar(Model model, @RequestParam long labId,@RequestParam String timeZone, ResourceRequest resourceRequest) throws SystemException {
    	LOGGER.info("changeCalendar : " + Constants.START);
    	LOGGER.info("labId : " + labId);
    	ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if(!eventServiceTracker.isEmpty()){
			EventsLocalService eventsLocalService=eventServiceTracker.getService();
			model.addAttribute("events", eventsLocalService.findByLab(labId, themeDisplay.getCompanyId(), -1, -1));
		}
    	model.addAttribute("timeZone1", timeZone);
    	LOGGER.info("changeCalendar : " + Constants.END);
    	return "events/calendar";
    }
    
    @ResourceMapping("add.edit.event.popup")
    public String eventPopup(Model model, @RequestParam long eventId,@RequestParam long labId,@RequestParam String timeZone, ResourceRequest resourceRequest) throws SystemException, PortalException {
    	LOGGER.info("eventPopup : " + Constants.START);
    	LOGGER.info("eventId : " + eventId + " labId : " + labId);
    	
    	PortletPreferences preferences = resourceRequest.getPreferences();
		List<String> statuses = new ArrayList<String>();
		String status = preferences.getValue("status", PortletProps.get("activity.type"));
		statuses = Arrays.asList(status.split(","));
		 
		model.addAttribute("activityType", statuses);
		model.addAttribute("timeZone1", timeZone);
		if(!labDetailsServiceTracker.isEmpty()){
			LabDetailsLocalService labDetailsLocalService =labDetailsServiceTracker.getService();
			model.addAttribute("labDetails", labDetailsLocalService.getLabDetailses(-1, -1));
			model.addAttribute("labDetail", labDetailsLocalService.getLabDetails(labId));
		}
		if(!eventServiceTracker.isEmpty()){
			EventsLocalService eventsLocalService=eventServiceTracker.getService();
			model.addAttribute("event", eventsSetupBusinessDelegate.getEvent(eventId,eventsLocalService));
		}

    	LOGGER.info("eventPopup : " + Constants.END);
    	return "events/eventRecord";
    }
    
    @ResourceMapping("event.add.update")
    public void addEditEvent(ResourceRequest request, ResourceResponse response) throws SystemException, PortalException, IOException {
		if (!eventServiceTracker.isEmpty()) {
			EventsLocalService eventsLocalService = eventServiceTracker.getService();
			LOGGER.info("addEditEvent : " + Constants.START);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long eventId = ParamUtil.getLong(request, "eventId");
			long labId = ParamUtil.getLong(request, "labId");
			String timeZone = ParamUtil.getString(request, "timeZone");
			Events events = eventsSetupBusinessDelegate.getEvent(eventId,eventsLocalService);
			// Audit
			events.setGroupId(themeDisplay.getScopeGroupId());
			;
			events.setCompanyId(themeDisplay.getCompanyId());
			events.setUserId(themeDisplay.getUserId());
			events.setUserName(themeDisplay.getUser().getFullName());

			events.setModifiedDate(new Date());

			if (events.getEventId() == 0) {
				events.setEventId(CounterLocalServiceUtil.increment(Events.class.getName()));
				events.setCreateDate(new Date());
			}

			events.setLabId(labId);
			events.setTitle(ParamUtil.getString(request, "title"));
			events.setDescription(ParamUtil.getString(request, "description"));
			events.setActivityType(ParamUtil.getString(request, "selActivity"));
			boolean fullDay = request.getParameter("fullDay") != null;
			LOGGER.info("fullDay : " + fullDay);
			events.setFullDay(fullDay);
			String from = ParamUtil.getString(request, "from");
			String fromTime = ParamUtil.getString(request, "fromTime");
			String to = ParamUtil.getString(request, "to");
			String toTime = ParamUtil.getString(request, "toTime");
			events.setStartTime(eventsSetupBusinessDelegate.setupDateTime(from, fromTime, timeZone));
			events.setEndTime(eventsSetupBusinessDelegate.setupDateTime(to, toTime, timeZone));

			EventsLocalServiceUtil.updateEvents(events);

			response.getWriter().append("SUCCESS");
			LOGGER.info("addEditEvent : " + Constants.END);
		}
	}
    
}
