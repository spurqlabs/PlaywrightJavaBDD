package utilities;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import core.TestContext;


public class WebUtil extends TestContext {
    public static WebDriver driver;

    public static Page initBrowser(){
      //Initializes a browser session using Playwright's Chromium browser
        Playwright playwright = Playwright.create();  //Creates an instance of Playwright
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage(); //Creates a new page/tab within the launched browser
        return page;
    }

    public static void tearDownPW() {
        page.close();
    }   // It is called to close the current page/tag

}
