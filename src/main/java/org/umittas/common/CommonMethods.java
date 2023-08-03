package org.umittas.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.umittas.Main;
import org.umittas.classes.Airport;
import java.util.ArrayList;
import java.util.List;
public class CommonMethods extends Main {
    //EXPERIMENT to collect airports from external source and compare with actual airports
    public static List<Airport> collectAirports(List<WebElement> airportCodes) {
        List<Airport> expectedAirports = new ArrayList<Airport>();

        int i = 0, xpathIndex = 1;

        //Go to nationsonline.org website and collect all airports within Canada, add them into ArrayList to further use
        for (WebElement airport : airportCodes) {
            try {
                Airport a = new Airport();
                a.setName(airportCodes.get(i).findElement(By.xpath("((//tr)[" + xpathIndex + "]//td)[3]")).getText());
                a.setIatacode(airportCodes.get(i).findElement(By.xpath("((//tr)[" + xpathIndex + "]//td)[1]")).getText());
                a.setCity(airportCodes.get(i).findElement(By.xpath("((//tr)[" + xpathIndex + "]//td)[2]")).getText());
                a.setProvince("");
                a.setCountry(airportCodes.get(i).findElement(By.xpath("((//tr)[" + xpathIndex + "]//td)[4]/a")).getText());

                //There are some other country airports starts with iatacode Y, eliminate them.
                if (a.getCountry().equals("Canada")) {
                    System.out.println(xpathIndex + " " + a.toString());
                    expectedAirports.add(a);
                }
                i++;
                xpathIndex++;
            } catch (Exception e) {
                //Google ads interrupting in somewhere
                i++;
                xpathIndex++;
            }
        }

        return expectedAirports;
    }

    public static List<Airport> collectAirportsSample(){
        List<Airport> expectedAirports = new ArrayList<Airport>();
        expectedAirports.add(new Airport("Lester B. Pearson International Airport","YYZ","Toronto","","Canada"));
        expectedAirports.add(new Airport("Pierre E.Trudeau International Airport","YUL","Montreal","","Canada"));
        expectedAirports.add(new Airport("Sault Ste Marie Airport","YAM","Sault Ste. Marie","","Canada"));
        expectedAirports.add(new Airport("Baie Comeau Airport","YBC","Baie Comeau","","Canada"));
        expectedAirports.add(new Airport("Bagotville Airport","YBG","Saguenay","","Canada"));
        return expectedAirports;
    }
}
