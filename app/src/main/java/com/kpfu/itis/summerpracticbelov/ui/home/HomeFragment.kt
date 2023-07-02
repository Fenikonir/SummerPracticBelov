package com.kpfu.itis.summerpracticbelov.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.kpfu.itis.summerpracticbelov.PlanetRepository
import com.kpfu.itis.summerpracticbelov.R


class HomeFragment : Fragment() {
    private lateinit var planetListView: ListView
    private lateinit var planetListAdapter: ArrayAdapter<String>
    private lateinit var planetNames: List<String>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        planetListView = view.findViewById(R.id.planetListView)

        val bundle = Bundle()




        planetNames = PlanetRepository.getPlanetsName()

        planetListAdapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, planetNames)
        planetListView.adapter = planetListAdapter

        planetListView.setOnItemClickListener { _, _, position, _ ->


            val planetName = planetNames[position]

            val planetId = when (planetName) {
                "Меркурий" -> 1
                "Венера" -> 2
                "Земля" -> 3
                "Марс" -> 4
                "Юпитер" -> 5
                "Сатурн" -> 6
                "Уран" -> 7
                "Нептун" -> 8
                else -> 0

            }
            bundle.putInt("PLANET", planetId)
            findNavController().navigate(R.id.navigation_dashboard, bundle)
        }

        return view
    }
}


