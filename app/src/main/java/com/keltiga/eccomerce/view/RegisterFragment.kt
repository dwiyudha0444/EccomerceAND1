package com.keltiga.eccomerce.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.keltiga.eccomerce.databinding.FragmentRegisterBinding
import com.keltiga.eccomerce.network.ApiClient
import com.keltiga.eccomerce.network.ApiResponse
import com.keltiga.eccomerce.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterFragment : Fragment() {
    private lateinit var binding: FragmentRegisterBinding
    private val apiService = ApiClient.create()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val username = binding.etUsername.text.toString()
            val password = binding.etPassword.text.toString()

            // Panggil metode registerUser
            registerUser(username, password)
        }
    }

    private fun registerUser(username: String, password: String) {
        val call = apiService.registerUser(username, password)
        call.enqueue(object : Callback<ApiResponse> {
            override fun onResponse(call: Call<ApiResponse>, response: Response<ApiResponse>) {
                if (response.isSuccessful) {
                    val apiResponse = response.body()
                    if (apiResponse != null && apiResponse.success) {
                        // Registrasi sukses
                        // Lakukan tindakan setelah berhasil mendaftar
                    } else {
                        // Registrasi gagal
                        // Tampilkan pesan kesalahan
                    }
                } else {
                    // Respons tidak berhasil
                    // Tampilkan pesan kesalahan
                }
            }

            override fun onFailure(call: Call<ApiResponse>, t: Throwable) {
                // Kegagalan koneksi atau request
                // Tampilkan pesan kesalahan
            }
        })
    }
}

