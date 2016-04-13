package pl.droidsonroids.estimotebeaconsdemo;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.estimote.sdk.SystemRequirementsChecker;

public class MainActivity extends AppCompatActivity implements ScanningHintListener {
    private View mLayout;
    private TextView mText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = findViewById(R.id.layout);
        mText = (TextView) findViewById(R.id.text);
        BeaconsService.instance().initialize();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(SystemRequirementsChecker.checkWithDefaultDialogs(this)) {
            BeaconsService.instance().setScaningHintListener(this);
            BeaconsService.instance().startScanning();
        } else {
            Toast.makeText(MainActivity.this, R.string.error_permissions_not_granted, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onPause() {
        BeaconsService.instance().stopScanning();
        BeaconsService.instance().clearScaningHintListener();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        BeaconsService.instance().release();
        super.onDestroy();
    }

    @Override
    public void onNoBeaconsDetected() {
        mLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.white));
        mText.setText(R.string.no_beacons);
    }

    @Override
    public void onImmediateProximity() {
        mLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.green));
        mText.setText(R.string.beacon_in_immediate_proximity);
    }

    @Override
    public void onNearProximity() {
        mLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow));
        mText.setText(R.string.beacon_in_near_proximity);
    }

    @Override
    public void onFarProximity() {
        mLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.orange));
        mText.setText(R.string.beacon_in_far_proximity);
    }

    @Override
    public void onUnknownProximity() {
        mLayout.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
        mText.setText(R.string.beacon_in_unknown_proximity);
    }
}
