package com.kpfu.itis.summerpracticbelov.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.kpfu.itis.summerpracticbelov.R
import com.kpfu.itis.summerpracticbelov.databinding.FragmentHomeBinding
import com.kpfu.itis.summerpracticbelov.databinding.FragmentNotificationsBinding

class NotificationsFragment : Fragment() {
    private var _binding: FragmentNotificationsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val bundle = Bundle()


        val string = "From Notification Fragment"
        bundle.putString("ARG_FROM", string)

        _binding?.run {
            buttonHome.setOnClickListener {
                findNavController().navigate(R.id.navigation_home, bundle)
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

        _binding = FragmentNotificationsBinding.bind(view)
        binding.textNotification.text = arguments?.getString("ARG_FROM")

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