package com.epam.healenium.settings.drivers;

import com.epam.healenium.SelfHealingDriver;
import com.epam.healenium.settings.IDriverInterface;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URI;

public class RemoteDriver implements IDriverInterface {

  private final String remoteWebDriverUrl;

    public RemoteDriver(String remoteWebDriverUrl) {
        this.remoteWebDriverUrl = remoteWebDriverUrl;
    }

    @Override
    public WebDriver setDriver(Object capabilities) throws MalformedURLException {
        RemoteWebDriver delegate = new RemoteWebDriver(URI.create(remoteWebDriverUrl).toURL(),
                (Capabilities) capabilities);
      return SelfHealingDriver.create(delegate);
    }

    @Override
    public Object useChrome() {
        return new ChromeOptions();
    }

    @Override
    public Object useFirefox() {
        return new FirefoxOptions();
    }

    @Override
    public Object useEdge() {
        return new EdgeOptions();
    }

    @Override
    public Object useSafari() {
        return new SafariOptions();
    }
}
