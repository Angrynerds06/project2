package com.example.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize spinners and their data
        val stateSpinner: Spinner = findViewById(R.id.spinner1)
        val citySpinner: Spinner = findViewById(R.id.spinner2)

        // Create an adapter for the state Spinner
        val stateAdapter = ArrayAdapter<String>(this, R.layout.custom_spinner_item)
        stateAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        stateSpinner.adapter = stateAdapter

        // Create an adapter for the city Spinner
        val cityAdapter = ArrayAdapter<String>(this, R.layout.custom_spinner_item)
        cityAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        citySpinner.adapter = cityAdapter


        val stateNames = stateCityData.map { it.state }
        stateAdapter.addAll(stateNames)
        stateAdapter.notifyDataSetChanged()


        stateSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                val selectedState = stateAdapter.getItem(position)
                val cities = stateCityData.find { it.state == selectedState }?.cities ?: emptyList<String>()
                cityAdapter.clear()
                cityAdapter.addAll(cities)
                cityAdapter.notifyDataSetChanged()
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // Do nothing
            }
        }



        // Button click listener
        val searchButton: Button = findViewById(R.id.search_button)
        searchButton.setOnClickListener {
            // Get selected city
            val selectedCity = citySpinner.selectedItem.toString()
            val selectedState = stateSpinner.selectedItem.toString()

            // Create an Intent to start the ResultActivity
            val intent = Intent(this, mapactivity::class.java)
            intent.putExtra("selectedCity", selectedCity)
            intent.putExtra("selectedState", selectedState)

            // Start the new activity
            startActivity(intent)
        }

    }
}