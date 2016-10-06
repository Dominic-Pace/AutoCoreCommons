package org.autocore.java.rest.uri;

import org.autocore.java.commons.utils.StringUtils;

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
public class KeyValue {

    private String key;
    private String value;

    public KeyValue(String key, String value) {
        setKey(key);
        setValue(value);
    }

    /**
     * Method used to get the key String.
     *
     * @return String representation of key
     */
    public String getKey() {
        return StringUtils.checkNotNull(key);
    }

    /**
     * Method used to set the value String
     *
     * @param key String
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Method used to get the value String.
     *
     * @return String representation of value
     */
    public String getValue() {
        return StringUtils.checkNotNull(value);
    }

    /**
     * Method used to set the value String
     *
     * @param value String
     */
    public void setValue(String value) {
        this.value = value;
    }
}
