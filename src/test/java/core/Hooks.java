package core;

import core.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.WebUtil;

public class Hooks extends TestContext {//Hooks class inherits the property of TestContext class


    @Before  //@Before Tag denotes that it should be executed before scenario
    public void beforeScenario(Scenario scenario) {
        page = WebUtil.initBrowser();  //this method initializes the browser session
    }

    @After  //@After Tag denotes that it should be executed after scenario
    public void afterScenario() {
        WebUtil.tearDownPW();//this method is for tasks such as closing browser sessions
    }
}
