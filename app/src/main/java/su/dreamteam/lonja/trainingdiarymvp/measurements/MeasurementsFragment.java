package su.dreamteam.lonja.trainingdiarymvp.measurements;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import su.dreamteam.lonja.trainingdiarymvp.R;
import su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement.AddEditMeasurementActivity;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;
import su.dreamteam.lonja.trainingdiarymvp.databinding.FragmentMeasurementsBinding;

import static com.google.common.base.Preconditions.checkNotNull;

public class MeasurementsFragment extends Fragment implements MeasurementsContract.View {

    private MeasurementsContract.Presenter mPresenter;

    private MeasurementsAdapter mListAdapter;

    private MeasurementsViewModel mMeasurementsViewModel;

    public MeasurementsFragment() {

    }

    public static MeasurementsFragment newInstance() {
        return new MeasurementsFragment();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        mPresenter.result(requestCode, resultCode);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentMeasurementsBinding measurementsBinding = FragmentMeasurementsBinding.inflate(inflater, container, false);

        measurementsBinding.setMeasurements(mMeasurementsViewModel);

        measurementsBinding.setActionHandler(mPresenter);

        mListAdapter = new MeasurementsAdapter(new ArrayList<Measurement>(0), mPresenter);

        measurementsBinding.measurementsList.setLayoutManager(new LinearLayoutManager(getContext()));

        measurementsBinding.measurementsList.setAdapter(mListAdapter);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab_add_measurement);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addNewMeasurement();
            }
        });
//        measurementsBinding.refreshLayout.setColorSchemeColors()

//        swipeRefreshLayout.setScrollUpChild(swipeRefreshLayout.listView);

        setHasOptionsMenu(true);

        return measurementsBinding.getRoot();
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.measurements_fragment_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setLoadingIndicator(final boolean active) {
        if (getView() == null) {
            return;
        }
//        final SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) getView().findViewById(R.id.refresh_layout);
//
//        swipeRefreshLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                swipeRefreshLayout.setRefreshing(active);
//            }
//        });
    }

    @Override
    public void showMeasurements(List<Measurement> measurements) {
        mListAdapter.replaceData(measurements);
        mMeasurementsViewModel.setMeasurementsListSize(measurements.size());
    }

    @Override
    public void showAddMeasurement() {
        Intent intent = new Intent(getContext(), AddEditMeasurementActivity.class);
        startActivityForResult(intent, AddEditMeasurementActivity.REQUEST_ADD_MEASUREMENT);
    }

    @Override
    public void showMeasurementEdit(String measurementId) {
        Intent intent = new Intent(getContext(), AddEditMeasurementActivity.class);
        intent.putExtra(AddEditMeasurementActivity.ARGUMENT_EDIT_MEASUREMENT_ID, measurementId);
        startActivityForResult(intent, AddEditMeasurementActivity.REQUEST_EDIT_MEASUREMENT);
    }

    @Override
    public void showMeasurementsCleared() {
        showMessage(getString(R.string.measurements_cleared));
    }

    @Override
    public void showLoadingMeasurementsError() {
        showMessage(getString(R.string.loading_measurements_error));
    }

    @Override
    public void showSuccessfullySavedMessage() {
        showMessage(getString(R.string.measurement_saved));
    }

    private void showMessage(String message) {
        Snackbar.make(getView(), message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void setPresenter(MeasurementsContract.Presenter presenter) {
        mPresenter = checkNotNull(presenter);
    }

    public void setViewModel(MeasurementsViewModel viewModel) {
        mMeasurementsViewModel = viewModel;
    }
}
