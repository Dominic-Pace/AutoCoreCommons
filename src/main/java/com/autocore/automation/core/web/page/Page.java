package com.autocore.automation.core.web.page;

import com.autocore.automation.core.commons.Config;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

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
public class Page {

    protected WebDriver driver;
    protected Config config = Config.get();
    private WebDriverWait wait;

    protected final int DEFAULT_TIMEOUT = config.getDefaultTimeout();

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method used to refresh the page.
     */
    public void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * Method used to wait for the Page Complete Load State with JavaScript Executor.
     */
    public void waitForPageCompleteState() {
        new WebDriverWait(driver, DEFAULT_TIMEOUT).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState")
                        .equals("complete"));
    }

    /**
     * Method used to wait for the Page Complete Load State with JavaScript Executor via custom
     * timeout.
     *
     * @param customTimeout integer representation of a custom timeout.
     */
    public void waitForPageCompleteState(int customTimeout) {
        new WebDriverWait(driver, customTimeout).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState")
                        .equals("complete"));
    }
}
