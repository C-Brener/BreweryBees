package com.ciandt.breweryees.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.view.WindowManager
import com.ciandt.breweryees.R
import com.ciandt.breweryees.databinding.ActivityDetailsBinding
import com.ciandt.breweryees.databinding.FragmentRatingBinding
import com.ciandt.breweryees.databinding.FragmentRatingErrorBinding
import com.ciandt.breweryees.databinding.FragmentRatingSuccessBinding
import com.ciandt.breweryees.ui.details.DetailsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsBinding
    private val viewModel: DetailsViewModel by viewModel()
    private lateinit var breweriesId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        binding = ActivityDetailsBinding.inflate(layoutInflater)
        breweriesId = intent.getStringExtra("breweriesId").toString()

        binding.btnRating.setOnClickListener{
            showRatingDialog()
        }
    }

    override fun onCreateView(name: String, context: Context, attrs: AttributeSet): View? {
        return super.onCreateView(name, context, attrs)

    }

    private fun showRatingDialog(){
        val dialog = dialog()
        val sheetBind: FragmentRatingBinding = FragmentRatingBinding.inflate(layoutInflater)

        dialog.setContentView(sheetBind.root)
        dialog.show()

        sheetBind.btnSave.setOnClickListener{
            saveRating(sheetBind,dialog)
            dialog.dismiss()
        }
        sheetBind.btnExit.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun saveRating(sheetBind: FragmentRatingBinding, dialog: BottomSheetDialog) {
        val email = sheetBind.txtEmail.text.toString()
        val rating = sheetBind.ratingBar.rating.toDouble()

        viewModel.setRating(email,breweriesId,rating)

        viewModel.setBreweriesRating.observe(this){breweries ->
            if(breweries != null){
                dialogSuccess(dialog)
            }else{
                dialogError(dialog)
            }
        }
    }

    private fun dialog(): BottomSheetDialog{
        return BottomSheetDialog(this, R.style.BottomSheetDialog).apply {
            window?.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE)
        }
    }

    private fun dialogSuccess(dialog: BottomSheetDialog){
        val sheetSuccessBind: FragmentRatingSuccessBinding = FragmentRatingSuccessBinding.inflate(layoutInflater,null,false)
        dialog.setContentView(sheetSuccessBind.root)
        dialog.show()
    }

    fun dialogError(dialog: BottomSheetDialog){
        val sheetErrorBind: FragmentRatingErrorBinding = FragmentRatingErrorBinding.inflate(layoutInflater,null,false)
        dialog.setContentView(sheetErrorBind.root)
        dialog.show()
    }
}