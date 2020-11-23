package com.udacity.asteroidradar.main

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.asteroidradar.Asteroid
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        setupRecyclerViewAdapter()
        setupObservers()

        setHasOptionsMenu(true)

        return binding.root
    }

    private fun setupRecyclerViewAdapter() {
        val adapter = MainAsteroidAdapter(MainAsteroidAdapter.AsteroidListener { asteroid ->
            viewModel.onAsteroidClicked(asteroid)
        })
        binding.asteroidRecycler.adapter = adapter

        adapter.submitList(getDummyAsteroids())
    }

    private fun getDummyAsteroids(): MutableList<Asteroid> {
        val asteroids = mutableListOf<Asteroid>()
        asteroids.add(
            Asteroid(
                1, "68347 (20013 KB67", "2020-02-08",
                0.0, 0.0, 0.0, 0.0, true
            )
        )
        asteroids.add(
            Asteroid(
                1, "68347 (20013 KB67", "2020-02-08",
                0.0, 0.0, 0.0, 0.0, true
            )
        )
        asteroids.add(
            Asteroid(
                2, "68347 (20013 KB68", "2020-03-08",
                0.0, 0.0, 0.0, 0.0, false
            )
        )
        asteroids.add(
            Asteroid(
                3, "68347 (20013 KB69", "2020-04-08",
                0.0, 0.0, 0.0, 0.0, false
            )
        )
        asteroids.add(
            Asteroid(
                4, "68347 (20013 KB70", "2020-05-08",
                0.0, 0.0, 0.0, 0.0, false
            )
        )
        asteroids.add(
            Asteroid(
                5, "68347 (20013 KB71", "2020-06-08",
                0.0, 0.0, 0.0, 0.0, false
            )
        )
        return asteroids
    }

    private fun setupObservers() {
        viewModel.navigateToDetailFragment.observe(viewLifecycleOwner, { asteroid ->
            if (asteroid != null) {
                navigateToDetailFragment(asteroid)
                viewModel.doneNavigating()
            }
        })
    }

    private fun navigateToDetailFragment(asteroid: Asteroid) {
        findNavController().navigate(MainFragmentDirections.actionShowDetail(asteroid))
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_overflow_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return true
    }
}