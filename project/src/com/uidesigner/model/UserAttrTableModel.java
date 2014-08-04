package com.uidesigner.model;

import javax.swing.table.AbstractTableModel;

/**
 * Sherk.
 *
 * 属性表模型.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 下午2:48:30
 */
public class UserAttrTableModel extends AbstractTableModel {

	private static final long serialVersionUID = -181210739176803504L;

	@Override
	public int getRowCount() {
		return 10;
	}

	@Override
	public int getColumnCount() {
		return AttrTableColEnum.values().length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return "";
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public String getColumnName(int column) {
		return AttrTableColEnum.values()[column].getColName();
	}

}
