/**
 *
 */
package com.uidesigner.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Shrek.
 *
 * 标签属性值实体.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月5日 下午10:30:24
 */
public class SysTagAttrVal implements Serializable {

	private static final long serialVersionUID = 8132117503506050993L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "val_id")
	private Long valId = null;

	@Column(name = "tag_id")
	private Long tagId = null;

	@Column(name = "attr_id")
	private Long attrId = null;

	@Column(name = "def_val")
	private String defVal = null;

	public Long getValId() {
		return this.valId;
	}

	public void setValId(Long valId) {
		this.valId = valId;
	}

	public Long getTagId() {
		return this.tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public Long getAttrId() {
		return this.attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public String getDefVal() {
		return this.defVal;
	}

	public void setDefVal(String defVal) {
		this.defVal = defVal;
	}
}
