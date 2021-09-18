package com.globomantic.login

import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.globomantic.login.MainActivityInteractions.emailEditText
import com.globomantic.login.MainActivityInteractions.loginButton
import com.globomantic.login.MainActivityInteractions.passwordEditText
import com.globomantic.login.MainActivityInteractions.snackbar

fun mainScreen(block: MainActivityRobot.() -> Unit): MainActivityRobot{
    return MainActivityRobot().apply { block() }
}
class MainActivityRobot {
    fun enterEmail(email: String){
        emailEditText().perform(typeText(email))
    }

    fun enterPassword(password: String){
        passwordEditText().perform(typeText(password))
    }

    fun clickLoginButton(){
//        loginButton().perform(scrollTo())
        loginButton().perform(click())
    }

    fun checkSnackbarShown(text: String){
        snackbar().check(matches(withText(text)))
    }
}