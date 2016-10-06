package org.autocore.java.rest;

import org.autocore.java.commons.utils.BaseCoreTest;
import org.autocore.java.commons.utils.exception.RuntimeInterruptionException;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

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

    protected CloseableHttpClient httpClient;

    /**
     * Method used to initialize the client instance before the test.
     */
    @BeforeTest
    public void initClientInstanceBeforeTest() {
        httpClient = HttpClients.createDefault();
    }

    /**
     * Method used to close the client instance after the test.
     */
    @AfterTest
    public void closeClientInstanceBeforeTest() {
        try {
            httpClient.close();
        } catch (IOException e) {
            throw new RuntimeInterruptionException("Could not close out the client instance.");
        }
    }
}
