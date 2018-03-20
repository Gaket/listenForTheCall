package ru.gaket.testbroadcast;

import android.app.Application;
import android.util.Log;

/**
 * @author Artur Badretdinov (Gaket) 14.03.2018
 */
public class TestApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    Log.i("TestApp", "We are in onCreate!");

  }
}
