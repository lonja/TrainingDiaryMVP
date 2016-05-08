package su.dreamteam.lonja.trainingdiarymvp.measurements;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.List;

import io.realm.RealmResults;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import su.dreamteam.lonja.trainingdiarymvp.addeditmeasurement.AddEditMeasurementActivity;
import su.dreamteam.lonja.trainingdiarymvp.data.Measurement;
import su.dreamteam.lonja.trainingdiarymvp.data.source.DataManager;

import static com.google.common.base.Preconditions.checkNotNull;

public class MeasurementsPresenter implements MeasurementsContract.Presenter {

    private final DataManager mDataManager;

    private final MeasurementsContract.View mMeasurementsView;

    private boolean mFirstLoad = true;

    private CompositeSubscription mSubscriptions;

    public MeasurementsPresenter(DataManager dataManager, MeasurementsContract.View measurementsView) {
        mDataManager = dataManager;
        mMeasurementsView = measurementsView;
        mSubscriptions = new CompositeSubscription();
        mMeasurementsView.setPresenter(this);
    }

    @Override
    public void result(int requestCode, int resultCode) {
        if (AddEditMeasurementActivity.REQUEST_ADD_MEASUREMENT == requestCode && Activity.RESULT_OK == resultCode) {
            mMeasurementsView.showSuccessfullySavedMessage();
        }
    }

    @Override
    public void loadMeasurements(boolean forceUpdate) {
        loadMeasurements(forceUpdate || mFirstLoad, true);
        mFirstLoad = false;
    }

    private void loadMeasurements(boolean forceUpdate, final boolean showLoadingUI) {
        if (showLoadingUI) {
            mMeasurementsView.setLoadingIndicator(true);
        }
        if (forceUpdate) {
//            mDataManager.refreshMeasurements();
        }
        mSubscriptions.clear();
        Subscription subscription = mDataManager.getMeasurements()
                .filter(RealmResults::isLoaded)
                .first()
                .doOnNext(mMeasurementsView::showMeasurements)
                .subscribe();
        mSubscriptions.add(subscription);
    }

    @Override
    public void addNewMeasurement() {
        mMeasurementsView.showAddMeasurement();
    }

    @Override
    public void editMeasurement(@NonNull Measurement requestedMeasurement) {
        checkNotNull(requestedMeasurement, "requestedMeasurement cannot be null!");
        mMeasurementsView.showMeasurementEdit(requestedMeasurement.getId());
    }

    @Override
    public void subscribe() {
        loadMeasurements(false);
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }
}