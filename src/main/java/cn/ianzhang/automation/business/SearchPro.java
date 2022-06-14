package cn.ianzhang.automation.business;

import cn.ianzhang.automation.base.DriverBase;
import cn.ianzhang.automation.handle.SearchPageHandle;

public class SearchPro {
    public SearchPageHandle sph;
    public DriverBase driver;
    public SearchPro(DriverBase driver){
        this.driver = driver;
        sph = new SearchPageHandle(driver);
    }
    public void search(String searchContent){
        if(sph.assertLoginPage()){
            sph.switchToFrame();
            sph.sendKeysSearchContent(searchContent);
            sph.clickSearchButton();
            sph.clickPageSwitchButton();
        }else{
            System.out.println("页面不存在或者状态不正确。");
        }
    }
}
