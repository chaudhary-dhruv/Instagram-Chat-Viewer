package com.example.instachatviewer.ui.screens.chat

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.instachatviewer.databinding.FragmentChatHeaderBinding
import java.util.*

class ChatHeaderFragment(
    private val userName: String,
    private val onDateSelected: (String) -> Unit,
    private val onBack: () -> Unit
) : Fragment() {

    private var _binding: FragmentChatHeaderBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentChatHeaderBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.userNameText.text = userName

        binding.backBtn.setOnClickListener {
            onBack.invoke()
        }

        binding.datePickerBtn.setOnClickListener {
            val calendar = Calendar.getInstance()
            val datePickerDialog = DatePickerDialog(
                requireContext(),
                { _, year, month, day ->
                    val dateString = "$day/${month + 1}/$year"
                    onDateSelected.invoke(dateString)
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
            datePickerDialog.show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
