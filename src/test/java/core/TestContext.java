package core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import org.openqa.selenium.WebDriver;
import pages.CalculatorPage;


public class TestContext {  //TestContext class, which acts as a container to store all instances for test framework


    public static Page page;
    //Refers to Playwright’s Page object. This controls a specific browser tab or page in a Playwright-based test

    public static CalculatorPage calculatorPage;
    //This stores an instance of the CalculatorPage object, representing the page object model (POM)

    public static Browser browser;
    //refers to Playwright's Browser instance, which represents the entire browser

}
