package com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentAngularJS;

import com.linhoapps.tenbrucv.mvp.model.business_logic.objects.ResultSkills;
import com.linhoapps.tenbrucv.mvp.model.interactors.RepositoryInteractor;
import com.linhoapps.tenbrucv.mvp.model.interactors.RepositoryInteractorImpl;

/**
 * Created by KTB on 27/02/2017.
 */
public class SkillsPresenterAngularJSImpl implements SkillsPresenterAngularJS, RepositoryInteractor.OnAngularJSRepositoryListener {
    private RepositoryInteractorImpl repositoryInteractor;
    private SkillsViewAngularJS skillsViewAngularJS;

    public SkillsPresenterAngularJSImpl(SkillsViewAngularJS skillsViewAngularJS) {
        this.skillsViewAngularJS = skillsViewAngularJS;
    }

    @Override
    public void callRepository() {
        repositoryInteractor = new RepositoryInteractorImpl();
        repositoryInteractor.getAngularJSSkillsData(this);
    }

    @Override
    public void successGetAngularJSSkills(ResultSkills resultAngularJSSkills) {
        skillsViewAngularJS.successGetAngularJSSkills(resultAngularJSSkills);
    }
}
