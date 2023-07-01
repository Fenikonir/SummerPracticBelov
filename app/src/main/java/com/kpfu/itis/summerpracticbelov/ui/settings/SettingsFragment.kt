package com.kpfu.itis.summerpracticbelov.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.kpfu.itis.summerpracticbelov.R
import com.kpfu.itis.summerpracticbelov.databinding.FragmentHomeBinding
import com.kpfu.itis.summerpracticbelov.databinding.FragmentSettingsBinding


class SettingsFragment : Fragment() {

    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentSettingsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val bundle = Bundle()


        val string = "From Settings Fragment"
        bundle.putString("ARG_FROM", string)

        _binding?.run {
            buttonNotifications.setOnClickListener {
                findNavController().navigate(R.id.navigation_notifications, bundle)
            }
            buttonDashboard.setOnClickListener {
                findNavController().navigate(R.id.navigation_dashboard, bundle)
            }
            buttonSchedule.setOnClickListener {
                findNavController().navigate(R.id.navigation_schedule, bundle)
            }
            buttonHome.setOnClickListener {
                findNavController().navigate(R.id.navigation_home, bundle)
            }

        }

        return root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentSettingsBinding.bind(view)
        binding.textSettings.text = arguments?.getString("ARG_FROM")
        val message = arguments?.getString("ARG_FROM")
        message?.let {
            Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}