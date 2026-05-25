package fireflink.components;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryMechanism implements IRetryAnalyzer {

	@Override
	public boolean retry(ITestResult result) {
		int count = 0;
		int maxRetry = 0;
		if (count < maxRetry) {
			count++;
			return true;
		}

		return false;
	}

}
