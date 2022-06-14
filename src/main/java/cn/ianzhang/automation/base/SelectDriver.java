package cn.ianzhang.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
    public WebDriver driverName(String browser){
        if(browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
            return new ChromeDriver();
        }else {
            System.setProperty("webdriver.firefox.marionette", "driver/msedgedriver.exe");
            return new FirefoxDriver();
        }
    }
}
