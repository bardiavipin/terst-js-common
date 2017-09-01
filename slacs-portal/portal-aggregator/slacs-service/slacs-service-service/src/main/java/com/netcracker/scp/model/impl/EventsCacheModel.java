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

package com.netcracker.scp.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import com.netcracker.scp.model.Events;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Events in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Events
 * @generated
 */
@ProviderType
public class EventsCacheModel implements CacheModel<Events>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventsCacheModel)) {
			return false;
		}

		EventsCacheModel eventsCacheModel = (EventsCacheModel)obj;

		if (eventId == eventsCacheModel.eventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", labId=");
		sb.append(labId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", activityType=");
		sb.append(activityType);
		sb.append(", fullDay=");
		sb.append(fullDay);
		sb.append(", portalUser=");
		sb.append(portalUser);
		sb.append(", portalPass=");
		sb.append(portalPass);
		sb.append(", ncUser=");
		sb.append(ncUser);
		sb.append(", ncPass=");
		sb.append(ncPass);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Events toEntityModel() {
		EventsImpl eventsImpl = new EventsImpl();

		if (uuid == null) {
			eventsImpl.setUuid(StringPool.BLANK);
		}
		else {
			eventsImpl.setUuid(uuid);
		}

		eventsImpl.setEventId(eventId);
		eventsImpl.setLabId(labId);
		eventsImpl.setGroupId(groupId);
		eventsImpl.setCompanyId(companyId);
		eventsImpl.setUserId(userId);

		if (userName == null) {
			eventsImpl.setUserName(StringPool.BLANK);
		}
		else {
			eventsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eventsImpl.setCreateDate(null);
		}
		else {
			eventsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventsImpl.setModifiedDate(null);
		}
		else {
			eventsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			eventsImpl.setTitle(StringPool.BLANK);
		}
		else {
			eventsImpl.setTitle(title);
		}

		if (description == null) {
			eventsImpl.setDescription(StringPool.BLANK);
		}
		else {
			eventsImpl.setDescription(description);
		}

		if (startTime == Long.MIN_VALUE) {
			eventsImpl.setStartTime(null);
		}
		else {
			eventsImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			eventsImpl.setEndTime(null);
		}
		else {
			eventsImpl.setEndTime(new Date(endTime));
		}

		if (activityType == null) {
			eventsImpl.setActivityType(StringPool.BLANK);
		}
		else {
			eventsImpl.setActivityType(activityType);
		}

		eventsImpl.setFullDay(fullDay);

		if (portalUser == null) {
			eventsImpl.setPortalUser(StringPool.BLANK);
		}
		else {
			eventsImpl.setPortalUser(portalUser);
		}

		if (portalPass == null) {
			eventsImpl.setPortalPass(StringPool.BLANK);
		}
		else {
			eventsImpl.setPortalPass(portalPass);
		}

		if (ncUser == null) {
			eventsImpl.setNcUser(StringPool.BLANK);
		}
		else {
			eventsImpl.setNcUser(ncUser);
		}

		if (ncPass == null) {
			eventsImpl.setNcPass(StringPool.BLANK);
		}
		else {
			eventsImpl.setNcPass(ncPass);
		}

		eventsImpl.setStatus(status);

		eventsImpl.resetOriginalValues();

		return eventsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		eventId = objectInput.readLong();

		labId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
		activityType = objectInput.readUTF();

		fullDay = objectInput.readBoolean();
		portalUser = objectInput.readUTF();
		portalPass = objectInput.readUTF();
		ncUser = objectInput.readUTF();
		ncPass = objectInput.readUTF();

		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(eventId);

		objectOutput.writeLong(labId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);

		if (activityType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityType);
		}

		objectOutput.writeBoolean(fullDay);

		if (portalUser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portalUser);
		}

		if (portalPass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portalPass);
		}

		if (ncUser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ncUser);
		}

		if (ncPass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ncPass);
		}

		objectOutput.writeInt(status);
	}

	public String uuid;
	public long eventId;
	public long labId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public long startTime;
	public long endTime;
	public String activityType;
	public boolean fullDay;
	public String portalUser;
	public String portalPass;
	public String ncUser;
	public String ncPass;
	public int status;
}