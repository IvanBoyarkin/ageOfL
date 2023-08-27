package Tests;

import PageObjects.LandingPage;
import PageObjects.SubscriptionPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.IOException;

public class SignUpTest extends BaseTestCase {
    @Test
    public void signUpTest() {
        Properties config = new Properties();
        try {
            FileInputStream configFile = new FileInputStream("config.properties");
            config.load(configFile);
            configFile.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        String url = config.getProperty("url");

        LandingPage landingPage = new LandingPage(driver);
        SubscriptionPage subscriptionPage = new SubscriptionPage(driver);

        landingPage.goToHomePage("https://www.abcmouse.com");
        landingPage.clickSignUpButton();

        Assert.assertEquals(driver.getCurrentUrl(), url + "/abc/prospect-register/");
        Assert.assertTrue(subscriptionPage.isBecomeMemberTextVisible());

        subscriptionPage.inputEmailAddressAndSubmit();

        Assert.assertEquals(driver.getCurrentUrl(), url + "/abc/subscription/");

    }
}


