package com.example.hotelreservationsystem.Fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
<<<<<<< HEAD
=======
import android.util.Log
>>>>>>> bikash
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
<<<<<<< HEAD
import androidx.lifecycle.whenResumed
=======
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
>>>>>>> bikash
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.hotelreservationsystem.Models.HotelRequest

import com.example.hotelreservationsystem.R
import com.example.hotelreservationsystem.ViewModels.AuthViewModel
import com.example.hotelreservationsystem.ViewModels.HotelViewModel

import com.example.hotelreservationsystem.databinding.FragmentOwnerProfileBinding
import com.example.hotelreservationsystem.utils.NetworkResult
import com.example.hotelreservationsystem.utils.constants.TAG
import dagger.hilt.android.AndroidEntryPoint
import java.lang.Exception
@AndroidEntryPoint

class OwnerProfileFragment : Fragment() {
<<<<<<< HEAD
    private var selectedImageri: Uri?= null
    lateinit var  binding: FragmentOwnerProfileBinding
=======

    lateinit var binding: FragmentOwnerProfileBinding

    private var selectedImageri: Uri?= null
    private val authViewModel by viewModels<AuthViewModel> ()
    private val hotelViewModel by viewModels<HotelViewModel>()

>>>>>>> bikash



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOwnerProfileBinding.inflate(
            layoutInflater, container, false
        )
        // Inflate the layout for this fragment

<<<<<<< HEAD
        binding.addImage1.setOnClickListener()
        {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 4)
        }
=======


        // want to get owner id over here now


        binding.addhotel.setOnClickListener() {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, 3)
        }


>>>>>>> bikash
        binding
            .updateHotel.setOnClickListener {

                try {
                    hotelViewModel.createHotel(
                        "646af3f7af578d1470b81ecd",
                        HotelRequest(
                            "Trojan Hotel BIkash ",
                            "Bikash Test",
                            "this is one of the Hotel  in the asia "
                        )
                    )
                } catch (e: Exception) {
                    Toast.makeText(requireContext(), "${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
<<<<<<< HEAD


=======
        bindObservers()
>>>>>>> bikash
        return binding.root
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {

            if (requestCode == 4) {
                val selectedimage: Uri? = data.data;
                binding.image1.setImageURI(selectedimage);

            }


<<<<<<< HEAD
        }


    }
}
=======
    private fun bindObservers() {
        hotelViewModel.statusLiveData.observe( viewLifecycleOwner, Observer {
            binding.progressBar.isVisible= false
            when(it) {
                is NetworkResult.Success -> {
                    Toast.makeText(
                        requireContext(),
                        it.message,
                        Toast.LENGTH_LONG
                    ).show()
               findNavController().navigate(R.id.action_ownerProfileFragment_to_ownerHomeFragment)

                }

                is NetworkResult.Error -> {
                    Log.d(TAG,it.message.toString())

                }

                is  NetworkResult.Loading->{
                    binding.progressBar.isVisible = true

                }

            }


        })

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && data != null) {
            if (requestCode == 3) {
                val selectedimage: Uri? = data.data;
                binding.image1.setImageURI(selectedimage);
            }


        }

    }


}


>>>>>>> bikash
