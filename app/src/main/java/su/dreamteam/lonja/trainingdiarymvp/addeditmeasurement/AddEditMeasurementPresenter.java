package su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement;

import android.app.DatePickerDialog;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Date;

import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;
import su.dreamteam.lonja.trainingdiarymvp.data.source.MeasurementsDataSource;

import static com.google.common.base.Preconditions.checkNotNull;

public class AddEditMeasurementPresenter implements AddEditMeasurementContract.Presenter,
        MeasurementsDataSource.GetMeasurementCallback {

    @NonNull
    private final MeasurementsDataSource mMeasurementsRepository;

    @NonNull
    private final AddEditMeasurementContract.View mAddEditMeasurementView;

    @Nullable
    private String mMeasurementId;

    public AddEditMeasurementPresenter(
            @NonNull MeasurementsDataSource measurementsRepository,
            @NonNull AddEditMeasurementContract.View addEditMeasurementView,
            @Nullable String measurementId) {
        mMeasurementsRepository = checkNotNull(measurementsRepository);
        mAddEditMeasurementView = checkNotNull(addEditMeasurementView);
        mMeasurementId = measurementId;
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

    }

    @Override
    public void createMeasurement(Measurement measurement) {
        mMeasurementsRepository.saveMeasurement(measurement);
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
        if (mMeasurementId == null) {
            throw new RuntimeException("updateTask() was called but task is new.");
        }
        mMeasurementsRepository.saveMeasurement(measurement);
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
        mMeasurementsRepository.getMeasurement(mMeasurementId, this);
    }

    @Override
    public void start() {
        if (mMeasurementId != null) {
            populateMeasurement();
        }
    }

    @Override
    public void onMeasurementLoaded(Measurement measurements) {
        mAddEditMeasurementView.setMeasurement(measurements);
    }

    @Override
    public void onDataNotAvailable() {
        mAddEditMeasurementView.showEmptyMeasurementError();
    }
}
