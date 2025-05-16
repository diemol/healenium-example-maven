package com.epam.healenium.settings;

import com.epam.healenium.constants.BrowserType;
import com.epam.healenium.constants.DriverType;
import com.epam.healenium.settings.drivers.LocalDriver;
import com.epam.healenium.settings.drivers.ProxyDriver;
import com.epam.healenium.settings.drivers.RemoteDriver;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DriverContext {

    private WebDriver driver;
    private IDriverInterface context;

    public DriverContext(DriverType local) {
        switch (local) {
            case LOCAL:
                this.context = new LocalDriver();
                break;
            case PROXY:
                this.context = new ProxyDriver("http://localhost:8085");
                break;
            case REMOTE:
                // Get Sauce Labs username and access key from environment variables
                String username = System.getenv("SAUCE_USERNAME");
                String accessKey = System.getenv("SAUCE_ACCESS_KEY");
                // Set the Sauce Labs URL
                String sauceUrl = "https://" + username + ":" + accessKey +
                                  "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
                this.context = new RemoteDriver(sauceUrl);
                break;
        }

    }

    public WebDriver getDriver(BrowserType browser) throws MalformedURLException {
        switch (browser) {
            case CHROME:
                this.driver = context.setDriver(context.useChrome());
                break;
            case FIREFOX:
                this.driver = context.setDriver(context.useFirefox());
                break;
            case IE:
                this.driver = context.setDriver(context.useEdge());
                break;
            case SAFARI:
                this.driver = context.setDriver(context.useSafari());
                break;
        }
        return this.driver;
    }
}
