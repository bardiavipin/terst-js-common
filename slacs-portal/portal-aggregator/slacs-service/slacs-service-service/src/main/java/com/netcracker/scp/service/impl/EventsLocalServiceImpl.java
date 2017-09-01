package com.netcracker.scp.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.netcracker.scp.model.Events;
import com.netcracker.scp.model.impl.EventsImpl;
import com.netcracker.scp.service.base.EventsLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the events local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.netcracker.scp.service.EventsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.netcracker.scp.service.base.EventsLocalServiceBaseImpl
 * @see com.netcracker.scp.service.EventsLocalServiceUtil
 */
public class EventsLocalServiceImpl extends EventsLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.netcracker.scp.service.EventsLocalServiceUtil} to access the events local service.
     */
	public List<Events> findByUser(long userId, long companyId,int start, int end) throws SystemException{
		return eventsPersistence.findByUser(userId, companyId, start, end);
	}
	
	public List<Events> findByLab(long labId, long companyId,int start, int end) throws SystemException{
		return eventsPersistence.findByLab(labId, companyId, start, end);
	}
	public Events getEvents(){
		return  new EventsImpl();
	}
}
