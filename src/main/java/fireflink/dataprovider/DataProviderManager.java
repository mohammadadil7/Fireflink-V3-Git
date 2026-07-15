package fireflink.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import fireflink.testutils.ExcelUtils;

public class DataProviderManager {

	@DataProvider(name = "AddMultipleRecipient")
	public Object[][] loginData() throws IOException {

		String path = System.getProperty("user.dir") + "/src/test/resources/fireflink/dataproviders/groupsDataprovider.xlsx";

		return ExcelUtils.getExcelData_DataProvider(path, "AddMultipleRecipient");

	}
}