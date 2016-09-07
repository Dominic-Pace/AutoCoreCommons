package com.autocore.automation.core.web.browser;

import com.autocore.automation.core.commons.utils.StringUtils;
import com.autocore.automation.core.commons.utils.exception.RuntimeInterruptionException;
import com.autocore.automation.core.web.WebConfig;
import com.sun.org.apache.regexp.internal.RE;

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
public enum BrowserRunType {

    DIRECT("direct"),
    REMOTE("remote");

    private String browserRunType;

    BrowserRunType (String browserRunType) {
        this.browserRunType = browserRunType;
    }

    private static BrowserRunType getBrowserRunTypeEnum(String browserRunType) {

        switch(BrowserRunType.valueOf(browserRunType.toUpperCase())) {

            case DIRECT:
                return DIRECT;

            case REMOTE:
                return REMOTE;

            default:
                throw new RuntimeInterruptionException("Could not read the browser run type: "
                        + browserRunType);

        }
    }

    public static String getBrowserRunType() {
        return getBrowserRunTypeEnum(StringUtils.checkNotNull(WebConfig.get()
                .getBrowserRunType())).toString();
    }

    @Override
    public String toString() {
        return browserRunType;
    }
}
