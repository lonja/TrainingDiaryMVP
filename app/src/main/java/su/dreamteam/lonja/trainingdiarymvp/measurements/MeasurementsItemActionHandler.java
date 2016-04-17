package su.dreamteam.lonja.trainingdiarymvp.measurements;


import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;

public class MeasurementsItemActionHandler {

    private MeasurementsContract.Presenter mListener;

    public MeasurementsItemActionHandler(MeasurementsContract.Presenter listener) {
        mListener = listener;
    }

    public void measurementClicked(Measurement measurement) {
        mListener.editMeasurement(measurement);
    }

}