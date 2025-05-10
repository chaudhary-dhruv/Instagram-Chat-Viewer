package com.example.instachatviewer.ui.screens.chat

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.instachatviewer.adapter.UserListAdapter
import com.example.instachatviewer.databinding.ActivityUserListBinding
import com.example.instachatviewer.ui.screens.ChatActivity

class UserListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Sample users
        val userNames = listOf("Naruto", "Sasuke", "Sakura", "Kakashi", "Itachi")

        val adapter = UserListAdapter(userNames) { selectedUser ->
            val intent = Intent(this, ChatActivity::class.java)
            intent.putExtra("userName", selectedUser)
            startActivity(intent)
        }

        binding.userRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.userRecyclerView.adapter = adapter
    }
}
