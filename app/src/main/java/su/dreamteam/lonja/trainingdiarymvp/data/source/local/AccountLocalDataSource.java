package su.dreamteam.lonja.trainingdiarymvp.data.source.local;

import io.realm.Realm;
import rx.Observable;
import su.dreamteam.lonja.trainingdiarymvp.data.Account;
import su.dreamteam.lonja.trainingdiarymvp.data.source.AccountDataSource;

public class AccountLocalDataSource implements AccountDataSource {

    private Realm realm;

    private static AccountLocalDataSource INSTANCE;

    private AccountLocalDataSource() {
        realm = Realm.getDefaultInstance();
    }

    public static AccountLocalDataSource getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new AccountLocalDataSource();
        }
        return INSTANCE;
    }

    @Override
    public Observable<Account> getAccount() {
        return realm.where(Account.class)
                .findFirstAsync()
                .<Account>asObservable();
    }

    @Override
    public void saveAccount(Account account) {
        try {
            realm.beginTransaction();
            Account realmAccount = realm.createObject(Account.class);
            realmAccount.setId(account.getId());
            realmAccount.setName(account.getName());
            realmAccount.setSex(account.getSex());
            realmAccount.setBirthDate(account.getBirthDate());
            realmAccount.setHeight(account.getHeight());
            realmAccount.setWeight(account.getWeight());
            realm.commitTransaction();

        } catch (Exception e) {
            realm.cancelTransaction();
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void commit() {

    }

    @Override
    public void cancel() {

    }
}
