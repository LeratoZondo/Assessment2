package iLAB.webtest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import iLAB.database.dataBase;
import iLAB.pageobject.functions;
import iLAB.reports.report;
import iLAB.webUtilities.webUtilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;

public class ilabTest {
    webUtilities util = new webUtilities();
    functions fun = new functions();
    report rep = new report();
    dataBase data = new dataBase();
    ExtentReports repo;


    String sURL;
    String sBrowser;

    @Parameters({"iLABURL", "Browser"})
    @BeforeTest
    public void beforeMethod(String URL, String Browser) {
        sURL = URL;
        sBrowser = Browser;
        util.setWebDriver(util.initializeWebDriver(sBrowser));
        repo =  rep.initializeExtentReports("report/ilab.html");


    }

    @Test
    public void applicationTest() {
        ExtentTest Test = repo.createTest("reports for iLAB");
        Test.assignAuthor("Lerato");
        ResultSet rs;


        try {
            rs = data.ConnectAndQuerySQL("jdbc:mysql://localhost:3306/ilab",
                    "root", "Lerato@145", "Select * from ilabinfo");
            int iRow = data.rowCount(rs);
            util.navigate(sURL);
            for (int i = 1; i <= iRow; i++) {


                if (rs.next()) {


                    fun.landing(util.getWebDriver(),Test);
                    fun.county(util.getWebDriver(), Test);
                    fun.intern(util.getWebDriver(), Test);
                    fun.application(util.getWebDriver(),rs,Test);


                }


            }
            rs.close();


            }
         catch(Exception e){
                }


     }



     @AfterTest
    public void closeup() throws InterruptedException {
        Thread.sleep(2000);
         util.getWebDriver().quit();
         repo.flush();
     }


     }





