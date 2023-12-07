package com.example.appv3.main

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.appv3.banco_de_dados.User
import com.example.appv3.banco_de_dados.UserDao



class Verification(private val userDao: UserDao)  {
    
    fun authenticate(username: String, email: String, passwd: String): Boolean{
        val db: LiveData<User> = userDao.get(username)

        if (db != null){
            return false
        }
        else {
            val user: User
            user = User(username = username,email = email, passwd = passwd)
            userDao.insert(user)
            return true
        }


    }

    fun signUp(email: String, passwd: String): Boolean {
        var bool: Boolean
        bool = false
        val db: LiveData<List<User>> = userDao.getAll()
        db.observe(this, Observer { users ->
            users?.let {
                for (user in users){
                    if (user.email == email && user.passwd == passwd){
                        bool = true

                    }
                else{}
                }
                }
            })
        return bool
        }


}

private fun <T> LiveData<T>.observe(verification: Verification, observer: Observer<T>) {

}

