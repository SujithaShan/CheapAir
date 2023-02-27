package org.stepdefinition;

import java.io.IOException;

import org.baseclass.BaseClass;
import org.pagefactory.DepaturePgFactory;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightReturn {

	public static String flightRetPickTime;
	public static String flightRetDropTime;

	@When("Confirming return timing")
	public void confirming_return_timing() throws InterruptedException, IOException {
		BaseClass.iWait(30);
		DepaturePgFactory dP = new DepaturePgFactory();
		Thread.sleep(3000);
		//System.out.println(BaseClass.getText(dP.ret));
		flightRetPickTime = BaseClass.getText(dP.returnPick);
		flightRetDropTime = BaseClass.getText(dP.returnDrop);
		BaseClass.screenShot("cheapair\\Return");
//		System.out.println(flightRetPickTime);
//		System.out.println(flightRetDropTime);
	}

	@Then("Choosing return flight")
	public void choosing_return_flight() {
		DepaturePgFactory dP = new DepaturePgFactory();
		BaseClass.acClick(dP.chooseReturn);
	}

}
