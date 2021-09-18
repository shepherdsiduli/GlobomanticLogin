package com.globomantic.login

import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(Parameterized::class)
class EmailRegexTest(private val email: String, private var isEmail: Boolean) {
    companion object{
        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf("test@globomantics.com", true),
            arrayOf("admin@globomantics.com", true),
            arrayOf("dev@globomantics.com", true),
            arrayOf("1337@globomantics.com", true)
        )
    }
    @Test
    fun test() {
        assert(EMAIL_REGEX.toRegex().containsMatchIn(email) == isEmail)
    }
}