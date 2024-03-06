package com.example.weatherapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.weatherapp.databinding.FragmentMainBinding
import com.example.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding: FragmentMainBinding get() = _binding!!
    private val viewModel: WeatherViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
        initListeners()
    }

    private fun initListeners() {
        binding.btShow.setOnClickListener {
            viewModel.getWeather(binding.etCity.text.toString())
        }
    }

    private fun observe() {
        viewModel.weather.observe(viewLifecycleOwner) {
            binding.apply {
                tvCity.text = it.name
                tvTemp.text = resources.getString(R.string.temperature).plus(" ${it.temp.temp.toInt()}")
                tvFeels.text = resources.getString(R.string.feels_like).plus(" ${it.temp.feelsLike.toInt()}")
                tvHumidity.text = resources.getString(R.string.humidity).plus(" ${it.temp.humidity}")
                tvVisibility.text = resources.getString(R.string.visibility).plus(" ${it.visibility}")
                tvWeatherDesc.text = it.weather.first().description

            }
        }
        viewModel.message.observe(viewLifecycleOwner) {
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}