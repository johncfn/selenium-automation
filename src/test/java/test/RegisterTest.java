package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.RegisterPage;

public class RegisterTest {
	
	static WebDriver driver;
	static RegisterPage RegisterPage;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:/Users/johnc/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://accounts.google.com/SignUp?hl=pt");
		RegisterPage = new RegisterPage(driver);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {
		RegisterPage.fillInNamePageFields();
		Thread.sleep(2000);
		assertEquals(RegisterPage.NameAndLastNameMessageValidation(), "Digite sua data de nascimento e gênero");
		
		RegisterPage.fillInBithdayFields();
		Thread.sleep(2000);
		assertEquals(RegisterPage.BirthdayMessageValidation(), "Escolha um endereço do Gmail ou crie seu próprio endereço");
		
		RegisterPage.typeAValidEmail();
		Thread.sleep(2000);
		assertEquals(RegisterPage.EmailCreationMessageValidation(), "Crie uma senha forte com uma combinação de letras, números e símbolos");
		
		RegisterPage.typeThePassword();
		Thread.sleep(2000);
		assertEquals(RegisterPage.PasswordNotTheSameMessageValidation(), "As senhas não são iguais. Tente novamente.");
		
	}

}
