package cn.ianzhang.automation.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSteps {
    static ChromeDriver driver= null;
    static {
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Given("打开")
    public void open() {
        driver.get("http://www.baidu.com");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @When("输入 {string}")
    public void input(String query) {
        WebElement element = driver.findElement(By.name("wd"));
        element.sendKeys(query);
        element.submit();
    }
    @Then("显示连世玉")
    public void show() {

    }
}
