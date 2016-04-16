package su.dreamteam.lonja.trainingdiarymvp.measurements;

import android.app.Activity;
import android.support.annotation.NonNull;

import java.util.List;

import su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement.AddEditMeasurementActivity;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;
import su.dreamteam.lonja.trainingdiarymvp.data.source.MeasurementsDataSource;
import su.dreamteam.lonja.trainingdiarymvp.data.source.MeasurementsRepository;

import static com.google.common.base.Preconditions.checkNotNull;

public class MeasurementsPresenter implements MeasurementsContract.Presenter {

    private final MeasurementsRepository mMeasurementsRepository;

    private final MeasurementsContract.View mMeasurementsView;

    private boolean mFirstLoad = true;

    public MeasurementsPresenter(MeasurementsRepository measurementsRepository, MeasurementsContract.View measurementsView) {
        mMeasurementsRepository = measurementsRepository;
        mMeasurementsView = measurementsView;

        mMeasurementsView.setPresenter(this);
    }

    @Override
    public void result(int requestCode, int resultCode) {
        if (AddEditMeasurementActivity.REQUEST_ADD_MEASUREMENT == requestCode && Activity.RESULT_OK == resultCode) {
            mMeasurementsView.showSuccessfullySavedMessage();
        }
    }

    @Override
    public void loadMeasurements(boolean forceUpdate) {
        loadMeasurements(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    private void loadMeasurements(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mMeasurementsView.setLoadingIndicator(true);
        }
        if (forceUpdate) {
            mMeasurementsRepository.refreshMeasurements();
        }
        mMeasurementsRepository.getMeasurements(new MeasurementsDataSource.GetMeasurementsCallback() {
            @Override
            public void onMeasurementsLoaded(List<Measurement> measurements) {
                if (!mMeasurementsView.isActive()) {
                    return;
                }
                if (showLoadingUI) {
                    mMeasurementsView.setLoadingIndicator(false);
                }
                mMeasurementsView.showMeasurements(measurements);
            }

            @Override
            public void onDataNotAvailable() {
                if (!mMeasurementsView.isActive()) {
                    return;
                }
                mMeasurementsView.showLoadingMeasurementsError();
            }
        });
    }

    @Override
    public void addNewMeasurement() {
        mMeasurementsView.showAddMeasurement();
    }

    @Override
    public void editMeasurement(@NonNull Measurement requestedMeasurement) {
        checkNotNull(requestedMeasurement, "requestedMeasurement cannot be null!");
        mMeasurementsView.showMeasurementEdit(requestedMeasurement.getId());
    }

    @Override
    public void start() {
        loadMeasurements(false);
    }
}