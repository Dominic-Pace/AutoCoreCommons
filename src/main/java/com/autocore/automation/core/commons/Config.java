package com.autocore.automation.core.commons;

import com.autocore.automation.core.commons.utils.StringUtils;
import com.autocore.automation.core.commons.utils.exception.RuntimeInterruptionException;

import java.io.*;
import java.util.Properties;

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
public class Config {

    private Properties properties;
    private static final String configPropertiesFileName = "config.properties";

    public static Config get() {
        return new Config();
    }

    private void readPropertiesFile()  {
        properties = new Properties();

        try {
            properties.load(new FileInputStream(getConfigPropertiesFilePath()));
        } catch (IOException e) {
            throw new RuntimeInterruptionException("Property file " + configPropertiesFileName
                    + " does not exist");
        }
    }

    protected String getProperty(String propertyToRead) {
        if (properties == null) {
            readPropertiesFile();
        }
        return StringUtils.checkNotNull(properties.getProperty(propertyToRead));
    }

    private String getConfigPropertiesFilePath() {
        return StringUtils.checkNotNull(System.getProperty("user.dir") + File.separator
                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + configPropertiesFileName);
    }
}
