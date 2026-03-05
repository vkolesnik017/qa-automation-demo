package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

public class BaseTest {
    @BeforeMethod
    public void setup() {
        Configuration.browser = "chrome";
        Configuration.headless = false;
        Configuration.timeout = 10_000;
        Configuration.browserSize = "1920x1080";
    }

    protected void navigate(String url) {
        open(url);
    }

    @AfterMethod()
    public void tearDown() {
        closeWebDriver();
    }
}
