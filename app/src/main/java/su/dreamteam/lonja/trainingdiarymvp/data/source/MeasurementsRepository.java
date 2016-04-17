package su.dreamteam.lonja.trainingdiarymvp.data.source;


import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;

import static com.google.common.base.Preconditions.checkNotNull;

public class MeasurementsRepository implements MeasurementsDataSource {

    private static MeasurementsRepository INSTANCE = null;

    private final MeasurementsDataSource mMeasurementsLocalDataSource;

    Map<String, Measurement> mCachedMeasurements;

    boolean mCacheIsDirty = false;

    private MeasurementsRepository(@NonNull MeasurementsDataSource measurementsLocalDataSource) {
        mMeasurementsLocalDataSource = checkNotNull(measurementsLocalDataSource);
    }

    public static MeasurementsRepository getInstance(MeasurementsDataSource measurementsLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new MeasurementsRepository(measurementsLocalDataSource);
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

    @Override
    public void getMeasurements(@NonNull final GetMeasurementsCallback callback) {
        checkNotNull(callback);

        if (mCachedMeasurements != null && !mCacheIsDirty) {
            callback.onMeasurementsLoaded(new ArrayList<>(mCachedMeasurements.values()));
            return;
        }

        mMeasurementsLocalDataSource.getMeasurements(new GetMeasurementsCallback() {

            @Override
            public void onMeasurementsLoaded(List<Measurement> measurements) {
                refreshCache(measurements);
                callback.onMeasurementsLoaded(new ArrayList<>(mCachedMeasurements.values()));
            }

            @Override
            public void onDataNotAvailable() {

            }
        });

    }


    @Override
    public void getMeasurement(@NonNull String measurementId, @NonNull final GetMeasurementCallback callback) {
        checkNotNull(measurementId);
        checkNotNull(callback);

        Measurement cachedMeasurement = getMeasurementWithId(measurementId);

        if (cachedMeasurement != null) {
            callback.onMeasurementLoaded(cachedMeasurement);
            return;
        }

        mMeasurementsLocalDataSource.getMeasurement(measurementId, new GetMeasurementCallback() {
            @Override
            public void onMeasurementLoaded(Measurement measurement) {
                callback.onMeasurementLoaded(measurement);
            }

            @Override
            public void onDataNotAvailable() {
                callback.onDataNotAvailable();
            }
        });
    }

    @Override
    public void saveMeasurement(@NonNull Measurement measurement) {
        checkNotNull(measurement);
        mMeasurementsLocalDataSource.saveMeasurement(measurement);

        if (mCachedMeasurements == null) {
            mCachedMeasurements = new LinkedHashMap<>();
        }
        mCachedMeasurements.put(measurement.getId(), measurement);
    }

    @Override
    public void updateMeasurement(@NonNull Measurement measurement) {
        checkNotNull(measurement);
        mMeasurementsLocalDataSource.updateMeasurement(measurement);
        mCachedMeasurements.remove(measurement.getId());
        mCachedMeasurements.put(measurement.getId(), measurement);
    }

    @Override
    public void refreshMeasurements() {
        mCacheIsDirty = true;
    }

    @Override
    public void deleteAllMeasurements() {
        mMeasurementsLocalDataSource.deleteAllMeasurements();

        if (mCachedMeasurements == null) {
            mCachedMeasurements = new LinkedHashMap<>();
        }
        mCachedMeasurements.clear();
    }

    @Override
    public void deleteMeasurement(@NonNull String measurementId) {
        mMeasurementsLocalDataSource.deleteMeasurement(checkNotNull(measurementId));

        mCachedMeasurements.remove(measurementId);
    }

    private void getMeasurementsFromLocalDataSource(@NonNull final GetMeasurementsCallback callback) {

    }

    private void refreshCache(List<Measurement> measurements) {
        if (mCachedMeasurements == null) {
            mCachedMeasurements = new LinkedHashMap<>();
        }
        mCachedMeasurements.clear();
        for (Measurement measurement : measurements) {
            mCachedMeasurements.put(measurement.getId(), measurement);
        }
        mCacheIsDirty = false;
    }

    private void refreshLocalDataSource(List<Measurement> measurements) {
        mMeasurementsLocalDataSource.deleteAllMeasurements();
        for (Measurement measurement : measurements) {
            mMeasurementsLocalDataSource.saveMeasurement(measurement);
        }
    }

    @Nullable
    private Measurement getMeasurementWithId(@NonNull String id) {
        checkNotNull(id);
        if (mCachedMeasurements == null || mCachedMeasurements.isEmpty()) {
            return null;
        } else {
            return mCachedMeasurements.get(id);
        }
    }
}
