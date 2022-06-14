package cn.ianzhang.automation.page;

import cn.ianzhang.automation.base.DriverBase;
import org.openqa.selenium.WebElement;
import cn.ianzhang.automation.util.GetByLocator;
public class SearchPage extends BasePage{

    public SearchPage(DriverBase driver){
        super(driver);
    }

    /**
     * 获取搜索输入框
     * */
    public WebElement getInputElement(){
        return element(GetByLocator.getLocator("searchContent"));
    }

    /**
     * 获取搜索网页按钮
     * */
    public WebElement getSearchButtonElement(){
        return element(GetByLocator.getLocator("searchButton"));
    }

    /**
     * 获取切换分页按钮
     * */
    public WebElement getPageSwitchButtonElement(){
        return element(GetByLocator.getLocator("pageSwitchButton"));
    }

    /**
     * 获取iframe名字
     * */
    public WebElement getFrameElement(){
        return element(GetByLocator.getLocator("frame"));
    }
}
