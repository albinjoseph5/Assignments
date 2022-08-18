package com.albin.learningmaven.Assignments;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentsAugust8WithEdge {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		// Basic setup to begin with
		System.setProperty("webdriver.edge.driver", "C:\\Driver\\Edge\\msedgedriver.exe");

		// Opens up the browser
		driver = new EdgeDriver();

		// Load URL on the browser
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

		// Maximize the screen
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(100, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	}

	@Test
	public void purchaseTest() {
		Random randomNumber = new Random();
		WebElement myAccountBtn = driver.findElement(By.cssSelector("#top-links ul.list-inline>li:nth-of-type(2)>a"));
		myAccountBtn.click();

		WebElement registerBtn = driver.findElement(By.cssSelector("#top-links ul.dropdown-menu>li:first-of-type>a"));
		registerBtn.click();

		WebElement firstNameInputField = driver.findElement(By.cssSelector("#input-firstname"));
		firstNameInputField.sendKeys("User");

		WebElement lastNameInputField = driver.findElement(By.cssSelector("#input-lastname"));
		lastNameInputField.sendKeys("Name");

		String randomEmailID = "user" + randomNumber.nextInt(5000) + "@gmail.com";
		WebElement emailInputField = driver.findElement(By.cssSelector("#input-email"));
		emailInputField.sendKeys(randomEmailID);

		WebElement phoneNumberInputField = driver.findElement(By.cssSelector("#input-telephone"));
		phoneNumberInputField.sendKeys("1234567890");

		WebElement passwordInputField = driver.findElement(By.cssSelector("#input-password"));
		passwordInputField.sendKeys("Qwerty123");

		WebElement confirmPasswordInputField = driver.findElement(By.cssSelector("#input-confirm"));
		confirmPasswordInputField.sendKeys("Qwerty123");

		WebElement subscribeYesCheckBox = driver.findElement(By.cssSelector("label.radio-inline:nth-of-type(1) input"));
		subscribeYesCheckBox.click();

		WebElement privacyPolicyBtn = driver.findElement(By.cssSelector("#content div.buttons input:first-of-type"));
		privacyPolicyBtn.click();

		WebElement continueBtn = driver.findElement(By.cssSelector("input.btn.btn-primary"));
		continueBtn.submit();

		WebElement myAccountBtn1 = driver.findElement(By.cssSelector("#top-links ul.list-inline>li:nth-of-type(2)>a"));
		myAccountBtn1.click();

		WebElement logoutBtn = driver
				.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-of-type(5) > a"));
		logoutBtn.click();

		WebElement myAccountBtn2 = driver.findElement(By.cssSelector("#top-links ul.list-inline>li:nth-of-type(2)>a"));
		myAccountBtn2.click();

		WebElement loginBtn = driver.findElement(By.cssSelector("#top-links ul.dropdown-menu>li:last-of-type>a"));
		loginBtn.click();

		WebElement loginEmailInputField = driver
				.findElement(By.cssSelector("#content div.col-sm-6:last-of-type div.form-group:first-of-type input"));
		loginEmailInputField.sendKeys(randomEmailID);

		WebElement loginPasswordInputField = driver
				.findElement(By.cssSelector("#content div.col-sm-6:last-of-type div.form-group:last-of-type input"));
		loginPasswordInputField.sendKeys("Qwerty123");

		WebElement loginSubmitBtn = driver
				.findElement(By.cssSelector("#content div.col-sm-6:last-of-type div.well form>input"));
		loginSubmitBtn.submit();

		WebElement homeBtn = driver.findElement(By.cssSelector("#account-account>ul>li:first-of-type a i"));
		homeBtn.click();

		WebElement macbookAddToCartBtn = driver
				.findElement(By.cssSelector("#content div.row>div:first-of-type button:first-of-type"));
		macbookAddToCartBtn.click();

		WebElement iphoneAddToCartBtn = driver
				.findElement(By.cssSelector("#content div.row>div:nth-of-type(2) button:first-of-type"));
		iphoneAddToCartBtn.click();

		WebElement checkOutBtn = driver.findElement(By.cssSelector("#top-links > ul > li:nth-of-type(5) > a"));
		checkOutBtn.click();

		WebElement billingFirstNameInputField = driver.findElement(By.id("input-payment-firstname"));
		billingFirstNameInputField.sendKeys("User");

		WebElement billingLastNameInputField = driver.findElement(By.id("input-payment-lastname"));
		billingLastNameInputField.sendKeys("User");

		WebElement billingAddressInputField = driver.findElement(By.id("input-payment-address-1"));
		billingAddressInputField.sendKeys("2 Mccowan Rd");

		WebElement billingCityInputField = driver.findElement(By.id("input-payment-city"));
		billingCityInputField.sendKeys("Markham");

		WebElement billingPostalCodeInputField = driver.findElement(By.id("input-payment-postcode"));
		billingPostalCodeInputField.sendKeys("Markham");

		select(driver.findElement(By.id("input-payment-country")), "Canada");
		select(driver.findElement(By.id("input-payment-zone")), "Ontario");

		driver.findElement(By.id("button-payment-address")).click();
		driver.findElement(By.cssSelector("#button-shipping-address")).click();
		driver.findElement(By.id("button-shipping-method")).click();

		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.id("button-payment-method")).click();
		driver.findElement(By.id("button-confirm")).click();
		sleep();
		Assert.assertEquals(driver.findElement(By.cssSelector("#content h1")).getText(), "Your order has been placed!",
				"Text doesnot match");

		WebElement myAccountBtn3 = driver.findElement(By.cssSelector("#top-links ul.list-inline>li:nth-of-type(2)>a"));
		myAccountBtn3.click();

		WebElement logoutBtn1 = driver
				.findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-of-type(5) > a"));
		logoutBtn1.click();
//		sleep();
		Assert.assertEquals(driver.findElement(By.cssSelector("#content h1")).getText(), "Account Logout",
				"Text doesnot match");
	}

	@AfterMethod
	public void teardown() {
		// Close the browser
		driver.close();
	}

	public void sleep() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void select(WebElement element, String selectedElement) {
		Select sc = new Select(element);
		sc.selectByVisibleText(selectedElement);
	}

}
