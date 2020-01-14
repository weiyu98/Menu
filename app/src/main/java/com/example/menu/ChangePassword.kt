package com.example.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.menu.databinding.FragmentChangePasswordBinding
import com.example.menu.databinding.FragmentEditProfileBinding

/**
 * A simple [Fragment] subclass.
 */
class ChangePassword : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentChangePasswordBinding>(inflater,
            R.layout.fragment_change_password,container,false)

        return binding.root
    }


}
