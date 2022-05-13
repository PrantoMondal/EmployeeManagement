package com.example.employeemanagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.employeemanagement.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private lateinit var binding : FragmentLoginBinding
    private val viewModel:EmployeeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel.authLD.observe(viewLifecycleOwner){
            if (it == EmployeeViewModel.Auth.AUTHENTICATED){
                findNavController().popBackStack()
            }
        }
        viewModel.errorMsgLD.observe(viewLifecycleOwner){
            binding.errMsgTV.text = it
        }

        binding.loginBtn.setOnClickListener {
            val email = binding.emailInputET.text.toString()
            val password = binding.passwordInputET.text.toString()
        }
        return binding.root
    }


}