package pl.droidsonroids.estimotebeaconsdemo;

public interface ScanningHintListener {
    void onNoBeaconsDetected();

    void onImmediateProximity();

    void onNearProximity();

    void onFarProximity();

    void onUnknownProximity();

    class Empty implements ScanningHintListener {

        @Override
        public void onNoBeaconsDetected() {
            //no-op
        }

        @Override
        public void onImmediateProximity() {
            //no-op
        }

        @Override
        public void onNearProximity() {
            //no-op
        }

        @Override
        public void onFarProximity() {
            //no-op
        }

        @Override
        public void onUnknownProximity() {
            //no-op
        }
    }
}
