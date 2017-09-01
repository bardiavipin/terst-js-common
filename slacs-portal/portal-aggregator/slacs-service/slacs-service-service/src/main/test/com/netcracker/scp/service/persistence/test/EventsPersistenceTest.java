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

package com.netcracker.scp.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.rule.TransactionalTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;

import com.netcracker.scp.exception.NoSuchEventsException;
import com.netcracker.scp.model.Events;
import com.netcracker.scp.service.EventsLocalServiceUtil;
import com.netcracker.scp.service.persistence.EventsPersistence;
import com.netcracker.scp.service.persistence.EventsUtil;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import org.junit.runner.RunWith;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class EventsPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = EventsUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Events> iterator = _eventses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Events events = _persistence.create(pk);

		Assert.assertNotNull(events);

		Assert.assertEquals(events.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Events newEvents = addEvents();

		_persistence.remove(newEvents);

		Events existingEvents = _persistence.fetchByPrimaryKey(newEvents.getPrimaryKey());

		Assert.assertNull(existingEvents);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEvents();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Events newEvents = _persistence.create(pk);

		newEvents.setUuid(RandomTestUtil.randomString());

		newEvents.setLabId(RandomTestUtil.nextLong());

		newEvents.setGroupId(RandomTestUtil.nextLong());

		newEvents.setCompanyId(RandomTestUtil.nextLong());

		newEvents.setUserId(RandomTestUtil.nextLong());

		newEvents.setUserName(RandomTestUtil.randomString());

		newEvents.setCreateDate(RandomTestUtil.nextDate());

		newEvents.setModifiedDate(RandomTestUtil.nextDate());

		newEvents.setTitle(RandomTestUtil.randomString());

		newEvents.setDescription(RandomTestUtil.randomString());

		newEvents.setStartTime(RandomTestUtil.nextDate());

		newEvents.setEndTime(RandomTestUtil.nextDate());

		newEvents.setActivityType(RandomTestUtil.randomString());

		newEvents.setFullDay(RandomTestUtil.randomBoolean());

		newEvents.setPortalUser(RandomTestUtil.randomString());

		newEvents.setPortalPass(RandomTestUtil.randomString());

		newEvents.setNcUser(RandomTestUtil.randomString());

		newEvents.setNcPass(RandomTestUtil.randomString());

		newEvents.setStatus(RandomTestUtil.nextInt());

		_eventses.add(_persistence.update(newEvents));

		Events existingEvents = _persistence.findByPrimaryKey(newEvents.getPrimaryKey());

		Assert.assertEquals(existingEvents.getUuid(), newEvents.getUuid());
		Assert.assertEquals(existingEvents.getEventId(), newEvents.getEventId());
		Assert.assertEquals(existingEvents.getLabId(), newEvents.getLabId());
		Assert.assertEquals(existingEvents.getGroupId(), newEvents.getGroupId());
		Assert.assertEquals(existingEvents.getCompanyId(),
			newEvents.getCompanyId());
		Assert.assertEquals(existingEvents.getUserId(), newEvents.getUserId());
		Assert.assertEquals(existingEvents.getUserName(),
			newEvents.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingEvents.getCreateDate()),
			Time.getShortTimestamp(newEvents.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingEvents.getModifiedDate()),
			Time.getShortTimestamp(newEvents.getModifiedDate()));
		Assert.assertEquals(existingEvents.getTitle(), newEvents.getTitle());
		Assert.assertEquals(existingEvents.getDescription(),
			newEvents.getDescription());
		Assert.assertEquals(Time.getShortTimestamp(
				existingEvents.getStartTime()),
			Time.getShortTimestamp(newEvents.getStartTime()));
		Assert.assertEquals(Time.getShortTimestamp(existingEvents.getEndTime()),
			Time.getShortTimestamp(newEvents.getEndTime()));
		Assert.assertEquals(existingEvents.getActivityType(),
			newEvents.getActivityType());
		Assert.assertEquals(existingEvents.getFullDay(), newEvents.getFullDay());
		Assert.assertEquals(existingEvents.getPortalUser(),
			newEvents.getPortalUser());
		Assert.assertEquals(existingEvents.getPortalPass(),
			newEvents.getPortalPass());
		Assert.assertEquals(existingEvents.getNcUser(), newEvents.getNcUser());
		Assert.assertEquals(existingEvents.getNcPass(), newEvents.getNcPass());
		Assert.assertEquals(existingEvents.getStatus(), newEvents.getStatus());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid(StringPool.BLANK);

		_persistence.countByUuid(StringPool.NULL);

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUUID_G(StringPool.NULL, 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C(StringPool.BLANK, RandomTestUtil.nextLong());

		_persistence.countByUuid_C(StringPool.NULL, 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testCountByUser() throws Exception {
		_persistence.countByUser(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByUser(0L, 0L);
	}

	@Test
	public void testCountByLabStatus() throws Exception {
		_persistence.countByLabStatus(RandomTestUtil.nextLong(),
			RandomTestUtil.nextInt(), RandomTestUtil.nextLong());

		_persistence.countByLabStatus(0L, 0, 0L);
	}

	@Test
	public void testCountByLab() throws Exception {
		_persistence.countByLab(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong());

		_persistence.countByLab(0L, 0L);
	}

	@Test
	public void testCountByLabUser() throws Exception {
		_persistence.countByLabUser(RandomTestUtil.nextLong(),
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.countByLabUser(0L, 0L, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Events newEvents = addEvents();

		Events existingEvents = _persistence.findByPrimaryKey(newEvents.getPrimaryKey());

		Assert.assertEquals(existingEvents, newEvents);
	}

	@Test(expected = NoSuchEventsException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<Events> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Portlets_Events", "uuid",
			true, "eventId", true, "labId", true, "groupId", true, "companyId",
			true, "userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "title", true, "description", true,
			"startTime", true, "endTime", true, "activityType", true,
			"fullDay", true, "portalUser", true, "portalPass", true, "ncUser",
			true, "ncPass", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Events newEvents = addEvents();

		Events existingEvents = _persistence.fetchByPrimaryKey(newEvents.getPrimaryKey());

		Assert.assertEquals(existingEvents, newEvents);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Events missingEvents = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEvents);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		Events newEvents1 = addEvents();
		Events newEvents2 = addEvents();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEvents1.getPrimaryKey());
		primaryKeys.add(newEvents2.getPrimaryKey());

		Map<Serializable, Events> eventses = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, eventses.size());
		Assert.assertEquals(newEvents1, eventses.get(newEvents1.getPrimaryKey()));
		Assert.assertEquals(newEvents2, eventses.get(newEvents2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Events> eventses = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eventses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		Events newEvents = addEvents();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEvents.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Events> eventses = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eventses.size());
		Assert.assertEquals(newEvents, eventses.get(newEvents.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Events> eventses = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(eventses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		Events newEvents = addEvents();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEvents.getPrimaryKey());

		Map<Serializable, Events> eventses = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, eventses.size());
		Assert.assertEquals(newEvents, eventses.get(newEvents.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = EventsLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<Events>() {
				@Override
				public void performAction(Events events) {
					Assert.assertNotNull(events);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		Events newEvents = addEvents();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Events.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("eventId",
				newEvents.getEventId()));

		List<Events> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Events existingEvents = result.get(0);

		Assert.assertEquals(existingEvents, newEvents);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Events.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("eventId",
				RandomTestUtil.nextLong()));

		List<Events> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		Events newEvents = addEvents();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Events.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("eventId"));

		Object newEventId = newEvents.getEventId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("eventId",
				new Object[] { newEventId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEventId = result.get(0);

		Assert.assertEquals(existingEventId, newEventId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(Events.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("eventId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("eventId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		Events newEvents = addEvents();

		_persistence.clearCache();

		Events existingEvents = _persistence.findByPrimaryKey(newEvents.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingEvents.getUuid(),
				ReflectionTestUtil.invoke(existingEvents, "getOriginalUuid",
					new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingEvents.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingEvents,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected Events addEvents() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Events events = _persistence.create(pk);

		events.setUuid(RandomTestUtil.randomString());

		events.setLabId(RandomTestUtil.nextLong());

		events.setGroupId(RandomTestUtil.nextLong());

		events.setCompanyId(RandomTestUtil.nextLong());

		events.setUserId(RandomTestUtil.nextLong());

		events.setUserName(RandomTestUtil.randomString());

		events.setCreateDate(RandomTestUtil.nextDate());

		events.setModifiedDate(RandomTestUtil.nextDate());

		events.setTitle(RandomTestUtil.randomString());

		events.setDescription(RandomTestUtil.randomString());

		events.setStartTime(RandomTestUtil.nextDate());

		events.setEndTime(RandomTestUtil.nextDate());

		events.setActivityType(RandomTestUtil.randomString());

		events.setFullDay(RandomTestUtil.randomBoolean());

		events.setPortalUser(RandomTestUtil.randomString());

		events.setPortalPass(RandomTestUtil.randomString());

		events.setNcUser(RandomTestUtil.randomString());

		events.setNcPass(RandomTestUtil.randomString());

		events.setStatus(RandomTestUtil.nextInt());

		_eventses.add(_persistence.update(events));

		return events;
	}

	private List<Events> _eventses = new ArrayList<Events>();
	private EventsPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}