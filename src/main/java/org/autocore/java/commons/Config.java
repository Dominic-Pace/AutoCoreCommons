package org.autocore.java.commons;

import org.autocore.java.commons.utils.StringUtils;
import org.autocore.java.commons.utils.SystemUtils;
import org.autocore.java.commons.utils.exception.RuntimeInterruptionException;

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

    /**
     *  Method used to read the config property file.
     */
    private void readPropertiesFile()  {
        properties = new Properties();

        try {
            properties.load(new FileInputStream(getConfigPropertiesFilePath()));
        } catch (IOException e) {
            throw new RuntimeInterruptionException("Property file " + configPropertiesFileName
                    + " does not exist");
        }
    }

    /**
     * Method used to read a property from the config property file.
     *
     * @param propertyToRead name of property to read
     * @return String value of the property.
     */
    protected String getProperty(String propertyToRead) {
        if (properties == null) {
            readPropertiesFile();
        }
        return StringUtils.checkNotNull(properties.getProperty(propertyToRead));
    }

    /**
     * Method used to get the Config Property File Path.
     *
     * @return String representation of the config property file path
     */
    private String getConfigPropertiesFilePath() {
        return StringUtils.checkNotNull(SystemUtils.getProjectPath() + File.separator
                + "src" + File.separator + "main" + File.separator + "resources" + File.separator
                + configPropertiesFileName);
    }

    /**
     * Method used to get the driver run type.
     *
     * @return String representation of the driver run type
     */
    public String getDriverRunType() {
        return StringUtils.checkNotNull(getProperty("driver.run.type"));
    }

    /**
     * Method used to get the GRID URL.
     *
     * @return String representation of the selenium grid URL.
     */
    public String getGridURL() {
        return StringUtils.checkNotNull(getProperty("selenium.grid.url"));
    }

    /**
     * Method used to get the default timeout
     *
     * @return integer representation of the default timeout time.
     */
    public int getDefaultTimeout() {
        return Integer.parseInt(StringUtils.checkNotNull(getProperty("timeout.time")));
    }
}
