package utilities;

import org.apache.pdfbox.pdmodel.*;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.PDPageContentStream;

import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileGeneratorUtil {

    private static final String FOLDER_PATH = "testdata/";
    private static int counter = 1;

    // Method to create folder if not exists
    private static void createTestDataFolder() {
        File folder = new File(FOLDER_PATH);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    // Generate PDF
    public static File createTestDataPDF() throws IOException {

        createTestDataFolder();

        String fileName = "TestDataDocs_" + counter++ + ".pdf";
        File file = new File(FOLDER_PATH + fileName);

        PDDocument document = new PDDocument();
        PDPage page = new PDPage();
        document.addPage(page);

        PDPageContentStream content = new PDPageContentStream(document, page);

        content.beginText();
        content.setFont(PDType1Font.HELVETICA, 12);
        content.newLineAtOffset(100, 700);
        content.showText("Automation generated PDF file.");
        content.endText();

        content.close();

        document.save(file);
        document.close();

        return file;
    }

    // Generate DOCX
    public static File createTestDataDOCX() throws IOException {

        createTestDataFolder();

        String fileName = "TestDataDocs_" + counter++ + ".docx";
        File file = new File(FOLDER_PATH + fileName);

        XWPFDocument document = new XWPFDocument();

        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();

        run.setText("Automation generated DOCX file.");
        run.setBold(true);

        FileOutputStream out = new FileOutputStream(file);

        document.write(out);

        out.close();
        document.close();

        return file;
    }
}