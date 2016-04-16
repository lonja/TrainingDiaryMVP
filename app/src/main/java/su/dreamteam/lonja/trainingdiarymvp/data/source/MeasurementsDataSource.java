package su.dreamteam.lonja.trainingdiarymvp.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;

public interface MeasurementsDataSource {

    interface GetMeasurementsCallback {

        void onMeasurementsLoaded(List<Measurement> measurements);

        void onDataNotAvailable();

    }

    interface GetMeasurementCallback {

        void onMeasurementLoaded(Measurement measurements);

        void onDataNotAvailable();

    }

    void getMeasurements(@NonNull GetMeasurementsCallback callback);

    void getMeasurement(@NonNull String measurementId, @NonNull GetMeasurementCallback callback);

    void saveMeasurement(@NonNull Measurement measurement);

    void refreshMeasurements();

    void deleteAllMeasurements();

    void deleteMeasurement(@NonNull String measurementId);

}
