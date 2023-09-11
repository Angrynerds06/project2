package com.example.project1

data class StateCity(val state: String, val cities: List<String>)

val stateCityData = listOf(
    StateCity("Delhi", listOf("Delhi")),
    StateCity(
        "Andhra Pradesh",
        listOf(
            "Visakhapatnam",
            "Srikakulam",
            "Anataput",
            "Chittor",
            "Krishna",
            "Annathapuramu",
            "Anantapur"
        )
    ),
    StateCity("Assam", listOf("Kamrup")),
    StateCity("Chattisgarh", listOf("Raipur", "Durg")),
    StateCity(
        "Gujrat",
        listOf(
            "Sabar kantha",
            "Ahmedabad",
            "Rajkot",
            "Valsad",
            "Surat",
            "Bharuch",
            "Mehsana",
            "Vadodara",
            "Jamnagar",
            "Sachin",
            "Panchmahal",
            "Navsari",
            "Surat"
        )
    )
)

