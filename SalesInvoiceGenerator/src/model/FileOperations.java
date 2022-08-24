package model;

import view.SalesInvoiceFrame;

import javax.swing.*;
import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class FileOperations {

    SalesInvoiceFrame salesInvoiceFrame;


    public FileOperations(SalesInvoiceFrame salesInvoiceFrame) {
        this.salesInvoiceFrame = salesInvoiceFrame;
    }


    public ArrayList<InvoiceHeader> readFile()
    {
        System.out.println("Get Invoices File");
        ArrayList<InvoiceHeader> invoiceHeaders = new ArrayList<>();
        String str = chooseFileLoad();
        ArrayList<String> arrayOfInvoices = cutToArray(str);
        int i=0;
        while(i<arrayOfInvoices.size())
        {
            int num = Integer.valueOf(arrayOfInvoices.get(i));
            String date = (String) arrayOfInvoices.get(i + 1);
            String name = (String) arrayOfInvoices.get(i + 2);
            InvoiceHeader invoiceHeader = new InvoiceHeader(num,changeFormat(date),name);
            invoiceHeaders.add(invoiceHeader);

            i+=3;
        }
        System.out.println("***************************************************************");

        System.out.println("Get Lines File");
        //Lines
        String str1 = chooseFileLoad();
        ArrayList<InvoiceLine> invoiceLines;
        ArrayList<String> arrayOfLines = cutToArray(str1);
        for (int h = 0; h < invoiceHeaders.size(); h++) {
            invoiceLines = new ArrayList<>();
            int j = 0;
            while (j < arrayOfLines.size()) {
                int num = Integer.valueOf(arrayOfLines.get(j));
                if (num == invoiceHeaders.get(h).getInvoiceNum()) {
                    String item = (String) arrayOfLines.get(j + 1);
                    double price = Double.valueOf(arrayOfLines.get(j + 2));
                    double itemCount = Double.valueOf(arrayOfLines.get(j + 3));
                    InvoiceLine invoiceLine = new InvoiceLine(item, price, (int)itemCount);
                    invoiceLines.add(invoiceLine);
                }
                j += 4;
            }
            invoiceHeaders.get(h).setInvoiceLines(invoiceLines);
        }


        return invoiceHeaders;
    }

    public ArrayList<InvoiceHeader> readFileDefault(ArrayList<String> arrayOfInvoices,ArrayList<String> arrayOfLines) throws IOException {
        System.out.println("Get Invoices File");
        ArrayList<InvoiceHeader> invoiceHeaders = new ArrayList<>();
        int i=0;
        while(i<arrayOfInvoices.size())
        {
            int num = Integer.valueOf(arrayOfInvoices.get(i));
            String date = (String) arrayOfInvoices.get(i + 1);
            String name = (String) arrayOfInvoices.get(i + 2);
            InvoiceHeader invoiceHeader = new InvoiceHeader(num,changeFormat(date),name);
            invoiceHeaders.add(invoiceHeader);

            i+=3;
        }
        System.out.println("***************************************************************");

        System.out.println("Get Lines File");
        //Lines
        ArrayList<InvoiceLine> invoiceLines;
        for (int h = 0; h < invoiceHeaders.size(); h++) {
            invoiceLines = new ArrayList<>();
            int j = 0;
            while (j < arrayOfLines.size()) {
                int num = Integer.valueOf(arrayOfLines.get(j));
                if (num == invoiceHeaders.get(h).getInvoiceNum()) {
                    String item = (String) arrayOfLines.get(j + 1);
                    double price = Double.valueOf(arrayOfLines.get(j + 2));
                    double itemCount = Double.valueOf(arrayOfLines.get(j + 3));
                    InvoiceLine invoiceLine = new InvoiceLine(item, price, (int)itemCount);
                    invoiceLines.add(invoiceLine);
                }
                j += 4;
            }
            invoiceHeaders.get(h).setInvoiceLines(invoiceLines);
        }


        /*for (int k=0;k<salesInvoiceFrame.getInvoiceHeaders().size();k++)
        {
            String pattern = "dd-MM-yyyy";
            DateFormat df = new SimpleDateFormat(pattern);
            String dateChanged = df.format(salesInvoiceFrame.getInvoiceHeaders().get(k).getInvoiceDate());
            salesInvoiceFrame.getInvoiceHeadersDates().add(dateChanged);
        }
        salesInvoiceFrame.setInvoiceHeadersDatesBackUp(salesInvoiceFrame.getInvoiceHeadersDates());
        salesInvoiceFrame.setInvoiceHeadersBackUp(salesInvoiceFrame.getInvoiceHeaders());
        salesInvoiceFrame.setInvoiceHeaderTableModel(new InvoiceHeaderTable(salesInvoiceFrame.getInvoiceHeaders(), salesInvoiceFrame.getInvoiceHeadersDates()));
        salesInvoiceFrame.getInvoiceTable().setModel(salesInvoiceFrame.getInvoiceHeaderTable());*/
        return invoiceHeaders;
    }

    public String directory;
    public File file;
    //public File file2;
    public File path(String file_name)
    {
        directory = System.getProperty("user.dir");
        file=new File(directory);
        file = new File(file_name);
        directory=""+file.getAbsoluteFile();
        return file;
    }
    public ArrayList<String> loadDefaultFile(String fileName) throws IOException
    {
        File f;
        f=path(fileName);
        ArrayList<String> array=new ArrayList<>();
        if(f.exists())
        {
            FileReader fileReader = new FileReader(f);
            BufferedReader in = new BufferedReader(fileReader);
            String line;
            String field="";
            while((line = in.readLine())!= null)
            {
                for(int i=0;i<line.length();i++)
                {

                        if(line.charAt(i)!=',' && line.charAt(i)!='\n' && i<line.length()-1)
                            field+=line.charAt(i);
                        else if(i==line.length()-1)
                        {
                            field+=line.charAt(i);
                            array.add(field);
                            field="";
                        }
                        else
                        {
                            array.add(field);
                            field="";
                        }
                }
            }
            in.close();
        }
        return array;
    }

    public void writeFile(ArrayList<InvoiceHeader> invoiceHeaders)
    {
        String invoices = "";
        String lines = "";
        String invoice = "";
        String line = "";
        for (int i = 0; i < invoiceHeaders.size(); i++) {

            String date = changeFormat(invoiceHeaders.get(i).getInvoiceDate());

            if (i == invoiceHeaders.size()-1)
            {
                invoice = invoiceHeaders.get(i).getInvoiceNum() + "," + date + "," + invoiceHeaders.get(i).getCustomerName();
                for(int j = 0;j<invoiceHeaders.get(i).getInvoiceLines().size();j++)
                {
                    if (j == invoiceHeaders.get(i).getInvoiceLines().size()-1)
                    {
                        line = invoiceHeaders.get(i).getInvoiceNum() + "," + invoiceHeaders.get(i).getInvoiceLines().get(j).getItemName() + "," +
                                invoiceHeaders.get(i).getInvoiceLines().get(j).getItemPrice() + "," + invoiceHeaders.get(i).getInvoiceLines().get(j).getCount();
                    }
                    else if (j != invoiceHeaders.get(i).getInvoiceLines().size()-1)
                    {
                        line = invoiceHeaders.get(i).getInvoiceNum() + "," + invoiceHeaders.get(i).getInvoiceLines().get(j).getItemName() + "," +
                                invoiceHeaders.get(i).getInvoiceLines().get(j).getItemPrice() + "," + invoiceHeaders.get(i).getInvoiceLines().get(j).getCount() +"\n";
                    }
                    lines += line;

                }

            }
            else if (i != invoiceHeaders.size()-1)
            {
                invoice = invoiceHeaders.get(i).getInvoiceNum() + "," + date + "," + invoiceHeaders.get(i).getCustomerName()+"\n";
                for(int j = 0;j<invoiceHeaders.get(i).getInvoiceLines().size();j++)
                {
                        line = invoiceHeaders.get(i).getInvoiceNum() + "," + invoiceHeaders.get(i).getInvoiceLines().get(j).getItemName() + "," +
                                invoiceHeaders.get(i).getInvoiceLines().get(j).getItemPrice() + "," + invoiceHeaders.get(i).getInvoiceLines().get(j).getCount() +"\n";
                    lines += line;

                }

            }
            invoices += invoice ;



            invoice = "";
            line= "";

        }
        chooseFileSave(invoices);
        chooseFileSave(lines);
    }

    private String chooseFileLoad()
    {
        String str = null;/////////
        JFileChooser jFileChooser = new JFileChooser();
        int result = jFileChooser.showOpenDialog(this.salesInvoiceFrame);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            String path = jFileChooser.getSelectedFile().getPath();
            FileInputStream fileInputStream = null;
            try {
                fileInputStream = new FileInputStream(path);
                int size = fileInputStream.available();
                byte[] b = new byte[size];
                fileInputStream.read(b);
                str = new String(b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileInputStream.close();
                } catch (IOException e) {}
            }
        }
        return str;
    }
    private void chooseFileSave(String str)
    {
        JFileChooser jFileChooser = new JFileChooser();
        int result = jFileChooser.showOpenDialog(this.salesInvoiceFrame);
        if(result == JFileChooser.APPROVE_OPTION)
        {
            String path = jFileChooser.getSelectedFile().getPath();
            FileOutputStream fileOutputStream = null;
            try {
                fileOutputStream = new FileOutputStream(path);
                byte[] b = str.getBytes();
                fileOutputStream.write(b);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {}
            }
        }
    }

    private ArrayList<String> cutToArray(String str)
    {
        ArrayList<String> array=new ArrayList<>();
        String field="";
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)!=',' && str.charAt(i)!='\n' && i<str.length()-1)
                field+=str.charAt(i);
            else if(i==str.length()-1)
            {
                field+=str.charAt(i);
                array.add(field);
                field="";
            }
            else
            {
                array.add(field);
                field="";
            }
        }
        return array;
    }

    public Date changeFormat(String date)
    {
        Date d = null;
        try {
            d = new SimpleDateFormat("dd-MM-yyyy").parse(date);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(salesInvoiceFrame,"Bad Format","Bad format", JOptionPane.ERROR_MESSAGE);
        }

        return d;
    }

    public String changeFormat(Date date)
    {
        //Date d = new SimpleDateFormat("dd-MM-yyyy").parse(date);

        String pattern = "dd-MM-yyyy";
        DateFormat df = new SimpleDateFormat(pattern);
        String dateChanged = df.format(date);
        return dateChanged;
    }

    public void main(String args[]) {

        for(int i = 0;i<salesInvoiceFrame.getInvoiceHeaders().size();i++)
        {
            System.out.println("Invoice "+salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceNum()+"\n" +
                    "{\n"+salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceNum()+
                    "  "+changeFormat(salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceDate())+", "
                    +salesInvoiceFrame.getInvoiceHeaders().get(i).getCustomerName());

            for(int j = 0;j<salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().size();j++)
            {
                System.out.println("Invoice"+salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j).getItemName()+", "
                        +salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j).getItemPrice() +", "
                        +salesInvoiceFrame.getInvoiceHeaders().get(i).getInvoiceLines().get(j).getCount() +"\n");
            }

            System.out.println("}");


        }

    }


}
