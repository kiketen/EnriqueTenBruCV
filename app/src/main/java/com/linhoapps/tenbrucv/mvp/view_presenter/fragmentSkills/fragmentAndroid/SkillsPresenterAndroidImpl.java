package com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentAndroid;

import com.linhoapps.tenbrucv.mvp.model.business_logic.objects.ResultSkills;
import com.linhoapps.tenbrucv.mvp.model.interactors.RepositoryInteractor;
import com.linhoapps.tenbrucv.mvp.model.interactors.RepositoryInteractorImpl;

/**
 * Created by KTB on 27/02/2017.
 */
public class SkillsPresenterAndroidImpl implements SkillsPresenterAndroid, RepositoryInteractor.OnAndroidRepositoryListener {
    private final SkillsViewAndroid skillsViewAndroid;
    private RepositoryInteractorImpl repositoryInteractor;

    public SkillsPresenterAndroidImpl(SkillsViewAndroid skillsViewAndroid) {
        this.skillsViewAndroid = skillsViewAndroid;
    }

    @Override
    public void callRepository() {
        repositoryInteractor = new RepositoryInteractorImpl();
        repositoryInteractor.getAndroidSkillsData(this);
    }

    @Override
    public void successGetAndroidSkills(ResultSkills resultSkills) {
        skillsViewAndroid.successGetAndroidSkills(resultSkills);
    }
}
