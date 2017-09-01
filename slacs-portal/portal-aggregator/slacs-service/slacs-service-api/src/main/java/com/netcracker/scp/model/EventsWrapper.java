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

package com.netcracker.scp.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Events}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Events
 * @generated
 */
@ProviderType
public class EventsWrapper implements Events, ModelWrapper<Events> {
	public EventsWrapper(Events events) {
		_events = events;
	}

	@Override
	public Class<?> getModelClass() {
		return Events.class;
	}

	@Override
	public String getModelClassName() {
		return Events.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("eventId", getEventId());
		attributes.put("labId", getLabId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("activityType", getActivityType());
		attributes.put("fullDay", getFullDay());
		attributes.put("portalUser", getPortalUser());
		attributes.put("portalPass", getPortalPass());
		attributes.put("ncUser", getNcUser());
		attributes.put("ncPass", getNcPass());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}

		Long labId = (Long)attributes.get("labId");

		if (labId != null) {
			setLabId(labId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		String activityType = (String)attributes.get("activityType");

		if (activityType != null) {
			setActivityType(activityType);
		}

		Boolean fullDay = (Boolean)attributes.get("fullDay");

		if (fullDay != null) {
			setFullDay(fullDay);
		}

		String portalUser = (String)attributes.get("portalUser");

		if (portalUser != null) {
			setPortalUser(portalUser);
		}

		String portalPass = (String)attributes.get("portalPass");

		if (portalPass != null) {
			setPortalPass(portalPass);
		}

		String ncUser = (String)attributes.get("ncUser");

		if (ncUser != null) {
			setNcUser(ncUser);
		}

		String ncPass = (String)attributes.get("ncPass");

		if (ncPass != null) {
			setNcPass(ncPass);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public Events toEscapedModel() {
		return new EventsWrapper(_events.toEscapedModel());
	}

	@Override
	public Events toUnescapedModel() {
		return new EventsWrapper(_events.toUnescapedModel());
	}

	/**
	* Returns the full day of this events.
	*
	* @return the full day of this events
	*/
	@Override
	public boolean getFullDay() {
		return _events.getFullDay();
	}

	@Override
	public boolean isCachedModel() {
		return _events.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _events.isEscapedModel();
	}

	/**
	* Returns <code>true</code> if this events is full day.
	*
	* @return <code>true</code> if this events is full day; <code>false</code> otherwise
	*/
	@Override
	public boolean isFullDay() {
		return _events.isFullDay();
	}

	@Override
	public boolean isNew() {
		return _events.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _events.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<Events> toCacheModel() {
		return _events.toCacheModel();
	}

	@Override
	public int compareTo(Events events) {
		return _events.compareTo(events);
	}

	/**
	* Returns the status of this events.
	*
	* @return the status of this events
	*/
	@Override
	public int getStatus() {
		return _events.getStatus();
	}

	@Override
	public int hashCode() {
		return _events.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _events.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new EventsWrapper((Events)_events.clone());
	}

	/**
	* Returns the activity type of this events.
	*
	* @return the activity type of this events
	*/
	@Override
	public java.lang.String getActivityType() {
		return _events.getActivityType();
	}

	/**
	* Returns the description of this events.
	*
	* @return the description of this events
	*/
	@Override
	public java.lang.String getDescription() {
		return _events.getDescription();
	}

	/**
	* Returns the nc pass of this events.
	*
	* @return the nc pass of this events
	*/
	@Override
	public java.lang.String getNcPass() {
		return _events.getNcPass();
	}

	/**
	* Returns the nc user of this events.
	*
	* @return the nc user of this events
	*/
	@Override
	public java.lang.String getNcUser() {
		return _events.getNcUser();
	}

	/**
	* Returns the portal pass of this events.
	*
	* @return the portal pass of this events
	*/
	@Override
	public java.lang.String getPortalPass() {
		return _events.getPortalPass();
	}

	/**
	* Returns the portal user of this events.
	*
	* @return the portal user of this events
	*/
	@Override
	public java.lang.String getPortalUser() {
		return _events.getPortalUser();
	}

	/**
	* Returns the title of this events.
	*
	* @return the title of this events
	*/
	@Override
	public java.lang.String getTitle() {
		return _events.getTitle();
	}

	/**
	* Returns the user name of this events.
	*
	* @return the user name of this events
	*/
	@Override
	public java.lang.String getUserName() {
		return _events.getUserName();
	}

	/**
	* Returns the user uuid of this events.
	*
	* @return the user uuid of this events
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _events.getUserUuid();
	}

	/**
	* Returns the uuid of this events.
	*
	* @return the uuid of this events
	*/
	@Override
	public java.lang.String getUuid() {
		return _events.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _events.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _events.toXmlString();
	}

	/**
	* Returns the create date of this events.
	*
	* @return the create date of this events
	*/
	@Override
	public Date getCreateDate() {
		return _events.getCreateDate();
	}

	/**
	* Returns the end time of this events.
	*
	* @return the end time of this events
	*/
	@Override
	public Date getEndTime() {
		return _events.getEndTime();
	}

	/**
	* Returns the modified date of this events.
	*
	* @return the modified date of this events
	*/
	@Override
	public Date getModifiedDate() {
		return _events.getModifiedDate();
	}

	/**
	* Returns the start time of this events.
	*
	* @return the start time of this events
	*/
	@Override
	public Date getStartTime() {
		return _events.getStartTime();
	}

	/**
	* Returns the company ID of this events.
	*
	* @return the company ID of this events
	*/
	@Override
	public long getCompanyId() {
		return _events.getCompanyId();
	}

	/**
	* Returns the event ID of this events.
	*
	* @return the event ID of this events
	*/
	@Override
	public long getEventId() {
		return _events.getEventId();
	}

	/**
	* Returns the group ID of this events.
	*
	* @return the group ID of this events
	*/
	@Override
	public long getGroupId() {
		return _events.getGroupId();
	}

	/**
	* Returns the lab ID of this events.
	*
	* @return the lab ID of this events
	*/
	@Override
	public long getLabId() {
		return _events.getLabId();
	}

	/**
	* Returns the primary key of this events.
	*
	* @return the primary key of this events
	*/
	@Override
	public long getPrimaryKey() {
		return _events.getPrimaryKey();
	}

	/**
	* Returns the user ID of this events.
	*
	* @return the user ID of this events
	*/
	@Override
	public long getUserId() {
		return _events.getUserId();
	}

	@Override
	public void persist() {
		_events.persist();
	}

	/**
	* Sets the activity type of this events.
	*
	* @param activityType the activity type of this events
	*/
	@Override
	public void setActivityType(java.lang.String activityType) {
		_events.setActivityType(activityType);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_events.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this events.
	*
	* @param companyId the company ID of this events
	*/
	@Override
	public void setCompanyId(long companyId) {
		_events.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this events.
	*
	* @param createDate the create date of this events
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_events.setCreateDate(createDate);
	}

	/**
	* Sets the description of this events.
	*
	* @param description the description of this events
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_events.setDescription(description);
	}

	/**
	* Sets the end time of this events.
	*
	* @param endTime the end time of this events
	*/
	@Override
	public void setEndTime(Date endTime) {
		_events.setEndTime(endTime);
	}

	/**
	* Sets the event ID of this events.
	*
	* @param eventId the event ID of this events
	*/
	@Override
	public void setEventId(long eventId) {
		_events.setEventId(eventId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_events.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_events.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_events.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets whether this events is full day.
	*
	* @param fullDay the full day of this events
	*/
	@Override
	public void setFullDay(boolean fullDay) {
		_events.setFullDay(fullDay);
	}

	/**
	* Sets the group ID of this events.
	*
	* @param groupId the group ID of this events
	*/
	@Override
	public void setGroupId(long groupId) {
		_events.setGroupId(groupId);
	}

	/**
	* Sets the lab ID of this events.
	*
	* @param labId the lab ID of this events
	*/
	@Override
	public void setLabId(long labId) {
		_events.setLabId(labId);
	}

	/**
	* Sets the modified date of this events.
	*
	* @param modifiedDate the modified date of this events
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_events.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the nc pass of this events.
	*
	* @param ncPass the nc pass of this events
	*/
	@Override
	public void setNcPass(java.lang.String ncPass) {
		_events.setNcPass(ncPass);
	}

	/**
	* Sets the nc user of this events.
	*
	* @param ncUser the nc user of this events
	*/
	@Override
	public void setNcUser(java.lang.String ncUser) {
		_events.setNcUser(ncUser);
	}

	@Override
	public void setNew(boolean n) {
		_events.setNew(n);
	}

	/**
	* Sets the portal pass of this events.
	*
	* @param portalPass the portal pass of this events
	*/
	@Override
	public void setPortalPass(java.lang.String portalPass) {
		_events.setPortalPass(portalPass);
	}

	/**
	* Sets the portal user of this events.
	*
	* @param portalUser the portal user of this events
	*/
	@Override
	public void setPortalUser(java.lang.String portalUser) {
		_events.setPortalUser(portalUser);
	}

	/**
	* Sets the primary key of this events.
	*
	* @param primaryKey the primary key of this events
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_events.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_events.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the start time of this events.
	*
	* @param startTime the start time of this events
	*/
	@Override
	public void setStartTime(Date startTime) {
		_events.setStartTime(startTime);
	}

	/**
	* Sets the status of this events.
	*
	* @param status the status of this events
	*/
	@Override
	public void setStatus(int status) {
		_events.setStatus(status);
	}

	/**
	* Sets the title of this events.
	*
	* @param title the title of this events
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_events.setTitle(title);
	}

	/**
	* Sets the user ID of this events.
	*
	* @param userId the user ID of this events
	*/
	@Override
	public void setUserId(long userId) {
		_events.setUserId(userId);
	}

	/**
	* Sets the user name of this events.
	*
	* @param userName the user name of this events
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_events.setUserName(userName);
	}

	/**
	* Sets the user uuid of this events.
	*
	* @param userUuid the user uuid of this events
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_events.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this events.
	*
	* @param uuid the uuid of this events
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_events.setUuid(uuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof EventsWrapper)) {
			return false;
		}

		EventsWrapper eventsWrapper = (EventsWrapper)obj;

		if (Objects.equals(_events, eventsWrapper._events)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _events.getStagedModelType();
	}

	@Override
	public Events getWrappedModel() {
		return _events;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _events.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _events.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_events.resetOriginalValues();
	}

	private final Events _events;
}