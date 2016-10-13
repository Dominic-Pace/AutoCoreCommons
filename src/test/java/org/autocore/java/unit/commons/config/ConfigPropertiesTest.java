package org.autocore.java.unit.commons.config;

import org.autocore.java.BaseConfig;
import org.autocore.java.commons.utils.StringUtils;
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
public class ConfigPropertiesTest {

    @Test
    public void testBrowserType(){
        Assert.assertTrue(StringUtils.checkNotNull(BaseConfig.get().getBrowserType())
                .equals("CHROME"));
    }
}
