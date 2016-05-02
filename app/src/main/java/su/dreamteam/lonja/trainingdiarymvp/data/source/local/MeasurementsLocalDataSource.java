package su.dreamteam.lonja.trainingdiarymvp.data.source.local;

import android.support.annotation.NonNull;

import io.realm.Realm;
import io.realm.RealmResults;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;
import su.dreamteam.lonja.trainingdiarymvp.data.source.MeasurementsDataSource;

public class MeasurementsLocalDataSource implements MeasurementsDataSource {

    private static MeasurementsLocalDataSource INSTANCE;

    private Realm realm;

    private MeasurementsLocalDataSource() {
        realm = Realm.getDefaultInstance();
    }

    public static MeasurementsLocalDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MeasurementsLocalDataSource();
        }
        return INSTANCE;
    }


    @Override
    public void getMeasurements(@NonNull GetMeasurementsCallback callback) {
        try {
            RealmResults<Measurement> measurements = realm.where(Measurement.class).findAll();
            callback.onMeasurementsLoaded(measurements);
        } catch (Exception e) {
            callback.onDataNotAvailable();
        }
    }

    @Override
    public void getMeasurement(@NonNull String measurementId, @NonNull GetMeasurementCallback callback) {
        try {
            Measurement measurement = realm.where(Measurement.class).equalTo("id", measurementId).findFirst();
            callback.onMeasurementLoaded(measurement);
        } catch (Exception e) {
            callback.onDataNotAvailable();
        }
    }

    @Override
    public void saveMeasurement(@NonNull final Measurement measurement) {
        try {
            realm.beginTransaction();
            Measurement realmMeasurement = realm.createObject(Measurement.class);
            realmMeasurement.setId(measurement.getId());
            realmMeasurement.setDate(measurement.getDate());
            realmMeasurement.setComment(measurement.getComment());
            realmMeasurement.setChest(measurement.getChest());
            realmMeasurement.setLeftArm(measurement.getLeftArm());
            realmMeasurement.setLeftForearm(measurement.getLeftForearm());
            realmMeasurement.setLeftThigh(measurement.getLeftThigh());
            realmMeasurement.setLeftCalf(measurement.getLeftCalf());
            realmMeasurement.setNeck(measurement.getNeck());
            realmMeasurement.setRightArm(measurement.getRightArm());
            realmMeasurement.setRightCalf(measurement.getRightCalf());
            realmMeasurement.setRightForearm(measurement.getRightForearm());
            realmMeasurement.setRightThigh(measurement.getRightThigh());
            realmMeasurement.setWaist(measurement.getWaist());
            realmMeasurement.setWeight(measurement.getWeight());
            realmMeasurement.setAaa(measurement.getAaa());
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }

    @Override
    public void updateMeasurement(@NonNull Measurement measurement) {
        try {
            realm.beginTransaction();
            Measurement realmMeasurement = realm.where(Measurement.class)
                    .equalTo("id", measurement.getId())
                    .findFirst();
            realmMeasurement.setDate(measurement.getDate());
            realmMeasurement.setComment(measurement.getComment());
            realmMeasurement.setChest(measurement.getChest());
            realmMeasurement.setLeftArm(measurement.getLeftArm());
            realmMeasurement.setLeftForearm(measurement.getLeftForearm());
            realmMeasurement.setLeftThigh(measurement.getLeftThigh());
            realmMeasurement.setLeftCalf(measurement.getLeftCalf());
            realmMeasurement.setNeck(measurement.getNeck());
            realmMeasurement.setRightArm(measurement.getRightArm());
            realmMeasurement.setRightCalf(measurement.getRightCalf());
            realmMeasurement.setRightForearm(measurement.getRightForearm());
            realmMeasurement.setRightThigh(measurement.getRightThigh());
            realmMeasurement.setWaist(measurement.getWaist());
            realmMeasurement.setWeight(measurement.getWeight());
            realmMeasurement.setAaa(measurement.getAaa());
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }

    @Override
    public void refreshMeasurements() {

    }

    @Override
    public void deleteAllMeasurements() {
        try {
            realm.beginTransaction();
            realm.where(Measurement.class).findAll().clear();
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }

    @Override
    public void deleteMeasurement(@NonNull String measurementId) {
        try {
            realm.beginTransaction();
            realm.where(Measurement.class)
                    .equalTo("id", measurementId)
                    .findFirst()
                    .removeFromRealm();
            realm.commitTransaction();
        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }
}
