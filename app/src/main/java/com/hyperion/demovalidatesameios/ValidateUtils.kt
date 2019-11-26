package com.hyperion.demovalidatesameios

object ValidateUtils {

    private const val PASSWORD_MINIMUM_CHARACTER = 8
    private const val PASSWORD_MAXIMUM_CHARACTER = 100
    private const val EMAIL_MINIMUM_CHARACTER = 3
    private const val EMAIL_MAXIMUM_CHARACTER = 100
    private const val STORE_ID_MAXIMUM_CHARACTER = 2000000000

    fun validateEmail(email: String): String {
        if (email.isEmpty()) {
            return "email empty"
        }
        if ((email.length !in EMAIL_MINIMUM_CHARACTER..EMAIL_MAXIMUM_CHARACTER) ||
            (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.trim()).matches())
        ) {
            return "email invalid"
        }
        return ""
    }

    fun validatePassword(password: String): String {
        if (password.isEmpty()) {
            return "email empty"
        }
        if ((password.length !in PASSWORD_MINIMUM_CHARACTER..PASSWORD_MAXIMUM_CHARACTER) ||
            (password.isBlank())
        )
            return "pass invalid"
        return ""
    }
}
