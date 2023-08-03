package org.umittas;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.umittas.classes.*;
import org.umittas.pageobjects.PageObjects;
import static org.umittas.common.CommonMethods.*;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //Fill the List with sample data to compare.
        List<Airport> expectedAirports = collectAirportsSample();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.qatarairways.com/en/homepage.html");
        //Wait 5 seconds
        Thread.sleep(5000);
        //Set window size to 1024x768
        driver.manage().window().setSize(new Dimension(1024,768));
        //Select accept cookies and close pop-up
        driver.findElement(By.id("cookie-close-accept-all")).click();

        //ShadowDom technique is inside PageObjects class, Check out!
        WebElement fromDropdown= PageObjects.fromDropDownList(driver);
        fromDropdown.click();
        fromDropdown.sendKeys("Canada");
        Thread.sleep(5000);

        //capture auto-suggestion items from dropdown list
        List<WebElement> autoSuggestions = driver.findElements(By.xpath("//div[@class='option-details']"));

        int i=0, xpathIndex=1;
        for(WebElement element:autoSuggestions){
            String name=driver.findElement(By.xpath("(//div[@class='option-details']//span[@class='airport'])["+xpathIndex+"]")).getText();
            String iatacode=driver.findElement(By.xpath("(//div[@class='option-details']//strong[@class='iatacode'])["+xpathIndex+"]")).getText();
            String city=driver.findElement(By.xpath("(//div[@class='option-details']//strong[1])["+xpathIndex+"]")).getText();
            String province="";
            String country=driver.findElement(By.xpath("(//div[@class='option-details']//span[@class='countrycode']//b)["+xpathIndex+"]")).getText();

            Airport airport = new Airport(name,iatacode,city,province,country);

            //Compare captured airport object with expected airport objects using stream
            if(expectedAirports.stream().anyMatch(o->o.toString().equals(airport.toString()))){
                System.out.println("Pass | " + airport.toString());
            }else{
                System.out.println("Fail | " + airport.toString());
            }
            i++; xpathIndex++;
        }

        driver.close();
    }
}