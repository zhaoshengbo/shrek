/**
 *
 */
package com.shrek.lf.taglib;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * Shrek.
 *
 * 标签基类.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月5日 下午8:53:31
 */
public abstract class BaseTag extends TagSupport {

	private static final long serialVersionUID = 5902564532970491137L;

	@Override
	public int doStartTag() throws JspException {
		JspWriter jspwriter = this.pageContext.getOut();
		try {
			jspwriter.print(this.renderTag());
		} catch (IOException ioexception) {
		}
		return Tag.SKIP_BODY;
	}

	protected abstract String renderTag();

	protected PageContext getPageContext() {
		return this.pageContext;
	}
}
