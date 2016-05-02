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

        void createMeasurement(
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
                double neck);

        void createMeasurement(Measurement measurement);

        void updateMeasurement(
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
                double neck);

        void setDateTime();

        void setComment();

        void updateMeasurement(Measurement measurement);

        void populateMeasurement();
    }

}
