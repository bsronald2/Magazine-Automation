package com.trivago.magazine.hooks;

import com.trivago.magazine.ui.browser.DriverManager;
import com.trivago.magazine.ui.pages.MagazineHomePage;
import com.trivago.magazine.ui.pages.PageNavigator;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class Hooks {

   private static Boolean INIT_FRAMEWORK = false;
   private final static Logger logger = LogManager.getLogger(Hooks.class);
   private String parentWindowHandle;
   public Hooks() {

   }

   @Before
   public void setup() {
      // Init driver
      parentWindowHandle = DriverManager.getInstance().getDriver().getWindowHandle();
      if (!INIT_FRAMEWORK) {
         INIT_FRAMEWORK = true;
         new MagazineHomePage();
         // open a new thread that close web-browser at the end
         cleanEnvironment();
      }
   }


   @After
   void tearDown() {
   }

   @After(value = "@HomePage", order = 10)
   public void navigateToHomePage() {
      PageNavigator.getInstance().magazineHomePage();
   }

   @After(value="@CloseChildWindows", order= 11)
   public void closeChildWindows() {
      WebDriver driver = DriverManager.getInstance().getDriver();
      List<String> handles = new ArrayList<>(driver.getWindowHandles());
      for (String handle: handles) {
         if (!(handle.equals(parentWindowHandle))) {
            driver.switchTo().window(handle);
            driver.close();
         }
      }
      driver.switchTo().window(parentWindowHandle);
   }

   /**
    * Close web browser after all test executions.
    */
   public void cleanEnvironment() {
      // After execution
      Runtime.getRuntime().addShutdownHook(new Thread() {
         @Override
         public void run() {
            DriverManager.getInstance().getDriver().close();
            logger.info("Close Web Browser.");
         }
      });
   }
}
