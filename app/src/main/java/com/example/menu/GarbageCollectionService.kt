package com.example.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.menu.databinding.FragmentGarbageCollectionBinding
import com.example.menu.databinding.FragmentPracticalBinding

class GarbageCollectionService : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGarbageCollectionBinding>(inflater,
            R.layout.fragment_garbage_collection,container,false)

        binding.btnRequest.setOnClickListener {

            val recipient = "aunzx-wm17@student.tarc.edu.my"
            val subject = "Garbage Collection Service Request"
            val message = "Hello Piggy!!"

    //        sendEmail(recipient, subject, message)
        }

        return binding.root
    }
}