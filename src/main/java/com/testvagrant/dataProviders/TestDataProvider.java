package com.testvagrant.dataProviders;

import org.testng.annotations.DataProvider;
import com.testvagrant.constants.Constants;

public class TestDataProvider {

	@DataProvider(name = "teamData")
	public static Object[][] createTeamData() {
		return new Object[][] { { Constants.TEAM_BANGALORE_NAME, Constants.TEAM_BANGALORE_DATA_FILE_NAME } };

	}
}
