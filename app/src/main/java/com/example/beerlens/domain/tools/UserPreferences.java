package com.example.beerlens.domain.tools;

import android.content.Context;
import android.content.SharedPreferences;

public class UserPreferences {

    private static UserPreferences instance;
    private Context context;

    private UserPreferences(Context context) {
        this.context = context;
    }

    public static  UserPreferences getInstance(Context context) {
        if (instance == null) {
            instance = new UserPreferences(context);
        }
        return instance;
    }

    public void persistStringForKey(String key, String value) {
        SharedPreferences preferences = getPreferences();
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    private SharedPreferences getPreferences() {
        return context.getSharedPreferences("DataUser", Context.MODE_PRIVATE);
    }
    public String getUserName () {
        SharedPreferences preferences = getPreferences();
        return preferences.getString("Name","");
    }
}
