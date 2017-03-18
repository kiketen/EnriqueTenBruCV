package com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentSQL;

import com.linhoapps.tenbrucv.mvp.model.business_logic.objects.ResultSkills;
import com.linhoapps.tenbrucv.mvp.model.interactors.RepositoryInteractor;
import com.linhoapps.tenbrucv.mvp.model.interactors.RepositoryInteractorImpl;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentAngularJS.SkillsPresenterAngularJS;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentAngularJS.SkillsViewAngularJS;

/**
 * Created by KTB on 27/02/2017.
 */
public class SkillsPresenterSQLImpl implements SkillsPresenterSQL, RepositoryInteractor.OnSQLRepositoryListener {
    private RepositoryInteractorImpl repositoryInteractor;
    private SkillsViewSQL skillsViewSQL;

    public SkillsPresenterSQLImpl(SkillsViewSQL skillsViewSQL) {
        this.skillsViewSQL = skillsViewSQL;
    }

    @Override
    public void callRepository() {
        repositoryInteractor = new RepositoryInteractorImpl();
        repositoryInteractor.getSQLSkillsData(this);
    }

    @Override
    public void successGetSQLSkills(ResultSkills resultSQLSkills) {
        skillsViewSQL.successGetSQLSkills(resultSQLSkills);
    }
}
