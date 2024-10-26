package com.prathameshkumbhar.cooksy.feature.auth.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VerifyOtpViewModel @Inject constructor() : ViewModel() {
    private val _otpLiveData = MutableLiveData<String>()
    val otpLiveData: LiveData<String> = _otpLiveData

    fun setOtp(otp: String) {
        _otpLiveData.value = otp
    }
}