package com.linhoapps.tenbrucv.mvp.model.interactors;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.linhoapps.tenbrucv.Application;
import com.linhoapps.tenbrucv.mvp.model.business_logic.objects.ResultSkills;
import com.linhoapps.tenbrucv.utils.DeveloperMode;
import com.linhoapps.tenbrucv.utils.ReadJSONFile;

/**
 * Created by KTB on 22/02/2017.
 */

public class RepositoryInteractorImpl implements RepositoryInteractor {
    private String jsonResponse;

    @Override
    public void getAndroidSkillsData(OnAndroidRepositoryListener onAndroidRepositoryListener) {
        if (DeveloperMode.IS_DEV_MODE) {
            jsonResponse = ReadJSONFile.inputStreamToString(Application.getCurrentContext(),
                    ReadJSONFile.ANDROID_SKILLS);
            ResultSkills resultSkills = makeJSONtoObject(jsonResponse, "androidSkills");
            onAndroidRepositoryListener.successGetAndroidSkills(resultSkills);
        } else {
            //in future, I'll implement a DB to get data
        }
    }

    @Override
    public void getAngularJSSkillsData(OnAngularJSRepositoryListener onAngularJSRepositoryListener) {
        if (DeveloperMode.IS_DEV_MODE) {
            jsonResponse = ReadJSONFile.inputStreamToString(Application.getCurrentContext(),
                    ReadJSONFile.ANGULARJS_SKILLS);
            ResultSkills resultAngularJSSkills = makeJSONtoObject(jsonResponse, "angularJSSkills");
            onAngularJSRepositoryListener.successGetAngularJSSkills(resultAngularJSSkills);
        } else {
            //in future, I'll implement a DB to get data
        }
    }

    @Override
    public void getSQLSkillsData(OnSQLRepositoryListener onSQLRepositoryListener) {
        if (DeveloperMode.IS_DEV_MODE) {
            jsonResponse = ReadJSONFile.inputStreamToString(Application.getCurrentContext(),
                    ReadJSONFile.SQL_SKILLS);
            ResultSkills resultSQLSkills = makeJSONtoObject(jsonResponse, "SQLSkills");
            onSQLRepositoryListener.successGetSQLSkills(resultSQLSkills);
        } else {
            //in future, I'll implement a DB to get data
        }
    }

    @Override
    public void getOthersSkillsData(OnOthersRepositoryListener onOthersRepositoryListener) {
        if (DeveloperMode.IS_DEV_MODE) {
            jsonResponse = ReadJSONFile.inputStreamToString(Application.getCurrentContext(),
                    ReadJSONFile.OTHERS_SKILLS);
            ResultSkills resultOthersSkills = makeJSONtoObject(jsonResponse, "othersSkills");
            onOthersRepositoryListener.successGetOthersSkills(resultOthersSkills);
        } else {
            //in future, I'll implement a DB to get data
        }
    }

    private ResultSkills makeJSONtoObject(String json, String jsonFileName) {
        ResultSkills respuesta = null;
        Gson gson = new Gson();
        JsonObject jsonObject = new Gson().fromJson(json, JsonObject.class);
        JsonObject jsonObjectSkills = jsonObject.getAsJsonObject(jsonFileName);
        respuesta = gson.fromJson((jsonObjectSkills.get("resultado")), ResultSkills.class);
        return respuesta;
    }
}
