/*
package com.linhoapps.tenbrucv.utils.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentAndroid.SkillsFragmentAndroid;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.SkillsFragmentAngularJS;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentOthers.SkillsFragmentOthers;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentSQL.SkillsFragmentSQL;

*/
/**
 * Created by KTB on 27/02/2017.
 *//*


public class PagerSkillsAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public PagerSkillsAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                SkillsFragmentAndroid tab1 = new SkillsFragmentAndroid();
                return tab1;
            case 1:
                SkillsFragmentAngularJS tab2 = new SkillsFragmentAngularJS();
                return tab2;
            case 2:
                SkillsFragmentSQL tab3 = new SkillsFragmentSQL();
                return tab3;
            case 3:
                SkillsFragmentOthers tab4 = new SkillsFragmentOthers();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

*/
