package com.saleor.page.book;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BookPage {
    protected WebDriver driver = null;

    @FindBy(xpath = "//*[contains(concat(' ',@class, ' '), ' product-filters__attributes ')]")
    WebElement attributeFilter;

    @FindBy(xpath = "//*[contains(concat(' ',@class, ' '), ' product-filters__price-range ')]")
    WebElement priceFilter;

    @FindBy(xpath = "//button[normalize-space(.)='Update']")
    WebElement btn_Update;

    @FindBy(xpath = "//*[@itemprop='price']")
    List<WebElement> item_prices;

    public BookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementIsLoaded(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilFilterIsCompleted(int from, int to) {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.urlMatches(String.format(".*maxPrice=%1$s&minPrice=%2$s.*", Integer.toString(to), Integer.toString(from))));
    }

    public void filterPrice(int from, int to) {
        waitForElementIsLoaded(priceFilter);
        WebElement fromField = priceFilter.findElement(By.xpath(".//*[@placeholder = 'from']"));
        fromField.sendKeys(Integer.toString(from));
        WebElement toField = priceFilter.findElement(By.xpath(".//*[@placeholder = 'to']"));
        toField.sendKeys(Integer.toString(to));
        btn_Update.click();
        waitUntilFilterIsCompleted(from, to);
    }

    public List<String> getPricesOfItemsInCurrentPage() {
        List<String> prices = new ArrayList<String>();
        for (int i = 0; i < item_prices.size(); i++) {
            String tmp = item_prices.get(i).getText().trim();
            tmp = tmp.substring(tmp.indexOf('$') + 1);
            prices.add(tmp);
        }
        return prices;
    }
}
