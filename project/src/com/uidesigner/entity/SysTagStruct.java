/**
 *
 */
package com.uidesigner.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Sherk.
 *
 * 标签结构实体.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 上午9:45:30
 */
@Entity
@Table(name = "sys_tag_struct")
public class SysTagStruct {

	@Column(name = "tag_id")
	private Long tagId = null;

	@Column(name = "p_tag_id")
	private Long pTagId = null;

	@Column(name = "a_tag_id")
	private Long aTagId = null;

	public Long getTagId() {
		return this.tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public Long getpTagId() {
		return this.pTagId;
	}

	public void setpTagId(Long pTagId) {
		this.pTagId = pTagId;
	}

	public Long getaTagId() {
		return this.aTagId;
	}

	public void setaTagId(Long aTagId) {
		this.aTagId = aTagId;
	}

}
