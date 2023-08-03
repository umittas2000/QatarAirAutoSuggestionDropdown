package org.umittas.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObjects {
    public static WebElement fromDropDownList(WebDriver driver){
        //Get the root tag of shadow dom as WebElement
        WebElement root = driver.findElement(By.xpath("//app-root"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        /*
            Execute Javascript to capture Dropdown web element in ShadowDom

            To do that, right click in web element, select inspect and
            go to web element source code, right click on source code
            and select <copy JS path> and paste in to the below code and write <return> before the code
         */
        WebElement element = (WebElement) js.executeScript("return document.querySelector('div[app-root]').shadowRoot.querySelector(\"app-flight-autocomplete\").querySelector(\"input\")");
        return element;
    }
}
