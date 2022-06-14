package cn.ianzhang.automation;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/main/resources/lemon.feature", glue = "cn.ianzhang.automation.steps", monochrome = true)
public class CucumberRunner extends AbstractTestNGCucumberTests {

}
