package com.ciandt.breweryees.ui.ratedBreweries

import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ciandt.breweryees.databinding.FragmentInitRatedBreweriesBinding

class initRatedBreweriesFragment : Fragment() {
    private var _binding:FragmentInitRatedBreweriesBinding?=null
    private val binding get() = _binding!!
    var emailListener : ((String) -> Unit?)? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInitRatedBreweriesBinding.inflate(inflater,container,false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun String.isValidEmail() = !TextUtils.isEmpty(this) && Patterns.EMAIL_ADDRESS.matcher(this).matches()
        val inputEmail = binding.checkRatedEmail

        binding.buttonEmail.setOnClickListener {

            if(inputEmail.text.toString().isValidEmail()){
                val emailcapture = binding.inputTextRated.getText().toString()
                emailListener?.let { it(emailcapture) }
            }else{
                inputEmail.error="Email Invalid"
            }

        }
    }

}