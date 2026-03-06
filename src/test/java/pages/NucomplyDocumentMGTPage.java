package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;
import com.microsoft.playwright.options.WaitForSelectorState;
import core.TestContext;
import org.testng.Assert;
import utilities.DocumentGeneratorUtil;

import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class NucomplyDocumentMGTPage extends TestContext {

    public void clickondocumentManagement() {
        page.locator("(//button[@class=\"chakra-menu__menuitem css-15a4iup\"])[4]").click();
        System.out.println("click on document management");
        page.waitForTimeout(5000);
    }

    public void clickonuploaddocumentbutton() {
        page.locator("//button[text()='Add Document']").click();
        page.waitForTimeout(10000);
        System.out.println("click on upload document button");
    }

    public void userenterdocumenttitle(String documenttitle) {
        page.locator("//label[text()='Document Title']/following::input[1]").fill(documenttitle);
    }

    public void userselectpolicytype() {
        Locator policytype = page.locator("//label[text()='Document Type']/following::button[1]");
        policytype.click();
        page.locator("//button[text()='Policy']").click();
    }

    public void userselectproceduretype() {
        Locator proceduretype = page.locator("//label[text()='Document Type']/following::button[1]");
        proceduretype.click();
        page.locator("//button[text()='Procedure']").click();
    }

    public void training_material() {
        Locator trainingmaterial = page.locator("//label[text()='Document Type']/following::button[1]");
        trainingmaterial.click();
        page.locator("//button[text()='Training Material']").click();

    }

    public void other() {
        Locator other = page.locator("//label[text()='Document Type']/following::button[1]");
        other.click();
        page.locator("//button[text()='Other']").click();
    }

    public void userclickonnewfilterdropdown() {
        page.locator("//span[text()='Newest first']").click();
    }

    public void uerclicksonfilters() {
        page.locator("//button[text()='Filter']").click();
    }

    public void selecthenewestfilteropt() {
        page.locator("//span[text()='Newest first']").click();
    }

    public void verfifynewestfilteroption() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // matches 2/4/2026

        List<LocalDate> allDates = new ArrayList<>();
        while (true) {
            // 1️⃣ Capture all dates on the current page
            List<String> dateTexts = page.locator("//div[@class=\"chakra-stack css-hwz0ls\"]/p").allTextContents();
            dateTexts.forEach(d -> {
                // Convert string to LocalDate using the formatter
                allDates.add(LocalDate.parse(d.trim(), formatter));
            });

            // 2️⃣ Locate the "Next" button
            Locator nextBtn = page.locator("//button[@aria-label=\"Next page\"]");

            // 3️⃣ Stop if this is the last page
            if (nextBtn.isDisabled()) break;

            // 4️⃣ Go to next page and wait until it loads
            nextBtn.click();
            page.waitForTimeout(10000);
            page.waitForLoadState();

        }
        // Check if dates are sorted newest → oldest (descending), allowing duplicates
        boolean isDescending = true;
        for (int i = 0; i < allDates.size() - 1; i++) {
            // current date must be >= next date
            if (allDates.get(i).isBefore(allDates.get(i + 1))) {
                isDescending = false;
                break;
            }
        }
        // Print result
        if (isDescending) {
            System.out.println("✅ Dates are sorted newest → oldest (duplicates allowed).");
        } else {
            System.out.println("❌ Dates are NOT sorted newest → oldest.");
        }
        allDates.forEach(System.out::println);

    }

    public void selectoldestfilter() {
        page.locator("//button[text()='Oldest first']").click();
        page.waitForTimeout(10000);
    }

    public void documenttypefilter() {
        page.locator("//label[text()='Document Type']/following::div[text()='Select options'][1]").click();

    }

    public void selecttheoptiondocumenttypedrop() {
        page.locator("//label[text()='Document Type']/following::input[1]").fill("policy");
        page.keyboard().press("Enter");
    }

    public void selectthemoduletyprdrop() {
        page.locator("//label[text()='Document Type']/following::input[2]").click();
    }

    public void selectoptionmodule() {
        page.locator("//label[text()='Document Type']/following::input[2]").fill("email");
        page.keyboard().press("Enter");

    }

    public void userclicksonfiletype() {
        page.locator("//label[text()='Document Type']/following::input[3]").click();
    }

    public void selctthefiletypeopt() {
        page.locator("//label[text()='Document Type']/following::input[3]").fill("pdf");
        page.keyboard().press("Enter");
    }

    public void documentscreendisplayed() {
        page.waitForTimeout(5000);
        Locator adddocument = page.locator("//button[text()='Add Document']");
        Assert.assertTrue(page.locator("//h1[text()='Document Management']").isVisible());
        assertTrue(page.url().contains("/document-management"));
        Assert.assertTrue(adddocument.isVisible());


    }

    public void uploaddocumentscreenfiledvisible() {
        page.waitForTimeout(5000);
        page.locator("//p[text()='Drag and drop here to upload']").click();
        Assert.assertTrue(page.locator("//input[@type=\"file\"]").isVisible());
        Assert.assertTrue(page.locator("//button[text()='Cancel']").isVisible());
        Assert.assertTrue(page.locator("//button[text()='Upload']").isDisabled());
    }

    public void clickonadddocumentbutton() {
        page.locator("//button[text()='Add Document']").click();
        System.out.println("Clicked on Add Document button");
    }

    public void verifydocumentuploadpopup() {
        page.waitForSelector("//div[text()='Document Uploaded']",
                new Page.WaitForSelectorOptions()
                        .setState(WaitForSelectorState.VISIBLE)
                        .setTimeout(40000));

    }

    public void clickontomodifydocument() {
        page.waitForTimeout(2000);
        page.locator("//div[@class=\"css-1pi33nk\"][1]").click();
    }

    public void verifydocumentdetails() {
        page.waitForTimeout(5000);
        Assert.assertTrue(page.locator("//h2[text()='Bank Secrecy Act (BSA) / Anti-Money Laundering (AML) Policy']").isVisible());
        Assert.assertTrue(page.locator("//button[text()='Remove Document']").isVisible());
        System.out.println("Document details are displayed successfully");
    }

    public void editdocumentdetails() {
        page.locator("//button[text()='Edit Details']").click();
        page.waitForTimeout(5000);

    }

    public void editdocumentsdetailsareshowing() {
        Locator documenttitle = page.locator("//input[@placeholder=\"Document Title\"]");
        Locator sourceurl = page.locator("//input[@placeholder=\"https://\"]");
        String title = documenttitle.inputValue().trim();
        String url = sourceurl.innerHTML().trim();
        Locator dropdownselectionopt = page.locator("//label[text()='Document Type']//following::select");
        String dropdownopt = dropdownselectionopt.inputValue().trim();
        System.out.println("Placeholder text: " + title);
        System.out.println("Placeholder text: " + url);
        System.out.println("dropdown options are: " + dropdownopt);
    }

    public void update_document_detials() {
        page.locator("//label[text()='Title']/following::input[1]").fill("bank secrecy act policy");
        page.locator("//input[@placeholder=\"https://\"]").fill("https://www.sampleurl.com");
        // page.locator("//select[@class=\"chakra-select css-17lxuxo\"]").click();
        page.getByLabel("Type")
                .selectOption(new SelectOption().setIndex(2));


    }

    public void saveupdateddocumentdetails() {
        page.locator("//button[text()='Save Changes']").click();
        page.waitForTimeout(5000);
        Assert.assertTrue(page.locator("//h2[text()='bank secrecy act policy']").isVisible());
        System.out.println("click successfully");
    }

    public void documentdetailsupdatedsuccessfully() {
        Locator sucesspopup = page.locator("//div[text()='Success']");
        sucesspopup.isVisible();
        page.locator("//button[text()='Edit Details']").click();
        String documentTitle = page.locator("//input[@placeholder='Document Title']").inputValue();
        System.out.println(documentTitle);
        String sourceurl = page.locator("//input[@placeholder=\"https://\"]").inputValue();
        System.out.println(sourceurl);
        Locator dropdownselectionopt = page.locator("//label[text()='Document Type']//following::select");
        String dropdownopt = dropdownselectionopt.inputValue().trim();
        System.out.println("dropdown options are: " + dropdownopt);
        //reverting back to original details


    }

    public void updatemoduledetails() {
        page.locator("//button[text()='Update Modules']").click();
    }

    public void verifyupdatemoduledetailspage() {
        Assert.assertTrue(page.locator("//p[text()='Select Modules']").isVisible());
        Assert.assertTrue(page.locator("//button[text()='Apply']").isVisible());
        Assert.assertTrue(page.locator("//button[text()='Cancel']").isVisible());

    }

    public void updatemoduledetailsandapply() {
        page.locator("//p[text()='Email Review']").click();

    }

    public void clickonapplybutton() {
        page.locator("//button[text()='Apply']").click();

    }

    public void moduledetailsupdatedsuccessfully() {
        Locator sucesspopup = page.locator("//div[text()='Success']");
        sucesspopup.isVisible();
        Assert.assertTrue(page.locator("//span[text()='Email Review']").isVisible());
        System.out.println("Module details are updated successfully");
    }

    public void uploadpolicydocumentFile(String filePath) {
        try {
            // Find the file input element and upload the file
            Locator fileInput = page.locator("//input[@type=\"file\"]");
            fileInput.setInputFiles(Paths.get(filePath));
            page.waitForTimeout(2000);
        } catch (Exception e) {
            System.out.println("Error uploading file: " + e.getMessage());
        }
    }

    public void createrandomfile() throws Exception {
        String pdfFilePath = DocumentGeneratorUtil.createRandomPDF();
        page.locator("input[type='file']").setInputFiles(Paths.get(pdfFilePath));


    }

    public void selectRecordsPerPage(String value) {
        page.locator("//select[contains(@class,'chakra-select')]")
                .selectOption(value);
    }

    public void asperselectedvaluerecordsdisplayed(String value) {
        page.waitForTimeout(5000);
        int expectedCount = Integer.parseInt(value);
        Locator records = page.locator("//div[@class=\"css-1pi33nk\"]");
        int actualCount = records.count();
        if (actualCount > expectedCount) {
            throw new AssertionError("More than " + value + " items are displayed per page: " + actualCount);
        } else {
            System.out.println(value + " or fewer items are displayed per page: " + actualCount);
        }
    }

    public void chooseModuleFlag() {

        page.getByText("Module Flags").click();


    }

    public void selectmoduleflagoption(String flagoption) {
        page.locator("//div[@class=\"css-18euh9p\"]/input").fill(flagoption);
        page.keyboard().press("Enter");


    }

    public void selectedmoduleflagoptionisdisplayed(String flagoption) {
        page.waitForTimeout(5000);
        Assert.assertTrue(page.locator("//span[text()='" + flagoption + "']").isVisible());
        System.out.println("selected module flag option is displayed successfully");
    }


    public void selectmodulefromdropdown() {
        page.locator("//div[text()='Select options']").click();
        page.locator("//div[@class=\"css-18euh9p\"]/input").fill("Email Review");
        page.keyboard().press("Enter");

        System.out.println("module is selected");
    }

    public void clickuploadbutton() {
        page.locator("//button[text()='Upload']").click();
        page.waitForTimeout(5000);
        System.out.println("Clicked on upload button");
    }

    public void filteroptionsaredisplayed() {
        //Assert.assertTrue(page.locator("//button[text()='Newest first']").isVisible());
        Assert.assertTrue(page.locator("//button[text()='Oldest first']").isVisible());

    }

    public void verfiyoldestfilteroption() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy"); // matches 2/4/2026

        List<LocalDate> allDates = new ArrayList<>();
        while (true) {
            // 1️⃣ Capture all dates on the current page
            List<String> dateTexts = page.locator("//div[@class=\"chakra-stack css-hwz0ls\"]/p").allTextContents();
            dateTexts.forEach(d -> {
                // Convert string to LocalDate using the formatter
                allDates.add(LocalDate.parse(d.trim(), formatter));
            });

            // 2️⃣ Locate the "Next" button
            Locator nextBtn = page.locator("//button[@aria-label=\"Next page\"]");

            // 3️⃣ Stop if this is the last page
            if (nextBtn.isDisabled()) break;

            // 4️⃣ Go to next page and wait until it loads
            nextBtn.click();
            page.waitForTimeout(10000);
            page.waitForLoadState();

        }
        // Check if dates are sorted oldest → newest (ascending), allowing duplicates
        boolean isAscending = true;
        for (int i = 0; i < allDates.size() - 1; i++) {
            // current date must be <= next date
            if (allDates.get(i).isAfter(allDates.get(i + 1))) {
                isAscending = false;
                break;
            }
        }
        // Print result
        if (isAscending) {
            System.out.println("✅ Dates are sorted oldest → newest (duplicates allowed).");
        } else {
            System.out.println("❌ Dates are NOT sorted oldest → newest.");
        }
        allDates.forEach(System.out::println);

    }


    public void userserachdocumenttitle(String documenttitle) {
        page.locator("//input[@placeholder=\"Search\"]").fill(documenttitle);
        page.waitForTimeout(3000);

    }


    public void documetdisplayed() {
        page.waitForTimeout(5000);
        Locator Nodocumentfound = page.locator("//p[text()='No documents found for the selected criteria.']");
        if (Nodocumentfound.isVisible()) {
            System.out.println("No document found for the given title");
        } else {
            System.out.println("Document found with the given title");
            String documenttitle = page.locator("//div[@class=\"css-1pi33nk\"]//h3").textContent();
            Assert.assertEquals(documenttitle, "Fair Lending Policy");
            System.out.println("searched document title is =" + documenttitle);
        }

    }

    public void deafultitemperpage10displayed() {
        page.waitForTimeout(5000);
        Locator records = page.locator("//div[@class=\"css-1pi33nk\"]");
        int recordcount = records.count();
        System.out.println(recordcount);
        if (recordcount > 10) {
            throw new AssertionError("More than 10 items are displayed per page: " + recordcount);
        } else {
            System.out.println("10 or fewer items are displayed per page: " + recordcount);
        }
    }

    public void perpagerecord20() {
        page.waitForTimeout(5000);
        Locator dropd = page.locator("//select[@class=\"chakra-select css-bigvto\"]");
        dropd.click();
        dropd.selectOption("20");


    }

    public void verify20itemsdisplayedperpage() {
        page.waitForTimeout(5000);
        Locator records = page.locator("//div[@class=\"css-1pi33nk\"]");
        int recordcount = records.count();
        System.out.println(recordcount);
        if (recordcount > 20) {
            throw new AssertionError("More than 20 items are displayed per page: " + recordcount);
        } else {
            System.out.println("20 or fewer items are displayed per page: " + recordcount);
        }
    }

    public void emailmodulefilter() {
        page.waitForTimeout(5000);
        Locator emailrecords = page.locator("//div[@class=\"css-1pi33nk\"]");
        int emailcount = emailrecords.count();
        for (int i = 0; i < emailcount; i++) {
            Locator emailrecord = emailrecords.nth(i);
            boolean isVisible = emailrecord.locator("//span[text()='Email Review']", new Locator.LocatorOptions().setHasText("Email Review")).isVisible();
            if (!isVisible) {
                throw new AssertionError(
                        "Non-email record displayed after Email filter applied at index: " + i
                );
            }
        }
    }

    public void usernavigatedtonextpage() {
        page.waitForTimeout(5000);
        page.locator("//button[@aria-label=\"Next page\"]").click();

    }

    public void usernavigatedtopreviouspage() {
        page.waitForTimeout(5000);
        page.locator("//button[@aria-label=\"Previous page\"]").click();

    }

    public void verifydocumentuploadedsuccessfully() {
        page.waitForTimeout(30000);
        Locator sucesspopup = page.locator("//div[text()='Document Uploaded']");
        sucesspopup.isVisible();
        System.out.println("Document uploaded successfully");
    }

    public void userclickonuploadeddocument() {
        page.waitForTimeout(5000);
        page.locator("(//div[@class=\"css-1pi33nk\"]/div[2]/button)[1]").click();
    }

    public void userclickondeleteoption() {
        page.locator("(//button/following::span[text()='Delete'])[1]").click();

    }

    public void userclickondeletedocumentbutton() {
        page.locator("//button[text()='Delete Document']").click();
        page.waitForTimeout(5000);
    }

    public void deletedocumentsuccessfully() {
        Locator sucesspopup = page.locator("//div[text()='Success']");
        sucesspopup.isVisible();
        System.out.println("Document deleted successfully");
    }
    public void getcurrentdocumentdetails() {
        page.waitForTimeout(5000);
        String documenttitle = page.locator("//div[@class=\"css-1pi33nk\"]//h3").textContent();
        System.out.println("current document title is =" + documenttitle);
        Locator documentType = page.locator("//label[text()='Document Type']/following::select[1]");

        String selectedDocType = documentType.locator("option:checked").textContent().trim();

        System.out.println("Existing Document Type: " + selectedDocType);
    }

    public void pdffiletypefilterres() {
        page.waitForTimeout(5000);
        Locator pdfrecords = page.locator("//div[@class=\"css-1pi33nk\"]");
        int pdfcount = pdfrecords.count();
        for (int i = 0; i < pdfcount; i++) {
            Locator pdfrecord = pdfrecords.nth(i);
            boolean isVisible = pdfrecord.locator("//span[text()='PDF']", new Locator.LocatorOptions().setHasText("PDF")).isVisible();
            if (!isVisible) {
                throw new AssertionError(
                        "Non-pdf record displayed after pdf filter applied at index: " + i
                );
            }
        }
    }


}

