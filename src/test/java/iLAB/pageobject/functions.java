package iLAB.pageobject;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import iLAB.database.phoneNumber;
import iLAB.reports.report;
import iLAB.webUtilities.webActions;
import iLAB.webpageobject.application;
import iLAB.webpageobject.country;
import iLAB.webpageobject.internsLink;
import iLAB.webpageobject.landingPage;
import org.openqa.selenium.WebDriver;

import java.sql.ResultSet;

public class functions extends webActions {
    report rep = new report();
    String filename;

    public void landing (WebDriver driver, ExtentTest Test){
        landingPage Careers = new landingPage(driver);
        country count = new country(driver);





        try {
            filename = rep.CaptureScreenShot(driver);
            clickObject(Careers.CareerLink, driver);

            if (count.CountryLink.isDisplayed()) {
                Test.pass("Successful Clicked CareerLink", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());

            } else {

               Test.fail("Unable Click CareerLink",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            }

        }

            catch (Exception e) {



            }


            }

public void county (WebDriver driver, ExtentTest Test) {

    country count = new country(driver);
 internsLink inters = new internsLink(driver);


    try {
        filename = rep.CaptureScreenShot(driver);

        clickObject(count.CountryLink, driver);

        if (inters.internsLink.isDisplayed()) {
            Test.pass("Successful Clicked CountryLink",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
        } else {

            Test.fail("Unable Click CountryLink", MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
        }

    }

    catch (Exception e) {



    }




}


    public void intern(WebDriver driver, ExtentTest Test) {

        internsLink inters = new internsLink(driver);
        application app = new application(driver);


        try {
            filename = rep.CaptureScreenShot(driver);
            clickObject(inters.internsLink, driver);

            if (app.application.isDisplayed()) {
                Test.pass("Successful Clicked intersLink",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            } else {

                Test.fail("Unable Click intersLink",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            }

        } catch (Exception e) {


        }
    }



    public void application(WebDriver driver, ResultSet rs, ExtentTest Test) {

        application app = new application(driver);
        phoneNumber num = new phoneNumber();


        try {
            filename = rep.CaptureScreenShot(driver);
            clickObject(app.application, driver);

            passData(app.name, driver, rs.getString("FirstName"));
            passData(app.email, driver,rs.getString("Email"));
            passData(app.phone, driver,num.num());


            if (app.errormessage.isDisplayed()) {
                Test.pass("Error message displayed",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            } else {

                Test.fail("Error message not displayed",MediaEntityBuilder.createScreenCaptureFromBase64String(filename).build());
            }

        } catch (Exception e) {


        }
    }







    }





