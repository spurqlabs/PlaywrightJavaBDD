package utilities;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class DocumentGeneratorUtil {

    private static String getTestDataFolder() {
        return Paths.get(System.getProperty("user.dir"),
                "src", "test", "resources", "testdata").toString();
    }

    private static String generateFileName(String extension) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        return "TestDataDocsSeries_" + LocalDateTime.now().format(formatter) + extension;
    }

    // Generate Random PDF
    public static String createRandomPDF() {

        String fileName = generateFileName(".pdf");
        String filePath = Paths.get(getTestDataFolder(), fileName).toString();

        try {
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(filePath));

            document.open();
            document.add(new Paragraph("Automation Test Document"));
            document.add(new Paragraph("Generated at: " + LocalDateTime.now()));
            document.add(new Paragraph("Test Data Docs Series"));
            document.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return filePath;
    }

    // Generate Random DOCX
    public static String createRandomDOCX() {

        String fileName = generateFileName(".docx");
        String filePath = Paths.get(getTestDataFolder(), fileName).toString();

        try {

            XWPFDocument document = new XWPFDocument();

            XWPFParagraph paragraph = document.createParagraph();
            paragraph.createRun().setText("Automation Test Document");

            XWPFParagraph paragraph2 = document.createParagraph();
            paragraph2.createRun().setText("Generated at: " + LocalDateTime.now());

            FileOutputStream out = new FileOutputStream(new File(filePath));
            document.write(out);

            out.close();
            document.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;
    }
}