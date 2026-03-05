package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class LoginPage {
    private final SelenideElement login = $(By.id("user-name"));
    private final SelenideElement password = $(By.id("password"));
    private final SelenideElement loginBtn = $(By.id("login-button"));


    public InventoryPage loginAs(String userName, String password) {
        login.shouldBe(visible);
        login.setValue(userName);
        this.password.setValue(password);
        loginBtn.click();
        return new InventoryPage();
    }
}
