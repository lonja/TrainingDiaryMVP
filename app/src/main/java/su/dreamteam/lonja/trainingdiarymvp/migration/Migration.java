package su.dreamteam.lonja.trainingdiarymvp.migration;

import java.util.Date;

import io.realm.DynamicRealm;
import io.realm.FieldAttribute;
import io.realm.RealmMigration;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;

public class Migration implements RealmMigration {
    @Override
    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
        if (oldVersion == 0) {
            RealmSchema schema = realm.getSchema();
            RealmObjectSchema accountSchema = schema.get("Account");
            accountSchema.addField("name", String.class, FieldAttribute.REQUIRED)
                    .addField("sex", String.class, FieldAttribute.REQUIRED)
                    .addField("birthDate", Date.class, FieldAttribute.REQUIRED)
                    .addField("height", Double.class)
                    .addField("weight", Double.class);
            oldVersion++;
        }
    }
}
