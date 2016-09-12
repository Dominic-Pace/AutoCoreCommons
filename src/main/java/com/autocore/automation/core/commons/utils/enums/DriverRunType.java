package com.autocore.automation.core.commons.utils.enums;

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
public enum DriverRunType {

    DIRECT("direct"),
    REMOTE("remote");

    private String driverRunType;

    DriverRunType(String driverRunType) {
        this.driverRunType = driverRunType;
    }

    /**
     * Method used to get the driver run type.
     * 
     * @param driverRunType
     * @return
     */
    private static DriverRunType getDriverRunTypeEnum(String driverRunType) {

        switch(DriverRunType.valueOf(driverRunType.toUpperCase())) {

            case DIRECT:
                return DIRECT;

            case REMOTE:
                return REMOTE;

            default:
                throw new RuntimeInterruptionException("Could not read the driver run type: "
                        + driverRunType);

        }
    }

    /**
     * Method used to get the driver run type.
     * 
     * @return String representation of the driver run type.
     */
    public static String getDriverRunType() {
        return getDriverRunTypeEnum(StringUtils.checkNotNull(WebConfig.get()
                .getDriverRunType())).toString();
    }

    @Override
    public String toString() {
        return driverRunType;
    }
}
