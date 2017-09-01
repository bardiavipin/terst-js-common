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

import com.netcracker.scp.exception.NoSuchEventsException;
import com.netcracker.scp.model.Events;
import com.netcracker.scp.model.impl.EventsImpl;
import com.netcracker.scp.model.impl.EventsModelImpl;
import com.netcracker.scp.service.persistence.EventsPersistence;

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
 * The persistence implementation for the events service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EventsPersistence
 * @see com.netcracker.scp.service.persistence.EventsUtil
 * @generated
 */
@ProviderType
public class EventsPersistenceImpl extends BasePersistenceImpl<Events>
	implements EventsPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link EventsUtil} to access the events persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = EventsImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			EventsModelImpl.UUID_COLUMN_BITMASK |
			EventsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the eventses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching eventses
	 */
	@Override
	public List<Events> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Events> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Events> findByUuid(String uuid, int start, int end,
		OrderByComparator<Events> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Events> findByUuid(String uuid, int start, int end,
		OrderByComparator<Events> orderByComparator, boolean retrieveFromCache) {
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

		List<Events> list = null;

		if (retrieveFromCache) {
			list = (List<Events>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Events events : list) {
					if (!Objects.equals(uuid, events.getUuid())) {
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

			query.append(_SQL_SELECT_EVENTS_WHERE);

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
				query.append(EventsModelImpl.ORDER_BY_JPQL);
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
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	@Override
	public Events findByUuid_First(String uuid,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByUuid_First(uuid, orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
	}

	/**
	 * Returns the first events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events, or <code>null</code> if a matching events could not be found
	 */
	@Override
	public Events fetchByUuid_First(String uuid,
		OrderByComparator<Events> orderByComparator) {
		List<Events> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	@Override
	public Events findByUuid_Last(String uuid,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByUuid_Last(uuid, orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
	}

	/**
	 * Returns the last events in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching events, or <code>null</code> if a matching events could not be found
	 */
	@Override
	public Events fetchByUuid_Last(String uuid,
		OrderByComparator<Events> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Events> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Events[] findByUuid_PrevAndNext(long eventId, String uuid,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			Events[] array = new EventsImpl[3];

			array[0] = getByUuid_PrevAndNext(session, events, uuid,
					orderByComparator, true);

			array[1] = events;

			array[2] = getByUuid_PrevAndNext(session, events, uuid,
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

	protected Events getByUuid_PrevAndNext(Session session, Events events,
		String uuid, OrderByComparator<Events> orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_EVENTS_WHERE);

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
			query.append(EventsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(events);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Events> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventses where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Events events : findByUuid(uuid, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(events);
		}
	}

	/**
	 * Returns the number of eventses where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching eventses
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_EVENTS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "events.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "events.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(events.uuid IS NULL OR events.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			EventsModelImpl.UUID_COLUMN_BITMASK |
			EventsModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the events where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchEventsException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	@Override
	public Events findByUUID_G(String uuid, long groupId)
		throws NoSuchEventsException {
		Events events = fetchByUUID_G(uuid, groupId);

		if (events == null) {
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

			throw new NoSuchEventsException(msg.toString());
		}

		return events;
	}

	/**
	 * Returns the events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching events, or <code>null</code> if a matching events could not be found
	 */
	@Override
	public Events fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the events where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching events, or <code>null</code> if a matching events could not be found
	 */
	@Override
	public Events fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof Events) {
			Events events = (Events)result;

			if (!Objects.equals(uuid, events.getUuid()) ||
					(groupId != events.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_EVENTS_WHERE);

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

				List<Events> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					Events events = list.get(0);

					result = events;

					cacheResult(events);

					if ((events.getUuid() == null) ||
							!events.getUuid().equals(uuid) ||
							(events.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, events);
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
			return (Events)result;
		}
	}

	/**
	 * Removes the events where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the events that was removed
	 */
	@Override
	public Events removeByUUID_G(String uuid, long groupId)
		throws NoSuchEventsException {
		Events events = findByUUID_G(uuid, groupId);

		return remove(events);
	}

	/**
	 * Returns the number of eventses where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching eventses
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "events.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "events.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(events.uuid IS NULL OR events.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "events.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			EventsModelImpl.UUID_COLUMN_BITMASK |
			EventsModelImpl.COMPANYID_COLUMN_BITMASK |
			EventsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the eventses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching eventses
	 */
	@Override
	public List<Events> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Events> findByUuid_C(String uuid, long companyId, int start,
		int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Events> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Events> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Events> findByUuid_C(String uuid, long companyId, int start,
		int end, OrderByComparator<Events> orderByComparator,
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

		List<Events> list = null;

		if (retrieveFromCache) {
			list = (List<Events>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Events events : list) {
					if (!Objects.equals(uuid, events.getUuid()) ||
							(companyId != events.getCompanyId())) {
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

			query.append(_SQL_SELECT_EVENTS_WHERE);

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
				query.append(EventsModelImpl.ORDER_BY_JPQL);
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
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first events in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	@Override
	public Events findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
	}

	/**
	 * Returns the first events in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events, or <code>null</code> if a matching events could not be found
	 */
	@Override
	public Events fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<Events> orderByComparator) {
		List<Events> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Events findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
	}

	/**
	 * Returns the last events in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching events, or <code>null</code> if a matching events could not be found
	 */
	@Override
	public Events fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<Events> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Events> list = findByUuid_C(uuid, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Events[] findByUuid_C_PrevAndNext(long eventId, String uuid,
		long companyId, OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			Events[] array = new EventsImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, events, uuid,
					companyId, orderByComparator, true);

			array[1] = events;

			array[2] = getByUuid_C_PrevAndNext(session, events, uuid,
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

	protected Events getByUuid_C_PrevAndNext(Session session, Events events,
		String uuid, long companyId,
		OrderByComparator<Events> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_EVENTS_WHERE);

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
			query.append(EventsModelImpl.ORDER_BY_JPQL);
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
			Object[] values = orderByComparator.getOrderByConditionValues(events);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Events> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventses where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Events events : findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(events);
		}
	}

	/**
	 * Returns the number of eventses where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching eventses
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTS_WHERE);

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "events.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "events.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(events.uuid IS NULL OR events.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "events.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_USER = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventsModelImpl.USERID_COLUMN_BITMASK |
			EventsModelImpl.COMPANYID_COLUMN_BITMASK |
			EventsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_USER = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the eventses where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching eventses
	 */
	@Override
	public List<Events> findByUser(long userId, long companyId) {
		return findByUser(userId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Events> findByUser(long userId, long companyId, int start,
		int end) {
		return findByUser(userId, companyId, start, end, null);
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
	@Override
	public List<Events> findByUser(long userId, long companyId, int start,
		int end, OrderByComparator<Events> orderByComparator) {
		return findByUser(userId, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Events> findByUser(long userId, long companyId, int start,
		int end, OrderByComparator<Events> orderByComparator,
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

		List<Events> list = null;

		if (retrieveFromCache) {
			list = (List<Events>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Events events : list) {
					if ((userId != events.getUserId()) ||
							(companyId != events.getCompanyId())) {
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

			query.append(_SQL_SELECT_EVENTS_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			query.append(_FINDER_COLUMN_USER_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventsModelImpl.ORDER_BY_JPQL);
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
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first events in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	@Override
	public Events findByUser_First(long userId, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByUser_First(userId, companyId, orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
	}

	/**
	 * Returns the first events in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events, or <code>null</code> if a matching events could not be found
	 */
	@Override
	public Events fetchByUser_First(long userId, long companyId,
		OrderByComparator<Events> orderByComparator) {
		List<Events> list = findByUser(userId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Events findByUser_Last(long userId, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByUser_Last(userId, companyId, orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
	}

	/**
	 * Returns the last events in the ordered set where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching events, or <code>null</code> if a matching events could not be found
	 */
	@Override
	public Events fetchByUser_Last(long userId, long companyId,
		OrderByComparator<Events> orderByComparator) {
		int count = countByUser(userId, companyId);

		if (count == 0) {
			return null;
		}

		List<Events> list = findByUser(userId, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Events[] findByUser_PrevAndNext(long eventId, long userId,
		long companyId, OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			Events[] array = new EventsImpl[3];

			array[0] = getByUser_PrevAndNext(session, events, userId,
					companyId, orderByComparator, true);

			array[1] = events;

			array[2] = getByUser_PrevAndNext(session, events, userId,
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

	protected Events getByUser_PrevAndNext(Session session, Events events,
		long userId, long companyId,
		OrderByComparator<Events> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_EVENTS_WHERE);

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
			query.append(EventsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(events);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Events> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventses where userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUser(long userId, long companyId) {
		for (Events events : findByUser(userId, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(events);
		}
	}

	/**
	 * Returns the number of eventses where userId = &#63; and companyId = &#63;.
	 *
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching eventses
	 */
	@Override
	public int countByUser(long userId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_USER;

		Object[] finderArgs = new Object[] { userId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTS_WHERE);

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

	private static final String _FINDER_COLUMN_USER_USERID_2 = "events.userId = ? AND ";
	private static final String _FINDER_COLUMN_USER_COMPANYID_2 = "events.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LABSTATUS =
		new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLabStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABSTATUS =
		new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLabStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName()
			},
			EventsModelImpl.LABID_COLUMN_BITMASK |
			EventsModelImpl.STATUS_COLUMN_BITMASK |
			EventsModelImpl.COMPANYID_COLUMN_BITMASK |
			EventsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LABSTATUS = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLabStatus",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Long.class.getName()
			});

	/**
	 * Returns all the eventses where labId = &#63; and status = &#63; and companyId = &#63;.
	 *
	 * @param labId the lab ID
	 * @param status the status
	 * @param companyId the company ID
	 * @return the matching eventses
	 */
	@Override
	public List<Events> findByLabStatus(long labId, int status, long companyId) {
		return findByLabStatus(labId, status, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Events> findByLabStatus(long labId, int status, long companyId,
		int start, int end) {
		return findByLabStatus(labId, status, companyId, start, end, null);
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
	@Override
	public List<Events> findByLabStatus(long labId, int status, long companyId,
		int start, int end, OrderByComparator<Events> orderByComparator) {
		return findByLabStatus(labId, status, companyId, start, end,
			orderByComparator, true);
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
	@Override
	public List<Events> findByLabStatus(long labId, int status, long companyId,
		int start, int end, OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABSTATUS;
			finderArgs = new Object[] { labId, status, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LABSTATUS;
			finderArgs = new Object[] {
					labId, status, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Events> list = null;

		if (retrieveFromCache) {
			list = (List<Events>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Events events : list) {
					if ((labId != events.getLabId()) ||
							(status != events.getStatus()) ||
							(companyId != events.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_EVENTS_WHERE);

			query.append(_FINDER_COLUMN_LABSTATUS_LABID_2);

			query.append(_FINDER_COLUMN_LABSTATUS_STATUS_2);

			query.append(_FINDER_COLUMN_LABSTATUS_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(labId);

				qPos.add(status);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first events in the ordered set where labId = &#63; and status = &#63; and companyId = &#63;.
	 *
	 * @param labId the lab ID
	 * @param status the status
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	@Override
	public Events findByLabStatus_First(long labId, int status, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByLabStatus_First(labId, status, companyId,
				orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("labId=");
		msg.append(labId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
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
	@Override
	public Events fetchByLabStatus_First(long labId, int status,
		long companyId, OrderByComparator<Events> orderByComparator) {
		List<Events> list = findByLabStatus(labId, status, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Events findByLabStatus_Last(long labId, int status, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByLabStatus_Last(labId, status, companyId,
				orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("labId=");
		msg.append(labId);

		msg.append(", status=");
		msg.append(status);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
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
	@Override
	public Events fetchByLabStatus_Last(long labId, int status, long companyId,
		OrderByComparator<Events> orderByComparator) {
		int count = countByLabStatus(labId, status, companyId);

		if (count == 0) {
			return null;
		}

		List<Events> list = findByLabStatus(labId, status, companyId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Events[] findByLabStatus_PrevAndNext(long eventId, long labId,
		int status, long companyId, OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			Events[] array = new EventsImpl[3];

			array[0] = getByLabStatus_PrevAndNext(session, events, labId,
					status, companyId, orderByComparator, true);

			array[1] = events;

			array[2] = getByLabStatus_PrevAndNext(session, events, labId,
					status, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Events getByLabStatus_PrevAndNext(Session session, Events events,
		long labId, int status, long companyId,
		OrderByComparator<Events> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_EVENTS_WHERE);

		query.append(_FINDER_COLUMN_LABSTATUS_LABID_2);

		query.append(_FINDER_COLUMN_LABSTATUS_STATUS_2);

		query.append(_FINDER_COLUMN_LABSTATUS_COMPANYID_2);

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
			query.append(EventsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(labId);

		qPos.add(status);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(events);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Events> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventses where labId = &#63; and status = &#63; and companyId = &#63; from the database.
	 *
	 * @param labId the lab ID
	 * @param status the status
	 * @param companyId the company ID
	 */
	@Override
	public void removeByLabStatus(long labId, int status, long companyId) {
		for (Events events : findByLabStatus(labId, status, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(events);
		}
	}

	/**
	 * Returns the number of eventses where labId = &#63; and status = &#63; and companyId = &#63;.
	 *
	 * @param labId the lab ID
	 * @param status the status
	 * @param companyId the company ID
	 * @return the number of matching eventses
	 */
	@Override
	public int countByLabStatus(long labId, int status, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LABSTATUS;

		Object[] finderArgs = new Object[] { labId, status, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EVENTS_WHERE);

			query.append(_FINDER_COLUMN_LABSTATUS_LABID_2);

			query.append(_FINDER_COLUMN_LABSTATUS_STATUS_2);

			query.append(_FINDER_COLUMN_LABSTATUS_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(labId);

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

	private static final String _FINDER_COLUMN_LABSTATUS_LABID_2 = "events.labId = ? AND ";
	private static final String _FINDER_COLUMN_LABSTATUS_STATUS_2 = "events.status = ? AND ";
	private static final String _FINDER_COLUMN_LABSTATUS_COMPANYID_2 = "events.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LAB = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLab",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAB = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLab",
			new String[] { Long.class.getName(), Long.class.getName() },
			EventsModelImpl.LABID_COLUMN_BITMASK |
			EventsModelImpl.COMPANYID_COLUMN_BITMASK |
			EventsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LAB = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLab",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the eventses where labId = &#63; and companyId = &#63;.
	 *
	 * @param labId the lab ID
	 * @param companyId the company ID
	 * @return the matching eventses
	 */
	@Override
	public List<Events> findByLab(long labId, long companyId) {
		return findByLab(labId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Events> findByLab(long labId, long companyId, int start, int end) {
		return findByLab(labId, companyId, start, end, null);
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
	@Override
	public List<Events> findByLab(long labId, long companyId, int start,
		int end, OrderByComparator<Events> orderByComparator) {
		return findByLab(labId, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Events> findByLab(long labId, long companyId, int start,
		int end, OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAB;
			finderArgs = new Object[] { labId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LAB;
			finderArgs = new Object[] {
					labId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Events> list = null;

		if (retrieveFromCache) {
			list = (List<Events>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Events events : list) {
					if ((labId != events.getLabId()) ||
							(companyId != events.getCompanyId())) {
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

			query.append(_SQL_SELECT_EVENTS_WHERE);

			query.append(_FINDER_COLUMN_LAB_LABID_2);

			query.append(_FINDER_COLUMN_LAB_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(labId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first events in the ordered set where labId = &#63; and companyId = &#63;.
	 *
	 * @param labId the lab ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	@Override
	public Events findByLab_First(long labId, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByLab_First(labId, companyId, orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("labId=");
		msg.append(labId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
	}

	/**
	 * Returns the first events in the ordered set where labId = &#63; and companyId = &#63;.
	 *
	 * @param labId the lab ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events, or <code>null</code> if a matching events could not be found
	 */
	@Override
	public Events fetchByLab_First(long labId, long companyId,
		OrderByComparator<Events> orderByComparator) {
		List<Events> list = findByLab(labId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Events findByLab_Last(long labId, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByLab_Last(labId, companyId, orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("labId=");
		msg.append(labId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
	}

	/**
	 * Returns the last events in the ordered set where labId = &#63; and companyId = &#63;.
	 *
	 * @param labId the lab ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching events, or <code>null</code> if a matching events could not be found
	 */
	@Override
	public Events fetchByLab_Last(long labId, long companyId,
		OrderByComparator<Events> orderByComparator) {
		int count = countByLab(labId, companyId);

		if (count == 0) {
			return null;
		}

		List<Events> list = findByLab(labId, companyId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Events[] findByLab_PrevAndNext(long eventId, long labId,
		long companyId, OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			Events[] array = new EventsImpl[3];

			array[0] = getByLab_PrevAndNext(session, events, labId, companyId,
					orderByComparator, true);

			array[1] = events;

			array[2] = getByLab_PrevAndNext(session, events, labId, companyId,
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

	protected Events getByLab_PrevAndNext(Session session, Events events,
		long labId, long companyId,
		OrderByComparator<Events> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_EVENTS_WHERE);

		query.append(_FINDER_COLUMN_LAB_LABID_2);

		query.append(_FINDER_COLUMN_LAB_COMPANYID_2);

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
			query.append(EventsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(labId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(events);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Events> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventses where labId = &#63; and companyId = &#63; from the database.
	 *
	 * @param labId the lab ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByLab(long labId, long companyId) {
		for (Events events : findByLab(labId, companyId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(events);
		}
	}

	/**
	 * Returns the number of eventses where labId = &#63; and companyId = &#63;.
	 *
	 * @param labId the lab ID
	 * @param companyId the company ID
	 * @return the number of matching eventses
	 */
	@Override
	public int countByLab(long labId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LAB;

		Object[] finderArgs = new Object[] { labId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_EVENTS_WHERE);

			query.append(_FINDER_COLUMN_LAB_LABID_2);

			query.append(_FINDER_COLUMN_LAB_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(labId);

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

	private static final String _FINDER_COLUMN_LAB_LABID_2 = "events.labId = ? AND ";
	private static final String _FINDER_COLUMN_LAB_COMPANYID_2 = "events.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_LABUSER = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByLabUser",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABUSER =
		new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, EventsImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByLabUser",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			EventsModelImpl.LABID_COLUMN_BITMASK |
			EventsModelImpl.USERID_COLUMN_BITMASK |
			EventsModelImpl.COMPANYID_COLUMN_BITMASK |
			EventsModelImpl.CREATEDATE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_LABUSER = new FinderPath(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByLabUser",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

	/**
	 * Returns all the eventses where labId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param labId the lab ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the matching eventses
	 */
	@Override
	public List<Events> findByLabUser(long labId, long userId, long companyId) {
		return findByLabUser(labId, userId, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Events> findByLabUser(long labId, long userId, long companyId,
		int start, int end) {
		return findByLabUser(labId, userId, companyId, start, end, null);
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
	@Override
	public List<Events> findByLabUser(long labId, long userId, long companyId,
		int start, int end, OrderByComparator<Events> orderByComparator) {
		return findByLabUser(labId, userId, companyId, start, end,
			orderByComparator, true);
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
	@Override
	public List<Events> findByLabUser(long labId, long userId, long companyId,
		int start, int end, OrderByComparator<Events> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABUSER;
			finderArgs = new Object[] { labId, userId, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_LABUSER;
			finderArgs = new Object[] {
					labId, userId, companyId,
					
					start, end, orderByComparator
				};
		}

		List<Events> list = null;

		if (retrieveFromCache) {
			list = (List<Events>)finderCache.getResult(finderPath, finderArgs,
					this);

			if ((list != null) && !list.isEmpty()) {
				for (Events events : list) {
					if ((labId != events.getLabId()) ||
							(userId != events.getUserId()) ||
							(companyId != events.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(5 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_EVENTS_WHERE);

			query.append(_FINDER_COLUMN_LABUSER_LABID_2);

			query.append(_FINDER_COLUMN_LABUSER_USERID_2);

			query.append(_FINDER_COLUMN_LABUSER_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(EventsModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(labId);

				qPos.add(userId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first events in the ordered set where labId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param labId the lab ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching events
	 * @throws NoSuchEventsException if a matching events could not be found
	 */
	@Override
	public Events findByLabUser_First(long labId, long userId, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByLabUser_First(labId, userId, companyId,
				orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("labId=");
		msg.append(labId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
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
	@Override
	public Events fetchByLabUser_First(long labId, long userId, long companyId,
		OrderByComparator<Events> orderByComparator) {
		List<Events> list = findByLabUser(labId, userId, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Events findByLabUser_Last(long labId, long userId, long companyId,
		OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = fetchByLabUser_Last(labId, userId, companyId,
				orderByComparator);

		if (events != null) {
			return events;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("labId=");
		msg.append(labId);

		msg.append(", userId=");
		msg.append(userId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchEventsException(msg.toString());
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
	@Override
	public Events fetchByLabUser_Last(long labId, long userId, long companyId,
		OrderByComparator<Events> orderByComparator) {
		int count = countByLabUser(labId, userId, companyId);

		if (count == 0) {
			return null;
		}

		List<Events> list = findByLabUser(labId, userId, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Events[] findByLabUser_PrevAndNext(long eventId, long labId,
		long userId, long companyId, OrderByComparator<Events> orderByComparator)
		throws NoSuchEventsException {
		Events events = findByPrimaryKey(eventId);

		Session session = null;

		try {
			session = openSession();

			Events[] array = new EventsImpl[3];

			array[0] = getByLabUser_PrevAndNext(session, events, labId, userId,
					companyId, orderByComparator, true);

			array[1] = events;

			array[2] = getByLabUser_PrevAndNext(session, events, labId, userId,
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

	protected Events getByLabUser_PrevAndNext(Session session, Events events,
		long labId, long userId, long companyId,
		OrderByComparator<Events> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_EVENTS_WHERE);

		query.append(_FINDER_COLUMN_LABUSER_LABID_2);

		query.append(_FINDER_COLUMN_LABUSER_USERID_2);

		query.append(_FINDER_COLUMN_LABUSER_COMPANYID_2);

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
			query.append(EventsModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(labId);

		qPos.add(userId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(events);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Events> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the eventses where labId = &#63; and userId = &#63; and companyId = &#63; from the database.
	 *
	 * @param labId the lab ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByLabUser(long labId, long userId, long companyId) {
		for (Events events : findByLabUser(labId, userId, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(events);
		}
	}

	/**
	 * Returns the number of eventses where labId = &#63; and userId = &#63; and companyId = &#63;.
	 *
	 * @param labId the lab ID
	 * @param userId the user ID
	 * @param companyId the company ID
	 * @return the number of matching eventses
	 */
	@Override
	public int countByLabUser(long labId, long userId, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_LABUSER;

		Object[] finderArgs = new Object[] { labId, userId, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_EVENTS_WHERE);

			query.append(_FINDER_COLUMN_LABUSER_LABID_2);

			query.append(_FINDER_COLUMN_LABUSER_USERID_2);

			query.append(_FINDER_COLUMN_LABUSER_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(labId);

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

	private static final String _FINDER_COLUMN_LABUSER_LABID_2 = "events.labId = ? AND ";
	private static final String _FINDER_COLUMN_LABUSER_USERID_2 = "events.userId = ? AND ";
	private static final String _FINDER_COLUMN_LABUSER_COMPANYID_2 = "events.companyId = ?";

	public EventsPersistenceImpl() {
		setModelClass(Events.class);
	}

	/**
	 * Caches the events in the entity cache if it is enabled.
	 *
	 * @param events the events
	 */
	@Override
	public void cacheResult(Events events) {
		entityCache.putResult(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsImpl.class, events.getPrimaryKey(), events);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { events.getUuid(), events.getGroupId() }, events);

		events.resetOriginalValues();
	}

	/**
	 * Caches the eventses in the entity cache if it is enabled.
	 *
	 * @param eventses the eventses
	 */
	@Override
	public void cacheResult(List<Events> eventses) {
		for (Events events : eventses) {
			if (entityCache.getResult(EventsModelImpl.ENTITY_CACHE_ENABLED,
						EventsImpl.class, events.getPrimaryKey()) == null) {
				cacheResult(events);
			}
			else {
				events.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all eventses.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(EventsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the events.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Events events) {
		entityCache.removeResult(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsImpl.class, events.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((EventsModelImpl)events);
	}

	@Override
	public void clearCache(List<Events> eventses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Events events : eventses) {
			entityCache.removeResult(EventsModelImpl.ENTITY_CACHE_ENABLED,
				EventsImpl.class, events.getPrimaryKey());

			clearUniqueFindersCache((EventsModelImpl)events);
		}
	}

	protected void cacheUniqueFindersCache(EventsModelImpl eventsModelImpl,
		boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					eventsModelImpl.getUuid(), eventsModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				eventsModelImpl);
		}
		else {
			if ((eventsModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventsModelImpl.getUuid(), eventsModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					eventsModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(EventsModelImpl eventsModelImpl) {
		Object[] args = new Object[] {
				eventsModelImpl.getUuid(), eventsModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((eventsModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					eventsModelImpl.getOriginalUuid(),
					eventsModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new events with the primary key. Does not add the events to the database.
	 *
	 * @param eventId the primary key for the new events
	 * @return the new events
	 */
	@Override
	public Events create(long eventId) {
		Events events = new EventsImpl();

		events.setNew(true);
		events.setPrimaryKey(eventId);

		String uuid = PortalUUIDUtil.generate();

		events.setUuid(uuid);

		events.setCompanyId(companyProvider.getCompanyId());

		return events;
	}

	/**
	 * Removes the events with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param eventId the primary key of the events
	 * @return the events that was removed
	 * @throws NoSuchEventsException if a events with the primary key could not be found
	 */
	@Override
	public Events remove(long eventId) throws NoSuchEventsException {
		return remove((Serializable)eventId);
	}

	/**
	 * Removes the events with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the events
	 * @return the events that was removed
	 * @throws NoSuchEventsException if a events with the primary key could not be found
	 */
	@Override
	public Events remove(Serializable primaryKey) throws NoSuchEventsException {
		Session session = null;

		try {
			session = openSession();

			Events events = (Events)session.get(EventsImpl.class, primaryKey);

			if (events == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchEventsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(events);
		}
		catch (NoSuchEventsException nsee) {
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
	protected Events removeImpl(Events events) {
		events = toUnwrappedModel(events);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(events)) {
				events = (Events)session.get(EventsImpl.class,
						events.getPrimaryKeyObj());
			}

			if (events != null) {
				session.delete(events);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (events != null) {
			clearCache(events);
		}

		return events;
	}

	@Override
	public Events updateImpl(Events events) {
		events = toUnwrappedModel(events);

		boolean isNew = events.isNew();

		EventsModelImpl eventsModelImpl = (EventsModelImpl)events;

		if (Validator.isNull(events.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			events.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (events.getCreateDate() == null)) {
			if (serviceContext == null) {
				events.setCreateDate(now);
			}
			else {
				events.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!eventsModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				events.setModifiedDate(now);
			}
			else {
				events.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (events.isNew()) {
				session.save(events);

				events.setNew(false);
			}
			else {
				events = (Events)session.merge(events);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !EventsModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((eventsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { eventsModelImpl.getOriginalUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { eventsModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((eventsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventsModelImpl.getOriginalUuid(),
						eventsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						eventsModelImpl.getUuid(),
						eventsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((eventsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventsModelImpl.getOriginalUserId(),
						eventsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);

				args = new Object[] {
						eventsModelImpl.getUserId(),
						eventsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_USER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_USER,
					args);
			}

			if ((eventsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABSTATUS.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventsModelImpl.getOriginalLabId(),
						eventsModelImpl.getOriginalStatus(),
						eventsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LABSTATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABSTATUS,
					args);

				args = new Object[] {
						eventsModelImpl.getLabId(), eventsModelImpl.getStatus(),
						eventsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LABSTATUS, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABSTATUS,
					args);
			}

			if ((eventsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAB.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventsModelImpl.getOriginalLabId(),
						eventsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LAB, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAB,
					args);

				args = new Object[] {
						eventsModelImpl.getLabId(),
						eventsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LAB, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LAB,
					args);
			}

			if ((eventsModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABUSER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						eventsModelImpl.getOriginalLabId(),
						eventsModelImpl.getOriginalUserId(),
						eventsModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LABUSER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABUSER,
					args);

				args = new Object[] {
						eventsModelImpl.getLabId(), eventsModelImpl.getUserId(),
						eventsModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_LABUSER, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_LABUSER,
					args);
			}
		}

		entityCache.putResult(EventsModelImpl.ENTITY_CACHE_ENABLED,
			EventsImpl.class, events.getPrimaryKey(), events, false);

		clearUniqueFindersCache(eventsModelImpl);
		cacheUniqueFindersCache(eventsModelImpl, isNew);

		events.resetOriginalValues();

		return events;
	}

	protected Events toUnwrappedModel(Events events) {
		if (events instanceof EventsImpl) {
			return events;
		}

		EventsImpl eventsImpl = new EventsImpl();

		eventsImpl.setNew(events.isNew());
		eventsImpl.setPrimaryKey(events.getPrimaryKey());

		eventsImpl.setUuid(events.getUuid());
		eventsImpl.setEventId(events.getEventId());
		eventsImpl.setLabId(events.getLabId());
		eventsImpl.setGroupId(events.getGroupId());
		eventsImpl.setCompanyId(events.getCompanyId());
		eventsImpl.setUserId(events.getUserId());
		eventsImpl.setUserName(events.getUserName());
		eventsImpl.setCreateDate(events.getCreateDate());
		eventsImpl.setModifiedDate(events.getModifiedDate());
		eventsImpl.setTitle(events.getTitle());
		eventsImpl.setDescription(events.getDescription());
		eventsImpl.setStartTime(events.getStartTime());
		eventsImpl.setEndTime(events.getEndTime());
		eventsImpl.setActivityType(events.getActivityType());
		eventsImpl.setFullDay(events.isFullDay());
		eventsImpl.setPortalUser(events.getPortalUser());
		eventsImpl.setPortalPass(events.getPortalPass());
		eventsImpl.setNcUser(events.getNcUser());
		eventsImpl.setNcPass(events.getNcPass());
		eventsImpl.setStatus(events.getStatus());

		return eventsImpl;
	}

	/**
	 * Returns the events with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the events
	 * @return the events
	 * @throws NoSuchEventsException if a events with the primary key could not be found
	 */
	@Override
	public Events findByPrimaryKey(Serializable primaryKey)
		throws NoSuchEventsException {
		Events events = fetchByPrimaryKey(primaryKey);

		if (events == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchEventsException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return events;
	}

	/**
	 * Returns the events with the primary key or throws a {@link NoSuchEventsException} if it could not be found.
	 *
	 * @param eventId the primary key of the events
	 * @return the events
	 * @throws NoSuchEventsException if a events with the primary key could not be found
	 */
	@Override
	public Events findByPrimaryKey(long eventId) throws NoSuchEventsException {
		return findByPrimaryKey((Serializable)eventId);
	}

	/**
	 * Returns the events with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the events
	 * @return the events, or <code>null</code> if a events with the primary key could not be found
	 */
	@Override
	public Events fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(EventsModelImpl.ENTITY_CACHE_ENABLED,
				EventsImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Events events = (Events)serializable;

		if (events == null) {
			Session session = null;

			try {
				session = openSession();

				events = (Events)session.get(EventsImpl.class, primaryKey);

				if (events != null) {
					cacheResult(events);
				}
				else {
					entityCache.putResult(EventsModelImpl.ENTITY_CACHE_ENABLED,
						EventsImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(EventsModelImpl.ENTITY_CACHE_ENABLED,
					EventsImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return events;
	}

	/**
	 * Returns the events with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param eventId the primary key of the events
	 * @return the events, or <code>null</code> if a events with the primary key could not be found
	 */
	@Override
	public Events fetchByPrimaryKey(long eventId) {
		return fetchByPrimaryKey((Serializable)eventId);
	}

	@Override
	public Map<Serializable, Events> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Events> map = new HashMap<Serializable, Events>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Events events = fetchByPrimaryKey(primaryKey);

			if (events != null) {
				map.put(primaryKey, events);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(EventsModelImpl.ENTITY_CACHE_ENABLED,
					EventsImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Events)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_EVENTS_WHERE_PKS_IN);

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

			for (Events events : (List<Events>)q.list()) {
				map.put(events.getPrimaryKeyObj(), events);

				cacheResult(events);

				uncachedPrimaryKeys.remove(events.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(EventsModelImpl.ENTITY_CACHE_ENABLED,
					EventsImpl.class, primaryKey, nullModel);
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
	 * Returns all the eventses.
	 *
	 * @return the eventses
	 */
	@Override
	public List<Events> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Events> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Events> findAll(int start, int end,
		OrderByComparator<Events> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Events> findAll(int start, int end,
		OrderByComparator<Events> orderByComparator, boolean retrieveFromCache) {
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

		List<Events> list = null;

		if (retrieveFromCache) {
			list = (List<Events>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_EVENTS);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_EVENTS;

				if (pagination) {
					sql = sql.concat(EventsModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Events>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the eventses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Events events : findAll()) {
			remove(events);
		}
	}

	/**
	 * Returns the number of eventses.
	 *
	 * @return the number of eventses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_EVENTS);

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
		return EventsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the events persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(EventsImpl.class.getName());
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
	private static final String _SQL_SELECT_EVENTS = "SELECT events FROM Events events";
	private static final String _SQL_SELECT_EVENTS_WHERE_PKS_IN = "SELECT events FROM Events events WHERE eventId IN (";
	private static final String _SQL_SELECT_EVENTS_WHERE = "SELECT events FROM Events events WHERE ";
	private static final String _SQL_COUNT_EVENTS = "SELECT COUNT(events) FROM Events events";
	private static final String _SQL_COUNT_EVENTS_WHERE = "SELECT COUNT(events) FROM Events events WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "events.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Events exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Events exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(EventsPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}