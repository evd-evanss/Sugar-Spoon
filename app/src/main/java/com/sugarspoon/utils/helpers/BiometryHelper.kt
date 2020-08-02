package com.sugarspoon.utils.helpers

import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.fragment.app.FragmentActivity
import java.util.concurrent.Executor

/**
 * Created by Evandro Costa 02/08/2020
 */

class BiometryHelper(private val biometricResponse: BiometricResponse,
                     private val executor: Executor,
                     private val fragmentActivity: FragmentActivity) {

    private var prompt: BiometricPrompt? = null

    fun setupHelper() {
        if(checkFeatureBiometric()) {
            prompt = BiometricPrompt(fragmentActivity, executor,
                    object : BiometricPrompt.AuthenticationCallback() {
                        override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                            super.onAuthenticationError(errorCode, errString)
                            biometricResponse.onAuthenticationError()
                        }

                        override fun onAuthenticationSucceeded(
                                result: BiometricPrompt.AuthenticationResult) {
                            super.onAuthenticationSucceeded(result)
                            biometricResponse.onAuthenticationSucceeded()
                        }

                        override fun onAuthenticationFailed() {
                            super.onAuthenticationFailed()
                            biometricResponse.onAuthenticationFailed()
                        }
                    })
        }
    }

    private fun checkFeatureBiometric() =
        when (BiometricManager.from(fragmentActivity).canAuthenticate()) {
        BiometricManager.BIOMETRIC_SUCCESS -> canAuthenticate()
        else -> canNotAuthenticate()
        }

    private fun canAuthenticate() : Boolean {
        biometricResponse.onCheckBiometrics(true)
        return true
    }

    private fun canNotAuthenticate() : Boolean {
        biometricResponse.onCheckBiometrics(false)
        return false
    }


    fun authenticate() {
        prompt?.authenticate(
                BiometricPrompt.PromptInfo.Builder()
                        .setTitle(TITLE)
                        .setSubtitle(SUBTITLE)
                        .setNegativeButtonText(CANCEL)
                        .build()
        )
    }

    companion object {
        const val TITLE = "Confirme sua digital."
        const val SUBTITLE = ""
        const val CANCEL = "Cancelar"
    }

}

interface BiometricResponse {
    fun onCheckBiometrics(enable: Boolean)
    fun onAuthenticationError()
    fun onAuthenticationSucceeded()
    fun onAuthenticationFailed()
}