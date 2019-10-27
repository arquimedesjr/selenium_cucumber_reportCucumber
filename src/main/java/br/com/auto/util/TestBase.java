package br.com.auto.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.vimalselvam.cucumber.listener.Reporter;


public class TestBase {
	private static TestBase testBase;
	private WebDriver driver;
	private WebDriverWait wait;
	private ConfigFileReader read = new ConfigFileReader("src\\main\\resources\\configs\\config.properties");

	public static TestBase getInstance() {
		if (testBase == null) {
			testBase = new TestBase();
		}
		return testBase;
	}
	

	public void setUp() {

		String browser = read.GetPropertyByKey("browserName");

		if (browser.toUpperCase().trim().equals("CHROME")) {
			System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\driver\\chromedriver.exe");
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
//		setGooglePage(PageFactory.initElements(driver, GooglePage.class));
		wait = new WebDriverWait(driver, 5);

	}

	public void url() {
		String url = read.GetPropertyByKey("URL");
		driver.get(url);
	}

	public void validacionObject(By locator) {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		} catch (Exception e) {
			try {
				wait.until(ExpectedConditions.elementToBeClickable(locator));

			} catch (Exception e2) {
				e2.getStackTrace();
			}
		}

	}

	public void click(By by) {
		try {
			validacionObject(by);
			driver.findElement(by).click();
		} catch (Exception e) {

			e.getStackTrace();

		}
	}

	public void sendKeys(By by, String string) {
		try {
			validacionObject(by);
			driver.findElement(by).sendKeys(string);
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public String captureText(By by) {
		String texto = null;
		try {
			validacionObject(by);
			driver.findElement(by).getText();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return texto;
	}

	public boolean visibility(By locator) {
		boolean status = false;
		try {
			status = wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return status;
	}

	public void close() {
		try {
			driver.quit();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

	public void mouseOver(By by, By submenu) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();

		WebElement FirstmenuAdmin = element.findElement(submenu);

		action.moveToElement(FirstmenuAdmin).click().build().perform();
	}

	public void scrollObject(By by) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();

	}

	public void SelectText(By by, String string) {
		validacionObject(by);
		WebElement element = driver.findElement(by);
		new Select(element).deselectByVisibleText(string);
	}

	public void SelectText(By by, int index) {
		validacionObject(by);
		WebElement element = driver.findElement(by);
		new Select(element).deselectByIndex(index);
	}

	public void takeScreenShotTest() {
		File dir = null;
		Date data = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyhhmmss");
		SimpleDateFormat sdfTwo = new SimpleDateFormat("yyyyMMdd");
		String dirReport = "";

		try {
			dir = new File(".\\src\\test\\resources\\Evidencia\\");
			File imagem = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			if (dir.exists()) {
				FileUtils.copyFile(imagem, new File(
						dir.getAbsolutePath() + "//" + sdfTwo.format(data) + "//" + sdf.format(data) + ".png"));
			} else {
				dir.mkdir();
				FileUtils.copyFile(imagem, new File(
						dir.getAbsolutePath() + "//" + sdfTwo.format(data) + "//" + sdf.format(data) + ".png"));
			}
			
			dirReport = dir.getAbsolutePath() + "//" + sdfTwo.format(data) + "//" + sdf.format(data) + ".png";

		} catch (IOException e) {
			e.getStackTrace();

		} finally {

			try {
				Reporter.addScreenCaptureFromPath(dirReport);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
