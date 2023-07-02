package com.kpfu.itis.summerpracticbelov.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.kpfu.itis.summerpracticbelov.Planet
import com.kpfu.itis.summerpracticbelov.PlanetRepository
import com.kpfu.itis.summerpracticbelov.R
import com.kpfu.itis.summerpracticbelov.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {
    private lateinit var planetImageView: ImageView
    private lateinit var planetNameTextView: TextView
    private lateinit var planetDescriptionTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)
        planetImageView = view.findViewById(R.id.planetImageView)
        planetNameTextView = view.findViewById(R.id.planetNameTextView)
        planetDescriptionTextView = view.findViewById(R.id.planetDescriptionTextView)

        val planetId = arguments?.getInt("PLANET")
        val planet = planetId?.let { PlanetRepository.getPlanetById(it) }

        if (planet != null) {
            planetNameTextView.text = planet.name
            planetDescriptionTextView.text = planet.description
            Glide.with(requireContext())
                .load(planet.url)
                .into(planetImageView)
        }

        return view
    }
}
