package com.kpfu.itis.summerpracticbelov.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.kpfu.itis.summerpracticbelov.R
import com.kpfu.itis.summerpracticbelov.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val bundle = Bundle()


        val string = "From Home Fragment"
        bundle.putString("ARG_FROM", string)

        _binding?.run {
            buttonNotifications.setOnClickListener {
                findNavController().navigate(R.id.navigation_notifications, bundle)
//                val fragmentManager = requireActivity().supportFragmentManager

            }
            buttonDashboard.setOnClickListener {
                findNavController().navigate(R.id.navigation_dashboard, bundle)
            }
            buttonSchedule.setOnClickListener {
                findNavController().navigate(R.id.navigation_schedule, bundle)
            }
            buttonSettings.setOnClickListener {
                findNavController().navigate(R.id.navigation_settings, bundle)
            }
        }



        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentHomeBinding.bind(view)
        binding.textHome.text = arguments?.getString("ARG_FROM")

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