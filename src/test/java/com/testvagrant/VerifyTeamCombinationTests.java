package com.testvagrant;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.testvagrant.constants.Constants;
import com.testvagrant.dataProviders.TestDataProvider;
import com.testvagrant.utility.Utilities;

public class VerifyTeamCombinationTests {

	@Test(dataProvider = "teamData", dataProviderClass = TestDataProvider.class)
	public void verifyTeamHasFourForeignPlayers(Object teamName, Object dataFileName) {

		Utilities util = new Utilities();
		int foreignPlayerCount = 0;

		System.out.println("Reading data for team " + teamName + " from file : " + dataFileName);
		JSONObject json = util.readJsonFile(Constants.DATA_FILE_LOCATION + dataFileName);

		String actualTeamName = (String) json.get(Constants.FIELD_TEAM_NAME);
		Assert.assertEquals("Team name does not match in data file and in constants...!!!", teamName, actualTeamName);

		JSONArray playersArray = (JSONArray) json.get(Constants.FIELD_PLAYER);
		Iterator iterator = playersArray.iterator();

		System.out.println("Looping through player list to count foreign players...!!!");
		while (iterator.hasNext()) {
			JSONObject player = (JSONObject) iterator.next();
			String playerCountry = (String) player.get(Constants.FIELD_PLAYER_COUNTRY);
			if (!playerCountry.equals(Constants.FIELD_VALUE_COUNTRY_INDIA)) {
				foreignPlayerCount++;
			}
		}
		Assert.assertEquals("Foreign Player Count must be four...!!!", Constants.FOREIGN_PLAYER_COUNT_FOUR,
				foreignPlayerCount);
		System.out.println("Foreign Player Count in Team :" + foreignPlayerCount);
	}
	

	@Test(dataProvider = "teamData", dataProviderClass = TestDataProvider.class)
	public void verifyTeamHasAtleastOneWicketKeeper(Object teamName, Object dataFileName) {

		Utilities util = new Utilities();
		int wicketKeeper = 0;

		System.out.println("Reading data for team " + teamName + " from file : " + dataFileName);
		JSONObject json = util.readJsonFile(Constants.DATA_FILE_LOCATION + dataFileName);

		String actualTeamName = (String) json.get(Constants.FIELD_TEAM_NAME);
		Assert.assertEquals("Team name does not match in data file and in constants...!!!", teamName, actualTeamName);

		JSONArray playersArray = (JSONArray) json.get(Constants.FIELD_PLAYER);
		Iterator iterator = playersArray.iterator();

		System.out.println("Looping through player roles to count wicket-keepers...!!!");
		while (iterator.hasNext()) {
			JSONObject player = (JSONObject) iterator.next();
			String playerCountry = (String) player.get(Constants.FIELD_PLAYER_ROLE);
			if (playerCountry.equals(Constants.FIELD_VALUE_ROLE_WICKET_KEEPER)) {
				wicketKeeper++;
			}
		}
		Assert.assertTrue("Atleast one Wicket-Keeper must be present...!!!",
				wicketKeeper >= Constants.MINIMUM_WICKET_KEEPER_COUNT);
		System.out.println("Wicket Keeper count in team :" + wicketKeeper);
	}
}
