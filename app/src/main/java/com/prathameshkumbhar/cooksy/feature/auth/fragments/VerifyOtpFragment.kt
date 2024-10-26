package com.prathameshkumbhar.cooksy.feature.auth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.prathameshkumbhar.cooksy.databinding.FragmentVerifyOtpBinding
import com.prathameshkumbhar.cooksy.feature.auth.viewmodel.VerifyOtpViewModel
import com.prathameshkumbhar.cooksy.service.SmsReceiverService
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VerifyOtpFragment : Fragment() {
    private lateinit var binding: FragmentVerifyOtpBinding
    private val verifyOtpViewModel: VerifyOtpViewModel by viewModels()
    private lateinit var smsBroadcastReceiver: SmsReceiverService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setupSmsReceiver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVerifyOtpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUi()
        setupObservers()
    }

    private fun setupUi() {
      //  setupOtpInputs()
    }

    private fun setupObservers() {
        verifyOtpViewModel.otpLiveData.observe(viewLifecycleOwner) { otp ->
           // setOtpToEditTexts(otp)
        }
    }

/*
    private fun setupOtpInputs() {
        with(binding.otpView) {
            val otpDigits = listOf(
                otpDigit1, otpDigit2, otpDigit3,
                otpDigit4, otpDigit5, otpDigit6
            )

            otpDigits.forEachIndexed { index, editText ->
                editText.addTextChangedListener(object : TextWatcher {
                    override fun afterTextChanged(s: Editable?) {
                        if (s?.length == 1 && index < otpDigits.size - 1) {
                            otpDigits[index + 1].requestFocus()
                        }
                    }

                    override fun beforeTextChanged(
                        s: CharSequence?, start: Int, count: Int, after: Int
                    ) {
                    }

                    override fun onTextChanged(
                        s: CharSequence?, start: Int, before: Int, count: Int
                    ) {
                    }
                })

                // Handle paste event
                editText.onPasteListener = { pastedText ->
                    if (pastedText.length == 6) {
                        setOtpToEditTexts(pastedText)
                    }
                }
            }
        }
    }

    private fun setOtpToEditTexts(otp: String) {
        with(binding.otpView) {
            if (otp.length == 6) {
                otpDigit1.setText(otp[0].toString())
                otpDigit2.setText(otp[1].toString())
                otpDigit3.setText(otp[2].toString())
                otpDigit4.setText(otp[3].toString())
                otpDigit5.setText(otp[4].toString())
                otpDigit6.setText(otp[5].toString())
            }
        }
    }

    private fun setupSmsReceiver() {
        smsBroadcastReceiver = SmsReceiverService().apply {
            otpReceivedListener = { otp ->
                verifyOtpViewModel.setOtp(otp)
            }
        }

        val intentFilter = IntentFilter(SmsRetriever.SMS_RETRIEVED_ACTION)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            ContextCompat.registerReceiver(
                requireActivity(),
                smsBroadcastReceiver,
                intentFilter,
                ContextCompat.RECEIVER_NOT_EXPORTED
            )
        } else {
            requireActivity().registerReceiver(smsBroadcastReceiver, intentFilter)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        requireActivity().unregisterReceiver(smsBroadcastReceiver)
    }
*/

}