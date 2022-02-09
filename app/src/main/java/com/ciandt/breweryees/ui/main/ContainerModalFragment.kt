package com.ciandt.mytestmodal

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ciandt.breweryees.databinding.FragmentModalBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ModalFragment : BottomSheetDialogFragment() {
    private var _binding: FragmentModalBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentModalBinding.inflate(inflater, container, false)

        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val brindeFragment = BrindeModalFragment()
        val inputEmail = binding.emailAddress
        binding.ButtonSave.setOnClickListener {
            if (inputEmail.text.toString().isValidEmail()) {
                brindeFragment.show(childFragmentManager, "SHow Fragment")
            }else{
                inputEmail.error = "Email Invalid"
            }
        }
    }

    private fun String.isValidEmail() = !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
}