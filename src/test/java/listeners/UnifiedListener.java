package listeners;

import base.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.*;

import utils.PDFReportUtility;
import utils.ScreenshotUtil;

public class UnifiedListener implements ITestListener, WebDriverListener {

    // START PDF

    public void onStart(ITestContext context) {
        PDFReportUtility.startReport();
    }

    //  PASS

    public void onTestSuccess(ITestResult result) {
        ScreenshotUtil.capture(TestBase.driver, result.getName() + "_PASS");
        PDFReportUtility.addStep(result.getName(), "PASS");
    }

    //  FAIL

    public void onTestFailure(ITestResult result) {
        ScreenshotUtil.capture(TestBase.driver, result.getName() + "_FAIL");
        PDFReportUtility.addStep(result.getName(), "FAIL");
    }

    //  END PDF

    public void onFinish(ITestContext context) {
        PDFReportUtility.endReport();
    }

    //  CLICK

    public void afterClick(WebElement element) {
        ScreenshotUtil.capture(((WrapsDriver) element).getWrappedDriver(), "CLICK");
    }

    // NAVIGATION

    public void afterGet(WebDriver driver, String url) {
        ScreenshotUtil.capture(driver, "NAVIGATE");
    }

    //  ELEMENT FIND

    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        ScreenshotUtil.capture(driver, "FIND_ELEMENT");
    }
}
