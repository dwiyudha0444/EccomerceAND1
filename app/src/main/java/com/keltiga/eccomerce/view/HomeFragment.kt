package com.keltiga.eccomerce.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.keltiga.eccomerce.adapter.SliderAdapter
import com.keltiga.eccomerce.databinding.FragmentHomeBinding
import com.keltiga.eccomerce.viewModel.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var sliderAdapter: SliderAdapter
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

        showSlide()
    }
    private fun showSlide() {
        homeViewModel = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
        homeViewModel.callApi()
        homeViewModel.liveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                // Tampilkan data jika ada
                binding.rvSlider.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                sliderAdapter = SliderAdapter(it) { selectedItem ->
                    Toast.makeText(requireContext(), selectedItem.title, Toast.LENGTH_SHORT).show()
                }
                binding.rvSlider.adapter = sliderAdapter

            } else {
                // Tampilkan pesan bahwa data kosong
                Toast.makeText(requireContext(), "Tidak ada data yang ditemukan.", Toast.LENGTH_SHORT).show()
            }
        })

    }

}
