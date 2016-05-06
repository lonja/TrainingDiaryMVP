package su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;

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
    public void createMeasurement(
            Date date,
            String comment,
            double weight,
            double chest,
            double leftCalf,
            double rightCalf,
            double leftThigh,
            double rightThigh,
            double leftArm,
            double rightArm,
            double leftForearm,
            double rightForearm,
            double waist,
            double neck) {
        Measurement measurement = new Measurement(date, comment, weight, chest, leftCalf, rightCalf,
                leftThigh, rightThigh, leftArm, rightArm, leftForearm, rightForearm, waist, neck);
        if (measurement.isEmpty()) {
            mAddEditMeasurementView.showEmptyMeasurementError();
        } else {
            mDataManager.saveMeasurement(measurement);
            mAddEditMeasurementView.showMeasurementsList();
        }
    }

    @Override
    public void createMeasurement(Measurement measurement) {
        mDataManager.saveMeasurement(measurement);
        mAddEditMeasurementView.showMeasurementsList();
    }

    @Override
    public void updateMeasurement(
            Date date,
            String comment,
            double weight,
            double chest,
            double leftCalf,
            double rightCalf,
            double leftThigh,
            double rightThigh,
            double leftArm,
            double rightArm,
            double leftForearm,
            double rightForearm,
            double waist,
            double neck) {

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
                .filter(measurement -> measurement.isValid())
                .doOnNext(measurement -> {
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

    private boolean isNewMeasurement() {
        return mMeasurementId == null;
    }

    @Override
    public void unsubscribe() {
        if (mDataManager.hasActiveTransaction()) {
            mDataManager.cancelMeasurementChanges();
        }
        mSubscriptions.clear();
    }
}