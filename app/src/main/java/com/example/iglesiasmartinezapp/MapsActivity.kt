package com.example.iglesiasmartinezapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptor
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private val iglesias = mutableListOf<Iglesias>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        addIglesias()

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun addIglesias() {
        iglesias.add(Iglesias(nombre ="Centro Cristiano M", latitud = 20.067389784283137, longitud = -97.06056654453278))
        iglesias.add(Iglesias(nombre = "Testigos de Jehova", latitud = 20.074111322839705, longitud = -97.06664174795154))
        iglesias.add(Iglesias(nombre = "Emmanuel", latitud = 20.069304494775796, longitud = -97.06299126148224))
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

      //  val icon = getIglesiasIcon()

        for (iglesias in iglesias){
            val iglesiasPosition = LatLng(iglesias.latitud, iglesias.longitud)
            val iglesiasName = iglesias.nombre

            val markerOptions = MarkerOptions().position(iglesiasPosition).title(iglesiasName)
      //          .icon()
            mMap.addMarker(markerOptions)
        }

        // Add a marker in Sydney and move the camera
        val cAlfarero = LatLng(20.074529519990673, -97.06785410642625)

        /**
        val iglesia2 = LatLng(20.067389784283137, -97.06056654453278)
        val iglesia3 = LatLng(20.074111322839705, -97.06664174795154)
        val iglesia4 = LatLng(20.069304494775796, -97.06299126148224)

        mMap.addMarker(MarkerOptions().position(iglesia2).title("Marker in C.C.M"))
        mMap.addMarker(MarkerOptions().position(iglesia3).title("Marker in T.D.J"))
        mMap.addMarker(MarkerOptions().position(iglesia4).title("Marker in Emmanuel"))
         */

        mMap.addMarker(MarkerOptions().position(cAlfarero).title("Marker in Casa del Alfarero"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(cAlfarero))

    }

    //private fun getIglesiasIcon(): BitmapDescriptor {

    //}
}