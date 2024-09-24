package pages;

import core.TestContext;
import utilities.ConfigUtil;

import java.io.IOException;

public class CalculatorPage extends TestContext {
    public void iAmOnCalculatorPage() throws IOException {
        page.navigate(ConfigUtil.getPropertyValue("base_url"));
    }

    public void iEnterNumber(int number) {
        page.locator("//span[@onclick='r(" + number + ")']").click();
    }

    public void iClickOnOperator(String operator) {
        page.locator("//span[@onclick=\"r('" + operator + "')\"]").click();
    }

    public String iVerifyTheResultAs() {
        page.locator("//span[@onclick=\"r('=')\"]").click();
        return page.locator("//div[@id='sciOutPut']").innerText().trim();
    }


}
