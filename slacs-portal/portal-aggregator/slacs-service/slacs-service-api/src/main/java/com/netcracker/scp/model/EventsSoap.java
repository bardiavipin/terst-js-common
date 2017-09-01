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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class EventsSoap implements Serializable {
	public static EventsSoap toSoapModel(Events model) {
		EventsSoap soapModel = new EventsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEventId(model.getEventId());
		soapModel.setLabId(model.getLabId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setActivityType(model.getActivityType());
		soapModel.setFullDay(model.getFullDay());
		soapModel.setPortalUser(model.getPortalUser());
		soapModel.setPortalPass(model.getPortalPass());
		soapModel.setNcUser(model.getNcUser());
		soapModel.setNcPass(model.getNcPass());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static EventsSoap[] toSoapModels(Events[] models) {
		EventsSoap[] soapModels = new EventsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EventsSoap[][] toSoapModels(Events[][] models) {
		EventsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EventsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EventsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EventsSoap[] toSoapModels(List<Events> models) {
		List<EventsSoap> soapModels = new ArrayList<EventsSoap>(models.size());

		for (Events model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EventsSoap[soapModels.size()]);
	}

	public EventsSoap() {
	}

	public long getPrimaryKey() {
		return _eventId;
	}

	public void setPrimaryKey(long pk) {
		setEventId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public long getLabId() {
		return _labId;
	}

	public void setLabId(long labId) {
		_labId = labId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public String getActivityType() {
		return _activityType;
	}

	public void setActivityType(String activityType) {
		_activityType = activityType;
	}

	public boolean getFullDay() {
		return _fullDay;
	}

	public boolean isFullDay() {
		return _fullDay;
	}

	public void setFullDay(boolean fullDay) {
		_fullDay = fullDay;
	}

	public String getPortalUser() {
		return _portalUser;
	}

	public void setPortalUser(String portalUser) {
		_portalUser = portalUser;
	}

	public String getPortalPass() {
		return _portalPass;
	}

	public void setPortalPass(String portalPass) {
		_portalPass = portalPass;
	}

	public String getNcUser() {
		return _ncUser;
	}

	public void setNcUser(String ncUser) {
		_ncUser = ncUser;
	}

	public String getNcPass() {
		return _ncPass;
	}

	public void setNcPass(String ncPass) {
		_ncPass = ncPass;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private String _uuid;
	private long _eventId;
	private long _labId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private Date _startTime;
	private Date _endTime;
	private String _activityType;
	private boolean _fullDay;
	private String _portalUser;
	private String _portalPass;
	private String _ncUser;
	private String _ncPass;
	private int _status;
}