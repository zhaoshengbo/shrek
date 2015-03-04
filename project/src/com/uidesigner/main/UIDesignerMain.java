package com.uidesigner.main;

import com.uidesigner.dao.BaseDAO;
import com.uidesigner.entity.SysTag;

public class UIDesignerMain {

	public static void main(String[] args) {
		SysTag tag = new SysTag();
		BaseDAO.getInstance().save(tag);
	}
}
