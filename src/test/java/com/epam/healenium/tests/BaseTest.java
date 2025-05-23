package com.epam.healenium.tests;

import com.epam.healenium.FrameworkPage;
import com.epam.healenium.constants.BrowserType;
import com.epam.healenium.constants.DriverType;
import com.epam.healenium.constants.FrameworkType;
import com.epam.healenium.constants.PagesType;
import com.epam.healenium.settings.DriverContext;
import com.epam.healenium.settings.FrameworkContext;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.util.HashMap;

public class BaseTest {
    static protected WebDriver driver;
    static protected HashMap<PagesType, FrameworkPage> pages;

    @BeforeAll
    static public void setUp() throws MalformedURLException {
        driver = new DriverContext(DriverType.REMOTE).getDriver(BrowserType.CHROME);

        driver.manage().window().setSize(new Dimension(1200, 800));

        pages = new FrameworkContext(FrameworkType.SELENIUM, driver).setFramework();
    }

    @AfterAll
    static public void afterAll() {
        if (driver != null) {
            driver.quit();
        }
    }
}
