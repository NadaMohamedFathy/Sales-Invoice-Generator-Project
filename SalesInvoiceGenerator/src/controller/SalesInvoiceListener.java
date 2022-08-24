package controller;

import model.*;
import view.InvoiceDialog;
import view.LineDialog;
import view.NoOfLinesDialog;
import view.SalesInvoiceFrame;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class SalesInvoiceListener implements ActionListener, ListSelectionListener {

    SalesInvoiceFrame salesInvoiceFrame;
    FileOperations fileOperations;
    InvoiceDialog invoiceDialog;
    LineDialog lineDialog;
    NoOfLinesDialog noOfLinesDialog;
    int num;
    ArrayList<InvoiceHeader> newInvoiceHeaders=new ArrayList<>();
    ArrayList<String> deletedInvoiceHeadersDate=new ArrayList<>();
    ArrayList<InvoiceHeader> deletedInvoiceHeaders=new ArrayList<>();


    public SalesInvoiceListener(SalesInvoiceFrame salesInvoiceFrame) {

        this.salesInvoiceFrame = salesInvoiceFrame;
        fileOperations = new FileOperations(this.salesInvoiceFrame);
        try {
            ArrayList<String> hArray = fileOperations.loadDefaultFile("InvoiceHeader.csv");
            ArrayList<String> lArray = fileOperations.loadDefaultFile("InvoiceLine.csv");
            salesInvoiceFrame.setInvoiceHeaders(fileOperations.readFileDefault(hArray, lArray));
            for(int i = 0;i<salesInvoiceFrame.getInvoiceHeaders().size();i++)
            {
                System.out.println("Invoice "+salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceNum()+"\n" +
                        "{\n"+ "  "+fileOperations.changeFormat(salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceDate())+", "
                        +salesInvoiceFrame.getInvoiceHeaders().get(i).getCustomerName());

                for(int j = 0;j<salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().size();j++)
                {
                    System.out.println("Invoice"+salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j).getItemName()+", "
                            +salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j).getItemPrice() +", "
                            +salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j).getCount());
                }

                System.out.println("}\n");


            }
            //drawTable();
        }catch (IOException e)
        {

        }


    }


