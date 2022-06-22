package utilities;

//Listener class used to generate Extent reports

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import testCases.BaseClass;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reporting extends TestListenerAdapter {
    public ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest logger;
    BaseClass bs = new BaseClass();


    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
        String repName = "Test-Report-" + timeStamp + ".html";

        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);//specify location of the report
        htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        //extent.setSystemInfo("Host name", "localhost");
        extent.setSystemInfo("Environment", "Windows");
        extent.setSystemInfo("Test", "QA Automation");
        extent.setSystemInfo("QA Engineer", "Gor Babloyan");

        htmlReporter.config().setDocumentTitle("Project_1"); // Title of report
        htmlReporter.config().setReportName("Functional Test Automation Report"); // name of the report

        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult tr) {
        logger = extent.createTest(tr.getName());      // create new entry in th report
        logger.pass(tr.getName() + " Passed");    // log test starts
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted

    }

    public void onTestFailure(ITestResult tr) {
        logger = extent.createTest(tr.getName()); // create new entry in th report
        logger.pass(tr.getName() + " Failed");    // log test starts
        logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED)); // send the passed information to the report with Red color highlighted
        try {
            bs.captureScreen(tr.getName());
            String screenshotPath = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + tr.getName() + ".png";
            File f = new File(screenshotPath);
            if (f.exists()) {
                try {
                    logger.fail("Screenshot is below. Screenshot name: " + tr.getName());
                    logger.addScreenCaptureFromPath("\\test-output\\Screenshots\\" + tr.getName() + ".png");
                    logger.addScreenCaptureFromPath("D:\\IntellIJ-selenium\\Hibrid_Framework_Course\\Selenium_Framework_Maven\\test-output\\Screenshots\\" + tr.getName() + ".png");

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public void onTestSkipped(ITestResult tr) {
        logger = extent.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext) {
        // logger = extent.createTest("Test execution finished"); // create new entry in th report
        extent.flush();
    }
}
