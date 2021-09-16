package org.techtown.myapplication67

import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
         mMap = googleMap
        val LATLNG = LatLng(37.566418,126.977943)
        var bitmapDrawable: BitmapDrawable
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            bitmapDrawable = getDrawable(R.drawable.pngegg) as BitmapDrawable
        }else{
            bitmapDrawable = resources.getDrawable(R.drawable.pngegg) as BitmapDrawable
        }

        val discriptor = BitmapDescriptorFactory.fromBitmap(bitmapDrawable.bitmap)
        val mark = MarkerOptions()
                .position(LATLNG)
                .icon(discriptor)
        val markerOptions = MarkerOptions().position(LATLNG)
            .title("Marker in Seoul City Hall")
        mMap.addMarker(markerOptions)
        val cameraPosition = CameraPosition.Builder()
            .target(LATLNG)
            .zoom(15.0f)
            .build()
        val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
        mMap.moveCamera(cameraUpdate)
        val marker = MarkerOptions()
            .position(LATLNG)
            .title("Seoul City Hall")
            .snippet("37.566418,126.977943")
        mMap.addMarker(marker)



    }
}