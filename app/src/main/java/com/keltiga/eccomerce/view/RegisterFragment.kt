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
import com.keltiga.eccomerce.databinding.FragmentRegisterBinding

class RegisterFragment : Fragment() {
    lateinit var binding: FragmentRegisterBinding
    lateinit var sharedpref: SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentRegisterBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedpref = requireContext().getSharedPreferences("dataUser", Context.MODE_PRIVATE)
        binding.btnReg.setOnClickListener {
            val nama = binding.etName.text.toString()
            val username = binding.etUsername.text.toString()
            val password = binding.etPass.text.toString()
            val uPassword = binding.etConfpass.text.toString()
            if(password == uPassword){
                val a = sharedpref.edit()
                a.putString("nama", nama)
                a.putString("userName", username)
                a.putString("password", password)
                a.apply()
                findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
                Toast.makeText(context,"Berhasil Regist", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(context,"Password harus sama", Toast.LENGTH_LONG).show()
            }
        }


    }

}