package org.example.pages.flightreservation;

import org.example.pages.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FlightSearchPage extends AbstractPage {

  @FindBy(id = "passengers")
  private WebElement passengerSelect;

  @FindBy(id = "search-flights")
  private WebElement searchFlightButton;

  public FlightSearchPage(WebDriver driver){
    super(driver);
  }
  @Override
  public boolean isAt() {
    this.wait.until(ExpectedConditions.visibilityOf(this.passengerSelect));
    return this.passengerSelect.isDisplayed();
  }

  public void selectPassengers(String noOfPPassengers){
    Select passengers = new Select(this.passengerSelect);
    passengers.selectByValue(noOfPPassengers);
  }

  public void searchFlights(){
    this.searchFlightButton.click();
  }
}
