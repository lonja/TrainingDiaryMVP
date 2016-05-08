package su.dreamteam.lonja.trainingdiarymvp.measurements;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import su.dreamteam.lonja.trainingdiarymvp.R;
import su.dreamteam.lonja.trainingdiarymvp.data.source.DataManager;
import su.dreamteam.lonja.trainingdiarymvp.data.source.local.AccountLocalDataSource;
import su.dreamteam.lonja.trainingdiarymvp.data.source.local.MeasurementsLocalDataSource;
import su.dreamteam.lonja.trainingdiarymvp.util.ActivityUtils;

public class MeasurementsActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private MeasurementsPresenter mMeasurementsPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_measurements);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (navigationView != null) {
            setupDrawerContent(navigationView);
        }

        MeasurementsFragment measurementsFragment = (MeasurementsFragment) getSupportFragmentManager().findFragmentById(R.id.content_frame);

        if (measurementsFragment == null) {
            measurementsFragment = MeasurementsFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), measurementsFragment, R.id.content_frame
            );
        }

        mMeasurementsPresenter = new MeasurementsPresenter(
                DataManager.getInstance(MeasurementsLocalDataSource.getInstance(),
                        AccountLocalDataSource.getInstance()),
                measurementsFragment
        );

        MeasurementsViewModel measurementsViewModel = new MeasurementsViewModel(getApplicationContext());

        measurementsFragment.setViewModel(measurementsViewModel);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(item -> false);
    }
}
