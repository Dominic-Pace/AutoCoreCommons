package org.autocore.java.mobile.driver;

import org.autocore.java.commons.utils.exception.RuntimeInterruptionException;
import org.autocore.java.mobile.MobileConfig;

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

    /**
     * Method used to get device type Enumeration.
     *
     * @param deviceType name.
     * @return Enumeration value of DeviceType
     */
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

    /**
     * Method used to get the device type.
     *
     * @return String representation of the device type.
     */
    public static String getDeviceType() {
        return getDeviceTypeEnum(MobileConfig.get().getMobileDeviceType()).toString();
    }

    @Override
    public String toString() {
        return deviceType;
    }
}
