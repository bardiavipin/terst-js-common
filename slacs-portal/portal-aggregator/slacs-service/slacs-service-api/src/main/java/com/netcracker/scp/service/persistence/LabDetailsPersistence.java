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

import com.netcracker.scp.exception.NoSuchLabDetailsException;
import com.netcracker.scp.model.LabDetails;

/**
 * The persistence interface for the lab details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.netcracker.scp.service.persistence.impl.LabDetailsPersistenceImpl
 * @see LabDetailsUtil
 * @generated
 */
@ProviderType
public interface LabDetailsPersistence extends BasePersistence<LabDetails> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LabDetailsUtil} to access the lab details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the lab detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching lab detailses
	*/
	public java.util.List<LabDetails> findByUuid(java.lang.String uuid);

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
	public java.util.List<LabDetails> findByUuid(java.lang.String uuid,
		int start, int end);

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
	public java.util.List<LabDetails> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

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
	public java.util.List<LabDetails> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first lab details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public LabDetails findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Returns the first lab details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public LabDetails fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

	/**
	* Returns the last lab details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public LabDetails findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Returns the last lab details in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public LabDetails fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

	/**
	* Returns the lab detailses before and after the current lab details in the ordered set where uuid = &#63;.
	*
	* @param labId the primary key of the current lab details
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next lab details
	* @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	*/
	public LabDetails[] findByUuid_PrevAndNext(long labId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Removes all the lab detailses where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of lab detailses where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching lab detailses
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the lab details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchLabDetailsException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public LabDetails findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchLabDetailsException;

	/**
	* Returns the lab details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public LabDetails fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the lab details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public LabDetails fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the lab details where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the lab details that was removed
	*/
	public LabDetails removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchLabDetailsException;

	/**
	* Returns the number of lab detailses where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching lab detailses
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the lab detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching lab detailses
	*/
	public java.util.List<LabDetails> findByUuid_C(java.lang.String uuid,
		long companyId);

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
	public java.util.List<LabDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

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
	public java.util.List<LabDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

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
	public java.util.List<LabDetails> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first lab details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public LabDetails findByUuid_C_First(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Returns the first lab details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public LabDetails fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

	/**
	* Returns the last lab details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public LabDetails findByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Returns the last lab details in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public LabDetails fetchByUuid_C_Last(java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

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
	public LabDetails[] findByUuid_C_PrevAndNext(long labId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Removes all the lab detailses where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of lab detailses where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching lab detailses
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the lab detailses where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @return the matching lab detailses
	*/
	public java.util.List<LabDetails> findByUser(long userId, long companyId);

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
	public java.util.List<LabDetails> findByUser(long userId, long companyId,
		int start, int end);

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
	public java.util.List<LabDetails> findByUser(long userId, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

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
	public java.util.List<LabDetails> findByUser(long userId, long companyId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first lab details in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public LabDetails findByUser_First(long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Returns the first lab details in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public LabDetails fetchByUser_First(long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

	/**
	* Returns the last lab details in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public LabDetails findByUser_Last(long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Returns the last lab details in the ordered set where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public LabDetails fetchByUser_Last(long userId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

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
	public LabDetails[] findByUser_PrevAndNext(long labId, long userId,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Removes all the lab detailses where userId = &#63; and companyId = &#63; from the database.
	*
	* @param userId the user ID
	* @param companyId the company ID
	*/
	public void removeByUser(long userId, long companyId);

	/**
	* Returns the number of lab detailses where userId = &#63; and companyId = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @return the number of matching lab detailses
	*/
	public int countByUser(long userId, long companyId);

	/**
	* Returns all the lab detailses where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the matching lab detailses
	*/
	public java.util.List<LabDetails> findByStatus(boolean status,
		long companyId);

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
	public java.util.List<LabDetails> findByStatus(boolean status,
		long companyId, int start, int end);

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
	public java.util.List<LabDetails> findByStatus(boolean status,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

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
	public java.util.List<LabDetails> findByStatus(boolean status,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first lab details in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public LabDetails findByStatus_First(boolean status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Returns the first lab details in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public LabDetails fetchByStatus_First(boolean status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

	/**
	* Returns the last lab details in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details
	* @throws NoSuchLabDetailsException if a matching lab details could not be found
	*/
	public LabDetails findByStatus_Last(boolean status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Returns the last lab details in the ordered set where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	*/
	public LabDetails fetchByStatus_Last(boolean status, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

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
	public LabDetails[] findByStatus_PrevAndNext(long labId, boolean status,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException;

	/**
	* Removes all the lab detailses where status = &#63; and companyId = &#63; from the database.
	*
	* @param status the status
	* @param companyId the company ID
	*/
	public void removeByStatus(boolean status, long companyId);

	/**
	* Returns the number of lab detailses where status = &#63; and companyId = &#63;.
	*
	* @param status the status
	* @param companyId the company ID
	* @return the number of matching lab detailses
	*/
	public int countByStatus(boolean status, long companyId);

	/**
	* Caches the lab details in the entity cache if it is enabled.
	*
	* @param labDetails the lab details
	*/
	public void cacheResult(LabDetails labDetails);

	/**
	* Caches the lab detailses in the entity cache if it is enabled.
	*
	* @param labDetailses the lab detailses
	*/
	public void cacheResult(java.util.List<LabDetails> labDetailses);

	/**
	* Creates a new lab details with the primary key. Does not add the lab details to the database.
	*
	* @param labId the primary key for the new lab details
	* @return the new lab details
	*/
	public LabDetails create(long labId);

	/**
	* Removes the lab details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param labId the primary key of the lab details
	* @return the lab details that was removed
	* @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	*/
	public LabDetails remove(long labId) throws NoSuchLabDetailsException;

	public LabDetails updateImpl(LabDetails labDetails);

	/**
	* Returns the lab details with the primary key or throws a {@link NoSuchLabDetailsException} if it could not be found.
	*
	* @param labId the primary key of the lab details
	* @return the lab details
	* @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	*/
	public LabDetails findByPrimaryKey(long labId)
		throws NoSuchLabDetailsException;

	/**
	* Returns the lab details with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param labId the primary key of the lab details
	* @return the lab details, or <code>null</code> if a lab details with the primary key could not be found
	*/
	public LabDetails fetchByPrimaryKey(long labId);

	@Override
	public java.util.Map<java.io.Serializable, LabDetails> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the lab detailses.
	*
	* @return the lab detailses
	*/
	public java.util.List<LabDetails> findAll();

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
	public java.util.List<LabDetails> findAll(int start, int end);

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
	public java.util.List<LabDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator);

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
	public java.util.List<LabDetails> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the lab detailses from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of lab detailses.
	*
	* @return the number of lab detailses
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}