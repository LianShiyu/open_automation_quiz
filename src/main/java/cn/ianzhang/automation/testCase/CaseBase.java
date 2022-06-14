package cn.ianzhang.automation.testCase;

import cn.ianzhang.automation.base.DriverBase;

public class CaseBase {
    public DriverBase InitDriver(String browser){
        return new DriverBase(browser);
    }
}
