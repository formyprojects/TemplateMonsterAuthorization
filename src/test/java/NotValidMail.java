import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by Женя on 10.04.2018.
 */
public class NotValidMail {

    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://account.templatemonster.com/auth/#/");
        //baseUrl = "https://account.templatemonster.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testValidMailPass() throws Exception {

        By emailInput = By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/div/form/div/div[4]/div/input");
        By passInput = By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/div/form/div/div[6]/div/input");
        By loginBtn = By.xpath("//*[@id=\"id-index-continue-button\"]/button");
        By passBtn = By.id("id-password-login-button");
        //driver.get(baseUrl + "/auth/#/");
        //1st test
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys("111");
        driver.findElement(loginBtn).click();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification__text")));
        String wrongmail = driver.findElement(By.className("notification__text")).getText();
        assertEquals(wrongmail, "Please specify a valid email", "wrong mail");
        // end 1st test

        // 2 test
        driver.findElement(emailInput).clear();
        driver.findElement(emailInput).sendKeys("123@mailru");
        driver.findElement(loginBtn).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("notification__text")));
        String wrongmail2 = driver.findElement(By.className("notification__text")).getText();
        assertEquals(wrongmail2, "Please specify a valid email", "wrong mail");

        //end 2 test


        //driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/div/form/div/div[6]/div/input")).sendKeys("12345");

        //driver.findElement(By.id("id-password-login-button")).click();
        //WebDriverWait wait = new WebDriverWait(driver, 30);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id-forgot-password-link-notification")));
        //driver.findElement(By.id("app-account-menu")).click();

        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("app-sign-out-btn__inner")));
        //driver.findElement(By.className("app-sign-out-btn__inner")).click();

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //Thread.sleep(2000);
        //String n = driver.findElement(By.id("id-forgot-password-link-notification")).getText();
        //assertEquals(n, "recover your password", "wrong password");
        //assertEquals(driver.getCurrentUrl(), "https://account.templatemonster.com/auth/?lang=en#/", "wait page PLEASE SIGN UP OR SIGN IN");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.close();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
