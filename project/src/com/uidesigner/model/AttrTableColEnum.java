package com.uidesigner.model;

import com.uidesigner.resource.UIResource;

/**
 *
 * Shrek.
 *
 * 属性表列枚举.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 下午11:56:25
 */
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