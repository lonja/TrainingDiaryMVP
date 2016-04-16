package su.dreamteam.lonja.trainingdiarymvp.data;

import java.util.Date;
import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Measurement extends RealmObject {

    @PrimaryKey
    private String id;

    @Required
    @Index
    private Date date;

    private String comment;

    private double weight;

    private double chest;

    private double leftCalf;
    private double rightCalf;

    private double leftThigh;
    private double rightThigh;

    private double leftArm;
    private double rightArm;

    private double leftForearm;
    private double rightForearm;

    private double waist;

    private double neck;

    public Measurement() {
        this.id = UUID.randomUUID().toString();
        this.date = new Date();

    }

    public Measurement(Date date, String comment, double weight, double chest, double leftCalf,
                       double rightCalf, double leftThigh, double rightThigh, double leftArm,
                       double rightArm, double leftForearm, double rightForearm, double waist, double neck) {
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

    public String  getId() {
        return id;
    }

    public void setId(String  id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getChest() {
        return chest;
    }

    public void setChest(double chest) {
        this.chest = chest;
    }

    public double getLeftCalf() {
        return leftCalf;
    }

    public void setLeftCalf(double lftCalf) {
        this.leftCalf = lftCalf;
    }

    public double getRightCalf() {
        return rightCalf;
    }

    public void setRightCalf(double rightCalf) {
        this.rightCalf = rightCalf;
    }

    public double getLeftThigh() {
        return leftThigh;
    }

    public void setLeftThigh(double leftThigh) {
        this.leftThigh = leftThigh;
    }

    public double getRightThigh() {
        return rightThigh;
    }

    public void setRightThigh(double rightThigh) {
        this.rightThigh = rightThigh;
    }

    public double getLeftArm() {
        return leftArm;
    }

    public void setLeftArm(double leftArm) {
        this.leftArm = leftArm;
    }

    public double getRightArm() {
        return rightArm;
    }

    public void setRightArm(double rightArm) {
        this.rightArm = rightArm;
    }

    public double getLeftForearm() {
        return leftForearm;
    }

    public void setLeftForearm(double leftForearm) {
        this.leftForearm = leftForearm;
    }

    public double getRightForearm() {
        return rightForearm;
    }

    public void setRightForearm(double rightForearm) {
        this.rightForearm = rightForearm;
    }

    public double getWaist() {
        return waist;
    }

    public void setWaist(double waist) {
        this.waist = waist;
    }

    public double getNeck() {
        return neck;
    }

    public void setNeck(double neck) {
        this.neck = neck;
    }

}
