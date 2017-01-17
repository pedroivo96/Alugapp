package br.ufpi.alugapp.fronteira;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;
import java.util.Locale;


import br.ufpi.alugapp.R;

public class TelaMapa extends AppCompatActivity implements
        OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        GoogleMap.OnMarkerDragListener,
        GoogleMap.OnMapClickListener,
        View.OnClickListener {

    private GoogleMap mMap;
    private double longitude;
    private double latitude;
    private GoogleApiClient googleApiClient;

    //  private  LatLng latLng;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_mapa);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        callConnetion();

    }
    private synchronized void callConnetion() {
        googleApiClient = new GoogleApiClient.Builder(this)
                .addOnConnectionFailedListener(this)
                .addConnectionCallbacks(this)
                .addApi(LocationServices.API)
                .build();
        googleApiClient.connect();
    }
    private void addPontos(double latitude, double longitude, String nome) {
        Location l = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        Log.i("LOG", "Latitude : " + latitude);
        Log.i("LOG", "Longitude : " + longitude + "\n tá aki");
        LatLng latLng = new LatLng(latitude, longitude);
        Log.i("LATLONG", latLng.toString());
        MarkerOptions marker = new MarkerOptions()
                .position(latLng) //setting position
                .draggable(false) //Making the marker draggable
                .title(nome); //Adding a title
        mMap.addMarker(marker);
    }

    @Override
    public void onConnected(Bundle bundle) {
        getCurrentLocation();
    }
    @Override
    public void onConnectionSuspended(int i) {
    }
    @Override
    public void onClick(View view) {
    }
    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
    }
    @Override
    protected void onStart() {
        googleApiClient.connect();
        super.onStart();
    }
    @Override
    protected void onStop() {
        googleApiClient.disconnect();
        super.onStop();
    }
    private void getCurrentLocation() {
        // mMap.clear();
        //Creating a location object
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        Location location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient);
        if (location != null) {
            //Getting longitude and latitude
            longitude = location.getLongitude();
            latitude = location.getLatitude();
            //moving the map to location
            moveMap();
            // addPontos();
        }
    }
    //Function to move the map
    private void moveMap() {
        mMap.clear();
        String msg = latitude + ", " + longitude;
        LatLng latLng = new LatLng(latitude, longitude);
        LatLng the = new LatLng(-5.092, -42.8038);
        mMap.addMarker(new MarkerOptions()
                .position(latLng) //setting position
                .draggable(true) //Making the marker draggable
                .title("Minha Localização")); //Adding a title
        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));
        getCompleteAddressString(latitude, longitude);

    }
    private String getCompleteAddressString(double LATITUDE, double LONGITUDE) {
        String strAdd = "";
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            List<Address> addresses = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1);
            if (addresses != null) {
                Address returnedAddress = addresses.get(0);
                StringBuilder strReturnedAddress = new StringBuilder("");
                for (int i = 0; i < returnedAddress.getMaxAddressLineIndex(); i++) {
                    strReturnedAddress.append(returnedAddress.getAddressLine(i)).append("\n");
                }
                strAdd = strReturnedAddress.toString();
                Log.i("LOG", "Localizacao Atual" + strReturnedAddress.toString());
            } else {
                Log.i("LOG", "Localizacao Atual - No Address returned!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("LOG", "Canont get Address!");
        }
        return strAdd;
    }
    @Override
    public void onMapClick(LatLng latLng) {
        mMap.clear();
        getCompleteAddressString(latLng.latitude, latLng.longitude);
        addPontos(latLng.latitude,latLng.longitude, "nome");
      //  moveMap();


    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng the = new LatLng(-5.092, -42.8038);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(the));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(12));
        mMap.setOnMapClickListener(this);
    }
    @Override
    public void onMarkerDragStart(Marker marker) {
    }
    @Override
    public void onMarkerDrag(Marker marker) {
    }
    @Override
    public void onMarkerDragEnd(Marker marker) {
        latitude = marker.getPosition().latitude;
        longitude = marker.getPosition().longitude;
        moveMap();
    }
}
