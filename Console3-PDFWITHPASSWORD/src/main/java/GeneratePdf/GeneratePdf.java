package GeneratePdf;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePdf {
    /**
     * @param args
     */
    public static void main(String[] args) {
        try {

        	Scanner sc=new Scanner(System.in);
        	System.out.println("Enter username");
        	String USER_PASS =sc.nextLine();
        	System.out.println("Enter password");

            String OWNER_PASS =sc.nextLine();
            OutputStream file = new FileOutputStream(new File("sree.pdf"));

            Document document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);

            writer.setEncryption(USER_PASS.getBytes(), OWNER_PASS.getBytes(),
                    PdfWriter.ALLOW_PRINTING|PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_128);
            Image image1 = Image.getInstance("3.png");
            image1.setAlignment(Element.ALIGN_CENTER);               
            document.open();    
            document.add(image1);
            document.add(new Paragraph("\n"));
            document.add(new Paragraph());
            document.add(new Paragraph("Password Protected Pdf"));
            document.add(new Paragraph("\n"));
            document.add(new Paragraph());
            document.add(new Paragraph(new Date().toString()));

            document.close();
            file.close();
            System.out.println("Pdf generated");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

