package org.example;
// importing a package of selenium
import org.openqa.selenium.By;
// importing a package of selenium WebDriver
import org.openqa.selenium.WebDriver;
// importing a package of chromeDriver
import org.openqa.selenium.chrome.ChromeDriver;
//importing a package of testng annotation
import org.testng.annotations.*;
//importing package for date to text format
import java.text.SimpleDateFormat;
//main class
public class HomePage
{
    //Executes before each test method
    @BeforeMethod
    public void openBrowser(){
        //Set the path of the driver for the Chrome Browser
        System.setProperty("webdriver.chrome.driver","src/test/java/Driver/chromedriver.exe");
        //creating object with chromedriver
        driver = new ChromeDriver();
        // To maximize a browser window
        driver.manage().window().maximize();
        //set application URL to navigate
        driver.get("https://demo.nopcommerce.com/");
    }
    //Executes after each test method
    @AfterMethod
    public void closeBrowser(){
       driver.close();
    }
    //creating method for click function
    public void clickOnElement(By by){
        driver.findElement(by).click();
    }
   // The getText() method simply returns the visible text present between the start and end tags
    public String getTextFromElement(By by){
        return driver.findElement(by).getText();
    }
  // creating method with parameter type
    public void typeText(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

    //imported selenium web driver interface using Maven dependency to perform automation task
    protected static WebDriver driver;
    //this is Test method
    @Test
    public void verifyRegistrationPage()
    {
        //returns timeStamp value corresponding to the given string
        String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
        // Click on register link text
        clickOnElement(By.className("ico-register"));
        //By gender field and Click on female radio button
        clickOnElement(By.id("gender-female"));
        //click on FirstName text field and send the value of text
        typeText(By.id("FirstName"),"Priya");
        //click on LastName text field and send the value of text
        typeText(By.id("LastName"),"Patel");
        //click on Dropdown list of day and send the value of text
        typeText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[1]"),"2");
        //click on  Dropdown list of month and send the value of text
        typeText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[2]"),"April");
        //click on Dropdown list of year and send the value of text
        typeText(By.xpath("//div[@class=\"date-picker-wrapper\"]/select[3]"),"1995");
        //click on Email text field and send the value of text
        typeText(By.id("Email"),"test"+timestamp+"@gmail.com");
        // click on Company text field and send the value of text
        typeText(By.id("Company"),"TestCompany");
        //Selecting checkbox of newsletter
        clickOnElement(By.id("Newsletter"));
        //click on password field and type the value of text
        typeText(By.id("Password"),"abcd1234");
        //click on Email ConfirmPassword field and type the value of sendKeys
        typeText(By.id("ConfirmPassword"),"abcd1234");
        // click on register button
        clickOnElement(By.id("register-button"));
        //returns text of the element and store value in  regMsg variable
         String regMsg = getTextFromElement(By.className("result"));
        //printing the value of redMsg
         System.out.println("Result : "+regMsg);
      // closeBrowser();
    }
    @Test
    public void verifyHomePageCategories(){
        //returns text of the element and store value in  Category1 variable
        String Category1 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li//a[@href=\"/computers\"]"));

        //returns text of the element and store value in  Category2 variable
        String Category2 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li//a[@href=\"/electronics\"]"));

        //returns text of the element and store value in  Category3 variable
        String Category3 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li//a[@href=\"/apparel\"]"));

        //returns text of the element and store value in  Category4 variable
        String Category4 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li//a[@href=\"/digital-downloads\"]"));

        //returns text of the element and store value in  Category5 variable
        String Category5 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li//a[@href=\"/books\"]"));

        //returns text of the element and store value in  Category6 variable
        String Category6 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li//a[@href=\"/jewelry\"]"));

        //returns text of the element and store value in  Category7 variable
        String Category7 = getTextFromElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li//a[@href=\"/gift-cards\"]"));

        //printing value of Category1
        System.out.println(Category1);

        //printing value of Category2
        System.out.println(Category2);

        //printing value of Category3
        System.out.println(Category3);

        //printing value of Category4
        System.out.println(Category4);

        //printing value of Category5
        System.out.println(Category5);

        //printing value of Category6
        System.out.println(Category6);

        //printing value of Category7
        System.out.println(Category7);

    }
    @Test
    public void verifyingProduct(){
    // click on computer element
    clickOnElement(By.xpath("//ul[@class=\"top-menu notmobile\"]/li[1]/a"));

    // click on Desktop element
    clickOnElement(By.xpath("//img[@alt=\"Picture for category Desktops\"]"));

    //returns text of the element and store value in  regMsg variable
    String regMsg = getTextFromElement(By.xpath("//div[@class=\"product-grid\"]/div/div/div/div[2]/h2/a[@href=\"/build-your-own-computer\"]"));

    //returns text of the element and store value in  regMsg1 variable
    String redMsg1 =getTextFromElement(By.xpath("//div[@class=\"product-grid\"]/div/div/div/div[2]/h2/a[@href=\"/digital-storm-vanquish-3-custom-performance-pc\"]"));

    //returns text of the element and store value in  regMsg2 variable
    String redMsg2 =getTextFromElement(By.xpath("//div[@class=\"product-grid\"]/div/div/div/div[2]/h2/a[@href=\"/lenovo-ideacentre-600-all-in-one-pc\"]"));

    //printing value of regMsg
    System.out.println(regMsg);

    //printing value of regMsg1
    System.out.println(redMsg1);

    //printing value of regMsg2
    System.out.println(redMsg2);
}
  @Test
    public void verifyyEmailToAFriend(){
      // click on Apple MacBook Pro 13-inch
      clickOnElement(By.xpath("//img[@alt=\"Picture of Apple MacBook Pro 13-inch\"]"));

      //click on email a friend button
      clickOnElement(By.className("email-a-friend"));

      //Click on FriendEmail text field and send the value of text
      typeText(By.id("FriendEmail"),"Test123@gmail.com");
      //Click on YourEmailAddress text field and send value of text
      typeText(By.id("YourEmailAddress"),"abc123@gmail.com");
      //click on PersonalMessage text field and send value of text
      typeText(By.id("PersonalMessage"),"Hope you like a product");
      // click on send email button
      clickOnElement(By.className("buttons"));

      //returns text of the element and store value in msg variable
      String msg =getTextFromElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li"));
      //printing value of msg
      System.out.println(msg);
}
  @Test
    public void verifyNewsCommentsPage(){
      //click on details button
      clickOnElement(By.xpath("//div[@class=\"news-items\"]/div[2]/div[3]/a"));
      //click on Title text field and type value of text
      typeText(By.id("AddNewComment_CommentTitle"),"Laptop");
      //click on Comment text field and type value of text
      typeText(By.id("AddNewComment_CommentText"),"I am very happy to use this product");
      // click on button
      clickOnElement(By.className("buttons"));

      //returns text of the element and store value in  regMsg variable
      String regMsg = getTextFromElement(By.className("result"));
      //printing value of regMsg
      System.out.println(regMsg);
  }


}
