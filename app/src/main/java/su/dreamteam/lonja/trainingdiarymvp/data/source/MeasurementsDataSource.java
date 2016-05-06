package su.dreamteam.lonja.trainingdiarymvp.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import io.realm.RealmResults;
import rx.Observable;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;

public interface MeasurementsDataSource {

    Observable<RealmResults<Measurement>> getMeasurements();

    Observable<Measurement> getMeasurement(@NonNull String measurementId);

    void saveMeasurement(@NonNull Measurement measurement);

    void refreshMeasurements();

    void deleteAllMeasurements();

    void deleteMeasurement(@NonNull String measurementId);

    void update();

    void commit();

    void cancel();

}
