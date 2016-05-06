package su.dreamteam.lonja.trainingdiarymvp.data;

import java.util.Date;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

@RealmClass
public class Measurement extends RealmObject {

    @PrimaryKey
    private String id;

    @Required
    @Index
    private Date date;

    private String comment;

    private Double weight;

    private Double chest;

    private Double leftCalf;
    private Double rightCalf;

    private Double leftThigh;
    private Double rightThigh;

    private Double leftArm;
    private Double rightArm;

    private Double leftForearm;
    private Double rightForearm;

    private Double waist;

    private Double neck;

    public Measurement() {
        this.id = UUID.randomUUID().toString();
        this.date = new Date();
    }

    public Measurement(Measurement measurement) {
        id = measurement.getId();
        date = measurement.getDate();
        comment = measurement.getComment();
        weight = measurement.getWeight();
        chest = measurement.getChest();
        leftCalf = measurement.getLeftCalf();
        rightCalf = measurement.getRightCalf();
        leftThigh = measurement.getLeftThigh();
        rightThigh = measurement.getRightThigh();
        leftArm = measurement.getLeftArm();
        rightArm = measurement.getRightArm();
        leftForearm = measurement.getLeftForearm();
        rightForearm = measurement.getRightForearm();
        waist = measurement.getWaist();
        neck = measurement.getNeck();
    }

    public Measurement(Date date, String comment, Double weight, Double chest, Double leftCalf,
                       Double rightCalf, Double leftThigh, Double rightThigh, Double leftArm,
                       Double rightArm, Double leftForearm, Double rightForearm, Double waist,
                       Double neck) {
        this();
        this.date = date;
        this.comment = comment;
        this.weight = weight;
        this.chest = chest;
        this.leftCalf = leftCalf;
        this.rightCalf = rightCalf;
        this.leftThigh = leftThigh;
        this.rightThigh = rightThigh;
        this.leftArm = leftArm;
        this.rightArm = rightArm;
        this.leftForearm = leftForearm;
        this.rightForearm = rightForearm;
        this.waist = waist;
        this.neck = neck;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return (isLoaded()) ? date : new Date();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return (isLoaded()) ? comment : null;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Double getWeight() {
        return (isLoaded()) ? weight : null;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getChest() {
        return (isLoaded()) ? chest : null;
    }

    public void setChest(Double chest) {
        this.chest = chest;
    }

    public Double getLeftCalf() {
        return (isLoaded()) ? leftCalf : null;
    }

    public void setLeftCalf(Double lftCalf) {
        this.leftCalf = lftCalf;
    }

    public Double getRightCalf() {
        return (isLoaded()) ? rightCalf : null;
    }

    public void setRightCalf(Double rightCalf) {
        this.rightCalf = rightCalf;
    }

    public Double getLeftThigh() {
        return (isLoaded()) ? leftThigh : null;
    }

    public void setLeftThigh(Double leftThigh) {
        this.leftThigh = leftThigh;
    }

    public Double getRightThigh() {
        return (isLoaded()) ? rightThigh : null;
    }

    public void setRightThigh(Double rightThigh) {
        this.rightThigh = rightThigh;
    }

    public Double getLeftArm() {
        return (isLoaded()) ? leftArm : null;
    }

    public void setLeftArm(Double leftArm) {
        this.leftArm = leftArm;
    }

    public Double getRightArm() {
        return (isLoaded()) ? rightArm : null;
    }

    public void setRightArm(Double rightArm) {
        this.rightArm = rightArm;
    }

    public Double getLeftForearm() {
        return (isLoaded()) ? leftForearm : null;
    }

    public void setLeftForearm(Double leftForearm) {
        this.leftForearm = leftForearm;
    }

    public Double getRightForearm() {
        return (isLoaded()) ? rightForearm : null;
    }

    public void setRightForearm(Double rightForearm) {
        this.rightForearm = rightForearm;
    }

    public Double getWaist() {
        return (isLoaded()) ? waist : null;
    }

    public void setWaist(Double waist) {
        this.waist = waist;
    }

    public Double getNeck() {
        return (isLoaded()) ? neck : null;
    }

    public void setNeck(Double neck) {
        this.neck = neck;
    }

    public boolean isEmpty() {
        return weight == null && chest == null && leftCalf == null && rightCalf == null &&
                leftThigh == null && rightThigh == null && leftArm == null && rightArm == null &&
                leftForearm == null && rightForearm == null && waist == null && neck == null;
    }
}
