import org.openqa.selenium.support.events.EventFiringWebDriver;
import pages.DashboardPage;
import pages.LogginPage;

/**
 * Created by Женя on 09.04.2018.
 */
public class TestAuthorization1 extends BaseTest{

    public static void main(String[] args) throws InterruptedException{

        EventFiringWebDriver driver = getConfiguredDriver();
        LogginPage logginPage = new LogginPage(driver);

        logginPage.open();
        logginPage.fillEmailInput();
        logginPage.clickLoginBtn();
        logginPage.fillPassInput();
        logginPage.clickPassBtn();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickOnUserIcon();
        dashboardPage.clickOnExitBtn();

        quiteDriver(driver);
    }
}
