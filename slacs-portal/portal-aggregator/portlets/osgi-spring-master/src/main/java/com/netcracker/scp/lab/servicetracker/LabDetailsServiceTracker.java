package com.netcracker.scp.lab.servicetracker;

import com.netcracker.scp.service.LabDetailsLocalService;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Created by tana0616 on 4/24/2017.
 */
public class LabDetailsServiceTracker extends ServiceTracker<LabDetailsLocalService, LabDetailsLocalService> {
    public LabDetailsServiceTracker(Object controllerObj) {
        super(FrameworkUtil.getBundle(controllerObj.getClass()).getBundleContext(),LabDetailsLocalService.class, null);

    }
}
