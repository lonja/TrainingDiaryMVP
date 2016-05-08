package su.dreamteam.lonja.trainingdiarymvp.data;

import java.util.Date;
import java.util.UUID;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

@RealmClass
public class Account extends RealmObject {

    @PrimaryKey
    private String id;

    @Required
    private String name;

    @Required
    private String sex;

    @Required
    private Date birthDate;

    private Double height;

    private Double weight;

    public Account() {
        id = UUID.randomUUID().toString();
        sex = "male";
    }

    public Account(String name, String sex, Date birthDate, double height,
                   double weight) {
        this();
        this.name = name;
        this.sex = sex;
        this.birthDate = birthDate;
        this.height = height;
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
