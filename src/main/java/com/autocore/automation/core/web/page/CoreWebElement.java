package com.autocore.automation.core.web.page;

import com.autocore.automation.core.commons.Config;
import com.google.common.base.Preconditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

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
public class CoreWebElement {

    private WebElement element;
    private WebDriver driver;
    protected FluentWait<WebDriver> wait;
    protected By byLocator;
    protected final Config config = Config.get();
    protected final int sleepTime = 100;
    protected final int DEFAULT_TIMEOUT = config.getDefaultTimeout();

    /**
     * Constructor for CoreWebElement
     *
     * @param byLocator - the by locator used to define the element
     * @param driver - WebDriver instance
     */
    public CoreWebElement(By byLocator, WebDriver driver) {
        this.byLocator = byLocator;
        this.driver = driver;
        if (wait == null) {
            wait = new WebDriverWait(driver, DEFAULT_TIMEOUT, sleepTime)
                    .ignoring(WebDriverException.class);
        }
    }

    /**
     * Method used to init the core web element.
     */
    private void initCoreElement() {
        if (this.element == null) {
            element = driver.findElement(byLocator);
        }
    }

    /**
     * Method used to get a web element via the core wrapper.
     *
     * @param byLocator - the by locator used to define the element
     * @param driver - WebDriver instance
     * @return CoreWebElement element
     */
    public static CoreWebElement getCoreElement(By byLocator, WebDriver driver) {
        return new CoreWebElement(byLocator, driver);
    }

    /**
     * Method used for waiting for an element to be visible.
     */
    public CoreWebElement waitForElementToBeVisible() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(sleepTime, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(byLocator));
        return this;
    }

    /**
     * Method used for waiting for an element to be visible with a custom timeout.
     */
    public CoreWebElement waitForElementToBeVisible(int timeout) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(sleepTime, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(byLocator));
        return this;
    }

    /**
     * Method used to click on a web element.
     *
     * @return CoreWebElement instance
     */
    public CoreWebElement click() {
        Preconditions.checkNotNull(element);

        this.element.click();

        return this;

    }
}
