package com.example.v2;

import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.Call;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.LinkedList;



public class newMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    static Integer listKushal=0;
    static Integer listAkul=20;
    static Integer listSurya=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

//        listKushal = getIntent().getIntExtra("riskscoreKushal", 0);
//        listAkul = getIntent().getIntExtra("riskscoreAkul", 0);
//        listSurya = getIntent().getIntExtra("riskscoreSurya", 0);

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
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        Marker kushal;
        Marker surya;
        Marker akul;




        // Add a marker in Sydney and move the camera
        LatLng Kushal = new LatLng(42.273804, -71.809240);
        LatLng Akul = new LatLng(42.273749, -71.809257);
        LatLng Suryansh = new LatLng(42.273774, -71.809359);
        kushal = mMap.addMarker(new MarkerOptions().position(Kushal).title("Kushal").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        akul = mMap.addMarker(new MarkerOptions().position(Akul).title("Akul").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE)));
        surya = mMap.addMarker(new MarkerOptions().position(Suryansh).title("Suryansh").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(Kushal,20), 5000, null);

        kushal.setTag(listKushal);
        surya.setTag(listSurya);
        akul.setTag(listAkul);

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                String markerTitle = marker.getTitle();
                Integer tag = (Integer) marker.getTag();
                Intent i = new Intent(newMapActivity.this, DetailsActivity.class);
                i.putExtra("title", markerTitle);
                i.putExtra("tag", tag);
                startActivity(i);
                return false;
            }
        });

    }
}