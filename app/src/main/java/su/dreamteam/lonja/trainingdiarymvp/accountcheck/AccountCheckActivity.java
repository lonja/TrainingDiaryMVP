package su.dreamteam.lonja.trainingdiarymvp.accountcheck;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import su.dreamteam.lonja.trainingdiarymvp.data.source.DataManager;
import su.dreamteam.lonja.trainingdiarymvp.data.source.local.AccountLocalDataSource;
import su.dreamteam.lonja.trainingdiarymvp.data.source.local.MeasurementsLocalDataSource;
import su.dreamteam.lonja.trainingdiarymvp.measurements.MeasurementsActivity;
import su.dreamteam.lonja.trainingdiarymvp.wizard.accountinfo.AccountInfoActivity;

public class AccountCheckActivity extends Activity {

    DataManager mDataManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDataManager = DataManager.getInstance(MeasurementsLocalDataSource.getInstance(),
                AccountLocalDataSource.getInstance());
        mDataManager.getAccount()
                .filter(account -> account.isLoaded())
                .first()
                .doOnNext(account -> {
                    if (account.isValid()) {
                        Intent intent = new Intent(this, MeasurementsActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        return;
                    }
                    Intent intent = new Intent(this, AccountInfoActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                })
                .subscribe();
    }
}