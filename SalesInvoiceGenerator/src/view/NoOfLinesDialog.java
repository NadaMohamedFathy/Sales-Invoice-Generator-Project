package view;

import javax.swing.*;
import java.awt.*;

public class NoOfLinesDialog extends JDialog {

    private JTextField itemNumbers;
    private JLabel itemNumbersLb;
    private JLabel noteLb;
    private JButton ok;

    public NoOfLinesDialog(SalesInvoiceFrame salesInvoiceFrame)
    {
        super(salesInvoiceFrame);
        itemNumbersLb = new JLabel("Number Of Items: ");
        itemNumbers = new JTextField(20);
        noteLb = new JLabel("If you do not need to add any items, press zero<0>.");
        ok = new JButton("OK");

        ok.setActionCommand("NumberOfItemsok");
        ok.addActionListener(salesInvoiceFrame.getSalesInvoiceListener());

        setLayout(new GridLayout(4,1));

        add(noteLb);
        add(itemNumbersLb);
        add(itemNumbers);
        add(ok);
        setModal(true);

        pack();


    }

    public JTextField getItemNumbers() {
        return itemNumbers;
    }
}
