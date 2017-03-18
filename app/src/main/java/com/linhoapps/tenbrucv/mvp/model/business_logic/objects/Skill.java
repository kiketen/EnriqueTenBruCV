package com.linhoapps.tenbrucv.mvp.model.business_logic.objects;

import java.util.ArrayList;

/**
 * Created by KTB on 03/03/2017.
 */

public class Skill {

    private String globalSkill;
    private ArrayList<ParticularSkill> particularSkills;

    public String getGlobalSkill() {
        return globalSkill;
    }

    public void setGlobalSkill(String globalSkill) {
        this.globalSkill = globalSkill;
    }

    public ArrayList<ParticularSkill> getParticularSkills() {
        return particularSkills;
    }

    public void setParticularSkills(ArrayList<ParticularSkill> particularSkills) {
        this.particularSkills = particularSkills;
    }
}
