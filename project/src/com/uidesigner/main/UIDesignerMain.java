package com.uidesigner.main;

public class UIDesignerMain {

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
		BootWindow window = new BootWindow(frame);
		window.setVisible(true);

		// frame.setVisible(true);
	}
}
