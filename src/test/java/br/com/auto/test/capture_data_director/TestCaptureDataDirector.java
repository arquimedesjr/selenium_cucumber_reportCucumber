package br.com.auto.test.capture_data_director;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import br.com.auto.util.ConfigFileReader;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\br\\com\\auto\\test\\capture_data_director\\capture_data_director.feature", glue = "br.com.auto.test.capture_data_director", plugin = {
		"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:src/test/resources/report-cucumber/report.html" }, monochrome = true)

public class TestCaptureDataDirector {

	@AfterClass
	public static void teardown() {
		ConfigFileReader read = new ConfigFileReader("src\\main\\resources\\configs\\config.properties");
		String browser = read.GetPropertyByKey("browserName");
		
		Reporter.loadXMLConfig("src/main/resources/configs/Extent-Config.xml");
		
		Reporter.setSystemInfo("Browser: ", browser);
		Reporter.setSystemInfo("Usuário Maquina: ", System.getProperty("user.name"));
		Reporter.setSystemInfo("Ambiente: ", "Testes");

	}

}
