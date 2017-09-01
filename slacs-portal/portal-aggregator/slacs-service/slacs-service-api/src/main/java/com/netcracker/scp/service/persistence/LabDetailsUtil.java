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

import com.netcracker.scp.model.LabDetails;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the lab details service. This utility wraps {@link com.netcracker.scp.service.persistence.impl.LabDetailsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LabDetailsPersistence
 * @see com.netcracker.scp.service.persistence.impl.LabDetailsPersistenceImpl
 * @generated
 */
@ProviderType
public class LabDetailsUtil {
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
	public static void clearCache(LabDetails labDetails) {
		getPersistence().clearCache(labDetails);
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
	public static List<LabDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LabDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LabDetails> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static LabDetails update(LabDetails labDetails) {
		return getPersistence().update(labDetails);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static LabDetails update(LabDetails labDetails,
		ServiceContext serviceContext) {
		return getPersistence().update(labDetails, serviceContext);
	}

	/**
	* Returns all the lab detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching lab detailses
	*/
	public static List<LabDetails> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the lab detailses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @return the range of matching lab detailses
	*/
	public static List<LabDetails> findByUuid(java.lang.String uuid, int start,
		int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the lab detailses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lab detailses
	*/
	public static List<LabDetails> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lab detailses where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching lab detailses
	*/
	public static List<LabDetails> findByUuid(java.lang.String uuid, int start,
		int end, OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first lab details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public static LabDetails findByUuid_First(java.lang.String uuid,
		OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first lab details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public static LabDetails fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last lab details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public static LabDetails findByUuid_Last(java.lang.String uuid,
		OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last lab details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public static LabDetails fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the lab detailses before and after the current lab details in the ordered set where uuid = &#63;.
	*
	* @param labId the primary key of the current lab details
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lab details
	* @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	*/
	public static LabDetails[] findByUuid_PrevAndNext(long labId,
		java.lang.String uuid, OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence()
				   .findByUuid_PrevAndNext(labId, uuid, orderByComparator);
	}

	/**
	* Removes all the lab detailses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of lab detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching lab detailses
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the lab details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchLabDetailsException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public static LabDetails findByUUID_G(java.lang.String uuid, long groupId)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the lab details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public static LabDetails fetchByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the lab details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public static LabDetails fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the lab details where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the lab details that was removed
	*/
	public static LabDetails removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of lab detailses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching lab detailses
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the lab detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching lab detailses
	*/
	public static List<LabDetails> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the lab detailses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @return the range of matching lab detailses
	*/
	public static List<LabDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the lab detailses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lab detailses
	*/
	public static List<LabDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lab detailses where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching lab detailses
	*/
	public static List<LabDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first lab details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public static LabDetails findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first lab details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public static LabDetails fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last lab details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public static LabDetails findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last lab details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public static LabDetails fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the lab detailses before and after the current lab details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param labId the primary key of the current lab details
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lab details
	* @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	*/
	public static LabDetails[] findByUuid_C_PrevAndNext(long labId,
		java.lang.String uuid, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(labId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the lab detailses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of lab detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching lab detailses
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the lab detailses where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @return the matching lab detailses
	*/
	public static List<LabDetails> findByUser(long userId, long companyId) {
		return getPersistence().findByUser(userId, companyId);
	}

	/**
	* Returns a range of all the lab detailses where userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @return the range of matching lab detailses
	*/
	public static List<LabDetails> findByUser(long userId, long companyId,
		int start, int end) {
		return getPersistence().findByUser(userId, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the lab detailses where userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lab detailses
	*/
	public static List<LabDetails> findByUser(long userId, long companyId,
		int start, int end, OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence()
				   .findByUser(userId, companyId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lab detailses where userId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching lab detailses
	*/
	public static List<LabDetails> findByUser(long userId, long companyId,
		int start, int end, OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUser(userId, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first lab details in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public static LabDetails findByUser_First(long userId, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence()
				   .findByUser_First(userId, companyId, orderByComparator);
	}

	/**
	* Returns the first lab details in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public static LabDetails fetchByUser_First(long userId, long companyId,
		OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUser_First(userId, companyId, orderByComparator);
	}

	/**
	* Returns the last lab details in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public static LabDetails findByUser_Last(long userId, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence()
				   .findByUser_Last(userId, companyId, orderByComparator);
	}

	/**
	* Returns the last lab details in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public static LabDetails fetchByUser_Last(long userId, long companyId,
		OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence()
				   .fetchByUser_Last(userId, companyId, orderByComparator);
	}

	/**
	* Returns the lab detailses before and after the current lab details in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param labId the primary key of the current lab details
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lab details
	* @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	*/
	public static LabDetails[] findByUser_PrevAndNext(long labId, long userId,
		long companyId, OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence()
				   .findByUser_PrevAndNext(labId, userId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the lab detailses where userId = &#63; and companyId = &#63; from the database.
	*
	* @param userId the user ID
	* @param companyId the company ID
	*/
	public static void removeByUser(long userId, long companyId) {
		getPersistence().removeByUser(userId, companyId);
	}

	/**
	* Returns the number of lab detailses where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @return the number of matching lab detailses
	*/
	public static int countByUser(long userId, long companyId) {
		return getPersistence().countByUser(userId, companyId);
	}

	/**
	* Returns all the lab detailses where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the matching lab detailses
	*/
	public static List<LabDetails> findByStatus(boolean status, long companyId) {
		return getPersistence().findByStatus(status, companyId);
	}

	/**
	* Returns a range of all the lab detailses where status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @return the range of matching lab detailses
	*/
	public static List<LabDetails> findByStatus(boolean status, long companyId,
		int start, int end) {
		return getPersistence().findByStatus(status, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the lab detailses where status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching lab detailses
	*/
	public static List<LabDetails> findByStatus(boolean status, long companyId,
		int start, int end, OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence()
				   .findByStatus(status, companyId, start, end,
			orderByComparator);
	}

	/**
	* Returns an ordered range of all the lab detailses where status = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param companyId the company ID
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching lab detailses
	*/
	public static List<LabDetails> findByStatus(boolean status, long companyId,
		int start, int end, OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByStatus(status, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first lab details in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public static LabDetails findByStatus_First(boolean status, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence()
				   .findByStatus_First(status, companyId, orderByComparator);
	}

	/**
	* Returns the first lab details in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public static LabDetails fetchByStatus_First(boolean status,
		long companyId, OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence()
				   .fetchByStatus_First(status, companyId, orderByComparator);
	}

	/**
	* Returns the last lab details in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public static LabDetails findByStatus_Last(boolean status, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence()
				   .findByStatus_Last(status, companyId, orderByComparator);
	}

	/**
	* Returns the last lab details in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public static LabDetails fetchByStatus_Last(boolean status, long companyId,
		OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence()
				   .fetchByStatus_Last(status, companyId, orderByComparator);
	}

	/**
	* Returns the lab detailses before and after the current lab details in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param labId the primary key of the current lab details
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lab details
	* @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	*/
	public static LabDetails[] findByStatus_PrevAndNext(long labId,
		boolean status, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence()
				   .findByStatus_PrevAndNext(labId, status, companyId,
			orderByComparator);
	}

	/**
	* Removes all the lab detailses where status = &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param companyId the company ID
	*/
	public static void removeByStatus(boolean status, long companyId) {
		getPersistence().removeByStatus(status, companyId);
	}

	/**
	* Returns the number of lab detailses where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the number of matching lab detailses
	*/
	public static int countByStatus(boolean status, long companyId) {
		return getPersistence().countByStatus(status, companyId);
	}

	/**
	* Caches the lab details in the entity cache if it is enabled.
	*
	* @param labDetails the lab details
	*/
	public static void cacheResult(LabDetails labDetails) {
		getPersistence().cacheResult(labDetails);
	}

	/**
	* Caches the lab detailses in the entity cache if it is enabled.
	*
	* @param labDetailses the lab detailses
	*/
	public static void cacheResult(List<LabDetails> labDetailses) {
		getPersistence().cacheResult(labDetailses);
	}

	/**
	* Creates a new lab details with the primary key. Does not add the lab details to the database.
	*
	* @param labId the primary key for the new lab details
	* @return the new lab details
	*/
	public static LabDetails create(long labId) {
		return getPersistence().create(labId);
	}

	/**
	* Removes the lab details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param labId the primary key of the lab details
	* @return the lab details that was removed
	* @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	*/
	public static LabDetails remove(long labId)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence().remove(labId);
	}

	public static LabDetails updateImpl(LabDetails labDetails) {
		return getPersistence().updateImpl(labDetails);
	}

	/**
	* Returns the lab details with the primary key or throws a {@link NoSuchLabDetailsException} if it could not be found.
	*
	* @param labId the primary key of the lab details
	* @return the lab details
	* @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	*/
	public static LabDetails findByPrimaryKey(long labId)
		throws com.netcracker.scp.exception.NoSuchLabDetailsException {
		return getPersistence().findByPrimaryKey(labId);
	}

	/**
	* Returns the lab details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param labId the primary key of the lab details
	* @return the lab details, or <code>null</code> if a lab details with the primary key could not be found
	*/
	public static LabDetails fetchByPrimaryKey(long labId) {
		return getPersistence().fetchByPrimaryKey(labId);
	}

	public static java.util.Map<java.io.Serializable, LabDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the lab detailses.
	*
	* @return the lab detailses
	*/
	public static List<LabDetails> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the lab detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @return the range of lab detailses
	*/
	public static List<LabDetails> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the lab detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of lab detailses
	*/
	public static List<LabDetails> findAll(int start, int end,
		OrderByComparator<LabDetails> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the lab detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link LabDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of lab detailses
	* @param end the upper bound of the range of lab detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of lab detailses
	*/
	public static List<LabDetails> findAll(int start, int end,
		OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the lab detailses from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of lab detailses.
	*
	* @return the number of lab detailses
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static LabDetailsPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LabDetailsPersistence, LabDetailsPersistence> _serviceTracker =
		ServiceTrackerFactory.open(LabDetailsPersistence.class);
}