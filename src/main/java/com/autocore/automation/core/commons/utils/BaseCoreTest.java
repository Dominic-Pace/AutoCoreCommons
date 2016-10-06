package com.autocore.automation.core.commons.utils;

import com.autocore.automation.core.commons.utils.exception.RuntimeInterruptionException;
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
public class BaseCoreTest {

    /**
     * DataProvider to return the parent class instance.
     *
     * @param superMethod Test method invoking this method.
     * @return instance of the super methods parameter
     */
    @DataProvider(name = "CoreDataProvider")
    protected static Object[][] getCoreDataProvider(Method superMethod) {
        try {
            return new Object[][]{{superMethod.getParameterTypes()[0].newInstance()}};
        } catch (Exception e) {
            throw new RuntimeInterruptionException("Could not return object for "
                    + superMethod.getParameterTypes()[0] + "...");
        }
    }
}
