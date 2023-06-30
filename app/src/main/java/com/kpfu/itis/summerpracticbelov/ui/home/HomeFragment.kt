package com.kpfu.itis.summerpracticbelov.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.kpfu.itis.summerpracticbelov.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var button: Button
    private lateinit var editTextName: EditText
    private lateinit var editTextHeight: EditText
    private lateinit var editTextWeight: EditText
    private lateinit var editTextAge: EditText
    private lateinit var resultText: TextView

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)



        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        button = binding.button;
        editTextName = binding.editTextName
        editTextHeight = binding.editTextHeight
        editTextWeight = binding.editTextWeight
        editTextAge = binding.editTextAge
        resultText = binding.resultText


        return root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button.setOnClickListener {
            val name = editTextName.text.toString()
            val height = editTextHeight.text.toString()
            val weight = editTextWeight.text.toString()
            val age = editTextAge.text.toString()

            val maxHeight = 250
            val minHeight = 0
            val maxAge = 150
            val minAge = 0

            if (name.isEmpty()) {
                editTextName.error = "Неверный ввод"
                return@setOnClickListener
            }


            if (height.isEmpty() || (height.isNotEmpty() && height.toDouble() > maxHeight)) {
                editTextHeight.error = "Неверный Рост"
                return@setOnClickListener
            }

            if (height.isEmpty() || (weight.isNotEmpty() && weight.toDouble() > maxHeight)) {
                editTextWeight.error = "Неверный  Вес"
                return@setOnClickListener
            }

            if (height.isEmpty() || (age.isNotEmpty() && age.toInt() > maxAge)) {
                editTextAge.error = "Неверный Возраст"
                return@setOnClickListener
            }

            val calories: Double = (weight.toDouble() * 10).toDouble() // Калории

            val nds: Double = (weight.toDouble() * height.toDouble())// НДС

            val mortgage: Double = (age.toDouble() * 1000).toDouble() // Example calculation for mortgage

            val horoscope = "Гороскоп у " + name + " какой-то" // Example calculation for horoscope

            val ndfl: Double = (weight.toDouble() / height.toDouble()).toDouble() // Ex

            val message = "Результат\nКалории: $calories\nНДС: $nds\nMortgage: $mortgage\nГороскоп: $horoscope\nНДФЛ: $ndfl"
            resultText.text = message
            resultText.visibility = VISIBLE

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}