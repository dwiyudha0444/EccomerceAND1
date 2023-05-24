package com.keltiga.eccomerce.view

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.keltiga.eccomerce.R
import com.keltiga.eccomerce.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var sharedpref: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvRegister.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
        data()
    }
    fun data(){

        binding.btnLogin.setOnClickListener {
            val sharedpref = context?.getSharedPreferences("dataUser", Context.MODE_PRIVATE)
            val userN = binding.etUsername.text.toString()
            val pass = binding.etPass.text.toString()
            val dataPass = sharedpref?.getString("password", "")
            val dataUserName = sharedpref?.getString("userName", "")
            if(userN == dataUserName && pass == dataPass){
                findNavController().navigate(R.id.action_loginFragment_to_homeFragment2)
            }else{
                Toast.makeText(context,"Password atau Username Salah", Toast.LENGTH_LONG).show()
            }
        }
    }
}