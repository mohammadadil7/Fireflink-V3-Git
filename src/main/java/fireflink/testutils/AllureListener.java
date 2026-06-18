package fireflink.testutils;

import org.testng.ITestListener;
import org.testng.ITestResult;

import fireflink.components.BaseClass;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {

        if (BaseClass.driver != null) {
            AllureUtils.attachScreenshot(BaseClass.driver);
        }
    }
}