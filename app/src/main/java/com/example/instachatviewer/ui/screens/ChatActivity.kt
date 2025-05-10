package com.example.instachatviewer.ui.screens

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instachatviewer.R
import com.example.instachatviewer.adapter.MessageAdapter
import com.example.instachatviewer.model.Message
import java.text.SimpleDateFormat
import java.util.*

class ChatActivity : AppCompatActivity() {

    private lateinit var userNameHeader: TextView
    private lateinit var datePickerButton: ImageView
    private lateinit var backButton: ImageView
    private lateinit var messageRecyclerView: RecyclerView
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var messageInput: EditText
    private lateinit var sendButton: Button

    private val messages = mutableListOf<Message>()
    private val originalMessages = mutableListOf<Message>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        userNameHeader = findViewById(R.id.userNameText) // id fix kara
        datePickerButton = findViewById(R.id.datePickerButton)
        backButton = findViewById(R.id.backButton)
        messageRecyclerView = findViewById(R.id.messageRecyclerView)
        messageInput = findViewById(R.id.messageInput)
        sendButton = findViewById(R.id.sendButton)

        val userName = intent.getStringExtra("userName")
        userNameHeader.text = userName ?: "Chat"

        messageAdapter = MessageAdapter(messages)
        messageRecyclerView.layoutManager = LinearLayoutManager(this)
        messageRecyclerView.adapter = messageAdapter

        loadDummyMessages()

        datePickerButton.setOnClickListener {
            showDatePicker()
        }

        backButton.setOnClickListener {
            finish()
        }

        sendButton.setOnClickListener {
            val text = messageInput.text.toString().trim()
            if (text.isNotEmpty()) {
                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
                val todayDate = sdf.format(Date())

                val newMessage = Message(text, true, todayDate)
                messages.add(newMessage)
                messageAdapter.notifyItemInserted(messages.size - 1)
                messageRecyclerView.scrollToPosition(messages.size - 1)
                messageInput.text.clear()
            }
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        DatePickerDialog(
            this,
            { _, year, month, day ->
                val selectedDate = String.format("%02d/%02d/%04d", day, month + 1, year)
                val filteredMessages = originalMessages.filter { it.date == selectedDate }

                messages.clear()
                messages.addAll(filteredMessages)
                messageAdapter.notifyDataSetChanged()

                if (filteredMessages.isNotEmpty()) {
                    messageRecyclerView.scrollToPosition(filteredMessages.size - 1)
                }
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun loadDummyMessages() {
        originalMessages.add(Message("Hello!", true, "10/04/2025"))
        originalMessages.add(Message("Hi, how are you?", false, "10/04/2025"))
        originalMessages.add(Message("I'm good. What about you?", true, "11/04/2025"))
        originalMessages.add(Message("Same here!", false, "11/04/2025"))
        originalMessages.add(Message("What's up?", true, "12/04/2025"))

        messages.clear()
        messages.addAll(originalMessages)
        messageAdapter.notifyDataSetChanged()
    }
}
