package com.trivago.magazine.hooks;

import com.trivago.magazine.ui.browser.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

   private static Boolean INIT_FRAMEWORK = false;

   @Before
   public void setup() {
      System.out.println("-----------------------");
      // Init driver
      if (!INIT_FRAMEWORK) {
         DriverManager.getInstance();
      }

   }


   @After void tearDown() {
      // TODO open a threat to close the navigator.
   }
}
