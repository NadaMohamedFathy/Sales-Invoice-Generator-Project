package model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class InvoiceHeaderTable extends AbstractTableModel {
    private String[] invoiceColumns = {"No.", "Date", "Customer", "Total"};

    private ArrayList<InvoiceHeader> invoiceHeaders;
    private ArrayList<String> invoiceHeadersDates;

    public InvoiceHeaderTable(ArrayList<InvoiceHeader> invoiceHeaders, ArrayList<String> invoiceHeadersDates) {
        this.invoiceHeaders = invoiceHeaders;
        this.invoiceHeadersDates = invoiceHeadersDates;
    }

    /*int rowCount;

    public void setRowCount(int c) {
        if(c == 0) {
            this.rowCount = c;
            invoiceColumns = new String[]{};
        }
        else {
            this.rowCount = invoiceHeaders.size();
            invoiceColumns = new String[]{"No.", "Date", "Customer", "Total"};
        }
    }*/

    @Override
    public int getRowCount() {
        return invoiceHeaders.size();
    }

    @Override
    public int getColumnCount() {
        return invoiceColumns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceHeader invoiceHeader = invoiceHeaders.get(rowIndex);
        String date = invoiceHeadersDates.get(rowIndex);

        switch (columnIndex)
        {
            case 0:
                return invoiceHeader.getInvoiceNum();
            case 1:
                return date;
            case 2:
                return invoiceHeader.getCustomerName();
            case 3:
                return invoiceHeader.getTotal();
        }
        return "";
    }

    public String getColumnName(int column)
    {
        return invoiceColumns[column];
    }
}
