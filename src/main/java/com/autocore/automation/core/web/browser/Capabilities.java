package com.autocore.automation.core.web.browser;

import com.autocore.automation.core.commons.utils.exception.RuntimeInterruptionException;
import com.autocore.automation.core.web.WebConfig;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;

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
public class Capabilities {

    public static DesiredCapabilities getBrowserCapabilites() {

        DesiredCapabilities capabilities = null;
        String browserType = WebConfig.get().getBrowserType();

        switch (BrowserType.valueOf(browserType)) {

            case FIREFOX:
                capabilities = DesiredCapabilities.firefox();
                FirefoxProfile profile = new FirefoxProfile();

                profile.setAcceptUntrustedCertificates(false);
                profile.setAssumeUntrustedCertificateIssuer(true);
                profile.setPreference("browser.helperApps.alwaysAsk.force", false);

                capabilities.setCapability(FirefoxDriver.PROFILE, profile);

                break;

            case CHROME:
                capabilities = DesiredCapabilities.chrome();

                break;

            case IE:
                break;

            case SAFARI:
                break;

            default:
                throw new RuntimeInterruptionException("Cannot resolve the browser capabilties for "
                        + "browser type: " + browserType);

        }

        return capabilities;
    }
}
