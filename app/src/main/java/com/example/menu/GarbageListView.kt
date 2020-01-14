package com.example.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.menu.databinding.FragmentGarbageListViewBinding

/**
 * A simple [Fragment] subclass.
 */
class GarbageListView : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGarbageListViewBinding>(inflater,
            R.layout.fragment_garbage_list_view,container,false)

        
        return binding.root
    }


}
