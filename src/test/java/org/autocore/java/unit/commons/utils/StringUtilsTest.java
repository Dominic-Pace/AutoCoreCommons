package org.autocore.java.unit.commons.utils;

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
public class StringUtilsTest {

    @Test
    public void testCheckNotNullIsValid() {
        Assert.assertTrue(StringUtils.checkNotNull("Test") != null);
        Assert.assertTrue(StringUtils.checkNotNull("12i2u3k") != null);
        Assert.assertTrue(StringUtils.checkNotNull("!") != null);
        Assert.assertTrue(StringUtils.checkNotNull("+") != null);
        Assert.assertTrue(StringUtils.checkNotNull("!@Fsl92") != null);
    }
}
