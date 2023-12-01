package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage {
	
	static WebDriver driver;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void fillInNamePageFields() {
		//type the name on the Name field
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.sendKeys("My test");
		
		//type the last name on the Last Name field
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.sendKeys("Last Name");
		
		//click on the Next button
		WebElement buttonNext = driver.findElement(By.id("collectNameNext"));
		buttonNext.click();		
	}
	
	public void fillInBithdayFields() {
		WebElement day = driver.findElement(By.id("day"));
		day.sendKeys("14");
		
		Select month = new Select(driver.findElement(By.id("month")));
		month.selectByVisibleText("Abril");
		
		WebElement year = driver.findElement(By.id("year"));
		year.sendKeys("1993");
		
		Select gender = new Select(driver.findElement(By.xpath("//select[@id='gender']")));
		gender.selectByVisibleText("Masculino");
		
		WebElement buttonNext = driver.findElement(By.xpath("//span[contains(text(),'Próxima')]"));
		buttonNext.click();
	}
	
	public void typeAValidEmail() {
		WebElement selectToCreateAnEmail = driver.findElement(By.id("selectionc2"));
		boolean selectState = selectToCreateAnEmail.isSelected();
		
		if(selectState == false) {
			selectToCreateAnEmail.click();
		}
		
		WebElement email = driver.findElement(By.name("Username"));
		email.sendKeys("myTest321email");
		
		WebElement buttonNext = driver.findElement(By.xpath("//span[contains(text(),'Próxima')]"));
		buttonNext.click();
	}
	
	public void typeThePassword() {
		WebElement password = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
		password.sendKeys("1234567abc!@#");
		
		WebElement confirmPassword = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]"));
		confirmPassword.sendKeys("1234567abc!@");
		
		WebElement showPassword = driver.findElement(By.xpath("//body/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[1]/section[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
		showPassword.click();
		
		WebElement buttonNext = driver.findElement(By.xpath("//span[contains(text(),'Próxima')]"));
		buttonNext.click();
	}
	
	//get the message for the next page to validate if it work
	public String NameAndLastNameMessageValidation() {
		return driver.findElement(By.xpath("//span[contains(text(),'Digite sua data de nascimento e gênero')]")).getText();
	}
	
	public String BirthdayMessageValidation() {
		return driver.findElement(By.xpath("//span[contains(text(),'Escolha um endereço do Gmail ou crie seu próprio endereço')]")).getText();
	}
	
	public String EmailCreationMessageValidation() {
		return driver.findElement(By.xpath("//span[contains(text(),'Crie uma senha forte com uma combinação de letras,')]")).getText();
	}
	
	public String PasswordNotTheSameMessageValidation() {
		return driver.findElement(By.xpath("//span[contains(text(),'As senhas não são iguais. Tente novamente.')]")).getText();
	}

}
