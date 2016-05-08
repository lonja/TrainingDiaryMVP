package su.dreamteam.lonja.trainingdiarymvp.data.source;

import android.support.annotation.NonNull;

import io.realm.RealmResults;
import rx.Observable;
import su.dreamteam.lonja.trainingdiarymvp.data.Account;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;
import su.dreamteam.lonja.trainingdiarymvp.data.source.local.AccountLocalDataSource;
import su.dreamteam.lonja.trainingdiarymvp.data.source.local.MeasurementsLocalDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

public class DataManager {

    private MeasurementsLocalDataSource mMeasurementsLocalDataSource;

    private AccountLocalDataSource mAccountLocalDataSource;

    private static DataManager INSTANCE;

    private DataManager(MeasurementsLocalDataSource measurementsLocalDataSource,
                        AccountLocalDataSource accountLocalDataSource) {
        mMeasurementsLocalDataSource = measurementsLocalDataSource;
        mAccountLocalDataSource = accountLocalDataSource;
    }

    public static DataManager getInstance(MeasurementsLocalDataSource measurementsLocalDataSource,
                                          AccountLocalDataSource accountLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DataManager(measurementsLocalDataSource, accountLocalDataSource);
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

    public void saveAccount(Account account) {
        mAccountLocalDataSource.saveAccount(account);
    }

    public Observable<Account> getAccount() {
        return mAccountLocalDataSource.getAccount();
    }
}
