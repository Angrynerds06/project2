package com.example.project1

import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class mapactivity : AppCompatActivity() , OnMapReadyCallback {

    private lateinit var mapView: MapView
    private lateinit var googleMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mapactivity)


        val selectedState = intent.getStringExtra("selectedState")

        mapView = findViewById<MapView>(R.id.mapView)
        mapView.onCreate(savedInstanceState)

        mapView.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        googleMap = map

        val cityName = intent.getStringExtra("selectedCity")

        val geocoder = Geocoder(this)
        val addresses = geocoder.getFromLocationName(cityName.toString(), 1)

        if (addresses!!.isNotEmpty()) {
            val latitude = addresses[0].latitude
            val longitude = addresses[0].longitude

            // Add a marker to the desired city
            val cityLocation = LatLng(latitude, longitude)
            googleMap.addMarker(MarkerOptions().position(cityLocation).title(cityName))
            googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cityLocation, 12f))
        }
        else{
            Toast.makeText(this,"NO CITY FOUND",Toast.LENGTH_LONG).show()
            finish()
        }
    }

    override fun onResume() {
        super.onResume()
        mapView.onResume()
    }

    override fun onPause() {
        super.onPause()
        mapView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        mapView.onDestroy()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        mapView.onLowMemory()
    }
}

