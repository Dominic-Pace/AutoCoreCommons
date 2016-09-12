package com.autocore.automation.core.commons.utils;

import com.google.common.base.Preconditions;

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
 * Class stored with commonly used String functions.
 *
 */
public class StringUtils {

    /**
     * Method used to check a String is not null
     *
     * @param stringToCheck some String to check
     * @return String representation of String passed in.
     */
    public static String checkNotNull(String stringToCheck) {

        Preconditions.checkNotNull(stringToCheck);

        return stringToCheck;
    }
}
