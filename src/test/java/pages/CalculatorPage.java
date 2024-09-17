package pages;

import core.TestContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ConfigUtil;

import java.io.IOException;

public class CalculatorPage extends TestContext {
    public void iAmOnCalculatorPage() throws IOException {
        page.navigate(ConfigUtil.getPropertyValue("base_url"));
    }

    public void iEnterNumber(int number) {
//        driver.findElement(By.xpath("//span[@onclick='r(" + number + ")']")).click();
        page.locator("//span[@onclick='r(" + number + ")']").click();

    }

    public void iClickOnOperator(String operator) {
//        driver.findElement(By.xpath("//span[@onclick=\"r('" + operator + "')\"]")).click();
        page.locator("//span[@onclick=\"r('" + operator + "')\"]").click();
    }

    public String iVerifyTheResultAs() {
//        driver.findElement(By.xpath("//span[@onclick=\"r('=')\"]")).click();
        page.locator("//span[@onclick=\"r('=')\"]").click();
//        return driver.findElement(By.xpath("//div[@id='sciOutPut']")).getText().trim();
        return page.locator("//div[@id='sciOutPut']").innerText().trim();
    }

    public void tearDown() {
        driver.quit();
    }
}
