package com.autocore.automation.core.mobile;

import com.autocore.automation.core.commons.Config;
import com.autocore.automation.core.commons.utils.StringUtils;

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
public class MobileConfig extends Config {

    public static MobileConfig get() {
        return new MobileConfig();
    }

    /**
     * Method used to get the Mobile Device Type.
     *
     * @return String representation of the selenium grid URL.
     */
    public String getMobileDeviceType() {
        return StringUtils.checkNotNull(getProperty("mobile.device.type")).toUpperCase();
    }

    /**
     * Method used to get the appium server URL.
     *
     * @return String representation of the appium server URL.
     */
    public String getAppiumServerURL() {
        return StringUtils.checkNotNull(getProperty("appium.server.url"));
    }

    /**
     * Method used to get the platform version.
     *
     * @return String representation of the platform version.
     */
    public String getPlatformVersion() {
        return StringUtils.checkNotNull(getProperty("platform.version"));
    }

    /**
     * Method used to get the device name.
     *
     * @return String representation of the device name.
     */
    public String getDeviceName() {
        return StringUtils.checkNotNull(getProperty("device.name"));
    }

    /**
     * Method used to get the mobile app name.
     *
     * @return String representation of the mobile app name.
     */
    public String getMobileAppName() {
        return StringUtils.checkNotNull(getProperty("mobile.app.name"));
    }

    /**
     * Method used to get the appium version.
     *
     * @return String representation of the appium version.
     */
    public String getAppiumVersion() {
        return StringUtils.checkNotNull(getProperty("appium.version"));
    }
}
