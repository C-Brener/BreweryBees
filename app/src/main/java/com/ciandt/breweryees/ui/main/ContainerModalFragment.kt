package com.ciandt.breweryees.ui.main

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.FragmentRatingBinding
import com.ciandt.mytestmodal.BrindeModalFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ModalFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentRatingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRatingBinding.inflate(inflater, container, false)

        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val brindeFragment = BrindeModalFragment()
        val inputEmail = binding.txtEmail
        binding.btnSave.setOnClickListener {
            if (inputEmail.text.toString().isValidEmail()) {
                brindeFragment.show(childFragmentManager, "SHow Fragment")
            }else{
                inputEmail.error = getString(R.string.errorAlert)
            }
        }
    }

    private fun String.isValidEmail() = !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}