/*
 * Copyright 2016-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.glowroot.tests.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.glowroot.tests.util.Utils;

import static org.openqa.selenium.By.xpath;

public class UserConfigPage {

    private final WebDriver driver;

    public UserConfigPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getUsernameTextField() {
        return withWait(xpath("//div[@gt-label='Username']//input"));
    }

    public WebElement getPasswordTextField() {
        return withWait(xpath("//div[@gt-label='Password']//input"));
    }

    public WebElement getVerifyPasswordTextField() {
        return withWait(xpath("//div[@gt-label='Verify password']//input"));
    }

    public void clickAddButton() {
        clickWithWait(xpath("//button[normalize-space()='Add']"));
    }

    public WebElement getDuplicateUsernameMessage() {
        return withWait(xpath("//div[text()='There is already a user with this username']"));
    }

    public void clickSaveButton() {
        clickWithWait(xpath("//button[normalize-space()='Save changes']"));
    }

    public void clickSaveWithNoRolesConfirmationButton() {
        clickWithWait(xpath("//button[@ng-click='saveWithNoRoles()']"));
    }

    public WebElement getDeleteButton() {
        return withWait(xpath("//button[normalize-space()='Delete']"));
    }

    private WebElement withWait(By by) {
        return Utils.withWait(driver, by);
    }

    private void clickWithWait(By by) {
        Utils.clickWithWait(driver, by);
    }
}
