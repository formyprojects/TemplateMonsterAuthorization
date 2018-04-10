package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Женя on 09.04.2018.
 */
public class DashboardPage {

    private WebDriver driver;
    private By userIcon = By.id("app-account-menu");
    private By exitBtn = By.className("app-sign-out-btn__inner");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickOnUserIcon(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userIcon));

        driver.findElement(userIcon).click();
    }

    public void clickOnExitBtn(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(exitBtn));


        driver.findElement(exitBtn).click();
    }

}
