package view;

import javax.swing.*;
import java.awt.*;

public class InvoiceDialog extends JDialog {

    private JTextField customerName;
    private JTextField invoiceDate;
    private JLabel customerNameLb;
    private JLabel invoiceDateLb;
    private JButton ok;
    private JButton cancel;

    public InvoiceDialog(SalesInvoiceFrame salesInvoiceFrame)
    {
        super(salesInvoiceFrame);
        customerNameLb = new JLabel("Customer Name: ");
        customerName = new JTextField(20);
        invoiceDateLb = new JLabel("Invoice Date: ");
        invoiceDate = new JTextField(20);
        ok = new JButton("OK");
        cancel = new JButton("Cancel");

        ok.setActionCommand("CreateInvoice");
        ok.addActionListener(salesInvoiceFrame.getSalesInvoiceListener());
        cancel.setActionCommand("CancelInvoice");
        cancel.addActionListener(salesInvoiceFrame.getSalesInvoiceListener());

        setLayout(new GridLayout(3,3));

        add(customerNameLb);
        add(customerName);
        add(invoiceDateLb);
        add(invoiceDate);
        add(ok);
        add(cancel);
        setModal(true);

        pack();


    }

    public JTextField getCustomerName() {
        return customerName;
    }

    public JTextField getInvoiceDate() {
        return invoiceDate;
    }
}
