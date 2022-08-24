package view;

import javax.swing.*;
import java.awt.*;

public class LineDialog extends JDialog {

    private JTextField itemName;
    private JTextField itemPrice;
    private JTextField itemCount;

    private JLabel itemNameLb;
    private JLabel itemPriceLb;
    private JLabel itemCountLb;

    private JButton ok;
    private JButton cancel;

    public LineDialog(SalesInvoiceFrame salesInvoiceFrame)
    {
        super(salesInvoiceFrame);
        itemNameLb = new JLabel("Item Name: ");
        itemName = new JTextField(20);
        itemPriceLb = new JLabel("Item Price: ");
        itemPrice = new JTextField(20);
        itemCountLb = new JLabel("Item Count: ");
        itemCount = new JTextField(20);
        ok = new JButton("OK");
        cancel = new JButton("Cancel");

        ok.setActionCommand("CreateLine");
        ok.addActionListener(salesInvoiceFrame.getSalesInvoiceListener());
        cancel.setActionCommand("CancelLine");
        cancel.addActionListener(salesInvoiceFrame.getSalesInvoiceListener());

        setLayout(new GridLayout(4,2));

        add(itemNameLb);
        add(itemName);
        add(itemPriceLb);
        add(itemPrice);
        add(itemCountLb);
        add(itemCount);
        add(ok);
        add(cancel);
        setModal(true);

        pack();


    }

    public JTextField getItemName() {
        return itemName;
    }

    public JTextField getItemPrice() {
        return itemPrice;
    }

    public JTextField getItemCount() {
        return itemCount;
    }
}

