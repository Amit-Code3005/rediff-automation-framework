package utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PDFReportUtility {

    private static Document document;

    //  Create PDF file
    public static void startReport() {
        try {
            String time = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                    .format(new Date());

            String filePath = System.getProperty("user.dir")
                    + "/report/TestReport_" + time + ".pdf";

            document = new Document();

            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();

            //  Title
            Paragraph title = new Paragraph("Test Execution Report\n\n",
                    FontFactory.getFont(FontFactory.HELVETICA_BOLD, 16));

            document.add(title);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Add test step / result
    public static void addStep(String testName, String status) {
        try {
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(new Date());

            Paragraph p = new Paragraph(
                    "Test Name: " + testName +
                            "\nStatus: " + status +
                            "\nTime: " + time +
                            "\n-----------------------------\n"
            );

            document.add(p);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Close PDF
    public static void endReport() {
        try {
            // Check if the document is present or not , if present then close else ignore
            if (document != null) {
                document.close();
                System.out.println(" PDF Report Generated");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
