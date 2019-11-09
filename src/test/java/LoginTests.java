import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {


    @Test
    public static void LoginEmptyEmailPasswordTest () {

        WebDriver driver = new ChromeDriver();
        driver.get("https://deens-master.now.sh/login");

        WebElement login_button = driver.findElement(By.cssSelector("[data-testid=\"loginSubmit\"]"));
        login_button.click();

        WebElement uiErrorMessage = driver.findElement(By.cssSelector(".ui.error.message p"));

        String errorMessagetext = uiErrorMessage.getText();

        Assert.assertEquals(errorMessagetext, "Empty email or password");

        driver.quit();


    }

    @Test
    public static void IncorrectEmailAndPasswordTest () {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://deens-master.now.sh/login");

        WebElement emailField = driver.findElement(By.cssSelector("#email"));
        emailField.sendKeys("incorrect@email.com");

        WebElement passwordlField = driver.findElement(By.cssSelector("#password"));
        passwordlField.sendKeys("incorrectPassword");

        WebElement login_button = driver.findElement(By.cssSelector("[data-testid=\"loginSubmit\"]"));
        login_button.click();

        WebElement uiErrorMessage = driver.findElement(By.cssSelector(".ui.error.message p"));
        String errorMessagetext = uiErrorMessage.getText();

        Assert.assertEquals(errorMessagetext, "Wrong email or password.");

        driver.quit();


    }


}
