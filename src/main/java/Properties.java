import org.openqa.selenium.remote.BrowserType;

/**
 * Created by Женя on 09.04.2018.
 */
public class Properties {

    public static final String DEFAULT_BASE_ADMIN_URL = "https://account.templatemonster.com/auth/";
    public static final String DEFAULT_BROWSER = BrowserType.CHROME;

    public static String getBaseAdminUrl(){
        return System.getProperty(EnvironmentVariables.BASE_ADMIN_URL.toString(), DEFAULT_BASE_ADMIN_URL);
    }

    public static String getBrowser(){
        return System.getProperty(EnvironmentVariables.BROWSER.toString(), DEFAULT_BROWSER);
    }
}

enum EnvironmentVariables {
    BASE_ADMIN_URL("env.admin.url"),
    BROWSER("browser");

    private String value;

    EnvironmentVariables(String value) { this.value = value;}

    @Override
    public String toString() { return value;}
}
