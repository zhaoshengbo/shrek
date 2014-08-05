package com.uidesigner.impl;

import com.uidesigner.dao.BaseDAO;
import com.uidesigner.itf.IExecuteStrategy;

/**
 * Shrek.
 *
 * 窗口引导执行策略.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 下午9:03:07
 */
public class BootWinExeStrategy implements IExecuteStrategy {

	@Override
	public void run() throws Exception {
		BaseDAO.getInstance();
	}

	@Override
	public int getExeMilliSeconds() {
		return 5000;
	}

}
