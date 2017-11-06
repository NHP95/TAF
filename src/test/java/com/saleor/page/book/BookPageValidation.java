package com.saleor.page.book;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class BookPageValidation extends BookPage{

    public BookPageValidation(WebDriver driver) {
        super(driver);
    }

    public void validatePriceOfResultIsInRange(int from, int to) {
        List<String> prices = getPricesOfItemsInCurrentPage();
        for (int i = 0; i < prices.size(); i++) {
            boolean tmp = Double.parseDouble(prices.get(i)) <= to && Double.parseDouble(prices.get(i)) >= from;
            Assert.assertTrue(tmp);
        }
    }
}
