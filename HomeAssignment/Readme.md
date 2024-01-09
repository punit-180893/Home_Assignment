### practice.automationtesting.in WebSite Automation Suite Information:-

##### To run the practice.automationtesting.in  Automation project folder
- `Maven test:- Right click on maven project > Run As >Maven test`  
or  
- `TestNG Test:- Right click on maven project > Run As > TestNG Test `   
or    
- ` Right Click on testng.xml file > Run As > TestNG Test`

##### TestNG File Description
* testng.xml - Define the test related to all pages.  
   
##### Package Description
- ** extentreport ** - All extent Report classes are available.
- ** pages ** - Defining all the pages.
- ** testnglisteners **- TestNg listener class.
- ** utils ** - Defining all the utility classes are here.
- ** tests ** - Defining all the tests and assertions.
  
##### Tests Files Description
+  ** BaseTest:- ** The main class which defines to open the browser and lunch the url of the test  and close the browser 					driver.
  
+ ** LoginTest:- ** Includes test - to verify loginPage,Account details page, BillingAddressPage, order page ,shipping 					Address page and logout page accessing data from excel sheet .  
+ ** MyAccountTest:- ** Includes test - to verify My account page.
+ ** ShopTest:- ** Includes test - to verify shop page.  
     

##### Other File Description
+ AccountDetailsPage.java: Defines all the functions of AccountDetailsTest.  
+ BillingAddressPage.java: Defines all the function of BillingAddressTest.  
+ LoginPage.java: Defines all the functions of LoginTest.
+ LogOutPage.java: Defines all the functions of LogOutTest.
+ MyAccountPage.java: Defines all the functions of MyAccountTest.
+ OrderPage.java: Defines all the functions of OrderTest;
+ ShippingAddressPage.java: Defines all the functions of shippingAdrressTest.
+ ShopPage.java: Defines all the functions of ShopTest.
+ TakeScreenShotsClass.java: Defines all the functions of taking Screenshots.
+ pom.xml: Defines all the dependency files are available.
+ dataProvider.properties: Defines all the browser's name, drivers and URL.
+ testData.xlsx: Defines all the data which passes in test suite.


##### Reports and Screenshots
+ Extent Report gets generated after the run under "\Reports\index.html"
+ TestNG Report as "emailable-report.html"  gets generated under "\test-output"
+ Screenshot gets placed under "\Screenshots" folder with TestName and date and time.
+ Log file generated in "logs" folder.

##### Limitations and Pre-Conditions
+ Ads are closed manually.(if not use optionChrome as a browser name)
+ For parallel test suite make a change on the testng.xml file `parallel="false"` to `parallel="classes"`