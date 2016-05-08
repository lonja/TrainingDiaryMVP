package su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;
import su.dreamteam.lonja.trainingdiarymvp.data.source.DataManager;

import static com.google.common.base.Preconditions.checkNotNull;

public class AddEditMeasurementPresenter implements AddEditMeasurementContract.Presenter {

    @NonNull
    private final DataManager mDataManager;

    @NonNull
    private final AddEditMeasurementContract.View mAddEditMeasurementView;

    @Nullable
    private String mMeasurementId;

    private CompositeSubscription mSubscriptions;

    public AddEditMeasurementPresenter(
            @NonNull DataManager dataManager,
            @NonNull AddEditMeasurementContract.View addEditMeasurementView,
            @Nullable String measurementId) {
        mDataManager = checkNotNull(dataManager);
        mAddEditMeasurementView = checkNotNull(addEditMeasurementView);
        mMeasurementId = measurementId;
        mSubscriptions = new CompositeSubscription();
        mAddEditMeasurementView.setPresenter(this);
    }

    @Override
    public void createMeasurement(Measurement measurement) {
        mDataManager.saveMeasurement(measurement);
        mAddEditMeasurementView.showMeasurementsList();
    }

    @Override
    public void updateMeasurement(Measurement measurement) {
        mDataManager.commitMeasurementChanges();
        mAddEditMeasurementView.showMeasurementsList();
    }

    @Override
    public void setDateTime() {
        mAddEditMeasurementView.showSetDateTimeDialog();
    }

    @Override
    public void setComment() {
        mAddEditMeasurementView.showSetCommentDialog();
    }

    @Override
    public void populateMeasurement() {
        if (mMeasurementId == null) {
            throw new RuntimeException("populateMeasurement() was called but task is new.");
        }
        mSubscriptions.clear();
        Subscription subscription = mDataManager.getMeasurement(mMeasurementId)
                .filter(measurement -> measurement.isLoaded())
                .first()
                .doOnNext(measurement -> {
                    Log.e("Measurement", measurement.toString());
                    mAddEditMeasurementView.setMeasurement(measurement);
                    mDataManager.updateMeasurement();
                })
                .doOnError(throwable -> mAddEditMeasurementView.showEmptyMeasurementError())
                .subscribe();
        mSubscriptions.add(subscription);
    }

    @Override
    public void subscribe() {
        if (mMeasurementId != null) {
            populateMeasurement();
        }
    }

    @Override
    public void unsubscribe() {
        if (mDataManager.hasActiveTransaction()) {
            mDataManager.cancelMeasurementChanges();
        }
        mSubscriptions.clear();
    }
}