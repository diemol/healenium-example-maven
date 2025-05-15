package com.epam.healenium.settings.drivers;

import com.epam.healenium.settings.IDriverInterface;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class ProxyDriver implements IDriverInterface {

  private final String proxyUrl;

    public ProxyDriver(String url) {
        this.proxyUrl = url;
    }

    @Override
    public WebDriver setDriver(Object options) throws MalformedURLException {
      return new RemoteWebDriver(new URL(proxyUrl), (Capabilities) options);
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
    public Object useSafari() {
      return new SafariOptions();
    }

    @Override
    public Object useEdge() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        return options;
    }
}
