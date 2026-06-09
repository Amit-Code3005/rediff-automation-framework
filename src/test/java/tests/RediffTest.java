package tests;

import base.TestBase;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.*;
import utils.WriteLinksToExcel;

@Listeners(listeners.UnifiedListener.class)
public class RediffTest extends TestBase {

    @Test(priority = 1)
    public void createAccountTest() {

        HomePage home = new HomePage(driver);
        home.clickCreate();

    }

    @Test(priority = 2, dependsOnMethods = "createAccountTest")
    public void termsWindowTest() throws Exception {
    	
        CreateAccountPage page = new CreateAccountPage(driver);

        Assert.assertTrue(page.validateTitle());

        List<WebElement> links  = page.printLinks();
        WriteLinksToExcel.writeLink(links);
        
        page.clickTerms();
        
        

        String parent = driver.getWindowHandle();

        for (String w : driver.getWindowHandles()) {
            if (!w.equals(parent)) {
                driver.switchTo().window(w);
                Assert.assertEquals(driver.getTitle(), "Terms and Conditions");
                driver.close();
            }
        }

        driver.switchTo().window(parent);
    }
}