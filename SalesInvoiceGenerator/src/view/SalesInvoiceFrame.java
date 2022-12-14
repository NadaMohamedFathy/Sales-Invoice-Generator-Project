/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SalesInvoiceListener;
import model.*;
import model.InvoiceLineTable;

import javax.swing.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class SalesInvoiceFrame extends javax.swing.JFrame {



    /**
     * Creates new form NewJFrame
     */


    SalesInvoiceListener salesInvoiceListener = new SalesInvoiceListener(this);
    public SalesInvoiceFrame() {
        initComponents();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        invoiceTable.getSelectionModel().addListSelectionListener(salesInvoiceListener);
        jScrollPane2 = new javax.swing.JScrollPane();
        linesTable = new javax.swing.JTable();
        createNewInvoiceBtn = new javax.swing.JButton();
        deleteInvoiceBtn = new javax.swing.JButton();
        saveLineBtn = new javax.swing.JButton();
        cancelLineBtn = new javax.swing.JButton();
        invoiceNumber = new javax.swing.JLabel();
        invoiceDate = new javax.swing.JLabel();
        customerName = new javax.swing.JLabel();
        invoiceTotal = new javax.swing.JLabel();
        invoicesTable = new javax.swing.JLabel();
        invoiceLines = new javax.swing.JLabel();
        invoiceNumberLb = new javax.swing.JLabel();
        invoiceDateLb = new javax.swing.JLabel();
        customerNameLb = new javax.swing.JLabel();
        invoiceTotalLb = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        invoiceTable.setToolTipText("");
        jScrollPane1.setViewportView(invoiceTable);

        linesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {

                }
        ));
        jScrollPane2.setViewportView(linesTable);

        createNewInvoiceBtn.setText("Create New Invoice");
        createNewInvoiceBtn.addActionListener(salesInvoiceListener);
        createNewInvoiceBtn.setActionCommand("CIN");

        deleteInvoiceBtn.setText("Delete Invoice");
        deleteInvoiceBtn.addActionListener(salesInvoiceListener);
        deleteInvoiceBtn.setActionCommand("DI");

        saveLineBtn.setText("Create New Line");
        saveLineBtn.addActionListener(salesInvoiceListener);
        saveLineBtn.setActionCommand("CNL");

        cancelLineBtn.setText("Delete Line");
        cancelLineBtn.addActionListener(salesInvoiceListener);
        cancelLineBtn.setActionCommand("DL");

        invoiceNumber.setText("Invoice Number:");

        invoiceDate.setText("Invoice Date:");

        customerName.setText("Customer Name:");

        invoiceTotal.setText("Invoice Total:");

        invoicesTable.setText("Invoices Table:");

        invoiceLines.setText("Invoice Lines:");

        invoiceNumberLb.setText("");

        invoiceDateLb.setText("");

        customerNameLb.setText("");

        invoiceTotalLb.setText("");

        fileMenu.setText("File");

        loadMenuItem.setText("Load");
        loadMenuItem.addActionListener(salesInvoiceListener);
        loadMenuItem.setActionCommand("L");
        fileMenu.add(loadMenuItem);

        saveMenuItem.setText("Save");
        saveMenuItem.addActionListener(salesInvoiceListener);
        saveMenuItem.setActionCommand("S");
        fileMenu.add(saveMenuItem);

        menuBar.add(fileMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(91, 91, 91)
                                                .addComponent(createNewInvoiceBtn)
                                                .addGap(97, 97, 97)
                                                .addComponent(deleteInvoiceBtn)
                                                .addGap(192, 192, 192)
                                                .addComponent(saveLineBtn)
                                                .addGap(171, 171, 171)
                                                .addComponent(cancelLineBtn))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(24, 24, 24)
                                                                .addComponent(invoicesTable)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(60, 60, 60)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                                                        .addComponent(invoiceNumber)
                                                                                                        .addGap(59, 59, 59))
                                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                        .addComponent(invoiceDate)
                                                                                                        .addGap(78, 78, 78)))
                                                                                        .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                        .addComponent(customerName)
                                                                                                        .addComponent(invoiceTotal))
                                                                                                .addGap(56, 56, 56)))
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addComponent(customerNameLb)
                                                                                        .addComponent(invoiceDateLb)
                                                                                        .addComponent(invoiceNumberLb)
                                                                                        .addComponent(invoiceTotalLb)))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(87, 87, 87)
                                                                .addComponent(invoiceLines)))))
                                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(37, 37, 37)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceNumber)
                                                        .addComponent(invoiceNumberLb))
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceDate)
                                                        .addComponent(invoiceDateLb))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(customerName)
                                                        .addComponent(customerNameLb))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(invoiceTotal)
                                                        .addComponent(invoiceTotalLb))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                                .addComponent(invoiceLines)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(invoicesTable)
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(createNewInvoiceBtn)
                                                .addComponent(deleteInvoiceBtn)
                                                .addComponent(cancelLineBtn))
                                        .addComponent(saveLineBtn))
                                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
            try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(SalesInvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(SalesInvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(SalesInvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(SalesInvoiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new SalesInvoiceFrame().setVisible(true);
                }
            });

    }



    // Variables declaration - do not modify
    private javax.swing.JButton cancelLineBtn;
    private javax.swing.JButton createNewInvoiceBtn;
    private javax.swing.JLabel customerName;
    private javax.swing.JLabel customerNameLb;
    private javax.swing.JButton deleteInvoiceBtn;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel invoiceDate;
    private javax.swing.JLabel invoiceDateLb;
    private javax.swing.JLabel invoiceLines;
    private javax.swing.JLabel invoiceNumber;
    private javax.swing.JLabel invoiceNumberLb;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel invoiceTotal;
    private javax.swing.JLabel invoiceTotalLb;
    private javax.swing.JLabel invoicesTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable linesTable;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton saveLineBtn;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration


    private  ArrayList<InvoiceHeader> invoiceHeaders;


    private  ArrayList<InvoiceHeader> invoiceHeadersBackUp;

    private ArrayList<String> invoiceHeadersDates;

    private ArrayList<String> invoiceHeadersDatesBackUp;

    private InvoiceHeaderTable invoiceHeaderTable;
    private InvoiceLineTable invoiceLineTable;

    public ArrayList<String> getInvoiceHeadersDatesBackUp() {

        if(invoiceHeadersDatesBackUp == null)
        {
            invoiceHeadersDatesBackUp = new ArrayList<>();
        }
        return invoiceHeadersDatesBackUp;
    }

    public void setInvoiceHeadersDatesBackUp(ArrayList<String> invoiceHeadersDatesBackUp) {
        this.invoiceHeadersDatesBackUp = invoiceHeadersDatesBackUp;
    }

    public ArrayList<InvoiceHeader> getInvoiceHeadersBackUp() {

        if(invoiceHeadersBackUp == null)
        {
            invoiceHeadersBackUp = new ArrayList<>();
        }
        return invoiceHeadersBackUp;
    }

    public void setInvoiceHeadersBackUp(ArrayList<InvoiceHeader> invoiceHeadersBackUp) {
        this.invoiceHeadersBackUp = invoiceHeadersBackUp;
    }

    public ArrayList<InvoiceHeader> getInvoiceHeaders() {
        if(invoiceHeaders == null)
        {
            invoiceHeaders = new ArrayList<>();
        }
        return invoiceHeaders;
    }

    public ArrayList<String> getInvoiceHeadersDates() {
        if(invoiceHeadersDates == null)
        {
            invoiceHeadersDates = new ArrayList<>();
        }
        return invoiceHeadersDates;
    }

    public void setInvoiceHeadersDates(ArrayList<String> invoiceHeadersDates) {
        this.invoiceHeadersDates = invoiceHeadersDates;
    }

    private static void setInvoiceHeader(ArrayList<InvoiceHeader> inv) {
        ArrayList<InvoiceHeader> invoiceHeader=new ArrayList<>();
        invoiceHeader=inv;
        setInvoiceHeader(invoiceHeader);

    }

    public void setInvoiceHeaders(ArrayList<InvoiceHeader> invoiceHeaders) {
        this.invoiceHeaders = invoiceHeaders;
    }

    public InvoiceHeaderTable getInvoiceHeaderTable() {
        return invoiceHeaderTable;
    }

    public void setInvoiceHeaderTable(InvoiceHeaderTable invoiceHeaderTable) {
        this.invoiceHeaderTable = invoiceHeaderTable;
    }

    public JTable getInvoiceTable() {
        return invoiceTable;
    }

    public InvoiceLineTable getInvoiceLineTable() {
        return invoiceLineTable;
    }

    public void setInvoiceLineTable(InvoiceLineTable invoiceLineTable) {
        this.invoiceLineTable = invoiceLineTable;
    }

    public JLabel getCustomerNameLb() {
        return customerNameLb;
    }

    public JLabel getInvoiceDateLb() {
        return invoiceDateLb;
    }

    public JLabel getInvoiceNumberLb() {
        return invoiceNumberLb;
    }

    public JLabel getInvoiceTotalLb() {
        return invoiceTotalLb;
    }

    public JTable getLinesTable() {
        return linesTable;
    }

    public SalesInvoiceListener getSalesInvoiceListener() {
        return salesInvoiceListener;
    }

    public int getNewInvoiceNum()
    {
        int newNum = 0;
        for(int i = 0;i<invoiceHeaders.size();i++)
        {
            if(newNum < invoiceHeaders.get(i).getInvoiceNum())
            {
                newNum = invoiceHeaders.get(i).getInvoiceNum();
            }
        }
        return ++newNum;
    }

    public JLabel getCustomerName() {
        return customerName;
    }

    public JLabel getInvoiceDate() {
        return invoiceDate;
    }

    public JLabel getInvoiceNumber() {
        return invoiceNumber;
    }

    public JLabel getInvoiceTotal() {
        return invoiceTotal;
    }



}
