package su.dreamteam.lonja.trainingdiarymvp.measurements;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.graphics.drawable.Drawable;

import su.dreamteam.lonja.trainingdiarymvp.R;

public class MeasurementsViewModel extends BaseObservable {

    int mMeasurementsSize = 0;

    private Context mContext;

    public MeasurementsViewModel(Context context) {
        mContext = context;
    }

    @Bindable
    public String getNoMeasurementsLabel() {
        return mContext.getString(R.string.no_measurements);
    }


    @Bindable
    public Drawable getNoMeasurementsIconRes() {
        return mContext.getDrawable(R.drawable.ruler);
    }

    @Bindable
    public boolean isNotEmpty() {
        return mMeasurementsSize > 0;
    }

    public void setMeasurementsListSize(int measurementsListSize) {
        mMeasurementsSize = measurementsListSize;
    }

}
