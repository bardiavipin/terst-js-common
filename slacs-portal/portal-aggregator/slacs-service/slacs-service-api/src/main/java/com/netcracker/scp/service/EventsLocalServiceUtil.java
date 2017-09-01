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

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Events. This utility wraps
 * {@link com.netcracker.scp.service.impl.EventsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see EventsLocalService
 * @see com.netcracker.scp.service.base.EventsLocalServiceBaseImpl
 * @see com.netcracker.scp.service.impl.EventsLocalServiceImpl
 * @generated
 */
@ProviderType
public class EventsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.netcracker.scp.service.impl.EventsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Adds the events to the database. Also notifies the appropriate model listeners.
	*
	* @param events the events
	* @return the events that was added
	*/
	public static com.netcracker.scp.model.Events addEvents(
		com.netcracker.scp.model.Events events) {
		return getService().addEvents(events);
	}

	/**
	* Creates a new events with the primary key. Does not add the events to the database.
	*
	* @param eventId the primary key for the new events
	* @return the new events
	*/
	public static com.netcracker.scp.model.Events createEvents(long eventId) {
		return getService().createEvents(eventId);
	}

	/**
	* Deletes the events from the database. Also notifies the appropriate model listeners.
	*
	* @param events the events
	* @return the events that was removed
	*/
	public static com.netcracker.scp.model.Events deleteEvents(
		com.netcracker.scp.model.Events events) {
		return getService().deleteEvents(events);
	}

	/**
	* Deletes the events with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the events
	* @return the events that was removed
	* @throws PortalException if a events with the primary key could not be found
	*/
	public static com.netcracker.scp.model.Events deleteEvents(long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteEvents(eventId);
	}

	public static com.netcracker.scp.model.Events fetchEvents(long eventId) {
		return getService().fetchEvents(eventId);
	}

	/**
	* Returns the events matching the UUID and group.
	*
	* @param uuid the events's UUID
	* @param groupId the primary key of the group
	* @return the matching events, or <code>null</code> if a matching events could not be found
	*/
	public static com.netcracker.scp.model.Events fetchEventsByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchEventsByUuidAndGroupId(uuid, groupId);
	}

	public static com.netcracker.scp.model.Events getEvents() {
		return getService().getEvents();
	}

	/**
	* Returns the events with the primary key.
	*
	* @param eventId the primary key of the events
	* @return the events
	* @throws PortalException if a events with the primary key could not be found
	*/
	public static com.netcracker.scp.model.Events getEvents(long eventId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEvents(eventId);
	}

	/**
	* Returns the events matching the UUID and group.
	*
	* @param uuid the events's UUID
	* @param groupId the primary key of the group
	* @return the matching events
	* @throws PortalException if a matching events could not be found
	*/
	public static com.netcracker.scp.model.Events getEventsByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getEventsByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the events in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param events the events
	* @return the events that was updated
	*/
	public static com.netcracker.scp.model.Events updateEvents(
		com.netcracker.scp.model.Events events) {
		return getService().updateEvents(events);
	}

	/**
	* Returns the number of eventses.
	*
	* @return the number of eventses
	*/
	public static int getEventsesCount() {
		return getService().getEventsesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.netcracker.scp.model.impl.EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.netcracker.scp.model.impl.EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.netcracker.scp.model.Events> findByLab(
		long labId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByLab(labId, companyId, start, end);
	}

	public static java.util.List<com.netcracker.scp.model.Events> findByUser(
		long userId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().findByUser(userId, companyId, start, end);
	}

	/**
	* Returns a range of all the eventses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.netcracker.scp.model.impl.EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @return the range of eventses
	*/
	public static java.util.List<com.netcracker.scp.model.Events> getEventses(
		int start, int end) {
		return getService().getEventses(start, end);
	}

	/**
	* Returns all the eventses matching the UUID and company.
	*
	* @param uuid the UUID of the eventses
	* @param companyId the primary key of the company
	* @return the matching eventses, or an empty list if no matches were found
	*/
	public static java.util.List<com.netcracker.scp.model.Events> getEventsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getEventsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of eventses matching the UUID and company.
	*
	* @param uuid the UUID of the eventses
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching eventses, or an empty list if no matches were found
	*/
	public static java.util.List<com.netcracker.scp.model.Events> getEventsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.netcracker.scp.model.Events> orderByComparator) {
		return getService()
				   .getEventsesByUuidAndCompanyId(uuid, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static EventsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EventsLocalService, EventsLocalService> _serviceTracker =
		ServiceTrackerFactory.open(EventsLocalService.class);
}