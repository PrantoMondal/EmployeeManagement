package com.example.employeemanagement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController


class EmployeeListFragment : Fragment() {
    private val viewModel: EmployeeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.authLD.observe(viewLifecycleOwner){
            if (it == EmployeeViewModel.Auth.UNAUTHENTICATED){
                findNavController().navigate(R.id.action_employeeListFragment_to_loginFragment)
            }
        }
        return inflater.inflate(R.layout.fragment_employee_list, container, false)
    }


}