package su.dreamteam.lonja.trainingdiarymvp.wizard.accountinfo;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.github.paolorotolo.appintro.AppIntro2;
import com.github.paolorotolo.appintro.AppIntroFragment;

import su.dreamteam.lonja.trainingdiarymvp.R;

public class AccountInfoActivity extends AppIntro2 {
    @Override
    public void init(@Nullable Bundle savedInstanceState) {
        setFadeAnimation();
        addSlide(AppIntroFragment.newInstance("Sportify", "This is your personal fitness trainer", R.drawable.icon, R.color.colorAccent));

    }

    @Override
    public void onDonePressed() {

    }

    @Override
    public void onNextPressed() {

    }

    @Override
    public void onSlideChanged() {

    }
}
