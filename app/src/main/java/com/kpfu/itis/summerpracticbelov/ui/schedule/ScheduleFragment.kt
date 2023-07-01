package com.kpfu.itis.summerpracticbelov.ui.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.kpfu.itis.summerpracticbelov.R
import com.kpfu.itis.summerpracticbelov.databinding.FragmentScheduleBinding
import com.kpfu.itis.summerpracticbelov.ui.dashboard.DashboardFragment
import com.kpfu.itis.summerpracticbelov.ui.home.HomeFragment
import com.kpfu.itis.summerpracticbelov.ui.notifications.NotificationsFragment
import com.kpfu.itis.summerpracticbelov.ui.settings.SettingsFragment


class ScheduleFragment : Fragment() {


    private var _binding: FragmentScheduleBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentScheduleBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val bundle = Bundle()


        val string = "From Schedule Fragment"
        bundle.putString("ARG_FROM", string)



        _binding?.run {
            buttonHome.setOnClickListener {
                findNavController().navigate(R.id.navigation_home, bundle)
            }
            buttonDashboard.setOnClickListener {
                findNavController().navigate(R.id.navigation_dashboard, bundle)
            }
            buttonNotifications.setOnClickListener {
                findNavController().navigate(R.id.navigation_notifications, bundle)
            }
            buttonSettings.setOnClickListener {
                findNavController().navigate(R.id.navigation_settings, bundle)
            }

        }

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentScheduleBinding.bind(view)
        binding.textSchedule.text = arguments?.getString("ARG_FROM")
        val message = arguments?.getString("ARG_FROM")
        message?.let {
            Snackbar.make(requireView(), it, Snackbar.LENGTH_LONG).show()
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

//    fun fragmentNavigation(fragment: Int) {
//        val fragmentManager = requireActivity().supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//
//        when (fragment) {
//            R.id.navigation_home -> fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, HomeFragment())
//            R.id.navigation_dashboard -> fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, DashboardFragment())
//            R.id.navigation_notifications -> fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, NotificationsFragment())
//            R.id.navigation_settings -> fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, SettingsFragment())
//            R.id.navigation_schedule -> fragmentTransaction.replace(R.id.nav_host_fragment_activity_main, ScheduleFragment())
//        }
//        fragmentTransaction.addToBackStack(null)
//        fragmentTransaction.commit()
//    }
}