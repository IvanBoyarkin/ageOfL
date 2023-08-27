package BrowserFactory;

import Enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class BrowserFactory {
    public WebDriver createWebDriver(BrowserType browser) throws NoSuchMethodException {
        switch (browser){
            case CHROME:
                return GetChromeDriver();
            case FIREFOX:
                return GetFirefoxDriver();
            default:
                throw new NoSuchMethodException();
        }
    }

    private WebDriver GetFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--width=1920");
        options.addArguments("--height=1080");
        options.addArguments("--headless");
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
        return new FirefoxDriver(options);
    }

    private WebDriver GetChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1400,1200");
        //options.addArguments("--headless");
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        return new ChromeDriver(options);
    }
}
