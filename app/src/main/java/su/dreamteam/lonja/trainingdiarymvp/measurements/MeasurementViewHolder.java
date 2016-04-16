package su.dreamteam.lonja.trainingdiarymvp.measurements;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import su.dreamteam.lonja.trainingdiarymvp.databinding.MeasurementItemBinding;

public class MeasurementViewHolder extends RecyclerView.ViewHolder {

    MeasurementItemBinding binding;

    public MeasurementViewHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
    }

}
