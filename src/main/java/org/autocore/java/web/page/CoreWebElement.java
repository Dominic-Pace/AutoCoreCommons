package org.autocore.java.web.page;

import org.autocore.java.commons.Config;
import com.google.common.base.Preconditions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
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
        this.byLocator = Preconditions.checkNotNull(byLocator);
        this.driver = Preconditions.checkNotNull(driver);
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
     * @return CoreWebElement instance
     */
    protected static CoreWebElement getCoreElement(By byLocator, WebDriver driver) {
        return new CoreWebElement(byLocator, driver);

    }

    /**
     * Method used for waiting for an element to be visible.
     *
     * @return Core Web Element instance
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
     *
     * @param timeout custom timeout time.
     * @return Core Web Element instance
     */
    public CoreWebElement waitForElementToBeVisible(int timeout) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(sleepTime, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(byLocator));
        return this;
    }

    /**
     * Method used for waiting for an element to be clickable.
     *
     * @return Core Web Element instance
     */
    public CoreWebElement waitForElementToBeClickable() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.withTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .pollingEvery(sleepTime, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.elementToBeClickable(byLocator));
        return this;
    }

    /**
     * Method used for waiting for an element to be clickable with a custom timeout.
     *
     * @param timeout custom timeout time.
     * @return Core Web Element instance
     */
    public CoreWebElement waitForElementToBeClickable(int timeout) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(sleepTime, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.elementToBeClickable(byLocator));
        return this;
    }

    /**
     * Method used to click on a web element.
     */
    public void click() {
        this.element.click();

    }

    /**
     * Method used to click on a web element.
     */
    public void click(CharSequence... var1) {
        this.element.click();

    }

    /**
     * Method used to send text to a web element.
     *
     * @param var1 - variable to send to element
     */
    public void sendText(CharSequence... var1) {
        this.element.sendKeys(var1);

    }

    /**
     * Method used to clear a web element of all text or information.
     *
     * @return CoreWebElement instance.
     */
    public CoreWebElement clear() {
        this.element.clear();

        return this;

    }

    /**
     * Method used to send text to a web element.
     */
    public void clearAndSendText(String textToSend) {
        this.element.clear();
        this.element.sendKeys(textToSend);

    }

    /**
     * Method used to get the tag name of a web element.
     */
    public String getTagName() {
        return this.element.getTagName();

    }

    /**
     * Method used to get the attribute name of a web element.
     *
     * @param str - String to get attribute of.
     */
    public String getAttribute(String str) {
        return this.element.getAttribute(str);

    }

    /**
     * Method used to determine if an element is selectable or not.
     *
     * @return if the element is selectable or not
     */
    public boolean isSelected() {
        return this.element.isSelected();
    }

    /**
     * Method used to determine if an element is displayed or not.
     *
     * @return if the element is displayed or not
     */
    public boolean isDisplayed() {
        return this.element.isDisplayed();
    }

    /**
     * Method used to determine if an element is enabled or not.
     *
     * @return if the element is enabled or not
     */
    public boolean isEnabled() {
        return this.element.isEnabled();
    }

    /**
     * Method used to determine if an element is clickable or not.
     *
     * @return if the element is clickable or not
     */
    public boolean isClickable() {
        return this.element.isDisplayed() && this.element.isEnabled();
    }

    /**
     * Method used to get the text of an element.
     *
     * @return representation of the text of an element
     */
    public String getText() {
        return this.element.getText();
    }

    public <T extends WebElement> List<T> findElements(By var1) {
        return this.element.findElements(var1);
    }

    public <T extends WebElement> T findElement(By var1) {
        return this.element.findElement(var1);
    }

    /**
     * Method used to get the location of an element
     *
     * @return location of the element
     */
    public Point getLocation() {
        return this.element.getLocation();
    }

    /**
     * Method used to get the size of an element
     *
     * @return size of the element
     */
    public Dimension getSize() {
        return this.element.getSize();
    }

    /**
     * Method used to get the rectangle of an element
     *
     * @return rectangle of the element
     */
    public Rectangle getRect() {
        return this.element.getRect();
    }

    /**
     * Method used to get the CSS Value of an element
     *
     * @return css value of the element
     */
    public String getCssValue(String s) {
        return this.element.getCssValue(s);
    }

    /**
     * Method used to scroll to an element
     */
    public void scrollToElement() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                this.element);
    }
}
