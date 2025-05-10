package com.example.instachatviewer.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.instachatviewer.R
import com.example.instachatviewer.model.Message

class MessageAdapter(private var messageList: MutableList<Message>) :
    RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val messageText: TextView = itemView.findViewById(R.id.messageText)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_message, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messageList[position]
        holder.messageText.text = message.content

        val layoutParams = holder.messageText.layoutParams as ViewGroup.MarginLayoutParams
        if (message.isSentByMe) {
            holder.messageText.setBackgroundResource(R.drawable.bg_message_sent)
            layoutParams.marginStart = 100
            layoutParams.marginEnd = 16
        } else {
            holder.messageText.setBackgroundResource(R.drawable.bg_message_received)
            layoutParams.marginStart = 16
            layoutParams.marginEnd = 100
        }
        holder.messageText.layoutParams = layoutParams
    }

    override fun getItemCount(): Int = messageList.size

    // 🔥 New method added for filtering messages by date
    fun updateMessages(newMessages: List<Message>) {
        messageList = newMessages.toMutableList()
        notifyDataSetChanged()
    }
}
