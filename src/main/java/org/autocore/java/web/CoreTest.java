package org.autocore.java.web;

import org.autocore.java.commons.utils.BaseCoreTest;
import org.autocore.java.commons.utils.exception.RuntimeInterruptionException;
import org.autocore.java.web.browser.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

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
public class CoreTest extends BaseCoreTest {

    protected WebDriver driver;

    /**
     * Method used to initialize the browser before the test.
     */
    @BeforeTest
    public void initBrowserBeforeTest() {
        BrowserFactory browserFactory = new BrowserFactory();
        driver = browserFactory.getBrowserInstance();
    }

    /**
     * Method used to initialize the browser after the test.
     */
    @AfterTest
    public void closeBrowserAfterTest() {
        driver.close();
    }

    /**
     * DataProvider to return a Json Parsing class.
     *
     * @param superMethod Test method invoking this method.
     * @return Object array
     */
    @DataProvider(name = "JsonDataProvider")
    protected static Object[][] getJsonDataModel(Method superMethod) {
        try {
            return new Object[][]{{superMethod.getParameterTypes()[0].newInstance()}};
        } catch (Exception e) {
            throw new RuntimeInterruptionException("Could not return object for "
                    + superMethod.getParameterTypes()[0] + "...");
        }
    }
}
