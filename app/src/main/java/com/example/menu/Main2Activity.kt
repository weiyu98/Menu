package com.example.menu

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_register.*


class Main2Activity : AppCompatActivity() {

    lateinit var handler: AccDatabase

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")
      //  val binding = DataBindingUtil.setContentView<ActivityMain2Binding>(this, R.layout.activity_main2)
        handler = AccDatabase(this)

        setContentView(R.layout.fragment_login)

        txtSignup.setOnClickListener{
            setContentView(R.layout.fragment_register)
            sign_button.setOnClickListener {
                if(username.text.toString().isNotEmpty()){
                    if (handler.verifyUsername(username.text.toString())) {
                        if (pass.text.toString().isNotEmpty()) {
                            if (pass.text.toString() == password.text.toString()) {
                                if (email.text.toString().isNotEmpty()) {
                                    handler.insertUserData(username.text.toString(), pass.text.toString(), email.text.toString(), address.text.toString())
                                    Toast.makeText(this, "Register Successful", Toast.LENGTH_SHORT).show()
                                    setContentView(R.layout.fragment_login)
                                    loginToMenu()
                                } else {
                                    Toast.makeText(this, "Email cannot be empty", Toast.LENGTH_SHORT).show()
                                }
                            } else
                                Toast.makeText(this, "Incorrect Confirm Password", Toast.LENGTH_SHORT).show()
                        } else
                            Toast.makeText(this, "Password cannot be empty", Toast.LENGTH_SHORT).show()
                    } else
                        Toast.makeText(this, "Username Been Used", Toast.LENGTH_SHORT).show()
                } else
                    Toast.makeText(this, "Username cannot be empty", Toast.LENGTH_SHORT).show()
            }

            textView5.setOnClickListener{
                setContentView(R.layout.fragment_login)
                loginToMenu()
            }
        }
        loginToMenu()
    }

    private fun loginToMenu(){
        loginbtn.setOnClickListener {
            if (login_username.text.toString().isNotEmpty() && login_pass.text.toString().isNotEmpty()) {
                if (handler.userLogin(login_username.text.toString(), login_pass.text.toString())) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    GlobalVariable.userID = login_username.text.toString()
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                } else {
                    Toast.makeText(this, "Username Or Password Incorrect, Please enter again~", Toast.LENGTH_SHORT).show()
                }
            }else
                Toast.makeText(this, "Username and Password cannot be empty", Toast.LENGTH_SHORT).show()
        }
    }

}
