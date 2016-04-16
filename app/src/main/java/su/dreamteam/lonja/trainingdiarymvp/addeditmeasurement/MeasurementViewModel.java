package su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.TextView;

import java.util.Calendar;

import su.dreamteam.lonja.trainingdiarymvp.BR;
import su.dreamteam.lonja.trainingdiarymvp.R;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;

public class MeasurementViewModel extends BaseObservable {

    private Context mContext;

    private Measurement mMeasurement;

    private String weight;

    private String chest;

    private String leftCalf;
    private String rightCalf;

    private String leftThigh;
    private String rightThigh;

    private String leftArm;
    private String rightArm;

    private String leftForearm;
    private String rightForearm;

    private String waist;

    private String neck;

    public MeasurementViewModel(Context context) {
        mContext = context;
        mMeasurement = new Measurement();
    }

    public MeasurementViewModel(Measurement measurement) {
        mMeasurement = measurement;
    }

    @Bindable
    public String getDate() {
        return mMeasurement.getDate() == null ? "хуй" : DateFormat.format(
                "dd MMMM yyyy, HH:mm",
                mMeasurement.getDate()
        ).toString();
    }

    public void setDate(Calendar date) {
        mMeasurement.setDate(date.getTime());
        notifyPropertyChanged(BR.date);
    }

    @Bindable
    public String getComment() {
        return mMeasurement.getComment();
    }

    public void setComment(String comment) {
        mMeasurement.setComment(comment);
        notifyPropertyChanged(BR.date);
    }

    @Bindable
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
        mMeasurement.setWeight(Double.parseDouble(weight));
        notifyPropertyChanged(BR.weight);
    }

    @Bindable
    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
        mMeasurement.setWeight(Double.parseDouble(chest));
        notifyPropertyChanged(BR.chest);
    }

    @Bindable
    public String getLeftCalf() {
        return leftCalf;
    }

    public void setLeftCalf(String leftCalf) {
        this.leftCalf = leftCalf;
        mMeasurement.setWeight(Double.parseDouble(leftCalf));
        notifyPropertyChanged(BR.leftCalf);
    }

    @Bindable
    public String getRightCalf() {
        return rightCalf;
    }

    public void setRightCalf(String rightCalf) {
        this.rightCalf = rightCalf;
        mMeasurement.setWeight(Double.parseDouble(rightCalf));
        notifyPropertyChanged(BR.rightCalf);
    }

    @Bindable
    public String getLeftThigh() {
        return leftThigh;
    }

    public void setLeftThigh(String leftThigh) {
        this.leftThigh = leftThigh;
        mMeasurement.setWeight(Double.parseDouble(leftThigh));
        notifyPropertyChanged(BR.leftThigh);
    }

    @Bindable
    public String getRightThigh() {
        return rightThigh;
    }

    public void setRightThigh(String rightThigh) {
        this.rightThigh = rightThigh;
        mMeasurement.setWeight(Double.parseDouble(rightThigh));
        notifyPropertyChanged(BR.rightThigh);
    }

    @Bindable
    public String getLeftArm() {
        return leftArm;
    }

    public void setLeftArm(String leftArm) {
        this.leftArm = leftArm;
        mMeasurement.setWeight(Double.parseDouble(leftArm));
        notifyPropertyChanged(BR.leftArm);
    }

    @Bindable
    public String getRightArm() {
        return rightArm;
    }

    public void setRightArm(String rightArm) {
        this.rightArm = rightArm;
        mMeasurement.setWeight(Double.parseDouble(rightArm));
        notifyPropertyChanged(BR.rightArm);
    }

    @Bindable
    public String getLeftForearm() {
        return leftForearm;
    }

    public void setLeftForearm(String leftForearm) {
        this.leftForearm = leftForearm;
        mMeasurement.setWeight(Double.parseDouble(leftForearm));
        notifyPropertyChanged(BR.leftForearm);
    }


    @Bindable
    public String getRightForearm() {
        return rightForearm;
    }

    public void setRightForearm(String rightForearm) {
        this.rightForearm = rightForearm;
        mMeasurement.setWeight(Double.parseDouble(rightForearm));
        notifyPropertyChanged(BR.rightForearm);
    }

    @Bindable
    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
        mMeasurement.setWeight(Double.parseDouble(waist));
        notifyPropertyChanged(BR.waist);
    }

    @Bindable
    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
        mMeasurement.setWeight(Double.parseDouble(neck));
        notifyPropertyChanged(BR.neck);
    }

//    @BindingAdapter("android:text")
//    public static void setCommentText(final TextView view, MeasurementViewModel viewModel) {
//        view.setText(viewModel.getComment() != null ? viewModel.getComment() : R.string.comment_empty);
//    }

    public void setMeasurement(Measurement measurement) {
        mMeasurement = measurement;
    }

    public Measurement getMeasurement() {
        return mMeasurement;
    }
}
