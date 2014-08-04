package com.uidesigner.model;

import com.uidesigner.resource.UIResource;

public enum AttrTableColEnum {

	AttrName(UIResource.getAttrNameText()), AttrDefVal(UIResource.getAttrDefValText());
	String colName;

	AttrTableColEnum(String colName) {
		this.colName = colName;
	}

	public String getColName() {
		return this.colName;
	}
}