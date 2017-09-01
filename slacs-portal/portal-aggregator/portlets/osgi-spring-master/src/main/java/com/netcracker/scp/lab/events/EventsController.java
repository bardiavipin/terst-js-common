package com.netcracker.scp.lab.events;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.netcracker.scp.lab.events.businessdelegate.EventsSetupBusinessDelegate;
import com.netcracker.scp.lab.servicetracker.EventServiceTracker;
import com.netcracker.scp.lab.servicetracker.LabDetailsServiceTracker;
import com.netcracker.scp.model.Events;
import com.netcracker.scp.model.LabDetails;
import com.netcracker.scp.service.EventsLocalService;
import com.netcracker.scp.service.LabDetailsLocalService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.annotation.PostConstruct;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by tana0616 on 4/26/2017.
 */

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
        System.out.println(labDetailsServiceTracker+" : "+eventServiceTracker);
        List<LabDetails> labDetails=null;
        if(!labDetailsServiceTracker.isEmpty()){
            LabDetailsLocalService labDetailsLocalService =labDetailsServiceTracker.getService();
            labDetails= labDetailsLocalService.getLabDetailses(-1, -1);
            System.out.println("<---------------------> ");
            System.out.println("---------> "+labDetails.size());
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

        Map map=new HashMap();
        map.put("a","helloo");
        map.put("b","wallo");
        map.put("c","Dalloo");
        map.put("d","Bello");
        map.put("e","jalloo");
        map.put("f","wallo  wallo");
        model.addAttribute("mapObj",map);
        return "events/view1";
    }
    }
