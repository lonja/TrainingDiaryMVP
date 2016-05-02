package su.dreamteam.lonja.trainingdiarymvp.util;


import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;

public class MeasurementUtils {

    public static Measurement copyToNewMeasurement(Measurement measurement) {
        Measurement result = new Measurement();
        result.setId(measurement.getId());
        result.setDate(measurement.getDate());
        result.setComment(measurement.getComment());
        result.setWeight(measurement.getWeight());
        result.setChest(measurement.getChest());
        result.setLeftThigh(measurement.getLeftThigh());
        result.setRightThigh(measurement.getRightThigh());
        result.setLeftCalf(measurement.getLeftCalf());
        result.setRightCalf(measurement.getRightCalf());
        result.setLeftArm(measurement.getLeftArm());
        result.setRightArm(measurement.getRightArm());
        result.setLeftForearm(measurement.getLeftForearm());
        result.setRightForearm(measurement.getRightForearm());
        result.setWaist(measurement.getWaist());
        result.setNeck(measurement.getNeck());
        result.setAaa(measurement.getAaa());
        return result;
    }

}
