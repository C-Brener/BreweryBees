package com.ciandt.breweryees.ui.ratedBreweries

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.FragmentInitRatedBreweriesBinding
import com.ciandt.breweryees.ui.main.ResultFragment
import kotlinx.android.synthetic.main.fragment_init_rated_breweries.*

class initRatedBreweriesFragment : Fragment() {
    private var _binding:FragmentInitRatedBreweriesBinding?=null
    private val binding get() = _binding!!
    var emailListner : ((String) -> Unit?)? = null


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
        binding.buttonEmail.setOnClickListener {
            val emailcapture = binding.inputTextRated.getText().toString()
            emailListner?.let { it(emailcapture) }
        }
    }
}