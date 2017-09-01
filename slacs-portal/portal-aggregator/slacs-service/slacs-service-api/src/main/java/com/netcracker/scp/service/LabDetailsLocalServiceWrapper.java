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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LabDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LabDetailsLocalService
 * @generated
 */
@ProviderType
public class LabDetailsLocalServiceWrapper implements LabDetailsLocalService,
	ServiceWrapper<LabDetailsLocalService> {
	public LabDetailsLocalServiceWrapper(
		LabDetailsLocalService labDetailsLocalService) {
		_labDetailsLocalService = labDetailsLocalService;
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _labDetailsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _labDetailsLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return _labDetailsLocalService.getExportActionableDynamicQuery(portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _labDetailsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the lab details to the database. Also notifies the appropriate model listeners.
	*
	* @param labDetails the lab details
	* @return the lab details that was added
	*/
	@Override
	public com.netcracker.scp.model.LabDetails addLabDetails(
		com.netcracker.scp.model.LabDetails labDetails) {
		return _labDetailsLocalService.addLabDetails(labDetails);
	}

	/**
	* Creates a new lab details with the primary key. Does not add the lab details to the database.
	*
	* @param labId the primary key for the new lab details
	* @return the new lab details
	*/
	@Override
	public com.netcracker.scp.model.LabDetails createLabDetails(long labId) {
		return _labDetailsLocalService.createLabDetails(labId);
	}

	/**
	* Deletes the lab details from the database. Also notifies the appropriate model listeners.
	*
	* @param labDetails the lab details
	* @return the lab details that was removed
	*/
	@Override
	public com.netcracker.scp.model.LabDetails deleteLabDetails(
		com.netcracker.scp.model.LabDetails labDetails) {
		return _labDetailsLocalService.deleteLabDetails(labDetails);
	}

	/**
	* Deletes the lab details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param labId the primary key of the lab details
	* @return the lab details that was removed
	* @throws PortalException if a lab details with the primary key could not be found
	*/
	@Override
	public com.netcracker.scp.model.LabDetails deleteLabDetails(long labId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailsLocalService.deleteLabDetails(labId);
	}

	@Override
	public com.netcracker.scp.model.LabDetails fetchLabDetails(long labId) {
		return _labDetailsLocalService.fetchLabDetails(labId);
	}

	/**
	* Returns the lab details matching the UUID and group.
	*
	* @param uuid the lab details's UUID
	* @param groupId the primary key of the group
	* @return the matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	@Override
	public com.netcracker.scp.model.LabDetails fetchLabDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return _labDetailsLocalService.fetchLabDetailsByUuidAndGroupId(uuid,
			groupId);
	}

	@Override
	public com.netcracker.scp.model.LabDetails getLabDetails() {
		return _labDetailsLocalService.getLabDetails();
	}

	/**
	* Returns the lab details with the primary key.
	*
	* @param labId the primary key of the lab details
	* @return the lab details
	* @throws PortalException if a lab details with the primary key could not be found
	*/
	@Override
	public com.netcracker.scp.model.LabDetails getLabDetails(long labId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailsLocalService.getLabDetails(labId);
	}

	/**
	* Returns the lab details matching the UUID and group.
	*
	* @param uuid the lab details's UUID
	* @param groupId the primary key of the group
	* @return the matching lab details
	* @throws PortalException if a matching lab details could not be found
	*/
	@Override
	public com.netcracker.scp.model.LabDetails getLabDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _labDetailsLocalService.getLabDetailsByUuidAndGroupId(uuid,
			groupId);
	}

	/**
	* Updates the lab details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param labDetails the lab details
	* @return the lab details that was updated
	*/
	@Override
	public com.netcracker.scp.model.LabDetails updateLabDetails(
		com.netcracker.scp.model.LabDetails labDetails) {
		return _labDetailsLocalService.updateLabDetails(labDetails);
	}

	/**
	* Returns the number of lab detailses.
	*
	* @return the number of lab detailses
	*/
	@Override
	public int getLabDetailsesCount() {
		return _labDetailsLocalService.getLabDetailsesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _labDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _labDetailsLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _labDetailsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _labDetailsLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	@Override
	public java.util.List<com.netcracker.scp.model.LabDetails> findByStatus(
		boolean status, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _labDetailsLocalService.findByStatus(status, companyId, start,
			end);
	}

	@Override
	public java.util.List<com.netcracker.scp.model.LabDetails> findByUser(
		long userId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _labDetailsLocalService.findByUser(userId, companyId, start, end);
	}

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
	@Override
	public java.util.List<com.netcracker.scp.model.LabDetails> getLabDetailses(
		int start, int end) {
		return _labDetailsLocalService.getLabDetailses(start, end);
	}

	/**
	* Returns all the lab detailses matching the UUID and company.
	*
	* @param uuid the UUID of the lab detailses
	* @param companyId the primary key of the company
	* @return the matching lab detailses, or an empty list if no matches were found
	*/
	@Override
	public java.util.List<com.netcracker.scp.model.LabDetails> getLabDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return _labDetailsLocalService.getLabDetailsesByUuidAndCompanyId(uuid,
			companyId);
	}

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
	@Override
	public java.util.List<com.netcracker.scp.model.LabDetails> getLabDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.netcracker.scp.model.LabDetails> orderByComparator) {
		return _labDetailsLocalService.getLabDetailsesByUuidAndCompanyId(uuid,
			companyId, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _labDetailsLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _labDetailsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public LabDetailsLocalService getWrappedService() {
		return _labDetailsLocalService;
	}

	@Override
	public void setWrappedService(LabDetailsLocalService labDetailsLocalService) {
		_labDetailsLocalService = labDetailsLocalService;
	}

	private LabDetailsLocalService _labDetailsLocalService;
}