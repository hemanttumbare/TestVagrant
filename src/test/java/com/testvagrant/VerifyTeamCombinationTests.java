package com.testvagrant;

import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.testvagrant.constants.Constants;
import com.testvagrant.dataProviders.TestDataProvider;
import com.testvagrant.utility.Utilities;

public class VerifyTeamCombinationTests {

	private static final Logger logger = LogManager.getLogger(VerifyTeamCombinationTests.class);

	@Test(dataProvider = "teamData", dataProviderClass = TestDataProvider.class)
	public void verifyTeamHasFourForeignPlayers(Object teamName, Object dataFileName) {

		Utilities util = new Utilities();
		int foreignPlayerCount = 0;

		logger.info("Reading data for team " + teamName + " from file : " + dataFileName);
		JSONObject json = util.readJsonFile(Constants.DATA_FILE_LOCATION + dataFileName);

		String actualTeamName = (String) json.get(Constants.FIELD_TEAM_NAME);
		Assert.assertEquals("Team name does not match in data file and in constants...!!!", teamName, actualTeamName);

		JSONArray playersArray = (JSONArray) json.get(Constants.FIELD_PLAYER);
		Iterator iterator = playersArray.iterator();

		logger.info("Looping through player list to count foreign players...!!!");
		while (iterator.hasNext()) {
			JSONObject player = (JSONObject) iterator.next();
			String playerCountry = (String) player.get(Constants.FIELD_PLAYER_COUNTRY);
			if (!playerCountry.equals(Constants.FIELD_VALUE_COUNTRY_INDIA)) {
				foreignPlayerCount++;
			}
		}
		Assert.assertEquals("Foreign Player Count must be four...!!!", Constants.FOREIGN_PLAYER_COUNT_FOUR,
				foreignPlayerCount);
		logger.info("Foreign Player Count in Team : " + teamName + " is :" + foreignPlayerCount);
	}

	@Test(dataProvider = "teamData", dataProviderClass = TestDataProvider.class)
	public void verifyTeamHasAtleastOneWicketKeeper(Object teamName, Object dataFileName) {

		Utilities util = new Utilities();
		int wicketKeeper = 0;

		logger.info("Reading data for team " + teamName + " from file : " + dataFileName);
		JSONObject json = util.readJsonFile(Constants.DATA_FILE_LOCATION + dataFileName);

		String actualTeamName = (String) json.get(Constants.FIELD_TEAM_NAME);
		Assert.assertEquals("Team name does not match in data file and in constants...!!!", teamName, actualTeamName);

		JSONArray playersArray = (JSONArray) json.get(Constants.FIELD_PLAYER);
		Iterator iterator = playersArray.iterator();

		logger.info("Looping through player roles to count wicket-keepers...!!!");
		while (iterator.hasNext()) {
			JSONObject player = (JSONObject) iterator.next();
			String playerCountry = (String) player.get(Constants.FIELD_PLAYER_ROLE);
			if (playerCountry.equals(Constants.FIELD_VALUE_ROLE_WICKET_KEEPER)) {
				wicketKeeper++;
			}
		}
		Assert.assertTrue("Atleast one Wicket-Keeper must be present...!!!",
				wicketKeeper >= Constants.MINIMUM_WICKET_KEEPER_COUNT);
		logger.info("Wicket Keeper count in Team :" + teamName + " is :" + wicketKeeper);
	}

	@Test(dataProvider = "teamData", dataProviderClass = TestDataProvider.class)
	public void verifyTeamSpent(Object teamName, Object dataFileName) {

		Utilities util = new Utilities();
		int foreignPlayerCount = 0;
		double totalAmout=0.0;

		logger.info("Reading data for team " + teamName + " from file : " + dataFileName);
		JSONObject json = util.readJsonFile(Constants.DATA_FILE_LOCATION + dataFileName);

		String actualTeamName = (String) json.get(Constants.FIELD_TEAM_NAME);
		Assert.assertEquals("Team name does not match in data file and in constants...!!!", teamName, actualTeamName);

		JSONArray playersArray = (JSONArray) json.get(Constants.FIELD_PLAYER);
		Iterator iterator = playersArray.iterator();

		logger.info("Looping through player list to count foreign players...!!!");
		while (iterator.hasNext()) {
			JSONObject player = (JSONObject) iterator.next();
			String playerCountry = (String) player.get(Constants.FIELD_PLAYER_COUNTRY);
			if (!playerCountry.equals(Constants.FIELD_VALUE_COUNTRY_INDIA)) {
				totalAmout= totalAmout + Double.parseDouble((String) player.get("price-in-crores"));
		}
		}
			
		logger.info("Amount spent :"+ totalAmout);
		Assert.assertTrue("Total Amount spent should not be more than 50 crores", totalAmout<=50);
		//logger.info("Foreign Player Count in Team : "+teamName+ " is :"  + foreignPlayerCount);
	}
}
