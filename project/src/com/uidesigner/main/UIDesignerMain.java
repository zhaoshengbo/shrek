package com.uidesigner.main;

import com.uidesigner.impl.BootWinExeStrategy;

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