//public String str;

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "L" :
                salesInvoiceFrame.setInvoiceHeaders(fileOperations.readFile());
                /*System.out.println(salesInvoiceFrame.getInvoiceHeaders().get(0).getCustomerName());
                System.out.println(salesInvoiceFrame.getInvoiceHeaders().get(0).getInvoiceLines().get(0).getItemName());
                System.out.println(salesInvoiceFrame.getInvoiceHeaders().get(0).getTotal());
                System.out.println(salesInvoiceFrame.getInvoiceHeaders().get(1).getCustomerName());
                System.out.println(salesInvoiceFrame.getInvoiceHeaders().get(1).getInvoiceLines().get(0).getItemName());
                System.out.println(salesInvoiceFrame.getInvoiceHeaders().get(1).getTotal());*/
                for (int i=0;i<salesInvoiceFrame.getInvoiceHeaders().size();i++)
                {
                    String pattern = "dd-MM-yyyy";
                    DateFormat df = new SimpleDateFormat(pattern);
                    String dateChanged = df.format(salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceDate());
                    salesInvoiceFrame.getInvoiceHeadersDates().add(dateChanged);
                }
                //drawTable();
                salesInvoiceFrame.setInvoiceHeadersDatesBackUp(salesInvoiceFrame.getInvoiceHeadersDates());
                salesInvoiceFrame.setInvoiceHeadersBackUp(salesInvoiceFrame.getInvoiceHeaders());
                salesInvoiceFrame.setInvoiceHeaderTable(new InvoiceHeaderTable(salesInvoiceFrame.getInvoiceHeaders(), salesInvoiceFrame.getInvoiceHeadersDates()));
                salesInvoiceFrame.getInvoiceTable().setModel(salesInvoiceFrame.getInvoiceHeaderTable());
                //salesInvoiceFrame.getInvoiceTable().setModel(new InvoiceHeaderTable(salesInvoiceFrame.getInvoiceHeaders()));
                break;
            case "S" :
                System.out.println("SSSSSSSS");
                fileOperations.writeFile(salesInvoiceFrame.getInvoiceHeaders());
                break;
            case "CIN":
                createNewInvoice();
                break;
            case "DI":
                deleteInvoice();
                break;
            case "CNL":
                createNewLine();
                break;
            case "DL":
                deleteLine();
                break;
            case "CreateInvoice":
                createInvoice();
                break;
            case "CancelInvoice":
                cancelInvoice();
                break;
            case "CreateLine":
                    createLine();
                break;
            case "CancelLine":
                cancelLine();
                break;
            /*case "NumberOfItemsok":
                num = getNumberOfItemsOk();
                if(num > 0)
                    for(int i=0;i<num;i++)
                    {
                        createNewLine();
                    }

                break;*/
        }
    }

    private void deleteLine() {

        int selectedRow = salesInvoiceFrame.getInvoiceTable().getSelectedRow();
        int selectedRowLine = salesInvoiceFrame.getLinesTable().getSelectedRow();


        if(selectedRow >= 0 && selectedRowLine >= 0)
        {
            InvoiceHeader invoiceHeader = salesInvoiceFrame.getInvoiceHeaders().get(selectedRow);
            InvoiceLine invoiceLine = salesInvoiceFrame.getInvoiceHeaders().get(selectedRow).getInvoiceLines().get(selectedRowLine);

            //deletedInvoiceHeadersDate.add(fileOperations.changeFormat(invoiceHeader.getInvoiceDate()));
            for (int i=0;i<salesInvoiceFrame.getInvoiceHeaders().size();i++)
            {
                if(salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceNum() == invoiceHeader.getInvoiceNum())
                {
                    //deletedInvoiceHeaders.add(salesInvoiceFrame.getInvoiceHeaders().get(i));
                    for(int j=0;j<salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().size();j++)
                    {
                        if(salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j).equals(invoiceLine)) {
                            //deletedInvoiceHeaders.get(deletedInvoiceHeaders.size() - 1).getInvoiceLines().add(salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j));
                            salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().remove(j);
                            salesInvoiceFrame.getInvoiceLineTable().setRowCount(salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().size());
                        }
                    }
                }
            }
            salesInvoiceFrame.getInvoiceTotalLb().setText(String.valueOf(invoiceHeader.getTotal()));

        }

        salesInvoiceFrame.getInvoiceLineTable().fireTableDataChanged();
        salesInvoiceFrame.getInvoiceHeaderTable().fireTableDataChanged();

    }


    private void cancel() {


        for(int i=0;i<newInvoiceHeaders.size();i++)
        {
            for (int j=0;j<salesInvoiceFrame.getInvoiceHeaders().size();j++)
            {
                if(salesInvoiceFrame.getInvoiceHeaders().get(j).getInvoiceNum() == newInvoiceHeaders.get(i).getInvoiceNum())
                {
                    for(int k=0;k<salesInvoiceFrame.getInvoiceHeaders().get(j).getInvoiceLines().size();k++)
                    {
                        salesInvoiceFrame.getInvoiceHeaders().get(j).getInvoiceLines().remove(k);
                    }
                    salesInvoiceFrame.getInvoiceHeaders().remove(j);
                }
            }
            salesInvoiceFrame.getInvoiceLineTable().setRowCount(0);
            salesInvoiceFrame.getInvoiceLineTable().fireTableDataChanged();
            salesInvoiceFrame.getInvoiceHeaderTable().fireTableDataChanged();

        }

        salesInvoiceFrame.getInvoiceDateLb().setText("");
        salesInvoiceFrame.getInvoiceNumberLb().setText("");
        salesInvoiceFrame.getCustomerNameLb().setText("");
        salesInvoiceFrame.getInvoiceTotalLb().setText("");


        for(int i=0;i<deletedInvoiceHeaders.size();i++)
        {
            salesInvoiceFrame.getInvoiceHeaders().add(deletedInvoiceHeaders.get(i));
            salesInvoiceFrame.getInvoiceHeadersDates().add(deletedInvoiceHeadersDate.get(i));
        }

        salesInvoiceFrame.getInvoiceHeaderTable().fireTableDataChanged();
        salesInvoiceFrame.getInvoiceLineTable().fireTableDataChanged();


        /*salesInvoiceFrame.setInvoiceHeaders(salesInvoiceFrame.getInvoiceHeadersBackUp());
        salesInvoiceFrame.setInvoiceHeadersDates(salesInvoiceFrame.getInvoiceHeadersDatesBackUp());

        salesInvoiceFrame.setInvoiceHeaderTable(new InvoiceHeaderTable(salesInvoiceFrame.getInvoiceHeaders(), salesInvoiceFrame.getInvoiceHeadersDates()));
        salesInvoiceFrame.getInvoiceTable().setModel(salesInvoiceFrame.getInvoiceHeaderTable());*/

    }


    // private int selectedRow;

    @Override
    public void valueChanged(ListSelectionEvent e) {

        int selectedRow = salesInvoiceFrame.getInvoiceTable().getSelectedRow();
        if(selectedRow >= 0)
        {
            InvoiceHeader invoiceHeader = salesInvoiceFrame.getInvoiceHeaders().get(selectedRow);
            salesInvoiceFrame.getCustomerNameLb().setText(invoiceHeader.getCustomerName());
            salesInvoiceFrame.getInvoiceDateLb().setText(fileOperations.changeFormat(invoiceHeader.getInvoiceDate()));
            salesInvoiceFrame.getInvoiceTotalLb().setText(String.valueOf(invoiceHeader.getTotal()));
            salesInvoiceFrame.getInvoiceNumberLb().setText(String.valueOf(invoiceHeader.getInvoiceNum()));
            InvoiceLineTable invoiceLineTable = new InvoiceLineTable(invoiceHeader.getInvoiceLines(), invoiceHeader.getInvoiceNum());
            invoiceLineTable.setRowCount(invoiceHeader.getInvoiceLines().size());
            salesInvoiceFrame.setInvoiceLineTable(invoiceLineTable);
            salesInvoiceFrame.getLinesTable().setModel(salesInvoiceFrame.getInvoiceLineTable());
        }
        }


    private void createNewLine() {

        lineDialog = new LineDialog(salesInvoiceFrame);
        lineDialog.setVisible(true);

    }

    private void deleteInvoice() {
        int selectedRow = salesInvoiceFrame.getInvoiceTable().getSelectedRow();

        if(selectedRow >= 0)
        {
            InvoiceHeader invoiceHeader = salesInvoiceFrame.getInvoiceHeaders().get(selectedRow);

            deletedInvoiceHeadersDate.add(fileOperations.changeFormat(invoiceHeader.getInvoiceDate()));
            for (int i=0;i<salesInvoiceFrame.getInvoiceHeaders().size();i++)
            {
                if(salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceNum() == invoiceHeader.getInvoiceNum())
                {
                    deletedInvoiceHeaders.add(salesInvoiceFrame.getInvoiceHeaders().get(i));
                    for(int j=0;j<salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().size();j++)
                    {
                        deletedInvoiceHeaders.get(deletedInvoiceHeaders.size()-1).getInvoiceLines().add(salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j));
                        salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().remove(j);
                    }
                    salesInvoiceFrame.getInvoiceHeaders().remove(i);
                    salesInvoiceFrame.getInvoiceHeadersDates().remove(i);
                }
            }
        }
        salesInvoiceFrame.getInvoiceDateLb().setText("");
        salesInvoiceFrame.getInvoiceNumberLb().setText("");
        salesInvoiceFrame.getCustomerNameLb().setText("");
        salesInvoiceFrame.getInvoiceTotalLb().setText("");

        salesInvoiceFrame.getInvoiceLineTable().setRowCount(0);
        salesInvoiceFrame.getInvoiceLineTable().fireTableDataChanged();
        salesInvoiceFrame.getInvoiceHeaderTable().fireTableDataChanged();


    }

    private void createNewInvoice() {

        invoiceDialog = new InvoiceDialog(salesInvoiceFrame);
        invoiceDialog.setVisible(true);

    }

    private void cancelInvoice() {
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;
    }

    private void createInvoice() {

        String name = invoiceDialog.getCustomerName().getText();
        String invDate = invoiceDialog.getInvoiceDate().getText();
        invoiceDialog.setVisible(false);
        invoiceDialog.dispose();
        invoiceDialog = null;

        Date date = fileOperations.changeFormat(invDate);
        InvoiceHeader invoiceHeader = new InvoiceHeader(salesInvoiceFrame.getNewInvoiceNum(), date, name);
        salesInvoiceFrame.getInvoiceHeaders().add(invoiceHeader);
        salesInvoiceFrame.getInvoiceHeadersDates().add(invDate);
        salesInvoiceFrame.getInvoiceHeaderTable().fireTableDataChanged();
        //getNumberOfItems();
        newInvoiceHeaders.add(salesInvoiceFrame.getInvoiceHeaders().get(salesInvoiceFrame.getInvoiceHeaders().size()-1));

    }

    public void drawTable()
    {
       /* for(int i = 0;i<salesInvoiceFrame.getInvoiceHeaders().size();i++)
        {
            System.out.println("H******Num  "+salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceNum());
            System.out.println("H******date  "+salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceDate());
            System.out.println("H******Name  "+salesInvoiceFrame.getInvoiceHeaders().get(i).getCustomerName());

            for(int j = 0;j<salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().size();j++)
            {
                System.out.println("L******name  "+salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j).getItemName());
                System.out.println("L******price  "+salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j).getItemPrice());
                System.out.println("L******count  "+salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j).getCount());

            }

            System.out.println("*****************************************************************************************");


        }*/
        for (int i=0;i<salesInvoiceFrame.getInvoiceHeaders().size();i++)
        {
            String pattern = "dd-MM-yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            String dateChanged = df.format(salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceDate());
            salesInvoiceFrame.getInvoiceHeadersDates().add(dateChanged);
        }
        //salesInvoiceFrame.setInvoiceHeaderTable(new InvoiceHeaderTable(salesInvoiceFrame.getInvoiceHeaders(), salesInvoiceFrame.getInvoiceHeadersDates()));
        //salesInvoiceFrame.getInvoiceTable().setModel(salesInvoiceFrame.getInvoiceHeaderTable());
        /*InvoiceHeaderTable invoiceHeaderTable = new InvoiceHeaderTable(salesInvoiceFrame.getInvoiceHeaders(), salesInvoiceFrame.getInvoiceHeadersDates());
        invoiceHeaderTable.setRowCount(salesInvoiceFrame.getInvoiceHeaders().size());
        salesInvoiceFrame.setInvoiceHeaderTable(invoiceHeaderTable);
        salesInvoiceFrame.getInvoiceTable().setModel(salesInvoiceFrame.getInvoiceHeaderTable());*/

    }

    private void getNumberOfItems() {

        noOfLinesDialog = new NoOfLinesDialog(salesInvoiceFrame);
        noOfLinesDialog.setVisible(true);

    }

    private int getNumberOfItemsOk() {
        String itemNum = noOfLinesDialog.getItemNumbers().getText();
        noOfLinesDialog.setVisible(false);
        noOfLinesDialog.dispose();
        noOfLinesDialog = null;
        int no = Integer.valueOf(itemNum);
        return no;

    }



    private void cancelLine() {

        lineDialog.setVisible(false);
        lineDialog.dispose();
        lineDialog = null;

    }

    private void createLine() {

        String itemName = lineDialog.getItemName().getText();
        String itemPrice = lineDialog.getItemPrice().getText();
        String itemCount = lineDialog.getItemCount().getText();
            lineDialog.setVisible(false);
            lineDialog.dispose();
            lineDialog = null;
            int selectedRow = salesInvoiceFrame.getInvoiceTable().getSelectedRow();

            if(selectedRow >= 0)
            {
                InvoiceLine invoiceLine = new InvoiceLine(itemName, Double.valueOf(itemPrice), Integer.valueOf(itemCount));
                InvoiceHeader invoiceHeader = salesInvoiceFrame.getInvoiceHeaders().get(selectedRow);
                invoiceHeader.getInvoiceLines().add(invoiceLine);
                //newInvoiceHeaders.get(newInvoiceHeaders.size()-1).getInvoiceLines().add(invoiceLine);
                salesInvoiceFrame.getInvoiceLineTable().setRowCount(invoiceHeader.getInvoiceLines().size());
                salesInvoiceFrame.getInvoiceLineTable().fireTableDataChanged();
                salesInvoiceFrame.getInvoiceTotalLb().setText(String.valueOf(invoiceHeader.getTotal()));
                salesInvoiceFrame.getInvoiceHeaderTable().fireTableDataChanged();
            }
    }

}
