package com.autocore.automation.core.mobile.driver;

import com.autocore.automation.core.commons.utils.exception.RuntimeInterruptionException;
import com.autocore.automation.core.mobile.MobileConfig;

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
public enum DeviceType {

    IOS("ios"),
    ANDROID("android");

    private String deviceType;

    DeviceType (String deviceType) {
        this.deviceType = deviceType;
    }

    private static DeviceType getDeviceTypeEnum(String deviceType) {

        switch(DeviceType.valueOf(deviceType)) {

            case IOS:
                return IOS;

            case ANDROID:
                return ANDROID;

            default:
                throw new RuntimeInterruptionException("Could not read the device type: "
                        + deviceType);

        }
    }

    public static String getDeviceType() {
        return getDeviceTypeEnum(MobileConfig.get().getMobileDeviceType()).toString();
    }

    @Override
    public String toString() {
        return deviceType;
    }
}
