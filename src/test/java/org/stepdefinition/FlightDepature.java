package org.stepdefinition;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.pagefactory.DepaturePgFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class FlightDepature extends DepaturePgFactory {

	public static String flightDepPickTime;
	public static String flightDepDropTime;
	
	@Given("Sorting flights by price")
	public void sorting_flights_by_price() {
		BaseClass.iWait(30);
		BaseClass.getCurrentURL();
		DepaturePgFactory dP = new DepaturePgFactory();
		try {
			BaseClass.click(dP.dealClose);
		} catch (Exception e) {
			System.out.println("no deal");
		}

	}

	@When("Choosing lowest price flight")
	public void choosing_lowest_price_flight() throws IOException {

		DepaturePgFactory dP = new DepaturePgFactory();
		flightDepPickTime = BaseClass.getText(dP.deppickTime);
		flightDepDropTime = BaseClass.getText(dP.depdropTime);
		System.out.println(flightDepPickTime);
		System.out.println(flightDepDropTime);
		BaseClass.screenShot("cheapair\\Depature");

	}

	@Then("Confiming flight timing")
	public void confiming_flight_timing() throws InterruptedException {
		DepaturePgFactory dP = new DepaturePgFactory();
		BaseClass.acClick(dP.chooseup);
		Thread.sleep(3000);
	}

	
}
