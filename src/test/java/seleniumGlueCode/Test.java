package seleniumGlueCode;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Test {

    protected ChromeDriver driver;

    @Given("^The user is navigates on the SUT page$")
    public void the_user_is_navigates_on_the_SUT_page() throws Throwable {
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://staging-zapatoca.miaguila.com/registro/?hidecaptcha=true");
    }

    @When("^Clik on guest mode$")
    public void clik_on_guest_mode() throws InterruptedException {

        //Address//
        WebElement inAddress = driver.findElement(
                By.xpath("/html/body/div/div/div/div[1]/div[2]/div[2]/div[3]/div[2]"));
        inAddress.click();
        Thread.sleep(3000);

        WebElement city = driver.findElement(
                By.xpath("//input[@class='autocomplete-input']"));
        city.sendKeys("Bogotá");
        driver.findElement(By.xpath("//li[@id='autocomplete-item-0']")).click();
        // City selected.

        //Way//
        Select way = new Select (driver.findElement(By.xpath("//select[1]")));
        way.selectByIndex(1);
        // Way selected
        Thread.sleep(500);
        driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']" +
                        "/div[@class='main-theme bg-default-snow']/div[@class='location z-200']" +
                        "/div[@class='w-full max-w-md']/form[@class='form card bg-white mx-auto px-0 " +
                        "pt-0 pb-8 max-h-screen overflow-auto']/div[@class='form-content flex flex-col " +
                        "items-center justify-center px-4']/div[3]/div[2]/div[1]/div[1]/input[1]"))
                .sendKeys("104");
        Thread.sleep(500);
        driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']" +
                        "/div[@class='main-theme bg-default-snow']/div[@class='location z-200']" +
                        "/div[@class='w-full max-w-md']/form[@class='form card bg-white mx-auto px-0 " +
                        "pt-0 pb-8 max-h-screen overflow-auto']/div[@class='form-content flex flex-col " +
                        "items-center justify-center px-4']/div[@class='w-full mb-4 grid gap-2 grid-cols-2']" +
                        "/div[1]/div[1]/div[1]/input[1]"))
                .sendKeys("152a");
        Thread.sleep(500);
        driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']" +
                        "/div[@class='main-theme bg-default-snow']/div[@class='location z-200']" +
                        "/div[@class='w-full max-w-md']/form[@class='form card bg-white mx-auto px-0 pt-0 " +
                        "pb-8 max-h-screen overflow-auto']/div[@class='form-content flex flex-col items-center " +
                        "justify-center px-4']/div[4]/div[2]/div[1]/div[1]/input[1]"))
                .sendKeys("55");
        Thread.sleep(500);

        //Button search//
        WebElement search = driver.findElement(
                By.xpath("//button[@class='button text-white text-sm rounded-lg uppercase font-semi-bold w-full h-11']"));
        search.click();
        // Play search.

        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[2]/div[4]/div/div/input"))
                .sendKeys("piso 1");

        Thread.sleep(500);
        //Button save//
        WebElement save = driver.findElement(
                By.xpath("//button[@class='button text-white text-sm rounded-lg uppercase font-semi-bold " +
                        "btn-confirm mt-6 w-full mx-auto block px-6 py-3']"));
        save.click();
        //saved
        WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Inicia sesión')]"));
        login.click();
        Thread.sleep(4000);
        WebElement takeMode = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/" +
                "div[4]/div[1]/div[3]/div[1]/div[2]/a[1]"));
        takeMode.click();
        Thread.sleep(4000);
    }

    @When("^searches for soap$")
    public void searches_for_soap() throws InterruptedException {
        WebElement search = driver.findElement(By.xpath("//body/div[@id='__nuxt']/div[@id='__layout']" +
                "/div[1]/div[1]/div[2]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"));
        search.sendKeys("jabón");
        search.sendKeys(Keys.ENTER);
        Thread.sleep(8000);
    }

    @When("^filter by cleanliness home$")
    public void filter_by_cleanliness_home() throws Throwable {
        WebElement clFilter = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div[2]/div[1]/div/div[1]/ul/li[3]/input"));
        clFilter.click();
        Thread.sleep(4000);
    }

    @When("^selects five items$")
    public void selects_five_items() throws Throwable {
        WebElement add1 = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div[2]/div[2]/div/div[2]/div[2]/div/a"));
        add1.click();
        Thread.sleep(2000);

        WebElement oneMore = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div[3]/div/div[2]/div[4]/div/input"));
        oneMore.clear();
        oneMore.sendKeys("2");

        WebElement addButton = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div[3]/div/div[2]/div[4]/button"));
        addButton.click();

        WebElement xButton = driver.findElement(
                By.xpath("/html/body/div/div/div/div[3]/div[1]"));
        xButton.click();
        Thread.sleep(3000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("window.scroll(0,400)");
        //Thread.sleep(2000);

        WebElement add2 = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div[3]/section/div[2]/div[2]/div/div[1]/div/div/div/a"));
        add2.click();
        Thread.sleep(2000);

        WebElement oneMore2 = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div[3]/div/div[2]/div[4]/div/input"));
        oneMore2.clear();
        oneMore2.sendKeys("3");
        Thread.sleep(1000);

        WebElement addButton2 = driver.findElement(
                By.xpath("/html/body/div/div/div/div[2]/div[4]/div[3]/div/div[2]/div[4]/button"));
        addButton2.click();

        WebElement endPurch = driver.findElement(
                By.xpath("/html/body/div/div/div/div[3]/div[2]/div[3]/button[1]"));
        endPurch.click();
        Thread.sleep(3000);

        WebElement endPop = driver.findElement(
                By.xpath("/html/body/div/div/div/div[1]/div/div[2]/button"));
        endPop.click();
        Thread.sleep(5000);

        WebElement resume = driver.findElement(
                By.xpath("/html/body/div/div/div/div[3]/div/section[2]/article/h2"));
        Assert.assertTrue(resume.getText().contains("Resumen del pedido"));
        // Verify content of procces.

        js.executeScript("window.scroll(0,800)");

    }

    @Then("^the user add it to the cart$")
    public void the_user_add_it_to_the_cart() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

}
