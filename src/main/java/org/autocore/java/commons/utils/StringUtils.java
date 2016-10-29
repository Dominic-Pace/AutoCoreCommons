package org.autocore.java.commons.utils;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.RandomStringUtils;

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

    private static final int STANDARD_STRING_LENGTH = 6;
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

    /**
     * Method used to create a random alphabetic string given a string name.
     *
     * @param stringToAppend - String to add onto.
     * @return newly redacted string.
     */
    public static String createRandomAlphabetic(String stringToAppend) {
        return checkNotNull(stringToAppend + "_"
                + RandomStringUtils.randomAlphabetic(STANDARD_STRING_LENGTH));
    }

    /**
     * Method used to create a random alphabetic string given a string name of a custom length.
     *
     * @param stringToAppend - String to add onto
     * @param stringLength - custom length of string
     * @return newly redacted string.
     */
    public static String createRandomAlphabetic(String stringToAppend, int stringLength) {
        return checkNotNull(stringToAppend + "_"
                + RandomStringUtils.randomAlphabetic(stringLength));
    }

    /**
     * Method used to create a random alphabetic string.
     *
     * @return newly redacted string.
     */
    public static String createRandomAlphabetic() {
        return checkNotNull(RandomStringUtils
                .randomAlphabetic(Integer.valueOf(createRandomNumericValue(1))));
    }

    /**
     * Method used to create a random alphabetic string of a custom length.
     *
     * @param stringLength - custom length of string
     * @return newly redacted string.
     */
    public static String createRandomAlphabetic(int stringLength) {
        return checkNotNull(RandomStringUtils.randomAlphabetic(stringLength));
    }

    /**
     * Method used to create a random alphanumeric string given a string name.
     *
     * @param stringToAppend - String to add onto.
     * @return newly redacted string.
     */
    public static String createRandomAlphaNumeric(String stringToAppend) {
        return checkNotNull(stringToAppend + "_"
                + RandomStringUtils.randomAlphanumeric(
                        Integer.valueOf(createRandomNumericValue(1))));
    }

    /**
     * Method used to create a random alphanumeric string given a string name of a custom length.
     *
     * @param stringToAppend - String to add onto
     * @param stringLength - custom length of string
     * @return newly redacted string.
     */
    public static String createRandomAlphaNumeric(String stringToAppend, int stringLength) {
        return checkNotNull(stringToAppend + "_"
                + RandomStringUtils.randomAlphanumeric(stringLength));
    }

    /**
     * Method used to create a random alphanumeric string.
     *
     * @return newly redacted string.
     */
    public static String createRandomAlphaNumeric() {
        return checkNotNull(RandomStringUtils
                .randomAlphanumeric(Integer.valueOf(createRandomNumericValue(1))));
    }

    /**
     * Method used to create a random alphanumeric string of a custom length.
     *
     * @param stringLength - custom length of string
     * @return newly redacted string.
     */
    public static String createRandomAlphaNumeric(int stringLength) {
        return checkNotNull(RandomStringUtils.randomAlphanumeric(stringLength));
    }

    /**
     * Method used to create a random numeric value of a custom length.
     *
     * @param valueLength - custom length of value
     * @return newly redacted string.
     */
    public static String createRandomNumericValue(int valueLength) {
        String randomIntegerValue = RandomStringUtils.randomNumeric(valueLength);

        if (randomIntegerValue.equals("0")) {
            randomIntegerValue = RandomStringUtils.randomNumeric(valueLength);
        }
        return randomIntegerValue;

    }
}
