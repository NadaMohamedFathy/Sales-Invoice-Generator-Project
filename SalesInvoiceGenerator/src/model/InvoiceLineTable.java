package model;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class InvoiceLineTable extends AbstractTableModel {

    private String[] LinesColumns = {};

    private ArrayList<InvoiceLine> lines;
    private int num;

    public InvoiceLineTable(ArrayList<InvoiceLine> lines, int num) {
        this.lines = lines;
        this.num = num;
    }

    int rowCount;

    public void setRowCount(int c) {
        if(c == 0) {
            this.rowCount = c;
            LinesColumns = new String[]{};
        }
        else {
            this.rowCount = lines.size();
            LinesColumns = new String[]{"No.", "Item Name", "Item Price", "Count", "Item Total"};
        }
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return LinesColumns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine invoiceLine = lines.get(rowIndex);

        switch (columnIndex)
        {
            case 0:
                return num;
            case 1:
                return invoiceLine.getItemName();
            case 2:
                return invoiceLine.getItemPrice();
            case 3:
                return invoiceLine.getCount();
            case 4:
                return invoiceLine.gatTotalPrice();
        }
        return "";
    }

    public String getColumnName(int column)
    {
        return LinesColumns[column];
    }
}