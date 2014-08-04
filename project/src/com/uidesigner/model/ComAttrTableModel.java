/**
 *
 */
package com.uidesigner.model;

import javax.swing.table.AbstractTableModel;

/**
 * Shrek.
 *
 * 通用属性表.
 *
 * @author zhaoshb
 * @since 1.0
 * @time 2014年8月4日 下午3:40:09
 */
public class ComAttrTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 4717795318873585927L;

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
