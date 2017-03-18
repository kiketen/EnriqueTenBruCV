package com.linhoapps.tenbrucv.mvp.model.interactors;

import com.linhoapps.tenbrucv.mvp.model.business_logic.objects.ResultSkills;

/**
 * Created by KTB on 22/02/2017.
 */

public interface RepositoryInteractor {


    void getAndroidSkillsData(OnAndroidRepositoryListener onAndroidRepositoryListener);

    void getAngularJSSkillsData(OnAngularJSRepositoryListener onAngularJSRepositoryListener);

    void getSQLSkillsData(OnSQLRepositoryListener onSQLRepositoryListener);

    void getOthersSkillsData(OnOthersRepositoryListener onOthersRepositoryListener);

    interface OnAndroidRepositoryListener {

        void successGetAndroidSkills(ResultSkills resultSkills);

    }

    interface OnAngularJSRepositoryListener{

        void successGetAngularJSSkills(ResultSkills resultAngularJSSkills);

    }

    interface OnSQLRepositoryListener{

        void successGetSQLSkills(ResultSkills resultSQLSkills);

    }

    interface OnOthersRepositoryListener{

        void successGetOthersSkills(ResultSkills resultOthersSkills);

    }
}
