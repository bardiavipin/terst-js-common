package com.netcracker.scp.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.netcracker.scp.model.LabDetails;
import com.netcracker.scp.model.impl.LabDetailsImpl;
import com.netcracker.scp.service.base.LabDetailsLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the lab details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.netcracker.scp.service.LabDetailsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.netcracker.scp.service.base.LabDetailsLocalServiceBaseImpl
 * @see com.netcracker.scp.service.LabDetailsLocalServiceUtil
 */
public class LabDetailsLocalServiceImpl extends LabDetailsLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.netcracker.scp.service.LabDetailsLocalServiceUtil} to access the lab details local service.
     */
	public List<LabDetails> findByStatus(boolean status, long companyId,int start, int end) throws SystemException{
		return labDetailsPersistence.findByStatus(status, companyId,start, end);
	}
	
	public List<LabDetails> findByUser(long userId, long companyId,int start, int end) throws SystemException{
		return labDetailsPersistence.findByUser(userId, companyId,start, end);
	}
	public LabDetails getLabDetails(){
		return  new LabDetailsImpl();
	}
}
