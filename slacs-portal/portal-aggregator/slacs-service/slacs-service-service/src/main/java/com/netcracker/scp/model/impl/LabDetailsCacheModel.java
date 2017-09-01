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

import com.netcracker.scp.model.LabDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LabDetails in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see LabDetails
 * @generated
 */
@ProviderType
public class LabDetailsCacheModel implements CacheModel<LabDetails>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LabDetailsCacheModel)) {
			return false;
		}

		LabDetailsCacheModel labDetailsCacheModel = (LabDetailsCacheModel)obj;

		if (labId == labDetailsCacheModel.labId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, labId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
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
		sb.append(", portalUrl=");
		sb.append(portalUrl);
		sb.append(", ncUrl=");
		sb.append(ncUrl);
		sb.append(", otherUrl=");
		sb.append(otherUrl);
		sb.append(", vimUser=");
		sb.append(vimUser);
		sb.append(", vimPass=");
		sb.append(vimPass);
		sb.append(", sdnUser=");
		sb.append(sdnUser);
		sb.append(", sdnPass=");
		sb.append(sdnPass);
		sb.append(", bassLink=");
		sb.append(bassLink);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LabDetails toEntityModel() {
		LabDetailsImpl labDetailsImpl = new LabDetailsImpl();

		if (uuid == null) {
			labDetailsImpl.setUuid(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setUuid(uuid);
		}

		labDetailsImpl.setLabId(labId);
		labDetailsImpl.setGroupId(groupId);
		labDetailsImpl.setCompanyId(companyId);
		labDetailsImpl.setUserId(userId);

		if (userName == null) {
			labDetailsImpl.setUserName(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			labDetailsImpl.setCreateDate(null);
		}
		else {
			labDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			labDetailsImpl.setModifiedDate(null);
		}
		else {
			labDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			labDetailsImpl.setTitle(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setTitle(title);
		}

		if (description == null) {
			labDetailsImpl.setDescription(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setDescription(description);
		}

		if (portalUrl == null) {
			labDetailsImpl.setPortalUrl(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setPortalUrl(portalUrl);
		}

		if (ncUrl == null) {
			labDetailsImpl.setNcUrl(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setNcUrl(ncUrl);
		}

		if (otherUrl == null) {
			labDetailsImpl.setOtherUrl(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setOtherUrl(otherUrl);
		}

		if (vimUser == null) {
			labDetailsImpl.setVimUser(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setVimUser(vimUser);
		}

		if (vimPass == null) {
			labDetailsImpl.setVimPass(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setVimPass(vimPass);
		}

		if (sdnUser == null) {
			labDetailsImpl.setSdnUser(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setSdnUser(sdnUser);
		}

		if (sdnPass == null) {
			labDetailsImpl.setSdnPass(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setSdnPass(sdnPass);
		}

		if (bassLink == null) {
			labDetailsImpl.setBassLink(StringPool.BLANK);
		}
		else {
			labDetailsImpl.setBassLink(bassLink);
		}

		labDetailsImpl.setStatus(status);

		labDetailsImpl.resetOriginalValues();

		return labDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		labId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		portalUrl = objectInput.readUTF();
		ncUrl = objectInput.readUTF();
		otherUrl = objectInput.readUTF();
		vimUser = objectInput.readUTF();
		vimPass = objectInput.readUTF();
		sdnUser = objectInput.readUTF();
		sdnPass = objectInput.readUTF();
		bassLink = objectInput.readUTF();

		status = objectInput.readBoolean();
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

		if (portalUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portalUrl);
		}

		if (ncUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ncUrl);
		}

		if (otherUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(otherUrl);
		}

		if (vimUser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vimUser);
		}

		if (vimPass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(vimPass);
		}

		if (sdnUser == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sdnUser);
		}

		if (sdnPass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sdnPass);
		}

		if (bassLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bassLink);
		}

		objectOutput.writeBoolean(status);
	}

	public String uuid;
	public long labId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public String portalUrl;
	public String ncUrl;
	public String otherUrl;
	public String vimUser;
	public String vimPass;
	public String sdnUser;
	public String sdnPass;
	public String bassLink;
	public boolean status;
}