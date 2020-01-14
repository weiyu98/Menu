package com.example.menu


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.menu.GlobalVariable.userID
import com.example.menu.databinding.FragmentEditProfileBinding
import kotlinx.android.synthetic.main.fragment_edit_profile.*

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

        handler = AccDatabase(binding.root.context)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var data = handler.retrieveData(userID)
        for(i in 0..(data.size-1)){
            editusername.append(data.get(i).username)
            editpass.append(data.get(i).password)
            editemail.append(data.get(i).email)
            editaddress.append(data.get(i).address)
        }

        edit_button.setOnClickListener {
            if (editpass.text.toString().isNotEmpty()) {
                    if (editemail.text.toString().isNotEmpty() && editaddress.text.toString().isNotEmpty()) {
                        handler.editProfile(editusername.text.toString(), editpass.text.toString(), editemail.text.toString(), editaddress.text.toString())
                        Toast.makeText(activity, "Edit Profile Successful", Toast.LENGTH_SHORT).show()
                    }else {
                        Toast.makeText(activity, "Email & Address cannot be empty", Toast.LENGTH_SHORT).show()
                    }
            } else
                Toast.makeText(activity, "Password cannot be empty", Toast.LENGTH_SHORT).show()
        }
    }


}
