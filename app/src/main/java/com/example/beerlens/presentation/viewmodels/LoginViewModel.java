package com.example.beerlens.presentation.viewmodels;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.beerlens.domain.tools.Tools;

public class LoginViewModel extends ViewModel {

    public void saveData(String name, Context context) {
        Tools.getUserPreferences(context).persistStringForKey("Name",name);

    }
    public boolean isEditTextEmpty(String text) {
        return TextUtils.isEmpty(text);
    }
}
