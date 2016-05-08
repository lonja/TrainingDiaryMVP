package su.dreamteam.lonja.trainingdiarymvp.data.source;

import rx.Observable;
import su.dreamteam.lonja.trainingdiarymvp.data.Account;

public interface AccountDataSource {

    Observable<Account> getAccount();

    void saveAccount(Account account);

    void update();

    void commit();

    void cancel();
}
