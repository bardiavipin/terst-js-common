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
public class LabDetailsSoap implements Serializable {
	public static LabDetailsSoap toSoapModel(LabDetails model) {
		LabDetailsSoap soapModel = new LabDetailsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setLabId(model.getLabId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setPortalUrl(model.getPortalUrl());
		soapModel.setNcUrl(model.getNcUrl());
		soapModel.setOtherUrl(model.getOtherUrl());
		soapModel.setVimUser(model.getVimUser());
		soapModel.setVimPass(model.getVimPass());
		soapModel.setSdnUser(model.getSdnUser());
		soapModel.setSdnPass(model.getSdnPass());
		soapModel.setBassLink(model.getBassLink());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static LabDetailsSoap[] toSoapModels(LabDetails[] models) {
		LabDetailsSoap[] soapModels = new LabDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LabDetailsSoap[][] toSoapModels(LabDetails[][] models) {
		LabDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LabDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LabDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LabDetailsSoap[] toSoapModels(List<LabDetails> models) {
		List<LabDetailsSoap> soapModels = new ArrayList<LabDetailsSoap>(models.size());

		for (LabDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LabDetailsSoap[soapModels.size()]);
	}

	public LabDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _labId;
	}

	public void setPrimaryKey(long pk) {
		setLabId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
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

	public String getPortalUrl() {
		return _portalUrl;
	}

	public void setPortalUrl(String portalUrl) {
		_portalUrl = portalUrl;
	}

	public String getNcUrl() {
		return _ncUrl;
	}

	public void setNcUrl(String ncUrl) {
		_ncUrl = ncUrl;
	}

	public String getOtherUrl() {
		return _otherUrl;
	}

	public void setOtherUrl(String otherUrl) {
		_otherUrl = otherUrl;
	}

	public String getVimUser() {
		return _vimUser;
	}

	public void setVimUser(String vimUser) {
		_vimUser = vimUser;
	}

	public String getVimPass() {
		return _vimPass;
	}

	public void setVimPass(String vimPass) {
		_vimPass = vimPass;
	}

	public String getSdnUser() {
		return _sdnUser;
	}

	public void setSdnUser(String sdnUser) {
		_sdnUser = sdnUser;
	}

	public String getSdnPass() {
		return _sdnPass;
	}

	public void setSdnPass(String sdnPass) {
		_sdnPass = sdnPass;
	}

	public String getBassLink() {
		return _bassLink;
	}

	public void setBassLink(String bassLink) {
		_bassLink = bassLink;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	private String _uuid;
	private long _labId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private String _portalUrl;
	private String _ncUrl;
	private String _otherUrl;
	private String _vimUser;
	private String _vimPass;
	private String _sdnUser;
	private String _sdnPass;
	private String _bassLink;
	private boolean _status;
}