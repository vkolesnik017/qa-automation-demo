package pages;
// test git change
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.opentelemetry.semconv.SemanticAttributes;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static java.lang.Double.*;
import static java.lang.Double.parseDouble;

public class InventoryPage {

    private final SelenideElement sortContainer = $(By.xpath("//select[@class='product_sort_container']"));
    private final ElementsCollection inventoryTitle = $$(By.xpath("//div[@class='inventory_item_name ']"));
    private final ElementsCollection inventoryPrice = $$(By.xpath("//div[@class='inventory_item_price']"));

    private SelenideElement itemTitle(String title) {
        return $(By.xpath(String.format("//div[text()='%s']/..", title)));
    }

    public InventoryPage selectSort(String option) {
        sortContainer.shouldBe(visible);
        sortContainer.selectOption(option);
        return this;
    }

    public List<Double> getPriceList() {
        List<Double> list = inventoryPrice.stream()
                .map(e -> parseDouble(e.getText().replace("$", "")))
                .collect(Collectors.toList());
        return list;
    }

    public List<Double> sortList(List<Double> list) {
        List<Double> newList = new ArrayList<>(list);
        Collections.sort(newList);
        return newList;
    }

    public List<String> hasItemWithNameContains(String text) {
        List<String> list = inventoryTitle.stream()
                .map(title -> title.getText())
                .filter(name -> name.toLowerCase().contains(text.toLowerCase()))
                .collect(Collectors.toList());
        return list;
    }

    public Double findFirstItemMoreExpensiveThan(double prc) {
        Double price = inventoryPrice.stream()
                .map(e -> parseDouble(e.getText().replace("$", "")))
                .filter(n -> n > prc)
                .findFirst()
                .orElseThrow();
        return price;
    }

    public String findFirstItemContaining(String text) {
        String expectedValue = inventoryTitle.stream()
                .map(e -> e.getText())
                .filter(name -> name.toLowerCase().contains(text.toLowerCase()))
                .findFirst()
                .orElseThrow();
        return expectedValue;
    }

    public CardPage addItemToBasket(String text) {
        String itemTitle = inventoryTitle.stream()
                .map(title -> title.getText())
                .filter(e -> e.toLowerCase().contains(text.toLowerCase()))
                .findFirst()
                .orElseThrow();
        clickOnTitle(itemTitle);
        return new CardPage();
    }

    public void clickOnTitle(String text) {
        itemTitle(text).click();
    }

}
