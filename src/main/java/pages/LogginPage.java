package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by Женя on 09.04.2018.
 */
public class LogginPage {

    private EventFiringWebDriver driver;

    private By emailInput = By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/div/form/div/div[4]/div/input");
    private By passInput = By.xpath("//*[@id=\"app\"]/div/div/div/div/div[1]/div/form/div/div[6]/div/input");
    private By loginBtn = By.xpath("//*[@id=\"id-index-continue-button\"]/button");
    private By passBtn = By.id("id-password-login-button");
    private String email = "yevheniia.shostak@gmail.com";
    private String password = "123456";

    public LogginPage(EventFiringWebDriver driver){
        this.driver = driver;
    }
    public void open(){
        driver.get("https://account.templatemonster.com/auth/");//(Properties.getBaseAdminUrl());

    }
    public void fillEmailInput(){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickLoginBtn(){
        driver.findElement(loginBtn).click();
    }

    public void fillPassInput(){
        driver.findElement(passInput).sendKeys(password);
    }


    public void clickPassBtn(){
        driver.findElement(passBtn).click();
    }
}
