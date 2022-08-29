package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {

    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp()
    {
        openBrowser(baseurl);

    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials()
    {
        //* Enter “tomsmith” username
        sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith");

        //* Enter “SuperSecretPassword!” password
        sendTextToElement(By.xpath("//input[@id='password']"),"SuperSecretPassword!");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        //* Verify the text “Secure Area”
        String actualText=getTextFromElement(By.xpath("//div[@class='example']"));
        String expectedText = "Secure Area\n" +
                "Welcome to the Secure Area. When you are done click logout below.\n" +
                "Logout";
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyTheUsernameErrorMessage()
    {
        //* Enter “tomsmith1” username
        sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith1");

        //* Enter “SuperSecretPassword!” password
        sendTextToElement(By.xpath("//input[@id='password']"),"SuperSecretPassword!");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        //* Verify the error message “Your username is invalid!”
        String actualText = getTextFromElement(By.xpath("//div[@id='flash']"));
        String expectedText = "Your username is invalid!\n" +
                "×";
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyThePasswordErrorMessage()
    {
        //* Enter “tomsmith” username
        sendTextToElement(By.xpath("//input[@id='username']"),"tomsmith");

        //* Enter “SuperSecretPassword” password
        sendTextToElement(By.xpath("//input[@id='password']"),"SuperSecretPassword");

        //* Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));

        //* Verify the error message “Your password is invalid!”
        String actualText = getTextFromElement(By.xpath("//div[@id='flash']"));
        String expectedText = "Your password is invalid!\n" +
                "×";
        Assert.assertEquals(expectedText,actualText);

    }


    @After
    public void tearDown()
    {
        //closeBrowser();

    }

}
