package br.com.auto.logic;

import br.com.auto.pageObject.Google;
import br.com.auto.util.TestBase;

public class Logic extends TestBase {

	private Google pageGoogle = new Google();

	public void searchBar(String string) {
		getInstance().sendKeys(pageGoogle.fieldSearch(), string);
	}

	public void waitObjectSearch() {
		getInstance().visibility(pageGoogle.fieldSearch());
	}

	public void clickButtonSearch() {
		getInstance().click(pageGoogle.buttonSearch());
	}

}
