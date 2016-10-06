package com.autocore.automation.core.rest;

import com.autocore.automation.core.commons.utils.BaseCoreTest;
import com.autocore.automation.core.commons.utils.exception.RuntimeInterruptionException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
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

    protected CloseableHttpClient client;

    /**
     * Method used to initialize the browser before the test.
     */
    @BeforeTest
    public void initClientInstanceBeforeTest() {
        client = HttpClients.createDefault();
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
