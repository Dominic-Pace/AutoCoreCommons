package org.autocore.java.unit.commons.utils;

import org.autocore.java.commons.utils.BaseCoreTest;
import org.autocore.java.commons.utils.JsonUtils;
import org.autocore.java.models.User;
import org.testng.Assert;
import org.testng.annotations.Test;

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
public class JsonUtilsTest extends BaseCoreTest {

    private String jsonFilePath = "/testdata/User00001.json";

    @Test(dataProvider = "CoreDataProvider")
    public void testCreateObjectFromJson(User testData) {
        JsonUtils jsonUtils = new JsonUtils(jsonFilePath);

        User newUser = (User) jsonUtils.createObjectFromJsonFile(testData);

        Assert.assertEquals(newUser.getClass(), testData.getClass());
    }
}
