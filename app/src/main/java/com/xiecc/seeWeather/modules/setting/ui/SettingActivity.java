package com.xiecc.seeWeather.modules.setting.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import com.xiecc.seeWeather.R;
import com.xiecc.seeWeather.base.ToolbarActivity;

/**
 * Created by hugo on 2016/2/19 0019.
 */
public class SettingActivity extends ToolbarActivity {

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mToolbar.setTitle("设置"); don't work and i find this
        //http://stackoverflow.com/questions/26486730/in-android-app-toolbar-settitle-method-has-no-effect-application-name-is-shown
        getSupportActionBar().setTitle("设置");
        setStatusBarColor(R.color.colorPrimary);
        if (mSetting.getCurrentHour() < 6 || mSetting.getCurrentHour() > 18) {
            mToolbar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorSunset));
            setStatusBarColor(R.color.colorSunset);
        }
        getFragmentManager().beginTransaction().replace(R.id.framelayout, new SettingFragment()).commit();
    }

    @Override
    public boolean canBack() {
        return true;
    }

}
