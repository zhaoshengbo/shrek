package com.uidesigner.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Shrek.
 *
 * 标签属性.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 上午9:28:29
 */
@Entity
@Table(name = "sys_tag_attr")
public class SysTagAttr implements Serializable {

	private static final long serialVersionUID = -1348316798556847345L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "attr_id")
	private Long attrId = null;

	@Column(name = "attr_name")
	private String attrName = null;

	public Long getAttrId() {
		return this.attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public String getAttrName() {
		return this.attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

}
