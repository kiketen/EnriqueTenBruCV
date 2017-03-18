package com.linhoapps.tenbrucv.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static com.akexorcist.localizationactivity.LanguageSetting.getLanguage;

/**
 * Created by @EmmanuelGuther on 28/11/2016.
 */

public class ReadJSONFile {
    public static final String ANDROID_SKILLS = "androidSkills.json";
    public static final String ANGULARJS_SKILLS = "angularJSSkills.json";
    public static final String SQL_SKILLS = "SQLSkills.json";
    public static final String OTHERS_SKILLS = "othersSkills.json";

    public static String inputStreamToString(Context context, String fileName) {

        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(fileName);
        } catch (IOException e) {
            e.printStackTrace();

        }

        String resultado = null;
        StringBuilder stringBuilder = new StringBuilder("");
        BufferedReader bufferedReader = null;
        String linea;

        try {
            if (inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream,
                        "utf-8"));
                while ((linea = bufferedReader.readLine()) != null) {
                    stringBuilder.append(linea);
                    stringBuilder.append("\n");
                    linea = null;
                }
                resultado = stringBuilder.toString();
            }
        } catch (Exception ex) {
            resultado = null;
        } finally {
            linea = null;
            stringBuilder = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException ex) {
                }
            }
        }
        return resultado;
    }

    public static int getLanguageJSON(){
        int language;
        if (getLanguage().equals("en")) {
            language = 0;
        } else if (getLanguage().equals("ca")) {
            language = 1;
        } else {
            language = 2;
        }
        return language;
    }
}
