package org.techtown.myapplication67

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.*

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
        val descriptor = getDescriptorFromDrawable(R.drawable.pngegg)
        val marker = MarkerOptions()
                .position(LATLNG)
                .title("Marker in Seoul")
                .icon(descriptor)
        mMap.addMarker(marker)
        val cameraPosition = CameraPosition.Builder()
            .target(LATLNG)
            .zoom(15.0f)
            .build()
        val cameraUpdate = CameraUpdateFactory.newCameraPosition(cameraPosition)
        mMap.moveCamera(cameraUpdate)
    }

    fun getDescriptorFromDrawable(drawableId:Int): BitmapDescriptor {
        var bitmapDrawable: BitmapDrawable
        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            bitmapDrawable = getDrawable(drawableId) as BitmapDrawable
        }else{
            bitmapDrawable = resources.getDrawable(drawableId) as BitmapDrawable
        }
        var scaledBitmap = Bitmap.createScaledBitmap(bitmapDrawable.bitmap,50,50,false)
      return BitmapDescriptorFactory.fromBitmap(bitmapDrawable.bitmap)

    }
}