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

package com.netcracker.scp.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.netcracker.scp.exception.NoSuchLabDetailsException;
import com.netcracker.scp.model.LabDetails;
import com.netcracker.scp.model.impl.LabDetailsImpl;
import com.netcracker.scp.model.impl.LabDetailsModelImpl;
import com.netcracker.scp.service.persistence.LabDetailsPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the lab details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LabDetailsPersistence
 * @see com.netcracker.scp.service.persistence.LabDetailsUtil
 * @generated
 */
@ProviderType
public class LabDetailsPersistenceImpl extends BasePersistenceImpl<LabDetails>
	implements LabDetailsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link LabDetailsUtil} to access the lab details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = LabDetailsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, LabDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, LabDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, LabDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, LabDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			LabDetailsModelImpl.UUID_COLUMN_BITMASK |
			LabDetailsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the lab detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching lab detailses
	 */
	@Override
	public List<LabDetails> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LabDetails> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<LabDetails> findByUuid(String uuid, int start, int end,
		OrderByComparator<LabDetails> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<LabDetails> findByUuid(String uuid, int start, int end,
		OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<LabDetails> list = null;

		if (retrieveFromCache) {
			list = (List<LabDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LabDetails labDetails : list) {
					if (!Objects.equals(uuid, labDetails.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_LABDETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LabDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<LabDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LabDetails>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first lab details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lab details
	 * @throws NoSuchLabDetailsException if a matching lab details could not be found
	 */
	@Override
	public LabDetails findByUuid_First(String uuid,
		OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = fetchByUuid_First(uuid, orderByComparator);

		if (labDetails != null) {
			return labDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLabDetailsException(msg.toString());
	}

	/**
	 * Returns the first lab details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	 */
	@Override
	public LabDetails fetchByUuid_First(String uuid,
		OrderByComparator<LabDetails> orderByComparator) {
		List<LabDetails> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last lab details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lab details
	 * @throws NoSuchLabDetailsException if a matching lab details could not be found
	 */
	@Override
	public LabDetails findByUuid_Last(String uuid,
		OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = fetchByUuid_Last(uuid, orderByComparator);

		if (labDetails != null) {
			return labDetails;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLabDetailsException(msg.toString());
	}

	/**
	 * Returns the last lab details in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	 */
	@Override
	public LabDetails fetchByUuid_Last(String uuid,
		OrderByComparator<LabDetails> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<LabDetails> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LabDetails[] findByUuid_PrevAndNext(long labId, String uuid,
		OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = findByPrimaryKey(labId);

		Session session = null;

		try {
			session = openSession();

			LabDetails[] array = new LabDetailsImpl[3];

			array[0] = getByUuid_PrevAndNext(session, labDetails, uuid,
					orderByComparator, true);

			array[1] = labDetails;

			array[2] = getByUuid_PrevAndNext(session, labDetails, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LabDetails getByUuid_PrevAndNext(Session session,
		LabDetails labDetails, String uuid,
		OrderByComparator<LabDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LABDETAILS_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LabDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(labDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LabDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lab detailses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (LabDetails labDetails : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(labDetails);
		}
	}

	/**
	 * Returns the number of lab detailses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching lab detailses
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LABDETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "labDetails.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "labDetails.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(labDetails.uuid IS NULL OR labDetails.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, LabDetailsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			LabDetailsModelImpl.UUID_COLUMN_BITMASK |
			LabDetailsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the lab details where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchLabDetailsException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching lab details
	 * @throws NoSuchLabDetailsException if a matching lab details could not be found
	 */
	@Override
	public LabDetails findByUUID_G(String uuid, long groupId)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = fetchByUUID_G(uuid, groupId);

		if (labDetails == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLabDetailsException(msg.toString());
		}

		return labDetails;
	}

	/**
	 * Returns the lab details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching lab details, or <code>null</code> if a matching lab details could not be found
	 */
	@Override
	public LabDetails fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the lab details where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching lab details, or <code>null</code> if a matching lab details could not be found
	 */
	@Override
	public LabDetails fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof LabDetails) {
			LabDetails labDetails = (LabDetails)result;

			if (!Objects.equals(uuid, labDetails.getUuid()) ||
					(groupId != labDetails.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_LABDETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<LabDetails> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					LabDetails labDetails = list.get(0);

					result = labDetails;

					cacheResult(labDetails);

					if ((labDetails.getUuid() == null) ||
							!labDetails.getUuid().equals(uuid) ||
							(labDetails.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, labDetails);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (LabDetails)result;
		}
	}

	/**
	 * Removes the lab details where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the lab details that was removed
	 */
	@Override
	public LabDetails removeByUUID_G(String uuid, long groupId)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = findByUUID_G(uuid, groupId);

		return remove(labDetails);
	}

	/**
	 * Returns the number of lab detailses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching lab detailses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LABDETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "labDetails.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "labDetails.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(labDetails.uuid IS NULL OR labDetails.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "labDetails.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, LabDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, LabDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			LabDetailsModelImpl.UUID_COLUMN_BITMASK |
			LabDetailsModelImpl.COMPANYID_COLUMN_BITMASK |
			LabDetailsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the lab detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching lab detailses
	 */
	@Override
	public List<LabDetails> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<LabDetails> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<LabDetails> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<LabDetails> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<LabDetails> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<LabDetails> list = null;

		if (retrieveFromCache) {
			list = (List<LabDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LabDetails labDetails : list) {
					if (!Objects.equals(uuid, labDetails.getUuid()) ||
							(companyId != labDetails.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LABDETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LabDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<LabDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LabDetails>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LabDetails findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (labDetails != null) {
			return labDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLabDetailsException(msg.toString());
	}

	/**
	 * Returns the first lab details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	 */
	@Override
	public LabDetails fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<LabDetails> orderByComparator) {
		List<LabDetails> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LabDetails findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (labDetails != null) {
			return labDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLabDetailsException(msg.toString());
	}

	/**
	 * Returns the last lab details in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	 */
	@Override
	public LabDetails fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<LabDetails> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<LabDetails> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LabDetails[] findByUuid_C_PrevAndNext(long labId, String uuid,
		long companyId, OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = findByPrimaryKey(labId);

		Session session = null;

		try {
			session = openSession();

			LabDetails[] array = new LabDetailsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, labDetails, uuid,
					companyId, orderByComparator, true);

			array[1] = labDetails;

			array[2] = getByUuid_C_PrevAndNext(session, labDetails, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LabDetails getByUuid_C_PrevAndNext(Session session,
		LabDetails labDetails, String uuid, long companyId,
		OrderByComparator<LabDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LABDETAILS_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LabDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(labDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LabDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lab detailses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (LabDetails labDetails : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(labDetails);
		}
	}

	/**
	 * Returns the number of lab detailses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching lab detailses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LABDETAILS_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "labDetails.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "labDetails.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(labDetails.uuid IS NULL OR labDetails.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "labDetails.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, LabDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, LabDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			LabDetailsModelImpl.USERID_COLUMN_BITMASK |
			LabDetailsModelImpl.COMPANYID_COLUMN_BITMASK |
			LabDetailsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the lab detailses where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching lab detailses
	 */
	@Override
	public List<LabDetails> findByUser(long userId, long companyId) {
		return findByUser(userId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<LabDetails> findByUser(long userId, long companyId, int start,
		int end) {
		return findByUser(userId, companyId, start, end, null);
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
	@Override
	public List<LabDetails> findByUser(long userId, long companyId, int start,
		int end, OrderByComparator<LabDetails> orderByComparator) {
		return findByUser(userId, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<LabDetails> findByUser(long userId, long companyId, int start,
		int end, OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] { userId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_USER;
			finderArgs = new Object[] {
					userId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<LabDetails> list = null;

		if (retrieveFromCache) {
			list = (List<LabDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LabDetails labDetails : list) {
					if ((userId != labDetails.getUserId()) ||
							(companyId != labDetails.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LABDETAILS_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			query.append(_FINDER_COLUMN_USER_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LabDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<LabDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LabDetails>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LabDetails findByUser_First(long userId, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = fetchByUser_First(userId, companyId,
				orderByComparator);

		if (labDetails != null) {
			return labDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLabDetailsException(msg.toString());
	}

	/**
	 * Returns the first lab details in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	 */
	@Override
	public LabDetails fetchByUser_First(long userId, long companyId,
		OrderByComparator<LabDetails> orderByComparator) {
		List<LabDetails> list = findByUser(userId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LabDetails findByUser_Last(long userId, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = fetchByUser_Last(userId, companyId,
				orderByComparator);

		if (labDetails != null) {
			return labDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLabDetailsException(msg.toString());
	}

	/**
	 * Returns the last lab details in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	 */
	@Override
	public LabDetails fetchByUser_Last(long userId, long companyId,
		OrderByComparator<LabDetails> orderByComparator) {
		int count = countByUser(userId, companyId);

		if (count == 0) {
			return null;
		}

		List<LabDetails> list = findByUser(userId, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LabDetails[] findByUser_PrevAndNext(long labId, long userId,
		long companyId, OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = findByPrimaryKey(labId);

		Session session = null;

		try {
			session = openSession();

			LabDetails[] array = new LabDetailsImpl[3];

			array[0] = getByUser_PrevAndNext(session, labDetails, userId,
					companyId, orderByComparator, true);

			array[1] = labDetails;

			array[2] = getByUser_PrevAndNext(session, labDetails, userId,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LabDetails getByUser_PrevAndNext(Session session,
		LabDetails labDetails, long userId, long companyId,
		OrderByComparator<LabDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LABDETAILS_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

		query.append(_FINDER_COLUMN_USER_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LabDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(labDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LabDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lab detailses where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUser(long userId, long companyId) {
		for (LabDetails labDetails : findByUser(userId, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(labDetails);
		}
	}

	/**
	 * Returns the number of lab detailses where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching lab detailses
	 */
	@Override
	public int countByUser(long userId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LABDETAILS_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			query.append(_FINDER_COLUMN_USER_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_USER_USERID_2 = "labDetails.userId = ? AND ";
	private static final String _FINDER_COLUMN_USER_COMPANYID_2 = "labDetails.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, LabDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByStatus",
			new String[] {
				Boolean.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS =
		new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, LabDetailsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByStatus",
			new String[] { Boolean.class.getName(), Long.class.getName() },
			LabDetailsModelImpl.STATUS_COLUMN_BITMASK |
			LabDetailsModelImpl.COMPANYID_COLUMN_BITMASK |
			LabDetailsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_STATUS = new FinderPath(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByStatus",
			new String[] { Boolean.class.getName(), Long.class.getName() });

	/**
	 * Returns all the lab detailses where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @return the matching lab detailses
	 */
	@Override
	public List<LabDetails> findByStatus(boolean status, long companyId) {
		return findByStatus(status, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<LabDetails> findByStatus(boolean status, long companyId,
		int start, int end) {
		return findByStatus(status, companyId, start, end, null);
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
	@Override
	public List<LabDetails> findByStatus(boolean status, long companyId,
		int start, int end, OrderByComparator<LabDetails> orderByComparator) {
		return findByStatus(status, companyId, start, end, orderByComparator,
			true);
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
	@Override
	public List<LabDetails> findByStatus(boolean status, long companyId,
		int start, int end, OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] { status, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_STATUS;
			finderArgs = new Object[] {
					status, companyId,
					
					start, end, orderByComparator
				};
		}

		List<LabDetails> list = null;

		if (retrieveFromCache) {
			list = (List<LabDetails>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (LabDetails labDetails : list) {
					if ((status != labDetails.getStatus()) ||
							(companyId != labDetails.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_LABDETAILS_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(LabDetailsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<LabDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LabDetails>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public LabDetails findByStatus_First(boolean status, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = fetchByStatus_First(status, companyId,
				orderByComparator);

		if (labDetails != null) {
			return labDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLabDetailsException(msg.toString());
	}

	/**
	 * Returns the first lab details in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching lab details, or <code>null</code> if a matching lab details could not be found
	 */
	@Override
	public LabDetails fetchByStatus_First(boolean status, long companyId,
		OrderByComparator<LabDetails> orderByComparator) {
		List<LabDetails> list = findByStatus(status, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LabDetails findByStatus_Last(boolean status, long companyId,
		OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = fetchByStatus_Last(status, companyId,
				orderByComparator);

		if (labDetails != null) {
			return labDetails;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("status=");
		msg.append(status);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchLabDetailsException(msg.toString());
	}

	/**
	 * Returns the last lab details in the ordered set where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching lab details, or <code>null</code> if a matching lab details could not be found
	 */
	@Override
	public LabDetails fetchByStatus_Last(boolean status, long companyId,
		OrderByComparator<LabDetails> orderByComparator) {
		int count = countByStatus(status, companyId);

		if (count == 0) {
			return null;
		}

		List<LabDetails> list = findByStatus(status, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public LabDetails[] findByStatus_PrevAndNext(long labId, boolean status,
		long companyId, OrderByComparator<LabDetails> orderByComparator)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = findByPrimaryKey(labId);

		Session session = null;

		try {
			session = openSession();

			LabDetails[] array = new LabDetailsImpl[3];

			array[0] = getByStatus_PrevAndNext(session, labDetails, status,
					companyId, orderByComparator, true);

			array[1] = labDetails;

			array[2] = getByStatus_PrevAndNext(session, labDetails, status,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected LabDetails getByStatus_PrevAndNext(Session session,
		LabDetails labDetails, boolean status, long companyId,
		OrderByComparator<LabDetails> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LABDETAILS_WHERE);

		query.append(_FINDER_COLUMN_STATUS_STATUS_2);

		query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(LabDetailsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(status);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(labDetails);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<LabDetails> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the lab detailses where status = &#63; and companyId = &#63; from the database.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 */
	@Override
	public void removeByStatus(boolean status, long companyId) {
		for (LabDetails labDetails : findByStatus(status, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(labDetails);
		}
	}

	/**
	 * Returns the number of lab detailses where status = &#63; and companyId = &#63;.
	 *
	 * @param status the status
	 * @param companyId the company ID
	 * @return the number of matching lab detailses
	 */
	@Override
	public int countByStatus(boolean status, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_STATUS;

		Object[] finderArgs = new Object[] { status, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LABDETAILS_WHERE);

			query.append(_FINDER_COLUMN_STATUS_STATUS_2);

			query.append(_FINDER_COLUMN_STATUS_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(status);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_STATUS_STATUS_2 = "labDetails.status = ? AND ";
	private static final String _FINDER_COLUMN_STATUS_COMPANYID_2 = "labDetails.companyId = ?";

	public LabDetailsPersistenceImpl() {
		setModelClass(LabDetails.class);
	}

	/**
	 * Caches the lab details in the entity cache if it is enabled.
	 *
	 * @param labDetails the lab details
	 */
	@Override
	public void cacheResult(LabDetails labDetails) {
		entityCache.putResult(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsImpl.class, labDetails.getPrimaryKey(), labDetails);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { labDetails.getUuid(), labDetails.getGroupId() },
			labDetails);

		labDetails.resetOriginalValues();
	}

	/**
	 * Caches the lab detailses in the entity cache if it is enabled.
	 *
	 * @param labDetailses the lab detailses
	 */
	@Override
	public void cacheResult(List<LabDetails> labDetailses) {
		for (LabDetails labDetails : labDetailses) {
			if (entityCache.getResult(
						LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LabDetailsImpl.class, labDetails.getPrimaryKey()) == null) {
				cacheResult(labDetails);
			}
			else {
				labDetails.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all lab detailses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LabDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lab details.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LabDetails labDetails) {
		entityCache.removeResult(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsImpl.class, labDetails.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LabDetailsModelImpl)labDetails);
	}

	@Override
	public void clearCache(List<LabDetails> labDetailses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (LabDetails labDetails : labDetailses) {
			entityCache.removeResult(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LabDetailsImpl.class, labDetails.getPrimaryKey());

			clearUniqueFindersCache((LabDetailsModelImpl)labDetails);
		}
	}

	protected void cacheUniqueFindersCache(
		LabDetailsModelImpl labDetailsModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					labDetailsModelImpl.getUuid(),
					labDetailsModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				labDetailsModelImpl);
		}
		else {
			if ((labDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						labDetailsModelImpl.getUuid(),
						labDetailsModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					labDetailsModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		LabDetailsModelImpl labDetailsModelImpl) {
		Object[] args = new Object[] {
				labDetailsModelImpl.getUuid(), labDetailsModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((labDetailsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					labDetailsModelImpl.getOriginalUuid(),
					labDetailsModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new lab details with the primary key. Does not add the lab details to the database.
	 *
	 * @param labId the primary key for the new lab details
	 * @return the new lab details
	 */
	@Override
	public LabDetails create(long labId) {
		LabDetails labDetails = new LabDetailsImpl();

		labDetails.setNew(true);
		labDetails.setPrimaryKey(labId);

		String uuid = PortalUUIDUtil.generate();

		labDetails.setUuid(uuid);

		labDetails.setCompanyId(companyProvider.getCompanyId());

		return labDetails;
	}

	/**
	 * Removes the lab details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param labId the primary key of the lab details
	 * @return the lab details that was removed
	 * @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	 */
	@Override
	public LabDetails remove(long labId) throws NoSuchLabDetailsException {
		return remove((Serializable)labId);
	}

	/**
	 * Removes the lab details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lab details
	 * @return the lab details that was removed
	 * @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	 */
	@Override
	public LabDetails remove(Serializable primaryKey)
		throws NoSuchLabDetailsException {
		Session session = null;

		try {
			session = openSession();

			LabDetails labDetails = (LabDetails)session.get(LabDetailsImpl.class,
					primaryKey);

			if (labDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLabDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(labDetails);
		}
		catch (NoSuchLabDetailsException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected LabDetails removeImpl(LabDetails labDetails) {
		labDetails = toUnwrappedModel(labDetails);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(labDetails)) {
				labDetails = (LabDetails)session.get(LabDetailsImpl.class,
						labDetails.getPrimaryKeyObj());
			}

			if (labDetails != null) {
				session.delete(labDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (labDetails != null) {
			clearCache(labDetails);
		}

		return labDetails;
	}

	@Override
	public LabDetails updateImpl(LabDetails labDetails) {
		labDetails = toUnwrappedModel(labDetails);

		boolean isNew = labDetails.isNew();

		LabDetailsModelImpl labDetailsModelImpl = (LabDetailsModelImpl)labDetails;

		if (Validator.isNull(labDetails.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			labDetails.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (labDetails.getCreateDate() == null)) {
			if (serviceContext == null) {
				labDetails.setCreateDate(now);
			}
			else {
				labDetails.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!labDetailsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				labDetails.setModifiedDate(now);
			}
			else {
				labDetails.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (labDetails.isNew()) {
				session.save(labDetails);

				labDetails.setNew(false);
			}
			else {
				labDetails = (LabDetails)session.merge(labDetails);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !LabDetailsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((labDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						labDetailsModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { labDetailsModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((labDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						labDetailsModelImpl.getOriginalUuid(),
						labDetailsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						labDetailsModelImpl.getUuid(),
						labDetailsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((labDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						labDetailsModelImpl.getOriginalUserId(),
						labDetailsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] {
						labDetailsModelImpl.getUserId(),
						labDetailsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((labDetailsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						labDetailsModelImpl.getOriginalStatus(),
						labDetailsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);

				args = new Object[] {
						labDetailsModelImpl.getStatus(),
						labDetailsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_STATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_STATUS,
					args);
			}
		}

		entityCache.putResult(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
			LabDetailsImpl.class, labDetails.getPrimaryKey(), labDetails, false);

		clearUniqueFindersCache(labDetailsModelImpl);
		cacheUniqueFindersCache(labDetailsModelImpl, isNew);

		labDetails.resetOriginalValues();

		return labDetails;
	}

	protected LabDetails toUnwrappedModel(LabDetails labDetails) {
		if (labDetails instanceof LabDetailsImpl) {
			return labDetails;
		}

		LabDetailsImpl labDetailsImpl = new LabDetailsImpl();

		labDetailsImpl.setNew(labDetails.isNew());
		labDetailsImpl.setPrimaryKey(labDetails.getPrimaryKey());

		labDetailsImpl.setUuid(labDetails.getUuid());
		labDetailsImpl.setLabId(labDetails.getLabId());
		labDetailsImpl.setGroupId(labDetails.getGroupId());
		labDetailsImpl.setCompanyId(labDetails.getCompanyId());
		labDetailsImpl.setUserId(labDetails.getUserId());
		labDetailsImpl.setUserName(labDetails.getUserName());
		labDetailsImpl.setCreateDate(labDetails.getCreateDate());
		labDetailsImpl.setModifiedDate(labDetails.getModifiedDate());
		labDetailsImpl.setTitle(labDetails.getTitle());
		labDetailsImpl.setDescription(labDetails.getDescription());
		labDetailsImpl.setPortalUrl(labDetails.getPortalUrl());
		labDetailsImpl.setNcUrl(labDetails.getNcUrl());
		labDetailsImpl.setOtherUrl(labDetails.getOtherUrl());
		labDetailsImpl.setVimUser(labDetails.getVimUser());
		labDetailsImpl.setVimPass(labDetails.getVimPass());
		labDetailsImpl.setSdnUser(labDetails.getSdnUser());
		labDetailsImpl.setSdnPass(labDetails.getSdnPass());
		labDetailsImpl.setBassLink(labDetails.getBassLink());
		labDetailsImpl.setStatus(labDetails.isStatus());

		return labDetailsImpl;
	}

	/**
	 * Returns the lab details with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab details
	 * @return the lab details
	 * @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	 */
	@Override
	public LabDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLabDetailsException {
		LabDetails labDetails = fetchByPrimaryKey(primaryKey);

		if (labDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLabDetailsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return labDetails;
	}

	/**
	 * Returns the lab details with the primary key or throws a {@link NoSuchLabDetailsException} if it could not be found.
	 *
	 * @param labId the primary key of the lab details
	 * @return the lab details
	 * @throws NoSuchLabDetailsException if a lab details with the primary key could not be found
	 */
	@Override
	public LabDetails findByPrimaryKey(long labId)
		throws NoSuchLabDetailsException {
		return findByPrimaryKey((Serializable)labId);
	}

	/**
	 * Returns the lab details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lab details
	 * @return the lab details, or <code>null</code> if a lab details with the primary key could not be found
	 */
	@Override
	public LabDetails fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
				LabDetailsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		LabDetails labDetails = (LabDetails)serializable;

		if (labDetails == null) {
			Session session = null;

			try {
				session = openSession();

				labDetails = (LabDetails)session.get(LabDetailsImpl.class,
						primaryKey);

				if (labDetails != null) {
					cacheResult(labDetails);
				}
				else {
					entityCache.putResult(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
						LabDetailsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
					LabDetailsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return labDetails;
	}

	/**
	 * Returns the lab details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param labId the primary key of the lab details
	 * @return the lab details, or <code>null</code> if a lab details with the primary key could not be found
	 */
	@Override
	public LabDetails fetchByPrimaryKey(long labId) {
		return fetchByPrimaryKey((Serializable)labId);
	}

	@Override
	public Map<Serializable, LabDetails> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, LabDetails> map = new HashMap<Serializable, LabDetails>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			LabDetails labDetails = fetchByPrimaryKey(primaryKey);

			if (labDetails != null) {
				map.put(primaryKey, labDetails);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
					LabDetailsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (LabDetails)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_LABDETAILS_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (LabDetails labDetails : (List<LabDetails>)q.list()) {
				map.put(labDetails.getPrimaryKeyObj(), labDetails);

				cacheResult(labDetails);

				uncachedPrimaryKeys.remove(labDetails.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(LabDetailsModelImpl.ENTITY_CACHE_ENABLED,
					LabDetailsImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the lab detailses.
	 *
	 * @return the lab detailses
	 */
	@Override
	public List<LabDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<LabDetails> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<LabDetails> findAll(int start, int end,
		OrderByComparator<LabDetails> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<LabDetails> findAll(int start, int end,
		OrderByComparator<LabDetails> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<LabDetails> list = null;

		if (retrieveFromCache) {
			list = (List<LabDetails>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LABDETAILS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LABDETAILS;

				if (pagination) {
					sql = sql.concat(LabDetailsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<LabDetails>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<LabDetails>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the lab detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LabDetails labDetails : findAll()) {
			remove(labDetails);
		}
	}

	/**
	 * Returns the number of lab detailses.
	 *
	 * @return the number of lab detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LABDETAILS);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LabDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lab details persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(LabDetailsImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_LABDETAILS = "SELECT labDetails FROM LabDetails labDetails";
	private static final String _SQL_SELECT_LABDETAILS_WHERE_PKS_IN = "SELECT labDetails FROM LabDetails labDetails WHERE labId IN (";
	private static final String _SQL_SELECT_LABDETAILS_WHERE = "SELECT labDetails FROM LabDetails labDetails WHERE ";
	private static final String _SQL_COUNT_LABDETAILS = "SELECT COUNT(labDetails) FROM LabDetails labDetails";
	private static final String _SQL_COUNT_LABDETAILS_WHERE = "SELECT COUNT(labDetails) FROM LabDetails labDetails WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "labDetails.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No LabDetails exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No LabDetails exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(LabDetailsPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}