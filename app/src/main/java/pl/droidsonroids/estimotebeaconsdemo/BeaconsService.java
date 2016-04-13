package pl.droidsonroids.estimotebeaconsdemo;

import android.content.Context;
import com.estimote.sdk.Beacon;

import static com.estimote.sdk.Utils.computeProximity;

public class BeaconsService {
    protected final Context mApplicationContext;
    private ScanningHintListener scaningHintListener;

    public BeaconsService(final Context applicationContext) {
        mApplicationContext = applicationContext;
    }

    public static BeaconsService instance() {
        return BeaconsApplication.getInstance().getBeaconsService();
    }

    public void initialize() {
        //TODO
    }

    private void onDetectedBeaconsEmpty() {
        scaningHintListener.onNoBeaconsDetected();
    }

    private void onSingleEntryInDetectedBeacons(final Beacon detectedBeacon) {
        switch (computeProximity(detectedBeacon)) {
            case IMMEDIATE:
                scaningHintListener.onImmediateProximity();
                break;
            case NEAR:
                scaningHintListener.onNearProximity();
                break;
            case FAR:
                scaningHintListener.onFarProximity();
                break;
            case UNKNOWN:
                scaningHintListener.onUnknownProximity();
                break;
        }
    }

    public void startScanning() {
        //TODO
    }

    public void stopScanning() {
        //TODO
    }

    public void release() {
        //TODO
    }

    public void setScaningHintListener(ScanningHintListener scaningHintListener) {
        this.scaningHintListener = scaningHintListener;
    }

    public void clearScaningHintListener() {
        scaningHintListener = new ScanningHintListener.Empty();
    }
}
