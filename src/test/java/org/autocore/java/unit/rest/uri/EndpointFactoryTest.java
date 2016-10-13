package org.autocore.java.unit.rest.uri;

import org.autocore.java.BaseConfig;
import org.autocore.java.commons.utils.BaseCoreTest;
import org.autocore.java.rest.uri.EndpointFactory;
import org.autocore.java.rest.uri.KeyValue;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
public class EndpointFactoryTest extends BaseCoreTest {

    private String baseEndpoint = BaseConfig.get().getBaseURL();

    @Test
    public void uriBuilderTest() {
        EndpointFactory factory = new EndpointFactory(baseEndpoint);

        Assert.assertEquals(baseEndpoint, BaseConfig.get().getBaseURL());

        baseEndpoint = factory.buildURI("username", "dpace");

        Assert.assertEquals(baseEndpoint, BaseConfig.get().getBaseURL()
                + "?username=dpace");

        KeyValue keyValue = new KeyValue("username", "dpace");
        baseEndpoint = factory.buildURI(keyValue);

        Assert.assertEquals(baseEndpoint, BaseConfig.get().getBaseURL()
                + "?username=dpace");

        List<KeyValue> keyValues = new ArrayList<>();
        keyValues.add(keyValue);
        keyValues.add(new KeyValue("password", "test1234!"));
        baseEndpoint = factory.buildURI(keyValues);

        Assert.assertEquals(baseEndpoint, BaseConfig.get().getBaseURL()
                + "?username=dpace&password=test1234%21");    }
}
