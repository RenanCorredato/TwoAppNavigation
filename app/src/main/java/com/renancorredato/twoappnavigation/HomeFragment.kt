package com.renancorredato.twoappnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.renancorredato.twoappnavigation.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSend.setOnClickListener {

            if(binding.edtProductId.text.isEmpty()){
                binding.edtProductId.error = "Preencha o id do produto"
                binding.edtProductId.requestFocus()
                return@setOnClickListener
            }


            val bundle = bundleOf(
                "ID" to binding.edtProductId.text.toString().toInt()
            )

            findNavController().navigate(
                R.id.action_homeFragment_to_productDetails,
                bundle
            )
        }
    }
}