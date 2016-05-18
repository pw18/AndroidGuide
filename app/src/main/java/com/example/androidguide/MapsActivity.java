package com.example.androidguide;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.Mydatabase.CRUD;
import com.example.model.HospitalProvinceModel;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private int areaId;
    private String areaName;
    private String province;
    private List<HospitalProvinceModel> item;
    private CRUD crud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            areaId = bundle.getInt("area_id");
            areaName = bundle.getString("area_name");
            province = bundle.getString("province");

        }

        crud = new CRUD(getApplicationContext());
        if (areaName.equals("Realm"))
            item = crud.selectHospitalRealm(areaId, province.replace("จังหวัด", "").replace(" ",""));
        else if (areaName.equals("Central"))
            item = crud.selectHospitalCentralRegion(areaId, province.replace("จังหวัด", "").replace(" ",""));
        else if (areaName.equals("North"))
            item = crud.selectHospitalNorth(areaId, province.replace("จังหวัด", "").replace(" ",""));
        else if (areaName.equals("South"))
            item = crud.selectHospitalSouth(areaId, province.replace("จังหวัด", "").replace(" ",""));
        else if (areaName.equals("East"))
            item = crud.selectHospitalEast(areaId, province.replace("จังหวัด", "").replace(" ",""));
        else if (areaName.equals("West"))
            item = crud.selectHospitalWest(areaId, province.replace("จังหวัด", "").replace(" ",""));
        else if (areaName.equals("NorthEast"))
            item = crud.selectHospitalNorthEast(areaId, province.replace("จังหวัด", "").replace(" ",""));

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        mMap.setMyLocationEnabled(true);
        if(item != null){
            for(HospitalProvinceModel data : item){
                String nLat = data.getLat().replace(", ", "");
                LatLng sydney = new LatLng(Double.parseDouble(nLat.replace(",", "")), Double.parseDouble(data.getLng()));
                mMap.addMarker(new MarkerOptions().position(sydney).title(data.getName()));
                mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
            }
        }
    }
}
