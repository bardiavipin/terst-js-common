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

import com.netcracker.scp.exception.NoSuchLabDetailsException;
import com.netcracker.scp.model.LabDetails;
import com.netcracker.scp.service.LabDetailsLocalServiceUtil;
import com.netcracker.scp.service.persistence.LabDetailsPersistence;
import com.netcracker.scp.service.persistence.LabDetailsUtil;

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
public class LabDetailsPersistenceTest {
	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule = new AggregateTestRule(new LiferayIntegrationTestRule(),
			PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(Propagation.REQUIRED));

	@Before
	public void setUp() {
		_persistence = LabDetailsUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<LabDetails> iterator = _labDetailses.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LabDetails labDetails = _persistence.create(pk);

		Assert.assertNotNull(labDetails);

		Assert.assertEquals(labDetails.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		LabDetails newLabDetails = addLabDetails();

		_persistence.remove(newLabDetails);

		LabDetails existingLabDetails = _persistence.fetchByPrimaryKey(newLabDetails.getPrimaryKey());

		Assert.assertNull(existingLabDetails);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addLabDetails();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LabDetails newLabDetails = _persistence.create(pk);

		newLabDetails.setUuid(RandomTestUtil.randomString());

		newLabDetails.setGroupId(RandomTestUtil.nextLong());

		newLabDetails.setCompanyId(RandomTestUtil.nextLong());

		newLabDetails.setUserId(RandomTestUtil.nextLong());

		newLabDetails.setUserName(RandomTestUtil.randomString());

		newLabDetails.setCreateDate(RandomTestUtil.nextDate());

		newLabDetails.setModifiedDate(RandomTestUtil.nextDate());

		newLabDetails.setTitle(RandomTestUtil.randomString());

		newLabDetails.setDescription(RandomTestUtil.randomString());

		newLabDetails.setPortalUrl(RandomTestUtil.randomString());

		newLabDetails.setNcUrl(RandomTestUtil.randomString());

		newLabDetails.setOtherUrl(RandomTestUtil.randomString());

		newLabDetails.setVimUser(RandomTestUtil.randomString());

		newLabDetails.setVimPass(RandomTestUtil.randomString());

		newLabDetails.setSdnUser(RandomTestUtil.randomString());

		newLabDetails.setSdnPass(RandomTestUtil.randomString());

		newLabDetails.setBassLink(RandomTestUtil.randomString());

		newLabDetails.setStatus(RandomTestUtil.randomBoolean());

		_labDetailses.add(_persistence.update(newLabDetails));

		LabDetails existingLabDetails = _persistence.findByPrimaryKey(newLabDetails.getPrimaryKey());

		Assert.assertEquals(existingLabDetails.getUuid(),
			newLabDetails.getUuid());
		Assert.assertEquals(existingLabDetails.getLabId(),
			newLabDetails.getLabId());
		Assert.assertEquals(existingLabDetails.getGroupId(),
			newLabDetails.getGroupId());
		Assert.assertEquals(existingLabDetails.getCompanyId(),
			newLabDetails.getCompanyId());
		Assert.assertEquals(existingLabDetails.getUserId(),
			newLabDetails.getUserId());
		Assert.assertEquals(existingLabDetails.getUserName(),
			newLabDetails.getUserName());
		Assert.assertEquals(Time.getShortTimestamp(
				existingLabDetails.getCreateDate()),
			Time.getShortTimestamp(newLabDetails.getCreateDate()));
		Assert.assertEquals(Time.getShortTimestamp(
				existingLabDetails.getModifiedDate()),
			Time.getShortTimestamp(newLabDetails.getModifiedDate()));
		Assert.assertEquals(existingLabDetails.getTitle(),
			newLabDetails.getTitle());
		Assert.assertEquals(existingLabDetails.getDescription(),
			newLabDetails.getDescription());
		Assert.assertEquals(existingLabDetails.getPortalUrl(),
			newLabDetails.getPortalUrl());
		Assert.assertEquals(existingLabDetails.getNcUrl(),
			newLabDetails.getNcUrl());
		Assert.assertEquals(existingLabDetails.getOtherUrl(),
			newLabDetails.getOtherUrl());
		Assert.assertEquals(existingLabDetails.getVimUser(),
			newLabDetails.getVimUser());
		Assert.assertEquals(existingLabDetails.getVimPass(),
			newLabDetails.getVimPass());
		Assert.assertEquals(existingLabDetails.getSdnUser(),
			newLabDetails.getSdnUser());
		Assert.assertEquals(existingLabDetails.getSdnPass(),
			newLabDetails.getSdnPass());
		Assert.assertEquals(existingLabDetails.getBassLink(),
			newLabDetails.getBassLink());
		Assert.assertEquals(existingLabDetails.getStatus(),
			newLabDetails.getStatus());
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
	public void testCountByStatus() throws Exception {
		_persistence.countByStatus(RandomTestUtil.randomBoolean(),
			RandomTestUtil.nextLong());

		_persistence.countByStatus(RandomTestUtil.randomBoolean(), 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		LabDetails newLabDetails = addLabDetails();

		LabDetails existingLabDetails = _persistence.findByPrimaryKey(newLabDetails.getPrimaryKey());

		Assert.assertEquals(existingLabDetails, newLabDetails);
	}

	@Test(expected = NoSuchLabDetailsException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			getOrderByComparator());
	}

	protected OrderByComparator<LabDetails> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create("Portlets_LabDetails",
			"uuid", true, "labId", true, "groupId", true, "companyId", true,
			"userId", true, "userName", true, "createDate", true,
			"modifiedDate", true, "title", true, "description", true,
			"portalUrl", true, "ncUrl", true, "otherUrl", true, "vimUser",
			true, "vimPass", true, "sdnUser", true, "sdnPass", true,
			"bassLink", true, "status", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		LabDetails newLabDetails = addLabDetails();

		LabDetails existingLabDetails = _persistence.fetchByPrimaryKey(newLabDetails.getPrimaryKey());

		Assert.assertEquals(existingLabDetails, newLabDetails);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LabDetails missingLabDetails = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingLabDetails);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {
		LabDetails newLabDetails1 = addLabDetails();
		LabDetails newLabDetails2 = addLabDetails();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLabDetails1.getPrimaryKey());
		primaryKeys.add(newLabDetails2.getPrimaryKey());

		Map<Serializable, LabDetails> labDetailses = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, labDetailses.size());
		Assert.assertEquals(newLabDetails1,
			labDetailses.get(newLabDetails1.getPrimaryKey()));
		Assert.assertEquals(newLabDetails2,
			labDetailses.get(newLabDetails2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {
		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, LabDetails> labDetailses = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(labDetailses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {
		LabDetails newLabDetails = addLabDetails();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLabDetails.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, LabDetails> labDetailses = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, labDetailses.size());
		Assert.assertEquals(newLabDetails,
			labDetailses.get(newLabDetails.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys()
		throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, LabDetails> labDetailses = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(labDetailses.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey()
		throws Exception {
		LabDetails newLabDetails = addLabDetails();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newLabDetails.getPrimaryKey());

		Map<Serializable, LabDetails> labDetailses = _persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, labDetailses.size());
		Assert.assertEquals(newLabDetails,
			labDetailses.get(newLabDetails.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery = LabDetailsLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<LabDetails>() {
				@Override
				public void performAction(LabDetails labDetails) {
					Assert.assertNotNull(labDetails);

					count.increment();
				}
			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting()
		throws Exception {
		LabDetails newLabDetails = addLabDetails();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LabDetails.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("labId",
				newLabDetails.getLabId()));

		List<LabDetails> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		LabDetails existingLabDetails = result.get(0);

		Assert.assertEquals(existingLabDetails, newLabDetails);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LabDetails.class,
				_dynamicQueryClassLoader);

		dynamicQuery.add(RestrictionsFactoryUtil.eq("labId",
				RandomTestUtil.nextLong()));

		List<LabDetails> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting()
		throws Exception {
		LabDetails newLabDetails = addLabDetails();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LabDetails.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("labId"));

		Object newLabId = newLabDetails.getLabId();

		dynamicQuery.add(RestrictionsFactoryUtil.in("labId",
				new Object[] { newLabId }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingLabId = result.get(0);

		Assert.assertEquals(existingLabId, newLabId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LabDetails.class,
				_dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("labId"));

		dynamicQuery.add(RestrictionsFactoryUtil.in("labId",
				new Object[] { RandomTestUtil.nextLong() }));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		LabDetails newLabDetails = addLabDetails();

		_persistence.clearCache();

		LabDetails existingLabDetails = _persistence.findByPrimaryKey(newLabDetails.getPrimaryKey());

		Assert.assertTrue(Objects.equals(existingLabDetails.getUuid(),
				ReflectionTestUtil.invoke(existingLabDetails,
					"getOriginalUuid", new Class<?>[0])));
		Assert.assertEquals(Long.valueOf(existingLabDetails.getGroupId()),
			ReflectionTestUtil.<Long>invoke(existingLabDetails,
				"getOriginalGroupId", new Class<?>[0]));
	}

	protected LabDetails addLabDetails() throws Exception {
		long pk = RandomTestUtil.nextLong();

		LabDetails labDetails = _persistence.create(pk);

		labDetails.setUuid(RandomTestUtil.randomString());

		labDetails.setGroupId(RandomTestUtil.nextLong());

		labDetails.setCompanyId(RandomTestUtil.nextLong());

		labDetails.setUserId(RandomTestUtil.nextLong());

		labDetails.setUserName(RandomTestUtil.randomString());

		labDetails.setCreateDate(RandomTestUtil.nextDate());

		labDetails.setModifiedDate(RandomTestUtil.nextDate());

		labDetails.setTitle(RandomTestUtil.randomString());

		labDetails.setDescription(RandomTestUtil.randomString());

		labDetails.setPortalUrl(RandomTestUtil.randomString());

		labDetails.setNcUrl(RandomTestUtil.randomString());

		labDetails.setOtherUrl(RandomTestUtil.randomString());

		labDetails.setVimUser(RandomTestUtil.randomString());

		labDetails.setVimPass(RandomTestUtil.randomString());

		labDetails.setSdnUser(RandomTestUtil.randomString());

		labDetails.setSdnPass(RandomTestUtil.randomString());

		labDetails.setBassLink(RandomTestUtil.randomString());

		labDetails.setStatus(RandomTestUtil.randomBoolean());

		_labDetailses.add(_persistence.update(labDetails));

		return labDetails;
	}

	private List<LabDetails> _labDetailses = new ArrayList<LabDetails>();
	private LabDetailsPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;
}