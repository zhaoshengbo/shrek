package com.uidesigner.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import com.uidesigner.dao.BaseDAO;
import com.uidesigner.entity.SysTag;
import com.uidesigner.entity.SysTagStruct;
import com.uidesigner.model.ComAttrTableModel;
import com.uidesigner.model.UserAttrTableModel;
import com.uidesigner.resource.UIResource;

/**
 * Shrek.
 *
 * 主框架结构.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 下午1:17:29
 */
public class MainFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = -101078670847085168L;

	private static final String ADD_TAG = "add_tag";

	private static final String DEL_TAG = "del_tag";

	private static final String USER_ADD_ATTR = "user_add_attr";

	private static final String USER_DEL_ATTR = "user_del_attr";

	private static final String COM_ADD_ATTR = "com_add_attr";

	private static final String COM_DEL_ATTR = "com_del_attr";

	private static final String DB_SET = "db_set";

	private static final String CONTACT_US = "contact_us";

	private static final String SAVE = "save";

	private static final String REFRESH = "refresh";

	private JTable userAttrEditTable = null;

	private JTable comAttrEditTable = null;

	private JTree tagTree = null;

	public MainFrame() {
		this.initUI();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void setVisible(boolean b) {
		super.setVisible(b);
		this.initData();
	}

	protected void initUI() {
		this.setFrameDefault();
		this.addComps();
	}

	protected void initData() {
		this.initTagTreeData();
	}

	protected void setFrameDefault() {
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setExtendedState(Frame.MAXIMIZED_BOTH);
		this.setTitle("UIDesigner");
	}

	protected void addComps() {
		this.addSplitPane();
		this.addMenuBar();
	}

	protected void addSplitPane() {
		JSplitPane splitPane = this.createSplitPane();
		splitPane.setDividerSize(2);
		splitPane.setLeftComponent(this.createTagPanel());
		splitPane.setRightComponent(this.createAttrEditPanel());

		this.add(splitPane);
	}

	protected void addMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(this.createSetMenu());
		menuBar.add(this.createAboutMenu());
		this.setJMenuBar(menuBar);
	}

	protected JPanel createTagPanel() {
		JPanel tagPanel = this.createTitledPanel(UIResource.getTagTreeText());
		tagPanel.setLayout(new BorderLayout());

		tagPanel.add(this.createTagBtnPanel(), BorderLayout.NORTH);
		tagPanel.add(this.createTagTreeScrollPane());

		return tagPanel;
	}

	protected JPanel createTagBtnPanel() {
		JPanel newPanel = new JPanel();
		newPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		newPanel.add(this.createAddTagBtn());
		newPanel.add(this.createDelTagBtn());

		return newPanel;
	}

	protected JButton createAddTagBtn() {
		return this.createButton(UIResource.getAddTagText(), MainFrame.ADD_TAG);
	}

	protected JButton createDelTagBtn() {
		return this.createButton(UIResource.getDelTagText(), MainFrame.DEL_TAG);
	}

	protected JScrollPane createTagTreeScrollPane() {
		JScrollPane scrollPane = this.createScrollPane();
		scrollPane.getViewport().setView(this.getTagTree());

		return scrollPane;
	}

	protected JPanel createAttrEditPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(this.createAttrEditSplitPane());
		panel.add(this.createSaveRefBtnPanel(), BorderLayout.SOUTH);

		return panel;
	}

	protected JPanel createSaveRefBtnPanel() {
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		btnPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		btnPanel.add(this.createSaveBtn());
		btnPanel.add(this.createRefreshBtn());

		return btnPanel;
	}

	protected JButton createSaveBtn() {
		return this.createButton(UIResource.getSaveText(), MainFrame.SAVE);
	}

	protected JButton createRefreshBtn() {
		return this.createButton(UIResource.getRefreshText(), MainFrame.REFRESH);
	}

	protected JSplitPane createAttrEditSplitPane() {
		JSplitPane splitPane = this.createSplitPane();
		splitPane.setDividerSize(2);
		splitPane.setLeftComponent(this.createUserAttrEditPanel());
		splitPane.setRightComponent(this.createComAttrEditPanel());

		return splitPane;
	}

	protected JPanel createUserAttrEditPanel() {
		JPanel attrEditPanel = this.createTitledPanel(UIResource.getUserAttrEditText());
		attrEditPanel.setLayout(new BorderLayout());
		attrEditPanel.add(this.createUserAttrEditBtnPanel(), BorderLayout.NORTH);
		attrEditPanel.add(this.createUserAttrTablePane(), BorderLayout.CENTER);

		return attrEditPanel;
	}

	protected JPanel createComAttrEditPanel() {
		JPanel editPanel = this.createTitledPanel(UIResource.getComAttrEditText());
		editPanel.setLayout(new BorderLayout());
		editPanel.add(this.createComAttrEditBtnPanel(), BorderLayout.NORTH);
		editPanel.add(this.createComAttrTablePane(), BorderLayout.CENTER);

		return editPanel;
	}

	protected JPanel createUserAttrEditBtnPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		panel.add(this.createUserAddAttrBtn());
		panel.add(this.createUserDelAttrBtn());

		return panel;
	}

	protected JPanel createComAttrEditBtnPanel() {
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		panel.add(this.createComAddAttrBtn());
		panel.add(this.createComDelAttrBtn());

		return panel;
	}

	protected JScrollPane createUserAttrTablePane() {
		JScrollPane scrollPane = this.createScrollPane();
		scrollPane.getViewport().setView(this.getUserAttrEditTable());

		return scrollPane;
	}

	protected JScrollPane createComAttrTablePane() {
		JScrollPane scrollPane = this.createScrollPane();
		scrollPane.getViewport().setView(this.getComAttrEditTable());

		return scrollPane;
	}

	protected JButton createUserAddAttrBtn() {
		return this.createButton(UIResource.getAddAttrText(), MainFrame.USER_ADD_ATTR);
	}

	protected JButton createUserDelAttrBtn() {
		return this.createButton(UIResource.getDelAttrText(), MainFrame.USER_DEL_ATTR);
	}

	protected JButton createComAddAttrBtn() {
		return this.createButton(UIResource.getAddAttrText(), MainFrame.COM_ADD_ATTR);
	}

	protected JButton createComDelAttrBtn() {
		return this.createButton(UIResource.getDelAttrText(), MainFrame.COM_DEL_ATTR);
	}

	protected JTree getTagTree() {
		if (this.tagTree == null) {
			this.tagTree = this.createTagTree();
		}
		return this.tagTree;
	}

	protected JTree createTagTree() {
		JTree tree = new JTree();
		tree.setRootVisible(false);
		tree.setPreferredSize(new Dimension(250, 200));

		return tree;
	}

	protected void initTagTreeData() {
		DefaultTreeModel tagTreeModel = (DefaultTreeModel) this.getTagTree().getModel();
		tagTreeModel.setRoot(this.getRootNode());
	}

	protected DefaultMutableTreeNode getRootNode() {
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode();
		List<SysTag> tagList = this.qryAllTag();
		Map<Long, SysTag> tagMap = this.getTagMap(tagList);
		for (SysTag tag : tagList) {
			this.createTreeNode(rootNode, tag, tagMap);
		}
		return rootNode;
	}

	protected Map<Long, SysTag> getTagMap(List<SysTag> tagList) {
		Map<Long, SysTag> tagMap = new HashMap<Long, SysTag>();
		for (SysTag sysTag : tagList) {
			tagMap.put(sysTag.getTagId(), sysTag);
		}
		return tagMap;
	}

	protected void createTreeNode(DefaultMutableTreeNode pNode, SysTag tag, Map<Long, SysTag> tagMap) {
		DefaultMutableTreeNode tagNode = new DefaultMutableTreeNode();
		tagNode.setUserObject(tag);
		pNode.add(tagNode);
		Set<SysTagStruct> structSet = tag.getTagStructSet();
		if (structSet.isEmpty()) {
			return;
		}
		for (SysTagStruct tagStruct : structSet) {
			this.createTreeNode(tagNode, tagMap.get(tagStruct.getTagId()), tagMap);
		}
	}

	protected List<SysTag> qryAllTag() {
		return BaseDAO.getInstance().loadAll(SysTag.class);
	}

	protected JMenu createSetMenu() {
		JMenu menu = this.createMenu(UIResource.getSetText());
		menu.add(this.createMenuItem(UIResource.getDBSetText(), MainFrame.DB_SET));

		return menu;
	}

	protected JMenu createAboutMenu() {
		JMenu menu = this.createMenu(UIResource.getAboutText());
		menu.add(this.createMenuItem(UIResource.getContactUsText(), MainFrame.CONTACT_US));

		return menu;
	}

	protected JTable getUserAttrEditTable() {
		if (this.userAttrEditTable == null) {
			this.userAttrEditTable = this.createUserAttrEditTable();
		}
		return this.userAttrEditTable;
	}

	protected JTable getComAttrEditTable() {
		if (this.comAttrEditTable == null) {
			this.comAttrEditTable = this.createComAttrEditTable();
		}
		return this.comAttrEditTable;
	}

	protected JTable createComAttrEditTable() {
		JTable table = this.createTable();
		table.setModel(new ComAttrTableModel());

		return table;
	}

	protected JTable createUserAttrEditTable() {
		JTable table = this.createTable();
		table.setModel(new UserAttrTableModel());

		return table;
	}

	protected JMenuItem createMenuItem(String text, String actionCommand) {
		JMenuItem menuItem = new JMenuItem();
		menuItem.setText(text);
		menuItem.setActionCommand(actionCommand);
		menuItem.addActionListener(this);

		return menuItem;
	}

	protected JMenu createMenu(String title) {
		JMenu menu = new JMenu();
		menu.setText(title);

		return menu;
	}

	protected JScrollPane createScrollPane() {
		return new JScrollPane();
	}

	protected JPanel createTitledPanel(String title) {
		JPanel newPanel = new JPanel();
		newPanel.setBorder(BorderFactory.createTitledBorder(title));

		return newPanel;
	}

	protected JButton createButton(String text, String actionCmd) {
		JButton newBtn = new JButton();
		newBtn.setText(text);
		newBtn.setActionCommand(actionCmd);
		newBtn.addActionListener(this);

		return newBtn;
	}

	protected JSplitPane createSplitPane() {
		return new JSplitPane();
	}

	protected JTable createTable() {
		JTable table = new JTable();
		table.setRowHeight(20);

		return table;
	}
}
