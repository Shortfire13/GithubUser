package com.dicoding.githubuser

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var username: TextView
    private lateinit var avatar: ImageView
    private lateinit var company: TextView
    private lateinit var repository: TextView
    private lateinit var follower: TextView
    private lateinit var following: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val data = intent.getParcelableExtra<user>("Data")
        Log.d("data", data?.name.toString())
        tvName = tvName.findViewById(R.id.detail_name)
        username = username.findViewById(R.id.detail_username)
        avatar = avatar.findViewById(R.id.detail_avatar)
        company = company.findViewById(R.id.detail_corporoation)
        repository = repository.findViewById(R.id.detail_repository)
        follower = follower.findViewById(R.id.detail_follower)
        following = following.findViewById(R.id.detail_following)


        tvName.text = data?.name.toString()
        username.text = data?.username.toString()
        if (data != null) {
            avatar.setImageDrawable(getDrawable(data.avatar))
        }
        company.text = data?.company.toString()
        repository.text = data?.repository.toString()
        follower.text = data?.follower.toString()
        following.text = data?.following.toString()
    }
}