package pl.droidsonroids.estimotebeaconsdemo;

import android.app.Application;

public class BeaconsApplication extends Application {
    private static BeaconsApplication sInstance;
    private BeaconsService mBeaconsService;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        mBeaconsService = new BeaconsService(this);
    }

    public static BeaconsApplication getInstance() {
        return sInstance;
    }

    public BeaconsService getBeaconsService() {
        return mBeaconsService;
    }
}
