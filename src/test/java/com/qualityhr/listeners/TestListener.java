package com.qualityhr.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.qualityhr.utils.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class TestListener implements ITestListener {
    private static ExtentReports extent = ExtentReportManager.getInstance();

    @Override
    public void onFinish(ITestContext context) {
        if (extent != null) {
            extent.flush();
        }
        System.out.println(" Report Saved. Refresh Eclipse folder now.");
    }
    
}