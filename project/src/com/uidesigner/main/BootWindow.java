package com.uidesigner.main;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

/**
 * Sherk.
 *
 * 引导窗口.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 下午5:12:37
 */
public class BootWindow extends Window {

	private static final long serialVersionUID = -6647634366784892146L;

	private Dimension SIZE = new Dimension(434, 243);

	private ImageIcon image = new ImageIcon("src/com/uidesigner/resource/logo.png");

	public BootWindow(Frame owner) {
		super(owner);
		this.initUI();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(this.getLogoImage(), 0, 0, null);
		super.paint(g);
	}

	protected void initUI() {
		this.setDefault();
		this.addProgressBar();
	}

	protected void setDefault() {
		this.setCenterLocation();
		this.setSize(this.getDefaultSize());
		this.setLayout(null);
	}

	protected void addProgressBar() {
		JProgressBar bar = new JProgressBar();
		bar.setOrientation(SwingConstants.HORIZONTAL);
		bar.setMinimum(0);
		bar.setMaximum(100);
		bar.setValue(20);
		bar.setBorder(BorderFactory.createEmptyBorder());
		bar.setBounds(1, 227, 432, 15);
		bar.setOpaque(false);

		this.add(bar);
	}

	protected void setCenterLocation() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int left = (screenSize.width - this.getDefaultSize().width) / 2;
		int top = (screenSize.height - this.getDefaultSize().height) / 2;
		this.setLocation(left, top);
	}

	private Dimension getDefaultSize() {
		return this.SIZE;
	}

	public Image getLogoImage() {
		return this.image.getImage();
	}

}