package com.autocore.automation.core.web.browser;

import com.autocore.automation.core.commons.utils.StringUtils;
import com.autocore.automation.core.commons.utils.exception.RuntimeInterruptionException;
import com.autocore.automation.core.web.WebConfig;

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
public enum BrowserType {

    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie"),
    SAFARI("safari");

    private String browserType;

    BrowserType (String browserType) {
        this.browserType = browserType;
    }

    /**
     * Method used to get the browser type.
     *
     * @param browserType name of browser.
     * @return Enumeration value of the browser type.
     */
    private static BrowserType getBrowserTypeEnum(String browserType) {

        switch(BrowserType.valueOf(browserType)) {

            case FIREFOX:
                return FIREFOX;

            case CHROME:
                return CHROME;

            case IE:
                return IE;

            case SAFARI:
                return SAFARI;

            default:
                throw new RuntimeInterruptionException("Could not read the browser type: "
                        + browserType);

        }
    }

    /**
     * Method used to get the browser type.
     *
     * @return String representation of browser type.
     */
    public static String getBrowserType() {
        return getBrowserTypeEnum(WebConfig.get().getBrowserType()).toString();
    }

    @Override
    public String toString() {
        return browserType;
    }
}