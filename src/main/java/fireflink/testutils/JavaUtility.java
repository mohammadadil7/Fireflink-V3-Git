package fireflink.testutils;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.Random;

public class JavaUtility {

	public String getDateandTime() {
		String time = LocalDateTime.now().toString().replace(":", "-");
		return time;
	}

	public Properties getConfigData() throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");

		Properties properties = new Properties();
		properties.load(fis);
		return properties;

	}

	public String generateRandomNumber(int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("Size must be greater than 0");
		}

		long lowerBound = (long) Math.pow(10, size - 1);
		long upperBound = (long) Math.pow(10, size) - 1;

		Random random = new Random();
		long randomNumber = lowerBound + (long) (random.nextDouble() * (upperBound - lowerBound + 1));

		return String.valueOf(randomNumber);
	}

	public String concateTwoStrings(String input1, String input2) {

		String result = input1 + input2;
		return result;

	}

//	public static void main(String[] args) {
//		JavaUtility jUtility=new JavaUtility();
//	String ss = jUtility.concateTwoStrings("ss", "4444");
//		System.out.println(ss);
//	}
}
