package core;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import pages.*;


public class TestContext {  //TestContext class, which acts as a container to store all instances for test framework


    public static Page page;//Refers to Playwright’s Page object. This controls a specific browser tab or page in a Playwright-based test
    public static CalculatorPage calculatorPage;
    //This stores an instance of the CalculatorPage object, representing the page object model (POM)
    public static NucomplyLoginPage nucomplyloginpage;
    public static NucomplySignupPage nucomplysignuppage;

    public static NucomplyUserMangementPage nucomplyUserMangementPage;
    public static NucomplyAskPage nucomplyAskPage;
    public static NucomplyPolicySolutionPage nucomplyPolicySolutionPage;
    public static NucomplyProcedurePage nucomplyProcedurePage;
    public static NucomplyEmailPage nucomplyEmailPage;
    public static NucomplyMarketingPage nucomplyMarketingPage;
    public static NucomplyRegulatoryChangePage nucomplyRegulatoryChangePage;
    public static NucomplyPolicyGeneratorPage nucomplyPolicyGeneratorPage;
    public static NucomplyDocumentMGTPage nucomplyDocumentMGTPage;
    public static Browser browser;
    //refers to Playwright's Browser instance, which represents the entire browser

}
