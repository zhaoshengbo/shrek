package com.uidesigner.main;

import com.uidesigner.impl.BootWinExeStrategy;

/**
 *
 * Shrek.
 *
 * main类.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 下午11:56:07
 */
public class UIDesignerMain {

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		BootWindow window = new BootWindow(frame);
		window.setVisible(true);
		boolean failed = window.runStartMisson(new BootWinExeStrategy());
		if (failed) {
			return;
		}
		window.setVisible(false);
		frame.setVisible(true);
	}
}
