/**
 *
 */
package com.shrek.lf.taglib;


/**
 * Shrek.
 *
 * TableTag.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月5日 下午8:34:46
 */
public class TableTag extends BaseTag {

	private static final long serialVersionUID = -5626256102235389418L;

	@Override
	protected String renderTag() {
		return "table_tag";
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	private String code = null;

}
