package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
	
	public ExtentReports er;
	
	public static ExtentReports getExtentReport() {
		
		String filepath = System.getProperty("user.dir")+"//reports//extentreport.html";
		ExtentSparkReporter esr = new ExtentSparkReporter(filepath);
		esr.config().setDocumentTitle("Title");
		esr.config().setReportName("reportName");
		
		ExtentReports er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("Operating System", "Mac OS");
		er.setSystemInfo("Tester", "Mohammad Ummar");
		
		return er;
	}
}
