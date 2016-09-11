package com.autocore.automation.core.mobile;

import com.autocore.automation.core.commons.Config;
import com.autocore.automation.core.commons.utils.StringUtils;
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
public class MobileConfig extends Config {

    public static MobileConfig get() {
        return new MobileConfig();
    }

    public String getMobileDeviceType() {
        return StringUtils.checkNotNull(getProperty("mobile.device.type")).toUpperCase();
    }

    public String getAppiumServerURL() {
        return StringUtils.checkNotNull(getProperty("appium.server.url"));
    }

    public String getPlatformVersion() {
        return StringUtils.checkNotNull(getProperty("platform.version"));
    }

    public String getDeviceName() {
        return StringUtils.checkNotNull(getProperty("device.name"));
    }

    public String getMobileAppName() {
        return StringUtils.checkNotNull(getProperty("mobile.app.name"));
    }

    public String getAppiumVersion() {
        return StringUtils.checkNotNull(getProperty("appium.version"));
    }
}
