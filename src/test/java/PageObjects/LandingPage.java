package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    private WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToHomePage(String url) {
        driver.get(url);
    }

    public void clickSignUpButton() {
        WebElement root = driver.findElement(By.tagName("route-view"));
        WebElement shadowDom1 = getShadowDom(root, driver);
        WebElement homeElement = shadowDom1.findElement(By.tagName("home-element"));
        WebElement shadowDom2 = getShadowDom(homeElement, driver);
        WebElement signupButton = shadowDom2.findElement(By.tagName("signup-button"));
        signupButton.click();
    }

    static WebElement getShadowDom (WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        WebElement shadowDom1 = (WebElement) js.executeScript("return arguments[0].shadowRoot", element);
        return shadowDom1;
    }

}
