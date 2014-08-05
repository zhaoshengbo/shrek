/**
 *
 */
package com.uidesigner.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 * Shrek.
 *
 * 用户控件表.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月5日 下午10:34:59
 */
public class UserCtrl {

	@Id
	@Column(name = "ctrl_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long ctrlId = null;

	@Column(name = "tag_id")
	private Long tagId = null;

	@Column(name = "p_ctrl_id")
	private Long pCtrlId = null;

	@Column(name = "a_ctrl_id")
	private Long aCtrlId = null;

	@OneToMany
	@JoinColumn(name = "ctrl_id")
	private Set<UserCtrlAttrVal> userCtrlAttrValSet = null;

	public Long getCtrlId() {
		return this.ctrlId;
	}

	public void setCtrlId(Long ctrlId) {
		this.ctrlId = ctrlId;
	}

	public Long getTagId() {
		return this.tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public Long getpCtrlId() {
		return this.pCtrlId;
	}

	public void setpCtrlId(Long pCtrlId) {
		this.pCtrlId = pCtrlId;
	}

	public Long getaCtrlId() {
		return this.aCtrlId;
	}

	public void setaCtrlId(Long aCtrlId) {
		this.aCtrlId = aCtrlId;
	}

	public Set<UserCtrlAttrVal> getUserCtrlAttrValSet() {
		return this.userCtrlAttrValSet;
	}

	public void setUserCtrlAttrValSet(Set<UserCtrlAttrVal> userCtrlAttrValSet) {
		this.userCtrlAttrValSet = userCtrlAttrValSet;
	}

}
