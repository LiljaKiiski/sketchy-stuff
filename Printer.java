import java.io.FileInputStream;
import java.io.IOException;

import java.util.Scanner;

import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.Copies;
import javax.print.event.*;

public class Printer {

   	public static void main(String[] args) throws PrintException, IOException{
		Scanner in = new Scanner(System.in);

      		PrintService ps = java.awt.print.PrinterJob.lookupPrintServices()[0];
		System.out.println("Printer: " + ps.getName());

		DocPrintJob job = ps.createPrintJob();
      		
		job.addPrintJobListener(new PrintJobAdapter() {
      		
			public void printDataTransferCompleted(PrintJobEvent event){
        			
      			}

      			public void printJobNoMoreEvents(PrintJobEvent event){
        		    	
         		}
      		});
      
		System.out.print("File to print: ");
		String fileName = in.nextLine();
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(fileName);
		
		} catch (java.io.FileNotFoundException e){
			System.out.println("Sorry, couldn't find that file. Please run the program again");
			System.exit(0);
		}

		Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
      		
		PrintRequestAttributeSet attrib=new HashPrintRequestAttributeSet();
      		
		System.out.print("Copies: ");
		int copies = in.nextInt();

		attrib.add(new Copies(copies));
      		
		job.print(doc, attrib);
		System.out.println("Printing your document");
   	}
}
