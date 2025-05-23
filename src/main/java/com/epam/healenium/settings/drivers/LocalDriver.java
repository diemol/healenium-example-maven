package com.epam.healenium.settings.drivers;

import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.settings.IDriverInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class LocalDriver implements IDriverInterface {
    private SelfHealingDriver driver;

    @Override
    public WebDriver setDriver(Object delegate) {
        driver = SelfHealingDriver.create((WebDriver) delegate);

        return driver;
    }

    @Override
    public Object useChrome() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--user-data-dir=/tmp/unique-chrome-profile-" + System.currentTimeMillis());
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        WebDriver delegate = new ChromeDriver(options);
        return delegate;
    }

    @Override
    public Object useFirefox() {
        FirefoxOptions options = new FirefoxOptions();

        WebDriver delegate = new FirefoxDriver(options);
        return delegate;
    }

    @Override
    public Object useEdge() {
        EdgeOptions options = new EdgeOptions();

        WebDriver delegate = new EdgeDriver(options);
        return delegate;
    }

    @Override
    public Object useSafari() {
        SafariOptions options = new SafariOptions();

        WebDriver delegate = new SafariDriver(options);
        return delegate;
    }
}
