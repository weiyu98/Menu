package com.example.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.menu.databinding.FragmentEditProfileBinding

/**
 * A simple [Fragment] subclass.
 */
class EditProfile : Fragment() {

    lateinit var handler: AccDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentEditProfileBinding>(inflater,
            R.layout.fragment_edit_profile,container,false)

        var data = handler.retrieveData(GlobalVariable.userID)
        for(i in 0..(data.size-1)){
            binding.editusername.append(data.get(i).username)
            binding.editpass.append(data.get(i).password)
            binding.editemail.append(data.get(i).email)
            binding.editaddress.append(data.get(i).address)
        }

        return binding.root
    }


}
