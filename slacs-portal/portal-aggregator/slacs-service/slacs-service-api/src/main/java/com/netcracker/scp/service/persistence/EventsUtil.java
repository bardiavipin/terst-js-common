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

package com.netcracker.scp.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.netcracker.scp.model.Events;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the events service. This utility wraps {@link com.netcracker.scp.service.persistence.impl.EventsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventsPersistence
 * @see com.netcracker.scp.service.persistence.impl.EventsPersistenceImpl
 * @generated
 */
@ProviderType
public class EventsUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Events events) {
		getPersistence().clearCache(events);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Events> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Events> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Events> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Events update(Events events) {
		return getPersistence().update(events);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Events update(Events events, ServiceContext serviceContext) {
		return getPersistence().update(events, serviceContext);
	}

	/**
	* Returns all the eventses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching eventses
	*/
	public static List<Events> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the eventses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @return the range of matching eventses
	*/
	public static List<Events> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the eventses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Events> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the eventses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByUuid_First(java.lang.String uuid,
		OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<Events> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByUuid_Last(java.lang.String uuid,
		OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<Events> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the eventses before and after the current events in the ordered set where uuid = &#63;.
	*
	* @param eventId the primary key of the current events
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next events
	* @throws NoSuchEventsException if a events with the primary key could not be found
	*/
	public static Events[] findByUuid_PrevAndNext(long eventId,
		java.lang.String uuid, OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByUuid_PrevAndNext(eventId, uuid, orderByComparator);
	}

	/**
	* Removes all the eventses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of eventses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching eventses
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the events where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEventsException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByUUID_G(java.lang.String uuid, long groupId)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the events where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the events that was removed
	*/
	public static Events removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of eventses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching eventses
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the eventses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching eventses
	*/
	public static List<Events> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the eventses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @return the range of matching eventses
	*/
	public static List<Events> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the eventses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the eventses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<Events> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first events in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first events in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the eventses before and after the current events in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param eventId the primary key of the current events
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next events
	* @throws NoSuchEventsException if a events with the primary key could not be found
	*/
	public static Events[] findByUuid_C_PrevAndNext(long eventId,
		java.lang.String uuid, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(eventId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the eventses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of eventses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching eventses
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the eventses where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @return the matching eventses
	*/
	public static List<Events> findByUser(long userId, long companyId) {
		return getPersistence().findByUser(userId, companyId);
	}

	/**
	* Returns a range of all the eventses where userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @return the range of matching eventses
	*/
	public static List<Events> findByUser(long userId, long companyId,
		int start, int end) {
		return getPersistence().findByUser(userId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the eventses where userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByUser(long userId, long companyId,
		int start, int end, OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .findByUser(userId, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the eventses where userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByUser(long userId, long companyId,
		int start, int end, OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUser(userId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first events in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByUser_First(long userId, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByUser_First(userId, companyId, orderByComparator);
	}

	/**
	* Returns the first events in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByUser_First(long userId, long companyId,
		OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .fetchByUser_First(userId, companyId, orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByUser_Last(long userId, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByUser_Last(userId, companyId, orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByUser_Last(long userId, long companyId,
		OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .fetchByUser_Last(userId, companyId, orderByComparator);
	}

	/**
	* Returns the eventses before and after the current events in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param eventId the primary key of the current events
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next events
	* @throws NoSuchEventsException if a events with the primary key could not be found
	*/
	public static Events[] findByUser_PrevAndNext(long eventId, long userId,
		long companyId, OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByUser_PrevAndNext(eventId, userId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the eventses where userId = &#63; and companyId = &#63; from the database.
	*
	* @param userId the user ID
	* @param companyId the company ID
	*/
	public static void removeByUser(long userId, long companyId) {
		getPersistence().removeByUser(userId, companyId);
	}

	/**
	* Returns the number of eventses where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @return the number of matching eventses
	*/
	public static int countByUser(long userId, long companyId) {
		return getPersistence().countByUser(userId, companyId);
	}

	/**
	* Returns all the eventses where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @return the matching eventses
	*/
	public static List<Events> findByLabStatus(long labId, int status,
		long companyId) {
		return getPersistence().findByLabStatus(labId, status, companyId);
	}

	/**
	* Returns a range of all the eventses where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @return the range of matching eventses
	*/
	public static List<Events> findByLabStatus(long labId, int status,
		long companyId, int start, int end) {
		return getPersistence()
				   .findByLabStatus(labId, status, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the eventses where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByLabStatus(long labId, int status,
		long companyId, int start, int end,
		OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .findByLabStatus(labId, status, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the eventses where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByLabStatus(long labId, int status,
		long companyId, int start, int end,
		OrderByComparator<Events> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByLabStatus(labId, status, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first events in the ordered set where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByLabStatus_First(long labId, int status,
		long companyId, OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByLabStatus_First(labId, status, companyId,
			orderByComparator);
	}

	/**
	* Returns the first events in the ordered set where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByLabStatus_First(long labId, int status,
		long companyId, OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .fetchByLabStatus_First(labId, status, companyId,
			orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByLabStatus_Last(long labId, int status,
		long companyId, OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByLabStatus_Last(labId, status, companyId,
			orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByLabStatus_Last(long labId, int status,
		long companyId, OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .fetchByLabStatus_Last(labId, status, companyId,
			orderByComparator);
	}

	/**
	* Returns the eventses before and after the current events in the ordered set where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* @param eventId the primary key of the current events
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next events
	* @throws NoSuchEventsException if a events with the primary key could not be found
	*/
	public static Events[] findByLabStatus_PrevAndNext(long eventId,
		long labId, int status, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByLabStatus_PrevAndNext(eventId, labId, status,
			companyId, orderByComparator);
	}

	/**
	* Removes all the eventses where labId = &#63; and status = &#63; and companyId = &#63; from the database.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	*/
	public static void removeByLabStatus(long labId, int status, long companyId) {
		getPersistence().removeByLabStatus(labId, status, companyId);
	}

	/**
	* Returns the number of eventses where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @return the number of matching eventses
	*/
	public static int countByLabStatus(long labId, int status, long companyId) {
		return getPersistence().countByLabStatus(labId, status, companyId);
	}

	/**
	* Returns all the eventses where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @return the matching eventses
	*/
	public static List<Events> findByLab(long labId, long companyId) {
		return getPersistence().findByLab(labId, companyId);
	}

	/**
	* Returns a range of all the eventses where labId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @return the range of matching eventses
	*/
	public static List<Events> findByLab(long labId, long companyId, int start,
		int end) {
		return getPersistence().findByLab(labId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the eventses where labId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByLab(long labId, long companyId, int start,
		int end, OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .findByLab(labId, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the eventses where labId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByLab(long labId, long companyId, int start,
		int end, OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByLab(labId, companyId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first events in the ordered set where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByLab_First(long labId, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByLab_First(labId, companyId, orderByComparator);
	}

	/**
	* Returns the first events in the ordered set where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByLab_First(long labId, long companyId,
		OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .fetchByLab_First(labId, companyId, orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByLab_Last(long labId, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByLab_Last(labId, companyId, orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByLab_Last(long labId, long companyId,
		OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .fetchByLab_Last(labId, companyId, orderByComparator);
	}

	/**
	* Returns the eventses before and after the current events in the ordered set where labId = &#63; and companyId = &#63;.
	*
	* @param eventId the primary key of the current events
	* @param labId the lab ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next events
	* @throws NoSuchEventsException if a events with the primary key could not be found
	*/
	public static Events[] findByLab_PrevAndNext(long eventId, long labId,
		long companyId, OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByLab_PrevAndNext(eventId, labId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the eventses where labId = &#63; and companyId = &#63; from the database.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	*/
	public static void removeByLab(long labId, long companyId) {
		getPersistence().removeByLab(labId, companyId);
	}

	/**
	* Returns the number of eventses where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @return the number of matching eventses
	*/
	public static int countByLab(long labId, long companyId) {
		return getPersistence().countByLab(labId, companyId);
	}

	/**
	* Returns all the eventses where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the matching eventses
	*/
	public static List<Events> findByLabUser(long labId, long userId,
		long companyId) {
		return getPersistence().findByLabUser(labId, userId, companyId);
	}

	/**
	* Returns a range of all the eventses where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @return the range of matching eventses
	*/
	public static List<Events> findByLabUser(long labId, long userId,
		long companyId, int start, int end) {
		return getPersistence()
				   .findByLabUser(labId, userId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the eventses where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByLabUser(long labId, long userId,
		long companyId, int start, int end,
		OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .findByLabUser(labId, userId, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the eventses where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching eventses
	*/
	public static List<Events> findByLabUser(long labId, long userId,
		long companyId, int start, int end,
		OrderByComparator<Events> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findByLabUser(labId, userId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first events in the ordered set where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByLabUser_First(long labId, long userId,
		long companyId, OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByLabUser_First(labId, userId, companyId,
			orderByComparator);
	}

	/**
	* Returns the first events in the ordered set where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByLabUser_First(long labId, long userId,
		long companyId, OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .fetchByLabUser_First(labId, userId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public static Events findByLabUser_Last(long labId, long userId,
		long companyId, OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByLabUser_Last(labId, userId, companyId,
			orderByComparator);
	}

	/**
	* Returns the last events in the ordered set where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public static Events fetchByLabUser_Last(long labId, long userId,
		long companyId, OrderByComparator<Events> orderByComparator) {
		return getPersistence()
				   .fetchByLabUser_Last(labId, userId, companyId,
			orderByComparator);
	}

	/**
	* Returns the eventses before and after the current events in the ordered set where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param eventId the primary key of the current events
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next events
	* @throws NoSuchEventsException if a events with the primary key could not be found
	*/
	public static Events[] findByLabUser_PrevAndNext(long eventId, long labId,
		long userId, long companyId, OrderByComparator<Events> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence()
				   .findByLabUser_PrevAndNext(eventId, labId, userId,
			companyId, orderByComparator);
	}

	/**
	* Removes all the eventses where labId = &#63; and userId = &#63; and companyId = &#63; from the database.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	*/
	public static void removeByLabUser(long labId, long userId, long companyId) {
		getPersistence().removeByLabUser(labId, userId, companyId);
	}

	/**
	* Returns the number of eventses where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the number of matching eventses
	*/
	public static int countByLabUser(long labId, long userId, long companyId) {
		return getPersistence().countByLabUser(labId, userId, companyId);
	}

	/**
	* Caches the events in the entity cache if it is enabled.
	*
	* @param events the events
	*/
	public static void cacheResult(Events events) {
		getPersistence().cacheResult(events);
	}

	/**
	* Caches the eventses in the entity cache if it is enabled.
	*
	* @param eventses the eventses
	*/
	public static void cacheResult(List<Events> eventses) {
		getPersistence().cacheResult(eventses);
	}

	/**
	* Creates a new events with the primary key. Does not add the events to the database.
	*
	* @param eventId the primary key for the new events
	* @return the new events
	*/
	public static Events create(long eventId) {
		return getPersistence().create(eventId);
	}

	/**
	* Removes the events with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the events
	* @return the events that was removed
	* @throws NoSuchEventsException if a events with the primary key could not be found
	*/
	public static Events remove(long eventId)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence().remove(eventId);
	}

	public static Events updateImpl(Events events) {
		return getPersistence().updateImpl(events);
	}

	/**
	* Returns the events with the primary key or throws a {@link NoSuchEventsException} if it could not be found.
	*
	* @param eventId the primary key of the events
	* @return the events
	* @throws NoSuchEventsException if a events with the primary key could not be found
	*/
	public static Events findByPrimaryKey(long eventId)
		throws com.netcracker.scp.exception.NoSuchEventsException {
		return getPersistence().findByPrimaryKey(eventId);
	}

	/**
	* Returns the events with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventId the primary key of the events
	* @return the events, or <code>null</code> if a events with the primary key could not be found
	*/
	public static Events fetchByPrimaryKey(long eventId) {
		return getPersistence().fetchByPrimaryKey(eventId);
	}

	public static java.util.Map<java.io.Serializable, Events> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the eventses.
	*
	* @return the eventses
	*/
	public static List<Events> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the eventses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @return the range of eventses
	*/
	public static List<Events> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the eventses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of eventses
	*/
	public static List<Events> findAll(int start, int end,
		OrderByComparator<Events> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the eventses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link EventsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of eventses
	* @param end the upper bound of the range of eventses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of eventses
	*/
	public static List<Events> findAll(int start, int end,
		OrderByComparator<Events> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the eventses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of eventses.
	*
	* @return the number of eventses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static EventsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<EventsPersistence, EventsPersistence> _serviceTracker =
		ServiceTrackerFactory.open(EventsPersistence.class);
}