package com.saleor.test.book;

import com.TAF.driver.DriverFactory;
import com.TAF.driver.DriverType;
import com.saleor.page.book.BookPageValidation;
import com.saleor.properties.URLs;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Filter {
    WebDriver driver = null;

    @Before
    public void setUp() throws Exception {
        driver = DriverFactory.getDriver(DriverType.CHROME);
    }

    @After
    public void tearDown() throws Exception {
        DriverFactory.terminateDriver();
    }

    @Test
    public void filter() {
        driver.get(URLs.bookURL);
        BookPageValidation book = new BookPageValidation(driver);
        book.filterPrice(18, 20);
        book.validatePriceOfResultIsInRange(18,20);
    }
}
