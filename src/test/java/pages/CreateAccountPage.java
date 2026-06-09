package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CreateAccountPage {

    WebDriver driver;

    @FindBy(tagName = "a")
    List<WebElement> links;

    @FindBy(xpath = "//a[contains(text(),'terms and conditions')]")
    WebElement terms;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean validateTitle() {
        return driver.getTitle().equals("Rediffmail Free Unlimited Storage");
    }

    public List<WebElement> printLinks() {
        for (WebElement e : links) {
            System.out.println(e.getText()+" : "+e.getAttribute("href"));
        }
        return links;
        
    }

    public void clickTerms() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", terms);
    }
}