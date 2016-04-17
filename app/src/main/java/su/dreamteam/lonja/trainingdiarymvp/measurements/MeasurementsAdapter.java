package su.dreamteam.lonja.trainingdiarymvp.measurements;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import su.dreamteam.lonja.trainingdiarymvp.R;
import su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement.MeasurementViewModel;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;
import su.dreamteam.lonja.trainingdiarymvp.databinding.MeasurementItemBinding;

public class MeasurementsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Measurement> mMeasurements;

    private MeasurementsContract.Presenter mUserActionListener;

    private Context mContext;

    private ViewDataBinding mBinding;

    public MeasurementsAdapter(List<Measurement> measurements, MeasurementsContract.Presenter userActionListener) {
        setData(measurements);
        mUserActionListener = userActionListener;
    }

    private void setData(List<Measurement> measurements) {
        mMeasurements = measurements;
        notifyDataSetChanged();
    }

    public void replaceData(List<Measurement> measurements) {
        setData(measurements);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(mContext);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.measurement_item, parent, false);
        return new MeasurementViewHolder(mBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MeasurementViewHolder measurementHolder = (MeasurementViewHolder) holder;
        measurementHolder.binding.setMeasurement(mMeasurements.get(position));
        MeasurementsItemActionHandler itemActionHandler = new MeasurementsItemActionHandler(mUserActionListener);
        measurementHolder.binding.setActionHandler(itemActionHandler);
    }

    @Override
    public int getItemCount() {
        return mMeasurements != null ? mMeasurements.size() : 0;
    }
}
