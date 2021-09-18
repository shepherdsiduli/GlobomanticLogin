package com.globomantic.login

import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class MainActivityShould {

    @get:Rule
    val activityRule = ActivityScenarioRule<MainActivity>(
        Intent(ApplicationProvider.getApplicationContext(), MainActivity::class.java)
    )

    @Test
    fun showLoginSuccess_withCorrectCredentials() {
        mainScreen {
            enterEmail("test@globomantics.com")
            enterPassword("test1234")

            clickLoginButton()

            checkSnackbarShown("Login Successful")
        }
    }

    @Test
    fun showLoginFailed_withoutEmail() {
        mainScreen {
            enterPassword("test1234")

            clickLoginButton()

            checkSnackbarShown("Login Failed")
        }
    }

    @Test
    fun showLoginFailed_withoutPassword() {
        mainScreen {
            enterEmail("test@globomantics.com")

            clickLoginButton()

            checkSnackbarShown("Login Failed")
        }
    }
}