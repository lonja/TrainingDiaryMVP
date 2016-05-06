package su.dreamteam.lonja.trainingdiarymvp.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import io.realm.RealmResults;
import rx.Observable;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;
import su.dreamteam.lonja.trainingdiarymvp.data.source.local.MeasurementsLocalDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

public class DataManager {

    private MeasurementsLocalDataSource mMeasurementsLocalDataSource;

    private static DataManager INSTANCE;

    private DataManager(MeasurementsLocalDataSource measurementsLocalDataSource) {
        mMeasurementsLocalDataSource = measurementsLocalDataSource;
    }

    public static DataManager getInstance(MeasurementsLocalDataSource measurementsLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DataManager(measurementsLocalDataSource);
        }
        return INSTANCE;
    }

    public Observable<RealmResults<Measurement>> getMeasurements() {
        return mMeasurementsLocalDataSource.getMeasurements();
    }

    public Observable<Measurement> getMeasurement(@NonNull final String measurementId) {
        checkNotNull(measurementId);
        return mMeasurementsLocalDataSource.getMeasurement(measurementId);
    }

    public void updateMeasurement(Measurement measurement) {
        mMeasurementsLocalDataSource.updateMeasurement(measurement);
    }

    public void updateMeasurement() {
        mMeasurementsLocalDataSource.update();
    }

    public void commitMeasurementChanges() {
        mMeasurementsLocalDataSource.commit();
    }

    public void cancelMeasurementChanges() {
        mMeasurementsLocalDataSource.cancel();
    }

    public boolean hasActiveTransaction() {
        return mMeasurementsLocalDataSource.isInTransaction();
    }

    public void saveMeasurement(Measurement measurement) {
        checkNotNull(measurement);
        mMeasurementsLocalDataSource.saveMeasurement(measurement);
    }
}
