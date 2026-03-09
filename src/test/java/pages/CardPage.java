package pages;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$;

public class CardPage {

    private final ElementsCollection inventoryTitle = $$(By.xpath("//div[@class='inventory_item_name']"));


    public List<String> getItemTitles() {
        return inventoryTitle.stream()
                .map(e -> e.getText())
                .collect(Collectors.toList());
    }
}
