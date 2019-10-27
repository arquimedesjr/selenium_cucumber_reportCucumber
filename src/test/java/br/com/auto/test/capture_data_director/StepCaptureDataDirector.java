package br.com.auto.test.capture_data_director;



import br.com.auto.logic.Logic;
import br.com.auto.util.TestBase;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepCaptureDataDirector extends LogicCaptureDataDirector{
	
	Logic logic = new Logic();

	@Before
	public void before() {
		TestBase.getInstance().setUp();
	}

	@After
	public void after(Scenario scenario) {
		if(scenario.isFailed()) {
			TestBase.getInstance().takeScreenShotTest();
		}
		
		TestBase.getInstance().close();
	}
	

	@Given("^que navego na url do google$")
	public void que_navego_na_url_do_google() throws Throwable {
		TestBase.getInstance().url();
		logic.waitObjectSearch();
		TestBase.getInstance().takeScreenShotTest();
	}

	@When("^insiro no campo de perquisa 'Joe Russo'$")
	public void insiro_no_campo_de_perquisa_Joe_Russo() throws Throwable {
		logic.searchBar("Joe Russo");
		TestBase.getInstance().takeScreenShotTest();
	}

	@When("^clico no botao 'Pesquisa Google'$")
	public void clico_no_botao_Pesquisa_Google() throws Throwable {
		logic.clickButtonSearch();
		TestBase.getInstance().takeScreenShotTest();
	}

	@Then("^capturo a data de nascimento do diretor 'Joe Russo'$")
	public void capturo_a_data_de_nascimento_do_diretor_Joe_Russo() throws Throwable {
		captureDateBirthDirector("Joe Russo");
		TestBase.getInstance().takeScreenShotTest();
	}

	@When("^insiro no campo de perquisa 'Joss Whedon'$")
	public void insiro_no_campo_de_perquisa_Joss_Whedon() throws Throwable {
		logic.searchBar("Joss Whedon");
		TestBase.getInstance().takeScreenShotTest();
	}

	@Then("^capturo a data de nascimento do 'Joss Whedon'$")
	public void capturo_a_data_de_nascimento_do_Joss_Whedon() throws Throwable {
		captureDateBirthDirector("Joss Whedon");
		TestBase.getInstance().takeScreenShotTest();
	}

	@When("^insiro no campo de perquisa 'Anthony Russo'$")
	public void insiro_no_campo_de_perquisa_Anthony_Russo() throws Throwable {
		logic.searchBar("Anthony Russo");
		TestBase.getInstance().takeScreenShotTest();
	}

	@Then("^capturo a data de nascimento do 'Anthony Russo'$")
	public void capturo_a_data_de_nascimento_do_Anthony_Russo() throws Throwable {
		captureDateBirthDirector("Anthony Russo");
		TestBase.getInstance().takeScreenShotTest();
	}

}
