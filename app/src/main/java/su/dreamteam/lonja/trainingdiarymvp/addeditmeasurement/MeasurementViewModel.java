package su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;

import com.google.common.math.DoubleMath;

import java.util.Calendar;
import java.util.Objects;

import su.dreamteam.lonja.trainingdiarymvp.BR;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;

import static com.google.common.base.Preconditions.checkNotNull;

public class MeasurementViewModel extends BaseObservable {

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

    private TextWatcher mWeightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setWeight(s.toString());
        }
    };

    private TextWatcher mChestTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setChest(s.toString());
        }
    };

    private TextWatcher mLeftCalfTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setLeftCalf(s.toString());
        }
    };

    private TextWatcher mRightCalfTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setRightCalf(s.toString());
        }
    };

    private TextWatcher mLeftThighTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setLeftThigh(s.toString());
        }
    };

    private TextWatcher mRightThighTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setRightThigh(s.toString());
        }
    };

    private TextWatcher mLeftArmTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setLeftArm(s.toString());
        }
    };

    private TextWatcher mRightArmTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setRightArm(s.toString());
        }
    };

    private TextWatcher mLeftForearmTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setLeftForearm(s.toString());
        }
    };

    private TextWatcher mRightForearmTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setRightForearm(s.toString());
        }
    };

    private TextWatcher mWaistTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setWaist(s.toString());
        }
    };

    private TextWatcher mNeckTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if (s == null) {
                return;
            }
            setNeck(s.toString());
        }
    };

    public MeasurementViewModel() {
        mMeasurement = new Measurement();
        setStringsValues(mMeasurement);
    }

    @Bindable
    public String getDate() {
        return mMeasurement.getDate() == null ? "" : DateFormat.format(
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
        if (mMeasurement.getComment() == null) {
            return "Enter comment";
        } else {
            return mMeasurement.getComment();
        }
    }

    public void setComment(String comment) {
        mMeasurement.setComment(comment);
        notifyPropertyChanged(BR.comment);
    }

    @Bindable
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
        if (Objects.equals(weight, "")) {
            return;
        }
        mMeasurement.setWeight(Double.parseDouble(weight));
        notifyPropertyChanged(BR.weight);
    }

    @Bindable
    public String getChest() {
        return chest;
    }

    public void setChest(String chest) {
        this.chest = chest;
        if (Objects.equals(chest, "")) {
            return;
        }
        mMeasurement.setChest(Double.parseDouble(chest));
        notifyPropertyChanged(BR.chest);
    }

    @Bindable
    public String getLeftCalf() {
        return leftCalf;
    }

    public void setLeftCalf(String leftCalf) {
        this.leftCalf = leftCalf;
        if (Objects.equals(leftCalf, "")) {
            return;
        }
        mMeasurement.setLeftCalf(Double.parseDouble(leftCalf));
        notifyPropertyChanged(BR.leftCalf);
    }

    @Bindable
    public String getRightCalf() {
        return rightCalf;
    }

    public void setRightCalf(String rightCalf) {
        this.rightCalf = rightCalf;
        if (Objects.equals(rightCalf, "")) {
            return;
        }
        mMeasurement.setRightCalf(Double.parseDouble(rightCalf));
        notifyPropertyChanged(BR.rightCalf);
    }

    @Bindable
    public String getLeftThigh() {
        return leftThigh;
    }

    public void setLeftThigh(String leftThigh) {
        this.leftThigh = leftThigh;
        if (Objects.equals(leftThigh, "")) {
            return;
        }
        mMeasurement.setLeftThigh(Double.parseDouble(leftThigh));
        notifyPropertyChanged(BR.leftThigh);
    }

    @Bindable
    public String getRightThigh() {
        return rightThigh;
    }

    public void setRightThigh(String rightThigh) {
        this.rightThigh = rightThigh;
        if (Objects.equals(rightThigh, "")) {
            return;
        }
        mMeasurement.setRightThigh(Double.parseDouble(rightThigh));
        notifyPropertyChanged(BR.rightThigh);
    }

    @Bindable
    public String getLeftArm() {
        return leftArm;
    }

    public void setLeftArm(String leftArm) {
        this.leftArm = leftArm;
        if (Objects.equals(leftArm, "")) {
            return;
        }
        mMeasurement.setLeftArm(Double.parseDouble(leftArm));
        notifyPropertyChanged(BR.leftArm);
    }

    @Bindable
    public String getRightArm() {
        return rightArm;
    }

    public void setRightArm(String rightArm) {
        this.rightArm = rightArm;
        if (Objects.equals(rightForearm, "")) {
            return;
        }
        mMeasurement.setRightArm(Double.parseDouble(rightArm));
        notifyPropertyChanged(BR.rightArm);
    }

    @Bindable
    public String getLeftForearm() {
        return leftForearm;
    }

    public void setLeftForearm(String leftForearm) {
        this.leftForearm = leftForearm;
        if (Objects.equals(leftForearm, "")) {
            return;
        }
        mMeasurement.setLeftForearm(Double.parseDouble(leftForearm));
        notifyPropertyChanged(BR.leftForearm);
    }


    @Bindable
    public String getRightForearm() {
        return rightForearm;
    }

    public void setRightForearm(String rightForearm) {
        this.rightForearm = rightForearm;
        if (Objects.equals(rightForearm, "")) {
            return;
        }
        mMeasurement.setRightForearm(Double.parseDouble(rightForearm));
        notifyPropertyChanged(BR.rightForearm);
    }

    @Bindable
    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
        if (Objects.equals(waist, "")) {
            return;
        }
        mMeasurement.setWaist(Double.parseDouble(waist));
        notifyPropertyChanged(BR.waist);
    }

    @Bindable
    public String getNeck() {
        return neck;
    }

    public void setNeck(String neck) {
        this.neck = neck;
        if (Objects.equals(neck, "")) {
            return;
        }
        mMeasurement.setNeck(Double.parseDouble(neck));
        notifyPropertyChanged(BR.neck);
    }

    public TextWatcher getWeightTextWatcher() {
        return mWeightTextWatcher;
    }

    public TextWatcher getChestTextWatcher() {
        return mChestTextWatcher;
    }

    public TextWatcher getLeftCalfTextWatcher() {
        return mLeftCalfTextWatcher;
    }

    public TextWatcher getRightCalfTextWatcher() {
        return mRightCalfTextWatcher;
    }

    public TextWatcher getLeftThighTextWatcher() {
        return mLeftThighTextWatcher;
    }

    public TextWatcher getRightThighTextWatcher() {
        return mRightThighTextWatcher;
    }

    public TextWatcher getLeftArmTextWatcher() {
        return mLeftArmTextWatcher;
    }

    public TextWatcher getRightArmTextWatcher() {
        return mRightArmTextWatcher;
    }

    public TextWatcher getLeftForearmTextWatcher() {
        return mLeftForearmTextWatcher;
    }

    public TextWatcher getRightForearmTextWatcher() {
        return mRightForearmTextWatcher;
    }

    public TextWatcher getWaistTextWatcher() {
        return mWaistTextWatcher;
    }

    public TextWatcher getNeckTextWatcher() {
        return mNeckTextWatcher;
    }

    private void setStringsValues(Measurement measurement) {
        checkNotNull(measurement);
        Double weightDouble = measurement.getWeight();
        Double chestDouble = measurement.getChest();
        Double leftCalfDouble = measurement.getLeftCalf();
        Double rightCalfDouble = measurement.getRightCalf();
        Double leftThighDouble = measurement.getLeftThigh();
        Double rightThighDouble = measurement.getRightThigh();
        Double leftArmDouble = measurement.getLeftArm();
        Double rightArmDouble = measurement.getRightArm();
        Double leftForearmDouble = measurement.getLeftForearm();
        Double rightForearmDouble = measurement.getRightForearm();
        Double waistDouble = measurement.getWaist();
        Double neckDouble = measurement.getNeck();

        if (weightDouble == null) {
            weight = null;
        } else if (DoubleMath.isMathematicalInteger(weightDouble)) {
            weight = Integer.toString(weightDouble.intValue());
        } else {
            weight = weightDouble.toString();
        }

        if (chestDouble == null) {
            chest = null;
        }
        else if (DoubleMath.isMathematicalInteger(chestDouble)) {
            chest = Integer.toString(chestDouble.intValue());
        } else {
            chest = chestDouble.toString();
        }

        if (leftCalfDouble == null) {
            chest = null;
        }
        else if (DoubleMath.isMathematicalInteger(leftCalfDouble)) {
            leftCalf = Integer.toString(leftCalfDouble.intValue());
        } else {
            leftCalf = leftCalfDouble.toString();
        }

        if (rightCalfDouble == null) {
            chest = null;
        }
        else if (DoubleMath.isMathematicalInteger(rightCalfDouble)) {
            rightCalf = Integer.toString(rightCalfDouble.intValue());
        } else {
            rightCalf = rightCalfDouble.toString();
        }

        if (leftThighDouble == null) {
            chest = null;
        }
        else if (DoubleMath.isMathematicalInteger(leftThighDouble)) {
            leftThigh = Integer.toString(leftThighDouble.intValue());
        } else {
            leftThigh = leftThighDouble.toString();
        }

        if (rightThighDouble == null) {
            chest = null;
        }
        else if (DoubleMath.isMathematicalInteger(rightThighDouble)) {
            rightThigh = Integer.toString(rightThighDouble.intValue());
        } else {
            rightThigh = rightThighDouble.toString();
        }

        if (leftArmDouble == null) {
            chest = null;
        }
        else if (DoubleMath.isMathematicalInteger(leftArmDouble)) {
            leftArm = Integer.toString(leftArmDouble.intValue());
        } else {
            leftArm = leftArmDouble.toString();
        }

        if (rightArmDouble == null) {
            chest = null;
        }
        else if (DoubleMath.isMathematicalInteger(rightArmDouble)) {
            rightArm = Integer.toString(rightArmDouble.intValue());
        } else {
            rightArm = rightArmDouble.toString();
        }

        if (leftForearmDouble == null) {
            chest = null;
        }
        else if (DoubleMath.isMathematicalInteger(leftForearmDouble)) {
            leftForearm = Integer.toString(leftForearmDouble.intValue());
        } else {
            leftForearm = leftForearmDouble.toString();
        }

        if (rightForearmDouble == null) {
            chest = null;
        }
        else if (DoubleMath.isMathematicalInteger(rightForearmDouble)) {
            rightForearm = Integer.toString(rightForearmDouble.intValue());
        } else {
            rightForearm = rightForearmDouble.toString();
        }

        if (waistDouble == null) {
            chest = null;
        }
        else if (DoubleMath.isMathematicalInteger(waistDouble)) {
            waist = Integer.toString(waistDouble.intValue());
        } else {
            waist = waistDouble.toString();
        }

        if (neckDouble == null) {
            chest = null;
        }
        else if (DoubleMath.isMathematicalInteger(neckDouble)) {
            neck = Integer.toString(neckDouble.intValue());
        } else {
            neck = neckDouble.toString();
        }

        notifyPropertyChanged(BR.weight);
        notifyPropertyChanged(BR.chest);
        notifyPropertyChanged(BR.leftCalf);
        notifyPropertyChanged(BR.rightCalf);
        notifyPropertyChanged(BR.leftThigh);
        notifyPropertyChanged(BR.rightThigh);
        notifyPropertyChanged(BR.leftArm);
        notifyPropertyChanged(BR.rightArm);
        notifyPropertyChanged(BR.leftForearm);
        notifyPropertyChanged(BR.rightForearm);
        notifyPropertyChanged(BR.waist);
        notifyPropertyChanged(BR.neck);
    }

    public void setMeasurement(Measurement measurement) {
        mMeasurement = measurement;
        setStringsValues(measurement);
    }

    public Measurement getMeasurement() {
        return mMeasurement;
    }
}