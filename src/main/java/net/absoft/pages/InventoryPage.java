package net.absoft.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BaseStorePage {

  @FindBy(css = ".product_sort_container")
  private WebElement filtersDropDownList;

  private final String itemXPath = "//div[@class='inventory_item'][.//div[@class='inventory_item_name' and text()='%s']]";

  public InventoryPage(WebDriver driver) {
    super(driver);
  }

  @Step("Adding item to cart")
  public InventoryPage addItemToCart(String itemName) {
    WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
    WebElement addToCartButton = item.findElement(
            By.xpath("//button[contains(@data-test, 'add-to-cart')]"));
    addToCartButton.click();
    return this;
  }

  @Step("Removing item from cart")
  public InventoryPage removeItemFromCart(String itemName) {
    WebElement item = driver.findElement(By.xpath(String.format(itemXPath, itemName)));
    WebElement removeFromCartButton = item.findElement(
            By.xpath("//button[contains(@data-test, 'remove')]"));
    removeFromCartButton.click();
    return this;
  }
}