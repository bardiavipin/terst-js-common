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

package com.netcracker.scp.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.PortletDataContext;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.netcracker.scp.model.LabDetails;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service interface for LabDetails. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see LabDetailsLocalServiceUtil
 * @see com.netcracker.scp.service.base.LabDetailsLocalServiceBaseImpl
 * @see com.netcracker.scp.service.impl.LabDetailsLocalServiceImpl
 * @generated
 */
@ProviderType
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LabDetailsLocalService extends BaseLocalService,
	PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LabDetailsLocalServiceUtil} to access the lab details local service. Add custom service methods to {@link com.netcracker.scp.service.impl.LabDetailsLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	public DynamicQuery dynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	* @throws PortalException
	*/
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	* Adds the lab details to the database. Also notifies the appropriate model listeners.
	*
	* @param labDetails the lab details
	* @return the lab details that was added
	*/
	@Indexable(type = IndexableType.REINDEX)
	public LabDetails addLabDetails(LabDetails labDetails);

	/**
	* Creates a new lab details with the primary key. Does not add the lab details to the database.
	*
	* @param labId the primary key for the new lab details
	* @return the new lab details
	*/
	public LabDetails createLabDetails(long labId);

	/**
	* Deletes the lab details from the database. Also notifies the appropriate model listeners.
	*
	* @param labDetails the lab details
	* @return the lab details that was removed
	*/
	@Indexable(type = IndexableType.DELETE)
	public LabDetails deleteLabDetails(LabDetails labDetails);

	/**
	* Deletes the lab details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param labId the primary key of the lab details
	* @return the lab details that was removed
	* @throws PortalException if a lab details with the primary key could not be found
	*/
	@Indexable(type = IndexableType.DELETE)
	public LabDetails deleteLabDetails(long labId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LabDetails fetchLabDetails(long labId);

	/**
	* Returns the lab details matching the UUID and group.
	*
	* @param uuid the lab details's UUID
	* @param groupId the primary key of the group
	* @return the matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LabDetails fetchLabDetailsByUuidAndGroupId(java.lang.String uuid,
		long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LabDetails getLabDetails();

	/**
	* Returns the lab details with the primary key.
	*
	* @param labId the primary key of the lab details
	* @return the lab details
	* @throws PortalException if a lab details with the primary key could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LabDetails getLabDetails(long labId) throws PortalException;

	/**
	* Returns the lab details matching the UUID and group.
	*
	* @param uuid the lab details's UUID
	* @param groupId the primary key of the group
	* @return the matching lab details
	* @throws PortalException if a matching lab details could not be found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LabDetails getLabDetailsByUuidAndGroupId(java.lang.String uuid,
		long groupId) throws PortalException;

	/**
	* Updates the lab details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labDetails the lab details
	* @return the lab details that was updated
	*/
	@Indexable(type = IndexableType.REINDEX)
	public LabDetails updateLabDetails(LabDetails labDetails);

	/**
	* Returns the number of lab detailses.
	*
	* @return the number of lab detailses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLabDetailsesCount();

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public java.lang.String getOSGiServiceIdentifier();

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.netcracker.scp.model.impl.LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end);

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.netcracker.scp.model.impl.LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator);

	public List<LabDetails> findByStatus(boolean status, long companyId,
		int start, int end) throws SystemException;

	public List<LabDetails> findByUser(long userId, long companyId, int start,
		int end) throws SystemException;

	/**
	* Returns a range of all the lab detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.netcracker.scp.model.impl.LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @return the range of lab detailses
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LabDetails> getLabDetailses(int start, int end);

	/**
	* Returns all the lab detailses matching the UUID and company.
	*
	* @param uuid the UUID of the lab detailses
	* @param companyId the primary key of the company
	* @return the matching lab detailses, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LabDetails> getLabDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId);

	/**
	* Returns a range of lab detailses matching the UUID and company.
	*
	* @param uuid the UUID of the lab detailses
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching lab detailses, or an empty list if no matches were found
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LabDetails> getLabDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		OrderByComparator<LabDetails> orderByComparator);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection);
}