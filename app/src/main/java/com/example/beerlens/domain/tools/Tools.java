package com.example.beerlens.domain.tools;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;


import com.example.beerlens.R;
import com.example.beerlens.data.database.entity.BeerEntity;
import com.example.beerlens.presentation.datas.BeerData;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Tools {
    public static UserPreferences getUserPreferences(Context context) {
        return UserPreferences.getInstance(context);
    }
    public static int getTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
    public static String getSaludo(int hora) {
        if (hora >= 0 && hora < 12) {
            return "Buenos días";
        } else if (hora >= 12 && hora < 18) {
            return "Buenas tardes";
        } else {
            return "Buenas noches";
        }
    }

    public static List<BeerData>  CastList (List<BeerEntity> sourceList) {
        List<BeerData> targetList = new ArrayList<>();
        Log.e("TAG", "CastList: size " + sourceList.size() );

        for (BeerEntity beerEntity : sourceList) {
            BeerData beerData = new BeerData(
                    beerEntity.getName(),
                    beerEntity.getImage_url(),
                    beerEntity.getBrewers_tips(),
                    beerEntity.getDescription(),
                    beerEntity.getBrewers_tips(),
                    beerEntity.getId()
            );
            targetList.add(beerData);

        }
        return targetList;
    }

    public static void showAlert(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.AlertDialogCustom);
        builder.setTitle("Cerrar Sesión");
        builder.setMessage("¿Desea cerrar sesión?");

        builder.setPositiveButton("Aceptar", (dialogInterface, i) -> {
            Tools.getUserPreferences(context).persistStringForKey("Name","");
            ((Activity) context).finish();
        });

        builder.setNegativeButton("Cancelar", (dialogInterface, i) -> {
        });

        AlertDialog alerta = builder.create();
        alerta.show();
    }
}
