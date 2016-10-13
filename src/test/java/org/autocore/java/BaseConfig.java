package org.autocore.java;

import org.autocore.java.commons.utils.StringUtils;
import org.autocore.java.commons.utils.SystemUtils;
import org.autocore.java.commons.utils.exception.RuntimeInterruptionException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
public class BaseConfig {

    private Properties properties;
    private static final String configPropertiesFileName = "config.properties";

    public static BaseConfig get() {
        return new BaseConfig();
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
                + "src" + File.separator + "test" + File.separator + "resources" + File.separator
                + configPropertiesFileName);
    }


    //******************BASE CONFIG*****************************


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

    /**
     * Method used to get the base URL.
     *
     * @return String representation of the URL.
     */
    public String getBaseURL() {
        return StringUtils.checkNotNull(getProperty("base.url"));
    }


    //******************WEB UI CONFIG*****************************


    /**
     * Method used to get the Browser Type.
     *
     * @return String representation of the browser type.
     */
    public String getBrowserType() {
        return StringUtils.checkNotNull(getProperty("browser.type")).toUpperCase();
    }


    //******************REST API CONFIG*****************************


    /**
     * Method used to get the REST API version.
     *
     * @return String representation of the REST API version.
     */
    public String getRestAPIVersion() {
        return StringUtils.checkNotNull(getProperty("rest.api.version"));
    }


    //******************MOBILE CONFIG*****************************


    /**
     * Method used to get the Mobile Device Type.
     *
     * @return String representation of the selenium grid URL.
     */
    public String getMobileDeviceType() {
        return StringUtils.checkNotNull(getProperty("mobile.device.type")).toUpperCase();
    }

    /**
     * Method used to get the appium server URL.
     *
     * @return String representation of the appium server URL.
     */
    public String getAppiumServerURL() {
        return StringUtils.checkNotNull(getProperty("appium.server.url"));
    }

    /**
     * Method used to get the platform version.
     *
     * @return String representation of the platform version.
     */
    public String getPlatformVersion() {
        return StringUtils.checkNotNull(getProperty("platform.version"));
    }

    /**
     * Method used to get the device name.
     *
     * @return String representation of the device name.
     */
    public String getDeviceName() {
        return StringUtils.checkNotNull(getProperty("device.name"));
    }

    /**
     * Method used to get the mobile app name.
     *
     * @return String representation of the mobile app name.
     */
    public String getMobileAppName() {
        return StringUtils.checkNotNull(getProperty("mobile.app.name"));
    }

    /**
     * Method used to get the appium version.
     *
     * @return String representation of the appium version.
     */
    public String getAppiumVersion() {
        return StringUtils.checkNotNull(getProperty("appium.version"));
    }
}
