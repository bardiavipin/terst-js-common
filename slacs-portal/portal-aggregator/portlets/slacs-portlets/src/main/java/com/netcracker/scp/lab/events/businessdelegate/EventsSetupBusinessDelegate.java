package com.netcracker.scp.lab.events.businessdelegate;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.netcracker.scp.lab.constants.Constants;
import com.netcracker.scp.model.Events;
import com.netcracker.scp.service.EventsLocalService;
import com.netcracker.scp.service.EventsLocalServiceUtil;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.netcracker.scp.service.persistence.EventsPersistence;
import org.springframework.stereotype.Component;

@Component
public class EventsSetupBusinessDelegate {


	public static final Log LOGGER = LogFactoryUtil.getLog(EventsSetupBusinessDelegate.class);
	
	/*public List<CalendarVO> getCalendarByLabId(long companyId, long labId) throws SystemException{
		List<Events> events = EventsLocalServiceUtil.findByLab(labId, companyId, -1, -1);
		List<CVO>
		for(Events event : events){
			
		}
		
	}*/
	
	public Events getEvent(long eventId,EventsLocalService eventsLocalService) throws PortalException, SystemException {
		LOGGER.info("getEvent : " + Constants.START);
    	Events event = null;
    	if(eventId!=0){
    		event = EventsLocalServiceUtil.getEvents(eventId);
    	} else {
    		event = eventsLocalService.getEvents();
    	}
    	LOGGER.info("getEvent : " + Constants.END);
    	return event;
    }
	
	public Date setupDateTime(String date, String time, String strTimeZone){
    	Calendar startTime = Calendar.getInstance();
    	TimeZone timeZone = TimeZone.getTimeZone("Etc/UTC");
    	
    	startTime.setTimeZone(timeZone);
    	
    	int year = Integer.valueOf(date.split("/")[2]);
    	int month = Integer.valueOf(date.split("/")[0]);
    	int day = Integer.valueOf(date.split("/")[1]);
    	if(time.isEmpty()){
    		startTime.set(year, month-1, day);
    	} else {
    		int hour = Integer.valueOf(time.split(":")[0]);
    		int min = Integer.valueOf(time.split(":")[1]);
    		
    		startTime.set(year, month-1, day, hour, min);
    	}
    	
    	return startTime.getTime();
    }
}
