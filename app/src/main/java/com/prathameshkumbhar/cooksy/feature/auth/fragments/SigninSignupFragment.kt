package com.prathameshkumbhar.cooksy.feature.auth.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.prathameshkumbhar.cooksy.databinding.FragmentSigninSignupBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SigninSignupFragment : Fragment() {
    private lateinit var binding: FragmentSigninSignupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSigninSignupBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


}