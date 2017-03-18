package com.linhoapps.tenbrucv.mvp.model.business_logic.objects;

import java.util.ArrayList;

/**
 * Created by KTB on 03/03/2017.
 */

public class ResultSkills {

    private String codError;
    private String desError;
    private ArrayList<Skill> skills;


    public String getCodError() {
        return codError;
    }

    public void setCodError(String codError) {
        this.codError = codError;
    }

    public String getDesError() {
        return desError;
    }

    public void setDesError(String desError) {
        this.desError = desError;
    }

    public ArrayList<Skill> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<Skill> skills) {
        this.skills = skills;
    }
}
