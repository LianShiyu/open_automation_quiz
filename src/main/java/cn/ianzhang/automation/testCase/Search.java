package cn.ianzhang.automation.testCase;

import cn.ianzhang.automation.base.DriverBase;
import cn.ianzhang.automation.business.SearchPro;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Search extends CaseBase{
    public DriverBase driver;
    public SearchPro searchPro;

    @BeforeClass
    public void init(){
        this.driver = InitDriver("chrome");
        driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        searchPro = new SearchPro(driver);
    }

    @Test
    @Parameters({"连世玉", "Selenium"})
    public void testSearch(String contentFirst, String contentSecond){
        searchPro.search(contentFirst);
        this.driver.back();
        searchPro.search(contentSecond);
    }

    @AfterClass
    public void closed(){
        driver.close();
    }
}
