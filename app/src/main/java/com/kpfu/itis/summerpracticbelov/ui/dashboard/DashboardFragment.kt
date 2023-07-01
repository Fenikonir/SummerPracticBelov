package com.kpfu.itis.summerpracticbelov.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.kpfu.itis.summerpracticbelov.R
import com.kpfu.itis.summerpracticbelov.databinding.FragmentDashboardBinding
import com.kpfu.itis.summerpracticbelov.databinding.FragmentHomeBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root


        return root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentDashboardBinding.bind(view)

        val bundle = Bundle()


        val string = "From Dashboard Fragment"
        bundle.putString("ARG_FROM", string)

        _binding?.run {
            buttonHome.setOnClickListener {
                findNavController().navigate(R.id.navigation_home, bundle)
            }
            buttonNotifications.setOnClickListener {
                findNavController().navigate(R.id.navigation_notifications, bundle)
            }
            buttonSchedule.setOnClickListener {
                findNavController().navigate(R.id.navigation_schedule, bundle)
            }
            buttonSettings.setOnClickListener {
                findNavController().navigate(R.id.navigation_settings, bundle)
            }

        }

        binding.textDashboard.text = arguments?.getString("ARG_FROM")

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