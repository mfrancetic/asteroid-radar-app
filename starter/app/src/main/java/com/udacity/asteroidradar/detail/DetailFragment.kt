package com.udacity.asteroidradar.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.udacity.asteroidradar.R
import com.udacity.asteroidradar.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentDetailBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val asteroid = DetailFragmentArgs.fromBundle(requireArguments()).selectedAsteroid
        binding.asteroid = asteroid

        setupObserver()

        return binding.root
    }

    private fun setupObserver() {
        viewModel.displayExplanationDialog.observe(viewLifecycleOwner, { displayExplanationDialog ->
            if (displayExplanationDialog) {
                displayAstronomicalUnitExplanationDialog()
                viewModel.onDisplayExplanationDialogDone()
            }
        })
    }

    private fun displayAstronomicalUnitExplanationDialog() {
        val builder = AlertDialog.Builder(requireActivity(), R.style.DialogTheme)
            .setMessage(getString(R.string.astronomica_unit_explanation))
            .setPositiveButton(android.R.string.ok, null)
        builder.create().show()
    }
}