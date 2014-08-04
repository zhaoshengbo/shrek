package com.uidesigner.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.Thread.UncaughtExceptionHandler;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import com.uidesigner.itf.IExecuteStrategy;

/**
 * Sherk.
 *
 * 引导窗口.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 下午5:12:37
 */
public class BootWindow extends Window implements UncaughtExceptionHandler {

	private static final long serialVersionUID = -6647634366784892146L;

	private Dimension SIZE = new Dimension(434, 243);

	private ImageIcon image = new ImageIcon("src/com/uidesigner/resource/logo.png");

	private JProgressBar progressBar = null;

	private JLabel infoLabel = null;

	private boolean missionFailed = false;

	public BootWindow(Frame owner) {
		super(owner);
		this.initUI();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(this.getLogoImage(), 0, 0, null);
		super.paint(g);
	}

	public boolean runStartMisson(IExecuteStrategy exeStrategy) {
		Thread thread = new Thread(new ExeStrategyRunnable(exeStrategy));
		thread.setUncaughtExceptionHandler(this);
		thread.start();

		int milliSeconds = exeStrategy.getExeMilliSeconds();
		int sleepSeconds = milliSeconds / 100;
		this.exeWaiting(thread, sleepSeconds);

		return this.isMissionFailed();
	}

	@Override
	public void uncaughtException(Thread t, Throwable e) {
		this.setMissionFailed(true);
		this.getProgressBar().setForeground(Color.RED);
		this.getInfoLabel().setText(e.getCause().getMessage());
		this.addFailedMouseListener();
	}

	protected void initUI() {
		this.setDefault();
		this.addInfoLabel();
		this.addProgressBar();
	}

	protected void setDefault() {
		this.setCenterLocation();
		this.setSize(this.getDefaultSize());
		this.setLayout(null);
	}

	protected void addInfoLabel() {
		this.add(this.getInfoLabel());
	}

	protected JLabel getInfoLabel() {
		if (this.infoLabel == null) {
			this.infoLabel = this.createInfoLable();
		}
		return this.infoLabel;
	}

	protected JLabel createInfoLable() {
		JLabel lable = new JLabel();
		lable.setBounds(4, 211, 429, 15);
		lable.setOpaque(false);

		return lable;
	}

	protected void addProgressBar() {
		this.add(this.getProgressBar());
	}

	protected JProgressBar createProgressBar() {
		JProgressBar bar = new JProgressBar();
		bar.setOrientation(SwingConstants.HORIZONTAL);
		bar.setMinimum(0);
		bar.setMaximum(100);
		bar.setValue(20);
		bar.setBorder(BorderFactory.createEmptyBorder());
		bar.setBounds(1, 227, 432, 15);
		bar.setOpaque(false);

		return bar;
	}

	protected void setCenterLocation() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int left = (screenSize.width - this.getDefaultSize().width) / 2;
		int top = (screenSize.height - this.getDefaultSize().height) / 2;
		this.setLocation(left, top);
	}

	protected void exeWaiting(Thread thread, int sleepSeconds) {
		try {
			int i = 1;
			for (; (i <= 100) && !this.isMissionFailed(); i++) {
				this.getProgressBar().setValue(i);
				TimeUnit.MILLISECONDS.sleep(sleepSeconds);
			}
			thread.join();
		} catch (InterruptedException e) {
		}
	}

	protected void addFailedMouseListener() {
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				BootWindow.this.setVisible(false);
			}
		});
	}

	private boolean isMissionFailed() {
		return this.missionFailed;
	}

	private void setMissionFailed(boolean missionFailed) {
		this.missionFailed = missionFailed;
	}

	private JProgressBar getProgressBar() {
		if (this.progressBar == null) {
			this.progressBar = this.createProgressBar();
		}
		return this.progressBar;
	}

	private Dimension getDefaultSize() {
		return this.SIZE;
	}

	private Image getLogoImage() {
		return this.image.getImage();
	}

	private class ExeStrategyRunnable implements Runnable {

		private IExecuteStrategy strategy = null;

		public ExeStrategyRunnable(IExecuteStrategy strategy) {
			this.strategy = strategy;
		}

		@Override
		public void run() {
			try {
				this.getStrategy().run();
			} catch (Exception e) {
			}
		}

		private IExecuteStrategy getStrategy() {
			return this.strategy;
		}

	}

}