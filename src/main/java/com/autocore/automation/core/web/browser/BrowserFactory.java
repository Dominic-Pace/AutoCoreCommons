package com.autocore.automation.core.web.browser;

import com.autocore.automation.core.commons.utils.enums.DriverRunType;
import com.autocore.automation.core.commons.utils.exception.RuntimeInterruptionException;
import com.autocore.automation.core.web.WebConfig;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.InternetExplorerDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * (C) Copyright 2016 Dominic Pace (https://github.com/Dominic-Pace)
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl-2.1.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Class used to
 */
public class BrowserFactory {

    private String browserRunType;
    private WebConfig config = WebConfig.get();
    private WebDriver driver;

    /**
     * Method used to initialize a browser instance.
     * @return WebDriver instnace.
     */
    public WebDriver getBrowserInstance() {

        setBrowserRunType();

        if (browserRunType.equals("direct")) {
            driver = initDirectDriver(Capabilities.getBrowserCapabilites());
        } else if (browserRunType.equals("remote")) {
            driver = initRemoteWebDriver(Capabilities.getBrowserCapabilites());
        } else {
            throw new RuntimeInterruptionException("Could not initialize a browser.");
        }

        return driver;
    }

    /**
     * Method used to initialize a direct webdriver instance.
     *
     * @param capabilities of the direct driver.
     * @return WebDriver instance.
     */
    private WebDriver initDirectDriver(DesiredCapabilities capabilities) {

        String browserType = config.getBrowserType();
        switch(BrowserType.valueOf(browserType.toUpperCase())) {

            case FIREFOX:
                driver = new FirefoxDriver(capabilities);
                break;

            case CHROME:
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver(capabilities);
                break;

            case IE:
                InternetExplorerDriverManager.getInstance().setup();
                driver = new InternetExplorerDriver(capabilities);
                break;

            case SAFARI:
                driver = new SafariDriver(capabilities);
                break;

            default:
                throw new RuntimeInterruptionException("Cannot resolve driver type: "
                        + browserType);
        }

        return driver;
    }

    /**
     * Method used to initialize a remote webdriver instance.
     *
     * @param capabilities of the remote driver.
     * @return WebDriver instance.
     */
    private WebDriver initRemoteWebDriver(DesiredCapabilities capabilities) {

        try {

            URL url = new URL(config.getGridURL());
            driver = new RemoteWebDriver(url, capabilities);
        } catch(MalformedURLException e) {

            throw new RuntimeInterruptionException(
                    "Cannot initialize a Remote WebDriver instance.");
        }

        return driver;
    }

    /**
     * Method used to set the browser run type.
     */
    private void setBrowserRunType() {
        this.browserRunType = DriverRunType.getDriverRunType();
    }

}
