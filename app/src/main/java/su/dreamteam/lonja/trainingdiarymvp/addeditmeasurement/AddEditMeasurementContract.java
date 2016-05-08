package su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement;

import java.util.Date;

import su.dreamteam.lonja.trainingdiarymvp.base.BasePresenter;
import su.dreamteam.lonja.trainingdiarymvp.base.BaseView;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;

public interface AddEditMeasurementContract {

    interface View extends BaseView<Presenter> {

        void showEmptyMeasurementError();

        void showMeasurementsList();

        void showSetDateTimeDialog();

        void showSetCommentDialog();

        void setMeasurement(Measurement measurement);
    }

    interface Presenter extends BasePresenter {

        void createMeasurement(Measurement measurement);

        void setDateTime();

        void setComment();

        void updateMeasurement(Measurement measurement);

        void populateMeasurement();
    }

}
