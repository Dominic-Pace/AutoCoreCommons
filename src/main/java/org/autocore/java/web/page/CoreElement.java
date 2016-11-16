package org.autocore.java.web.page;

import com.google.common.base.Preconditions;
import org.autocore.java.commons.Config;
import org.autocore.java.web.page.interfaces.CoreElementInterface;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.internal.Coordinates;
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
public class CoreElement implements CoreElementInterface {

    private final WebDriver driver;
    private final By byLocator;
    protected FluentWait<WebDriver> wait;
    protected final Config config = Config.get();
    protected final int sleepTime = 100;
    protected final int DEFAULT_TIMEOUT = config.getDefaultTimeout();

    public CoreElement(By byLocator, WebDriver driver) {
        this.byLocator = byLocator;
        this.driver = Preconditions.checkNotNull(driver);
        if (wait == null) {
            wait = new WebDriverWait(driver, DEFAULT_TIMEOUT, sleepTime)
                    .ignoring(WebDriverException.class);
        }
    }

    public static CoreElement getCoreElement(By byLocator, WebDriver driver) {
        return new CoreElement(byLocator, driver);

    }

    @Override
    public boolean elementWired() {
        return false;
    }

    @Override
    public void click() {
        driver.findElement(byLocator).click();
    }

    @Override
    public void submit() {
        driver.findElement(byLocator).submit();
    }

    @Override
    public void sendKeys(CharSequence... charSequences) {
        driver.findElement(byLocator).sendKeys(charSequences);
    }

    @Override
    public void clear() {
        driver.findElement(byLocator).clear();
    }

    @Override
    public String getTagName() {
        return driver.findElement(byLocator).getTagName();
    }

    @Override
    public String getAttribute(String s) {
        return driver.findElement(byLocator).getAttribute(s);
    }

    @Override
    public boolean isSelected() {
        return driver.findElement(byLocator).isSelected();
    }

    @Override
    public boolean isEnabled() {
        return driver.findElement(byLocator).isEnabled();
    }

    @Override
    public String getText() {
        return driver.findElement(byLocator).getText();
    }

    @Override
    public <T extends WebElement> List<T> findElements(By by) {
        return driver.findElement(byLocator).findElements(by);
    }

    @Override
    public <T extends WebElement> T findElement(By by) {
        return driver.findElement(byLocator).findElement(by);
    }

    @Override
    public boolean isDisplayed() {
        return driver.findElement(byLocator).isDisplayed();
    }

    @Override
    public Point getLocation() {
        return driver.findElement(byLocator).getLocation();
    }

    @Override
    public Dimension getSize() {
        return driver.findElement(byLocator).getSize();
    }

    @Override
    public Rectangle getRect() {
        return driver.findElement(byLocator).getRect();
    }

    @Override
    public String getCssValue(String s) {
        return driver.findElement(byLocator).getCssValue(s);
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> outputType) throws WebDriverException {
        return driver.findElement(byLocator).getScreenshotAs(outputType);
    }

    @Override
    public Coordinates getCoordinates() {
        return getCoordinates();
    }

    @Override
    public WebElement getWrappedElement() {
        return getWrappedElement();
    }

    @Override
    public void toggle() {
        getWrappedElement().click();
    }

    @Override
    public void check() {
        if (!isChecked()) {
            toggle();
        }
    }

    @Override
    public void uncheck() {
        if (isChecked()) {
            toggle();
        }
    }

    @Override
    public boolean isChecked() {
        return getWrappedElement().isSelected();
    }


    /**
     * Method used for waiting for an element to be visible.
     *
     * @return Core Web CoreElement instance
     */
    public CoreElement waitForElementToBeVisible() {
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
     * @return Core Web CoreElement instance
     */
    public CoreElement waitForElementToBeVisible(int timeout) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(sleepTime, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(byLocator));
        return this;
    }

    /**
     * Method used for waiting for an element to be clickable.
     *
     * @return Core Web CoreElement instance
     */
    public CoreElement waitForElementToBeClickable() {
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
     * @return Core Web CoreElement instance
     */
    public CoreElement waitForElementToBeClickable(int timeout) {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wait.withTimeout(timeout, TimeUnit.SECONDS)
                .pollingEvery(sleepTime, TimeUnit.MILLISECONDS)
                .until(ExpectedConditions.elementToBeClickable(byLocator));
        return this;
    }

    /**
     * Method used to determine if an element is clickable or not.
     *
     * @return if the element is clickable or not
     */
    public boolean isClickable() {
        return driver.findElement(byLocator).isDisplayed()
                && driver.findElement(byLocator).isEnabled();
    }


    /**
     * Method used to send text to a web element.
     */
    public void clearAndSendText(String textToSend) {
        driver.findElement(byLocator).clear();
        driver.findElement(byLocator).sendKeys(textToSend);

    }

    /**
     * Method used to scroll to an element.
     *
     * @return CoreElement instance
     */
    public CoreElement scrollToElement() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(byLocator));

        return this;
    }
}
