package org.example.tests.flightreservation;

import org.example.pages.flightreservation.FlightSearchPage;
import org.example.pages.flightreservation.FlightSelectionPage;
import org.example.pages.flightreservation.FlightsConfirmationPage;
import org.example.pages.flightreservation.RegistrationConfirmationPage;
import org.example.pages.flightreservation.RegistrationPage;
import org.example.tests.AbstractTest;
import org.example.tests.flightreservation.model.FlightReservationTestData;
import org.example.util.Config;
import org.example.util.Constants;
import org.example.util.JsonUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FlightReservationTest extends AbstractTest {

  private FlightReservationTestData testData;

  @BeforeTest
  @Parameters("testDataPath")
  public void setParameters(String testDataPath){
    this.testData = JsonUtil.getTestData(testDataPath, FlightReservationTestData.class);
  }

  @Test
  public void userRegistrationTest(){
    RegistrationPage registrationPage = new RegistrationPage(driver);
    registrationPage.goTo(Config.get(Constants.FLIGHT_RESERVATION_URL));
    Assert.assertTrue(registrationPage.isAt());

    registrationPage.enterUserDetails(testData.firstName(), testData.lastName());
    registrationPage.enterUserCredentials(testData.email(), testData.password());
    registrationPage.enterAddress(testData.street(), testData.city(), testData.zip());
    registrationPage.register();
  }

  @Test(dependsOnMethods = "userRegistrationTest")
  public void registrationConfirmationTest() {
    RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
    Assert.assertTrue(registrationConfirmationPage.isAt());
    Assert.assertEquals(registrationConfirmationPage.getFirstName(), testData.firstName());
    registrationConfirmationPage.goToFlightSearch();
  }

  @Test(dependsOnMethods = "registrationConfirmationTest")
  public void flightsSearchTest() {
    FlightSearchPage flightSearchPage = new FlightSearchPage(driver);
    Assert.assertTrue(flightSearchPage.isAt());
    flightSearchPage.selectPassengers(testData.passengersCount());
    flightSearchPage.searchFlights();
  }

  @Test(dependsOnMethods = "flightsSearchTest")
  public void flightsSelectionTest(){
    FlightSelectionPage flightSelectionPage = new FlightSelectionPage(driver);
    Assert.assertTrue(flightSelectionPage.isAt());
    flightSelectionPage.selectFlights();
    flightSelectionPage.confirmFlights();
  }

  @Test(dependsOnMethods = "flightsSelectionTest")
  public void flightReservationConfirmationTest(){
    FlightsConfirmationPage flightsConfirmationPage = new FlightsConfirmationPage(driver);
    Assert.assertTrue(flightsConfirmationPage.isAt());
    Assert.assertEquals(flightsConfirmationPage.getPrice(), testData.expectedPrice());
  }
}
