package com.autocore.automation.core.mobile.driver;

import com.autocore.automation.core.commons.utils.StringUtils;
import com.autocore.automation.core.commons.utils.exception.RuntimeInterruptionException;
import com.autocore.automation.core.mobile.MobileConfig;
import com.autocore.automation.core.web.browser.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.apache.commons.lang3.NotImplementedException;
import org.openqa.selenium.remote.DesiredCapabilities;

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
 */
public class MobileDriverFactory {

    private String driverRunType;
    private MobileConfig config = MobileConfig.get();
    private AppiumDriver driver;
    private URL appiumURL;

    /**
     * Method used to initialize a browser instance.
     * @return WebDriver instnace.
     */
    public AppiumDriver getAppiumDeviceInstance() {

        if (driverRunType.equals("direct")) {
            driver = initDirectAppiumDriver(Capabilities.getCapabilities());
        } else if (driverRunType.equals("remote")) {
            throw new NotImplementedException("Remote Driver Type for Mobile Device testing has "
                    + "yet to be implemented.");
        } else {
            throw new RuntimeInterruptionException("Could not initialize a driver instance.");
        }

        return driver;
    }

    /**
     * Method used for initializing a direct appium driver on your machine.
     *
     * @param capabilities of the driver type.
     * @return Appium Driver Instance
     */
    private AppiumDriver initDirectAppiumDriver(DesiredCapabilities capabilities) {

        String deviceType = config.getMobileDeviceType();

        try {
            appiumURL = new URL(config.getAppiumServerURL());
        } catch (MalformedURLException e) {
            throw new RuntimeInterruptionException("Could not get appium Server URL");
        }

        switch(DeviceType.valueOf(deviceType)) {

            case ANDROID:
                driver = new AndroidDriver(appiumURL, capabilities);
                break;

            case IOS:
                driver = new IOSDriver(appiumURL, capabilities);
                break;

            default:
                throw new RuntimeInterruptionException("Could not initialize a new instance of "
                        + "Appium Driver.");
        }

        return driver;
    }

    //TODO - Create Remote mobile driver through remote instance of driver?

    /**
     * Method used to set the driver run type.
     */
    private void setDriverRunType() {
        this.driverRunType = StringUtils.checkNotNull(BrowserRunType.getBrowserRunType());
    }

}
