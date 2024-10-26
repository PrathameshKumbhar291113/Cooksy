package com.prathameshkumbhar.cooksy.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.auth.api.phone.SmsRetriever
import com.google.android.gms.common.api.CommonStatusCodes
import com.google.android.gms.common.api.Status
import java.util.regex.Pattern

class SmsReceiverService : BroadcastReceiver() {
    var otpReceivedListener: ((String) -> Unit)? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        if (SmsRetriever.SMS_RETRIEVED_ACTION == intent?.action) {
            val extras = intent.extras

            val status: Status? = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
                extras?.getParcelable(SmsRetriever.EXTRA_STATUS, Status::class.java)
            } else {
                @Suppress("DEPRECATION")
                extras?.getParcelable(SmsRetriever.EXTRA_STATUS)
            }

            if (status?.statusCode == CommonStatusCodes.SUCCESS) {
                val message = extras?.getString(SmsRetriever.EXTRA_SMS_MESSAGE) // Use getString for message
                val otp = extractOtp(message)
                otp?.let { otpReceivedListener?.invoke(it) }
            }
        }
    }

    private fun extractOtp(message: String?): String? {
        val otpPattern = Pattern.compile("\\d{6}")
        val matcher = otpPattern.matcher(message ?: "")
        return if (matcher.find()) matcher.group(0) else null
    }
}


