package su.dreamteam.lonja.trainingdiarymvp.measurements;


import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;

public class MeasurementsItemActionHandler {

    private MeasurementsContract.Presenter mListener;

    public MeasurementsItemActionHandler(MeasurementsContract.Presenter listener) {
        mListener = listener;
    }

    public void measurementClicker(Measurement measurement) {
        mListener.editMeasurement(measurement);
    }

}