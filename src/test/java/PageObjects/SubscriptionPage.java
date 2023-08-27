package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static PageObjects.LandingPage.getShadowDom;

public class SubscriptionPage {
    private WebDriver driver;

    public SubscriptionPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isBecomeMemberTextVisible() {
        return driver.findElement(By.xpath("//h1[contains(text(), 'Become a Member!')]")).isDisplayed();
    }

    public void inputEmailAddressAndSubmit() {
        Properties config = new Properties();
        try {
            FileInputStream configFile = new FileInputStream("config.properties");
            config.load(configFile);
            configFile.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        String email = config.getProperty("email");

        WebElement root = driver.findElement(By.tagName("route-view"));
        WebElement shadowDom1 = getShadowDom(root, driver);
        WebElement prospectRegisterPage = shadowDom1.findElement(By.tagName("prospect-register-page"));
        WebElement shadowDom2 = getShadowDom(prospectRegisterPage, driver);
        WebElement emailAddressField = shadowDom2.findElement(By.cssSelector("#email"));
        emailAddressField.sendKeys(email);

        WebElement submitButton = shadowDom2.findElement(By.cssSelector("#submit-button"));
        submitButton.click();
    }
}

