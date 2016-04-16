package su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import su.dreamteam.lonja.trainingdiarymvp.R;
import su.dreamteam.lonja.trainingdiarymvp.data.source.MeasurementsRepository;
import su.dreamteam.lonja.trainingdiarymvp.data.source.local.MeasurementsLocalDataSource;
import su.dreamteam.lonja.trainingdiarymvp.util.ActivityUtils;

public class AddEditMeasurementActivity extends AppCompatActivity {

    public static final String ARGUMENT_EDIT_MEASUREMENT_ID = "EDIT_MEASUREMENT_ID";

    public static final int REQUEST_ADD_MEASUREMENT = 1;

    public static final int REQUEST_EDIT_MEASUREMENT = 2;

    private AddEditMeasurementPresenter mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_measurement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        AddEditMeasurementFragment addEditMeasurementFragment =
                (AddEditMeasurementFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);

        String measurementId = null;
        if (addEditMeasurementFragment == null) {
            addEditMeasurementFragment = AddEditMeasurementFragment.newInstance();

            if (getIntent().hasExtra(AddEditMeasurementFragment.ARGUMENT_EDIT_MEASUREMENT_ID)) {
                measurementId = getIntent().getStringExtra(AddEditMeasurementFragment.ARGUMENT_EDIT_MEASUREMENT_ID);
                actionBar.setTitle(R.string.edit_measurement);
                Bundle bundle = new Bundle();
                bundle.putString(AddEditMeasurementFragment.ARGUMENT_EDIT_MEASUREMENT_ID, measurementId);
                addEditMeasurementFragment.setArguments(bundle);
            } else {
                actionBar.setTitle(R.string.add_measurement);
            }

            mPresenter = new AddEditMeasurementPresenter(
                    MeasurementsRepository.getInstance(MeasurementsLocalDataSource.getInstance()),
                    addEditMeasurementFragment,
                    measurementId
            );

            addEditMeasurementFragment.setPresenter(mPresenter);

            MeasurementViewModel viewModel = new MeasurementViewModel(this);

            addEditMeasurementFragment.setViewModel(viewModel);

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    addEditMeasurementFragment, R.id.content_frame);
        }

        new AddEditMeasurementPresenter(
                MeasurementsRepository.getInstance(MeasurementsLocalDataSource.getInstance()),
                addEditMeasurementFragment,
                measurementId
        );
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}
