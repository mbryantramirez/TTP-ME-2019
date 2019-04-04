package nyc.bionic.ttp_me_2019.repo;

import android.Manifest.permission;
import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.util.Log;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.tbruyelle.rxpermissions2.RxPermissions;
import io.reactivex.Single;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class LocationRepository {

  private Context context;
  private FusedLocationProviderClient fusedLocationProviderClient;
  private final RxPermissions rxPermissions;

  public LocationRepository(Context context, RxPermissions rxPermissions) {
    this.context = context;
    fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(context);
    this.rxPermissions = rxPermissions;

  }

  @SuppressLint("MissingPermission")
  public Single<String> getLastLocation() {
    return Single.create(e -> {
      rxPermissions.request(permission.ACCESS_COARSE_LOCATION, permission.ACCESS_FINE_LOCATION)
          .subscribe(granted -> {
            if (granted) {
              LocationRequest locationRequest = LocationRequest.create();
              locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
              locationRequest.setInterval(1);

              fusedLocationProviderClient.getLastLocation().addOnSuccessListener(location -> {
                if (location != null) {
                  Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                  try {
                    List<Address> addresses = geocoder
                        .getFromLocation(location.getLatitude(), location.getLongitude(), 1);
                    String latLong =
                        addresses.get(0).getLatitude() + "," + addresses.get(0).getLongitude();
                    e.onSuccess(latLong);
                  } catch (IOException ioE) {
                    e.onError(ioE);
                  }
                } else {
                  String latLong = "40.758896,-73.985130";
                  Log.d(LocationRepository.class.getName(), "onLocationError: " + latLong);
                  e.onSuccess(latLong);
                }
              });

            } else {
              e.onError(new Throwable("You need to provide location permission"));
            }
          });
    });
  }


}
