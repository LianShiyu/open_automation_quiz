package cn.ianzhang.automation.base;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class DriverBase {
    public WebDriver driver;
    public DriverBase(String browser){
        SelectDriver selectDriver =new SelectDriver();
        this.driver = selectDriver.driverName(browser);
    }
    /**
     * 获取driver
     * */
    public WebDriver getDriver() {
        return driver;
    }

    public void stop(){
        System.out.println("stop webdriver");
        driver.close();
    }

    /**
     * 封装Element方法
     * */
    public WebElement findElement(By by){
        WebElement element = driver.findElement(by);
        return element;
    }
    /**
     * 封装定位一组elements的方法
     * */
    public List<WebElement> findElements(By by){
        return driver.findElements(by);
    }

    /**
     * 自动截图
     * */
    public void takeScreenShot() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        String dateStr = sf.format(date);
        String path = this.getClass().getSimpleName() + "_" + dateStr + ".png";
        takeScreenShot((TakesScreenshot) this.getDriver(), path);
        //takeScreenShot((TakesScreenshot) driver, path);
    }

    /**
     * 传入参数截图
     * */
    public void takeScreenShot(TakesScreenshot drivername, String path) {
        String currentPath = System.getProperty("user.dir"); // get current work
        File scrFile = drivername.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(currentPath + "\\" + path));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("截图成功");
        }
    }
    /**
     * get封装
     * */

    public void get(String url){
        driver.get(url);
    }

    /*
     * 返回
     * **/
    public void back(){
        driver.navigate().back();
    }

    /**
     * 点击
     * */
    public void click(WebElement element){
        element.click();
    }
    /**
     * 获取当前url
     * */
    public String getUrl(){
        return driver.getCurrentUrl();
    }
    /**
     * 获取title
     * */
    public String getTitle(){
        return driver.getTitle();
    }
    /**
     * 关闭浏览器
     * */
    public void close(){
        driver.close();
    }
    /**
     * 获取当前系统窗口list
     * */
    public List<String> getWindowsHandles(){
        Set<String> winHandels = driver.getWindowHandles();
        List<String> handles = new ArrayList<String>(winHandels);
        return handles;
    }

    /*
     * 获取当前窗口
     * **/
    public String getWindowHandle(){
        return driver.getWindowHandle();
    }

    /**
     * 切换windows窗口
     * */
    public void switchWindows(String name){
        driver.switchTo().window(name);
    }

    /**
     * 切换iframe窗口
     * */
    public void switchFrame(WebElement element){
        driver.switchTo().frame(element);
    }

    /**
     * 切换alert窗口
     * */
    public void switchAlert(){
        driver.switchTo().alert();
    }
    /**
     * 模态框切换
     * */
    public void switchToMode(){
        driver.switchTo().activeElement();
    }
    /**
     * actionMoveElement
     * */
    public void action(WebElement element){
        Actions action =new Actions(driver);
        action.moveToElement(element).perform();
    }

    /**
     * 获取cookcie
     * @return
     * */
    public Set<Cookie> getCookie(){
        Set<Cookie> cookies = driver.manage().getCookies();
        return cookies;
    }

    /**
     * 删除cookie
     * */
    public void deleteCookie(){
        driver.manage().deleteAllCookies();
    }
    /**
     * 设置cookie
     * */
    public void setCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }
}
