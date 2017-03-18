package com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentOthers;

import com.linhoapps.tenbrucv.mvp.model.business_logic.objects.ResultSkills;
import com.linhoapps.tenbrucv.mvp.model.interactors.RepositoryInteractor;
import com.linhoapps.tenbrucv.mvp.model.interactors.RepositoryInteractorImpl;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentSQL.SkillsPresenterSQL;
import com.linhoapps.tenbrucv.mvp.view_presenter.fragmentSkills.fragmentSQL.SkillsViewSQL;

/**
 * Created by KTB on 27/02/2017.
 */
public class SkillsPresenterOthersImpl implements SkillsPresenterOthers, RepositoryInteractor.OnOthersRepositoryListener {
    private RepositoryInteractorImpl repositoryInteractor;
    private SkillsViewOthers skillsViewOthers;

    public SkillsPresenterOthersImpl(SkillsViewOthers skillsViewOthers) {
        this.skillsViewOthers = skillsViewOthers;
    }

    @Override
    public void callRepository() {
        repositoryInteractor = new RepositoryInteractorImpl();
        repositoryInteractor.getOthersSkillsData(this);
    }

    @Override
    public void successGetOthersSkills(ResultSkills resultOthersSkills) {
        skillsViewOthers.successGetOthersSkills(resultOthersSkills);
    }
}
