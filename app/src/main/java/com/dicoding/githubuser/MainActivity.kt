package com.dicoding.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<user>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listuser)
        showRecyclerList()

    }
    private val listuser: ArrayList<user>
        get() {
            val dataName = resources.getStringArray(R.array.name)
            val dataUsername = resources.getStringArray(R.array.username)
            val dataAvatar = resources.obtainTypedArray(R.array.avatar)
            val dataCompany = resources.getStringArray(R.array.company)
            val dataRepository = resources.getStringArray(R.array.repository)
            val dataFollower = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listUsers = ArrayList<user>()
            for (i in dataName.indices) {
                val User = user(
                    dataName[i],
                    dataUsername[i],
                    dataAvatar.getResourceId(i, -1),
                    dataCompany[i],
                    dataRepository[i],
                    dataFollower[i],
                    dataFollowing[i]
                )
                listUsers.add(User)
            }
            return listUsers
        }
    private fun showRecyclerList() {
        rvUser.layoutManager = LinearLayoutManager(this)
        val listUserAdapter = ListUserAdapter(list)
        rvUser.adapter = listUserAdapter
        listUserAdapter.setOnItemClickCallback(object:ListUserAdapter.OnItemClickCallback{
            override fun onItemClicked(data: user) {
                val intent = Intent(this@MainActivity,DetailActivity::class.java)
                intent.putExtra("Data", data)
                startActivity(intent)
            }
        })
    }

}