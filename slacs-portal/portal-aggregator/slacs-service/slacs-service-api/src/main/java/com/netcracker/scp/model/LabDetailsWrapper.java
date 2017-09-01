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
 * This class is a wrapper for {@link LabDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LabDetails
 * @generated
 */
@ProviderType
public class LabDetailsWrapper implements LabDetails, ModelWrapper<LabDetails> {
	public LabDetailsWrapper(LabDetails labDetails) {
		_labDetails = labDetails;
	}

	@Override
	public Class<?> getModelClass() {
		return LabDetails.class;
	}

	@Override
	public String getModelClassName() {
		return LabDetails.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("labId", getLabId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("portalUrl", getPortalUrl());
		attributes.put("ncUrl", getNcUrl());
		attributes.put("otherUrl", getOtherUrl());
		attributes.put("vimUser", getVimUser());
		attributes.put("vimPass", getVimPass());
		attributes.put("sdnUser", getSdnUser());
		attributes.put("sdnPass", getSdnPass());
		attributes.put("bassLink", getBassLink());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
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

		String portalUrl = (String)attributes.get("portalUrl");

		if (portalUrl != null) {
			setPortalUrl(portalUrl);
		}

		String ncUrl = (String)attributes.get("ncUrl");

		if (ncUrl != null) {
			setNcUrl(ncUrl);
		}

		String otherUrl = (String)attributes.get("otherUrl");

		if (otherUrl != null) {
			setOtherUrl(otherUrl);
		}

		String vimUser = (String)attributes.get("vimUser");

		if (vimUser != null) {
			setVimUser(vimUser);
		}

		String vimPass = (String)attributes.get("vimPass");

		if (vimPass != null) {
			setVimPass(vimPass);
		}

		String sdnUser = (String)attributes.get("sdnUser");

		if (sdnUser != null) {
			setSdnUser(sdnUser);
		}

		String sdnPass = (String)attributes.get("sdnPass");

		if (sdnPass != null) {
			setSdnPass(sdnPass);
		}

		String bassLink = (String)attributes.get("bassLink");

		if (bassLink != null) {
			setBassLink(bassLink);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public LabDetails toEscapedModel() {
		return new LabDetailsWrapper(_labDetails.toEscapedModel());
	}

	@Override
	public LabDetails toUnescapedModel() {
		return new LabDetailsWrapper(_labDetails.toUnescapedModel());
	}

	/**
	* Returns the status of this lab details.
	*
	* @return the status of this lab details
	*/
	@Override
	public boolean getStatus() {
		return _labDetails.getStatus();
	}

	@Override
	public boolean isCachedModel() {
		return _labDetails.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _labDetails.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _labDetails.isNew();
	}

	/**
	* Returns <code>true</code> if this lab details is status.
	*
	* @return <code>true</code> if this lab details is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _labDetails.isStatus();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _labDetails.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<LabDetails> toCacheModel() {
		return _labDetails.toCacheModel();
	}

	@Override
	public int compareTo(LabDetails labDetails) {
		return _labDetails.compareTo(labDetails);
	}

	@Override
	public int hashCode() {
		return _labDetails.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _labDetails.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new LabDetailsWrapper((LabDetails)_labDetails.clone());
	}

	/**
	* Returns the bass link of this lab details.
	*
	* @return the bass link of this lab details
	*/
	@Override
	public java.lang.String getBassLink() {
		return _labDetails.getBassLink();
	}

	/**
	* Returns the description of this lab details.
	*
	* @return the description of this lab details
	*/
	@Override
	public java.lang.String getDescription() {
		return _labDetails.getDescription();
	}

	/**
	* Returns the nc url of this lab details.
	*
	* @return the nc url of this lab details
	*/
	@Override
	public java.lang.String getNcUrl() {
		return _labDetails.getNcUrl();
	}

	/**
	* Returns the other url of this lab details.
	*
	* @return the other url of this lab details
	*/
	@Override
	public java.lang.String getOtherUrl() {
		return _labDetails.getOtherUrl();
	}

	/**
	* Returns the portal url of this lab details.
	*
	* @return the portal url of this lab details
	*/
	@Override
	public java.lang.String getPortalUrl() {
		return _labDetails.getPortalUrl();
	}

	/**
	* Returns the sdn pass of this lab details.
	*
	* @return the sdn pass of this lab details
	*/
	@Override
	public java.lang.String getSdnPass() {
		return _labDetails.getSdnPass();
	}

	/**
	* Returns the sdn user of this lab details.
	*
	* @return the sdn user of this lab details
	*/
	@Override
	public java.lang.String getSdnUser() {
		return _labDetails.getSdnUser();
	}

	/**
	* Returns the title of this lab details.
	*
	* @return the title of this lab details
	*/
	@Override
	public java.lang.String getTitle() {
		return _labDetails.getTitle();
	}

	/**
	* Returns the user name of this lab details.
	*
	* @return the user name of this lab details
	*/
	@Override
	public java.lang.String getUserName() {
		return _labDetails.getUserName();
	}

	/**
	* Returns the user uuid of this lab details.
	*
	* @return the user uuid of this lab details
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _labDetails.getUserUuid();
	}

	/**
	* Returns the uuid of this lab details.
	*
	* @return the uuid of this lab details
	*/
	@Override
	public java.lang.String getUuid() {
		return _labDetails.getUuid();
	}

	/**
	* Returns the vim pass of this lab details.
	*
	* @return the vim pass of this lab details
	*/
	@Override
	public java.lang.String getVimPass() {
		return _labDetails.getVimPass();
	}

	/**
	* Returns the vim user of this lab details.
	*
	* @return the vim user of this lab details
	*/
	@Override
	public java.lang.String getVimUser() {
		return _labDetails.getVimUser();
	}

	@Override
	public java.lang.String toString() {
		return _labDetails.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _labDetails.toXmlString();
	}

	/**
	* Returns the create date of this lab details.
	*
	* @return the create date of this lab details
	*/
	@Override
	public Date getCreateDate() {
		return _labDetails.getCreateDate();
	}

	/**
	* Returns the modified date of this lab details.
	*
	* @return the modified date of this lab details
	*/
	@Override
	public Date getModifiedDate() {
		return _labDetails.getModifiedDate();
	}

	/**
	* Returns the company ID of this lab details.
	*
	* @return the company ID of this lab details
	*/
	@Override
	public long getCompanyId() {
		return _labDetails.getCompanyId();
	}

	/**
	* Returns the group ID of this lab details.
	*
	* @return the group ID of this lab details
	*/
	@Override
	public long getGroupId() {
		return _labDetails.getGroupId();
	}

	/**
	* Returns the lab ID of this lab details.
	*
	* @return the lab ID of this lab details
	*/
	@Override
	public long getLabId() {
		return _labDetails.getLabId();
	}

	/**
	* Returns the primary key of this lab details.
	*
	* @return the primary key of this lab details
	*/
	@Override
	public long getPrimaryKey() {
		return _labDetails.getPrimaryKey();
	}

	/**
	* Returns the user ID of this lab details.
	*
	* @return the user ID of this lab details
	*/
	@Override
	public long getUserId() {
		return _labDetails.getUserId();
	}

	@Override
	public void persist() {
		_labDetails.persist();
	}

	/**
	* Sets the bass link of this lab details.
	*
	* @param bassLink the bass link of this lab details
	*/
	@Override
	public void setBassLink(java.lang.String bassLink) {
		_labDetails.setBassLink(bassLink);
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_labDetails.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this lab details.
	*
	* @param companyId the company ID of this lab details
	*/
	@Override
	public void setCompanyId(long companyId) {
		_labDetails.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this lab details.
	*
	* @param createDate the create date of this lab details
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_labDetails.setCreateDate(createDate);
	}

	/**
	* Sets the description of this lab details.
	*
	* @param description the description of this lab details
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_labDetails.setDescription(description);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_labDetails.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_labDetails.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_labDetails.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this lab details.
	*
	* @param groupId the group ID of this lab details
	*/
	@Override
	public void setGroupId(long groupId) {
		_labDetails.setGroupId(groupId);
	}

	/**
	* Sets the lab ID of this lab details.
	*
	* @param labId the lab ID of this lab details
	*/
	@Override
	public void setLabId(long labId) {
		_labDetails.setLabId(labId);
	}

	/**
	* Sets the modified date of this lab details.
	*
	* @param modifiedDate the modified date of this lab details
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_labDetails.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the nc url of this lab details.
	*
	* @param ncUrl the nc url of this lab details
	*/
	@Override
	public void setNcUrl(java.lang.String ncUrl) {
		_labDetails.setNcUrl(ncUrl);
	}

	@Override
	public void setNew(boolean n) {
		_labDetails.setNew(n);
	}

	/**
	* Sets the other url of this lab details.
	*
	* @param otherUrl the other url of this lab details
	*/
	@Override
	public void setOtherUrl(java.lang.String otherUrl) {
		_labDetails.setOtherUrl(otherUrl);
	}

	/**
	* Sets the portal url of this lab details.
	*
	* @param portalUrl the portal url of this lab details
	*/
	@Override
	public void setPortalUrl(java.lang.String portalUrl) {
		_labDetails.setPortalUrl(portalUrl);
	}

	/**
	* Sets the primary key of this lab details.
	*
	* @param primaryKey the primary key of this lab details
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_labDetails.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_labDetails.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the sdn pass of this lab details.
	*
	* @param sdnPass the sdn pass of this lab details
	*/
	@Override
	public void setSdnPass(java.lang.String sdnPass) {
		_labDetails.setSdnPass(sdnPass);
	}

	/**
	* Sets the sdn user of this lab details.
	*
	* @param sdnUser the sdn user of this lab details
	*/
	@Override
	public void setSdnUser(java.lang.String sdnUser) {
		_labDetails.setSdnUser(sdnUser);
	}

	/**
	* Sets whether this lab details is status.
	*
	* @param status the status of this lab details
	*/
	@Override
	public void setStatus(boolean status) {
		_labDetails.setStatus(status);
	}

	/**
	* Sets the title of this lab details.
	*
	* @param title the title of this lab details
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_labDetails.setTitle(title);
	}

	/**
	* Sets the user ID of this lab details.
	*
	* @param userId the user ID of this lab details
	*/
	@Override
	public void setUserId(long userId) {
		_labDetails.setUserId(userId);
	}

	/**
	* Sets the user name of this lab details.
	*
	* @param userName the user name of this lab details
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_labDetails.setUserName(userName);
	}

	/**
	* Sets the user uuid of this lab details.
	*
	* @param userUuid the user uuid of this lab details
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_labDetails.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this lab details.
	*
	* @param uuid the uuid of this lab details
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_labDetails.setUuid(uuid);
	}

	/**
	* Sets the vim pass of this lab details.
	*
	* @param vimPass the vim pass of this lab details
	*/
	@Override
	public void setVimPass(java.lang.String vimPass) {
		_labDetails.setVimPass(vimPass);
	}

	/**
	* Sets the vim user of this lab details.
	*
	* @param vimUser the vim user of this lab details
	*/
	@Override
	public void setVimUser(java.lang.String vimUser) {
		_labDetails.setVimUser(vimUser);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LabDetailsWrapper)) {
			return false;
		}

		LabDetailsWrapper labDetailsWrapper = (LabDetailsWrapper)obj;

		if (Objects.equals(_labDetails, labDetailsWrapper._labDetails)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _labDetails.getStagedModelType();
	}

	@Override
	public LabDetails getWrappedModel() {
		return _labDetails;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _labDetails.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _labDetails.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_labDetails.resetOriginalValues();
	}

	private final LabDetails _labDetails;
}