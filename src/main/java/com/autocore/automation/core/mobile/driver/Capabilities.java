package com.autocore.automation.core.mobile.driver;

import com.autocore.automation.core.commons.utils.StringUtils;
import com.autocore.automation.core.commons.utils.SystemUtils;
import com.autocore.automation.core.commons.utils.exception.RuntimeInterruptionException;
import com.autocore.automation.core.mobile.MobileConfig;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

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

    private static MobileConfig config = MobileConfig.get();

    public static DesiredCapabilities getCapabilities() {

        DesiredCapabilities capabilities = null;
        String deviceType = MobileConfig.get().getMobileDeviceType();

        switch(DeviceType.valueOf(deviceType)) {

            case ANDROID:
                capabilities = DesiredCapabilities.android();

                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                        config.getPlatformVersion());
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
                        config.getDeviceName());
                capabilities.setCapability(MobileCapabilityType.APP,
                        getAppPath() + ".apk");
                capabilities.setCapability("appiumVersion", config.getAppiumVersion());

                break;

            case IOS:
                capabilities = new DesiredCapabilities();

                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,
                        config.getPlatformVersion());
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,
                        config.getDeviceName());
                capabilities.setCapability(MobileCapabilityType.APP,
                        getAppPath() + ".ipa");
                capabilities.setCapability("appiumVersion", config.getAppiumVersion());

                break;

            default:
                throw new RuntimeInterruptionException("Cannot resolve the device capabilties for "
                        + "device type: " + deviceType);
        }

        return capabilities;
    }

    private static String getAppPath() {
        return StringUtils.checkNotNull(SystemUtils.getProjectPath() + File.separator
                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + File.separator + "mobileapp" + File.separator + config.getMobileAppName());
    }
}
