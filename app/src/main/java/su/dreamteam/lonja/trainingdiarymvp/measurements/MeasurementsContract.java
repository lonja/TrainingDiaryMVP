package su.dreamteam.lonja.trainingdiarymvp.measurements;

import android.support.annotation.NonNull;

import java.util.List;

import su.dreamteam.lonja.trainingdiarymvp.base.BasePresenter;
import su.dreamteam.lonja.trainingdiarymvp.base.BaseView;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;

public interface MeasurementsContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showMeasurements(List<Measurement> measurements);

        void showAddMeasurement();

        void showMeasurementEdit(String measurementId);

        void showMeasurementsCleared();

        void showLoadingMeasurementsError();

        void showSuccessfullySavedMessage();

        boolean isActive();
    }

    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void loadMeasurements(boolean forceUpdate);

        void addNewMeasurement();

        void editMeasurement(@NonNull Measurement requestedMeasurement);

    }

}
