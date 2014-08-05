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
 * 用户控件属性值实体.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月5日 下午10:38:06
 */
public class UserCtrlAttrVal implements Serializable {

	private static final long serialVersionUID = 638819880230221862L;

	@Id
	@Column(name = "attr_val_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long attrValId = null;

	@Column(name = "ctrl_id")
	private Long ctrlId = null;

	@Column(name = "attr_id")
	private Long attrId = null;

	@Column(name = "attr_val")
	private String attrVal = null;

	public Long getAttrValId() {
		return this.attrValId;
	}

	public void setAttrValId(Long attrValId) {
		this.attrValId = attrValId;
	}

	public Long getCtrlId() {
		return this.ctrlId;
	}

	public void setCtrlId(Long ctrlId) {
		this.ctrlId = ctrlId;
	}

	public Long getAttrId() {
		return this.attrId;
	}

	public void setAttrId(Long attrId) {
		this.attrId = attrId;
	}

	public String getAttrVal() {
		return this.attrVal;
	}

	public void setAttrVal(String attrVal) {
		this.attrVal = attrVal;
	}

}
