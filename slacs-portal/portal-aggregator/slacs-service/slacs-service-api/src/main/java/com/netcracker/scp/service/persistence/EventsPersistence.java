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

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.netcracker.scp.exception.NoSuchEventsException;
import com.netcracker.scp.model.Events;

/**
 * The persistence interface for the events service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.netcracker.scp.service.persistence.impl.EventsPersistenceImpl
 * @see EventsUtil
 * @generated
 */
@ProviderType
public interface EventsPersistence extends BasePersistence<Events> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link EventsUtil} to access the events persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the eventses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching eventses
	*/
	public java.util.List<Events> findByUuid(java.lang.String uuid);

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
	public java.util.List<Events> findByUuid(java.lang.String uuid, int start,
		int end);

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
	public java.util.List<Events> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public java.util.List<Events> findByUuid(java.lang.String uuid, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public Events findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the first events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

	/**
	* Returns the last events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public Events findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the last events in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

	/**
	* Returns the eventses before and after the current events in the ordered set where uuid = &#63;.
	*
	* @param eventId the primary key of the current events
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next events
	* @throws NoSuchEventsException if a events with the primary key could not be found
	*/
	public Events[] findByUuid_PrevAndNext(long eventId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Removes all the eventses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of eventses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching eventses
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the events where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEventsException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public Events findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchEventsException;

	/**
	* Returns the events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the events where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the events that was removed
	*/
	public Events removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchEventsException;

	/**
	* Returns the number of eventses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching eventses
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the eventses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching eventses
	*/
	public java.util.List<Events> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<Events> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<Events> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public java.util.List<Events> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first events in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public Events findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the first events in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

	/**
	* Returns the last events in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public Events findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the last events in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public Events[] findByUuid_C_PrevAndNext(long eventId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Removes all the eventses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of eventses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching eventses
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the eventses where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @return the matching eventses
	*/
	public java.util.List<Events> findByUser(long userId, long companyId);

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
	public java.util.List<Events> findByUser(long userId, long companyId,
		int start, int end);

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
	public java.util.List<Events> findByUser(long userId, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public java.util.List<Events> findByUser(long userId, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first events in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public Events findByUser_First(long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the first events in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByUser_First(long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

	/**
	* Returns the last events in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public Events findByUser_Last(long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the last events in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByUser_Last(long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public Events[] findByUser_PrevAndNext(long eventId, long userId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Removes all the eventses where userId = &#63; and companyId = &#63; from the database.
	*
	* @param userId the user ID
	* @param companyId the company ID
	*/
	public void removeByUser(long userId, long companyId);

	/**
	* Returns the number of eventses where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @return the number of matching eventses
	*/
	public int countByUser(long userId, long companyId);

	/**
	* Returns all the eventses where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @return the matching eventses
	*/
	public java.util.List<Events> findByLabStatus(long labId, int status,
		long companyId);

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
	public java.util.List<Events> findByLabStatus(long labId, int status,
		long companyId, int start, int end);

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
	public java.util.List<Events> findByLabStatus(long labId, int status,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public java.util.List<Events> findByLabStatus(long labId, int status,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache);

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
	public Events findByLabStatus_First(long labId, int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the first events in the ordered set where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByLabStatus_First(long labId, int status,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public Events findByLabStatus_Last(long labId, int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the last events in the ordered set where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByLabStatus_Last(long labId, int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public Events[] findByLabStatus_PrevAndNext(long eventId, long labId,
		int status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Removes all the eventses where labId = &#63; and status = &#63; and companyId = &#63; from the database.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	*/
	public void removeByLabStatus(long labId, int status, long companyId);

	/**
	* Returns the number of eventses where labId = &#63; and status = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param status the status
	* @param companyId the company ID
	* @return the number of matching eventses
	*/
	public int countByLabStatus(long labId, int status, long companyId);

	/**
	* Returns all the eventses where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @return the matching eventses
	*/
	public java.util.List<Events> findByLab(long labId, long companyId);

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
	public java.util.List<Events> findByLab(long labId, long companyId,
		int start, int end);

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
	public java.util.List<Events> findByLab(long labId, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public java.util.List<Events> findByLab(long labId, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first events in the ordered set where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public Events findByLab_First(long labId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the first events in the ordered set where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByLab_First(long labId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

	/**
	* Returns the last events in the ordered set where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events
	* @throws NoSuchEventsException if a matching events could not be found
	*/
	public Events findByLab_Last(long labId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the last events in the ordered set where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByLab_Last(long labId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public Events[] findByLab_PrevAndNext(long eventId, long labId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Removes all the eventses where labId = &#63; and companyId = &#63; from the database.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	*/
	public void removeByLab(long labId, long companyId);

	/**
	* Returns the number of eventses where labId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param companyId the company ID
	* @return the number of matching eventses
	*/
	public int countByLab(long labId, long companyId);

	/**
	* Returns all the eventses where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the matching eventses
	*/
	public java.util.List<Events> findByLabUser(long labId, long userId,
		long companyId);

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
	public java.util.List<Events> findByLabUser(long labId, long userId,
		long companyId, int start, int end);

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
	public java.util.List<Events> findByLabUser(long labId, long userId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public java.util.List<Events> findByLabUser(long labId, long userId,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache);

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
	public Events findByLabUser_First(long labId, long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the first events in the ordered set where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByLabUser_First(long labId, long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public Events findByLabUser_Last(long labId, long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Returns the last events in the ordered set where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching events, or <code>null</code> if a matching events could not be found
	*/
	public Events fetchByLabUser_Last(long labId, long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public Events[] findByLabUser_PrevAndNext(long eventId, long labId,
		long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException;

	/**
	* Removes all the eventses where labId = &#63; and userId = &#63; and companyId = &#63; from the database.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	*/
	public void removeByLabUser(long labId, long userId, long companyId);

	/**
	* Returns the number of eventses where labId = &#63; and userId = &#63; and companyId = &#63;.
	*
	* @param labId the lab ID
	* @param userId the user ID
	* @param companyId the company ID
	* @return the number of matching eventses
	*/
	public int countByLabUser(long labId, long userId, long companyId);

	/**
	* Caches the events in the entity cache if it is enabled.
	*
	* @param events the events
	*/
	public void cacheResult(Events events);

	/**
	* Caches the eventses in the entity cache if it is enabled.
	*
	* @param eventses the eventses
	*/
	public void cacheResult(java.util.List<Events> eventses);

	/**
	* Creates a new events with the primary key. Does not add the events to the database.
	*
	* @param eventId the primary key for the new events
	* @return the new events
	*/
	public Events create(long eventId);

	/**
	* Removes the events with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param eventId the primary key of the events
	* @return the events that was removed
	* @throws NoSuchEventsException if a events with the primary key could not be found
	*/
	public Events remove(long eventId) throws NoSuchEventsException;

	public Events updateImpl(Events events);

	/**
	* Returns the events with the primary key or throws a {@link NoSuchEventsException} if it could not be found.
	*
	* @param eventId the primary key of the events
	* @return the events
	* @throws NoSuchEventsException if a events with the primary key could not be found
	*/
	public Events findByPrimaryKey(long eventId) throws NoSuchEventsException;

	/**
	* Returns the events with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param eventId the primary key of the events
	* @return the events, or <code>null</code> if a events with the primary key could not be found
	*/
	public Events fetchByPrimaryKey(long eventId);

	@Override
	public java.util.Map<java.io.Serializable, Events> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the eventses.
	*
	* @return the eventses
	*/
	public java.util.List<Events> findAll();

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
	public java.util.List<Events> findAll(int start, int end);

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
	public java.util.List<Events> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator);

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
	public java.util.List<Events> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the eventses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of eventses.
	*
	* @return the number of eventses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}