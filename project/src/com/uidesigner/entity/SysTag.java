package com.uidesigner.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * Sherk.
 *
 * 系统标签.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 上午9:30:29
 */
@Entity
@Table(name = "sys_tag")
public class SysTag implements Serializable {

	private static final long serialVersionUID = -8527518067736446291L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tag_id")
	private Long tagId = null;

	@Column(name = "tag_name")
	private String tagName = null;

	@Column(name = "tag_type")
	private String tagType = null;

	public Long getTagId() {
		return this.tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}

	public String getTagName() {
		return this.tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public String getTagType() {
		return this.tagType;
	}

	public void setTagType(String tagType) {
		this.tagType = tagType;
	}

}
