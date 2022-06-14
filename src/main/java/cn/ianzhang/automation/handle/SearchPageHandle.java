package cn.ianzhang.automation.handle;

import cn.ianzhang.automation.base.DriverBase;
import cn.ianzhang.automation.page.SearchPage;

public class SearchPageHandle {
    public DriverBase driver;
    public SearchPage sp;
    public SearchPageHandle(DriverBase driver){
        this.driver = driver;
        sp = new SearchPage(driver);
    }

    /**
     * 输入搜索内容
     * */
    public void sendKeysSearchContent(String searchContent){
        sp.sendkeys(sp.getInputElement(), searchContent);
    }

    /**
     * 点击搜索
     * */
    public void clickSearchButton(){
        sp.click(sp.getSearchButtonElement());
    }

    /**
     * 点击分页切换按钮
     * */
    public void clickPageSwitchButton(){
        sp.click(sp.getPageSwitchButtonElement());
    }

    /**
     * 切换frame
     * */
    public void switchToFrame(){
        this.driver.switchFrame(sp.getFrameElement());
    }

    /**
     * 判断是否搜索页面
     * */
    public boolean assertLoginPage(){
        return sp.assertElementIs(sp.getSearchButtonElement());
    }
}
