package com.netcracker.scp.lab.servicetracker;

import com.netcracker.scp.service.EventsLocalService;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Created by tana0616 on 4/24/2017.
 */
public class EventServiceTracker extends ServiceTracker<EventsLocalService, EventsLocalService> {
    public EventServiceTracker(Object controllerObj) {
        super(FrameworkUtil.getBundle(controllerObj.getClass()).getBundleContext(),EventsLocalService.class, null);

    }
}
