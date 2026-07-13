package fireflink.components;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.Reporter;

public class RetryMechanism implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int MAX_RETRY_COUNT = 1;

	@Override
	public boolean retry(ITestResult result) {

		if (retryCount < MAX_RETRY_COUNT) {
			retryCount++;
			Reporter.log("Retrying Test: " + result.getName() + " Retry Count: " + retryCount, true);

			return true;

		}

		return false;
	}
}