package su.dreamteam.lonja.trainingdiarymvp.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

@RealmClass
public class Account extends RealmObject {

    @PrimaryKey
    private String id;
}
