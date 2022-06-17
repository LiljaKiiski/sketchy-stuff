import java.io.FileInputStream;
import java.io.IOException;

import javax.print.*;
import javax.print.attribute.*;
import javax.print.attribute.standard.Copies;
import javax.print.event.*;

public class Printer {

   	public static void main(String[] args) throws PrintException, IOException{

      		PrintService ps = PrintServiceLookup.lookupDefaultPrintService();
		ps = java.awt.print.PrinterJob.lookupPrintServices()[0];

      		System.out.println(ps.getName());

		DocPrintJob job=ps.createPrintJob();
      		
		job.addPrintJobListener(new PrintJobAdapter() {
      		
			public void printDataTransferCompleted(PrintJobEvent event){
        			System.out.println("data transfer complete");
      			}

      			public void printJobNoMoreEvents(PrintJobEvent event){
        		    	System.out.println("received no more events");
         		}
      		});
      
		String fileName = "filename.png";
		FileInputStream fis=new FileInputStream(fileName);
      		Doc doc=new SimpleDoc(fis, DocFlavor.INPUT_STREAM.AUTOSENSE, null);
      		PrintRequestAttributeSet attrib=new HashPrintRequestAttributeSet();
      		attrib.add(new Copies(1));
      		job.print(doc, attrib);
   	}
}
