import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;

@Test
public class TestSelenide {
    public void test() {
        open("https://google.com");
        System.out.println();
    }
}
