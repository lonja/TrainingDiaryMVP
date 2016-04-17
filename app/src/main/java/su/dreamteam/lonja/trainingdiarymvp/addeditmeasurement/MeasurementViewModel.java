package su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.format.DateFormat;

import java.util.Calendar;

import su.dreamteam.lonja.trainingdiarymvp.BR;
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

    private TextWatcher mWeightTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
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
            setNeck(s.toString());
        }
    };

    public MeasurementViewModel(Context context) {
        mContext = context;
        mMeasurement = new Measurement();
        setValues(mMeasurement);
    }

    public MeasurementViewModel(Measurement measurement) {
        mMeasurement = measurement;
        setValues(mMeasurement);
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
        if (weight.equals("")) {
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
        if (chest.equals("")) {
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
        if (leftCalf.equals("")) {
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
        if (rightCalf.equals("")) {
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
        if (leftThigh.equals("")) {
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
        if (rightThigh.equals("")) {
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
        if (leftArm.equals("")) {
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
        if (rightForearm.equals("")) {
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
        if (leftForearm.equals("")) {
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
        if (rightForearm.equals("")) {
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
        if (waist.equals("")) {
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
        if (neck.equals("")) {
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

    private void setValues(Measurement measurement) {
        weight = Double.toString(measurement.getWeight());
        notifyPropertyChanged(BR.weight);
        chest = Double.toString(measurement.getChest());
        notifyPropertyChanged(BR.chest);
        leftCalf = Double.toString(measurement.getLeftCalf());
        notifyPropertyChanged(BR.leftCalf);
        rightCalf = Double.toString(measurement.getRightCalf());
        notifyPropertyChanged(BR.rightCalf);
        leftThigh = Double.toString(measurement.getLeftThigh());
        notifyPropertyChanged(BR.leftThigh);
        rightThigh = Double.toString(measurement.getRightThigh());
        notifyPropertyChanged(BR.rightThigh);
        leftArm = Double.toString(measurement.getLeftArm());
        notifyPropertyChanged(BR.leftArm);
        rightArm = Double.toString(measurement.getRightCalf());
        notifyPropertyChanged(BR.rightArm);
        leftForearm = Double.toString(measurement.getLeftForearm());
        notifyPropertyChanged(BR.leftForearm);
        rightForearm = Double.toString(measurement.getRightForearm());
        notifyPropertyChanged(BR.rightForearm);
        waist = Double.toString(measurement.getWaist());
        notifyPropertyChanged(BR.waist);
        neck = Double.toString(measurement.getNeck());
        notifyPropertyChanged(BR.neck);
    }

    public void setMeasurement(Measurement measurement) {
        mMeasurement = measurement;
        setValues(measurement);
    }

    public Measurement getMeasurement() {
        return mMeasurement;
    }
}
