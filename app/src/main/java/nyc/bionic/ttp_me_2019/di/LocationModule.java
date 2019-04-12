package nyc.bionic.ttp_me_2019.di;

import android.app.Application;
import androidx.fragment.app.Fragment;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.tbruyelle.rxpermissions2.RxPermissions;
import dagger.Provides;
import javax.inject.Singleton;

public class LocationModule {


  @Provides
  @Singleton
  FusedLocationProviderClient providesFusedLocationProviderClient(Application application) {
    return LocationServices.getFusedLocationProviderClient(application);
  }

  @Provides
  @Singleton
  RxPermissions providesRxPermissions(Fragment fragment) {
    return new RxPermissions(fragment);
  }

}
