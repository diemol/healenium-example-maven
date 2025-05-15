package com.epam.healenium.settings;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface IDriverInterface {

    WebDriver setDriver(Object delegate) throws MalformedURLException;

    Object useChrome();

    Object useFirefox();

    Object useEdge();

    Object useSafari();
}
