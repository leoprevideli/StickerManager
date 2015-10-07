package br.com.cast.turmaformacao.testecontrole.controller;

import android.app.Application;

import br.com.cast.turmaformacao.testecontrole.controller.util.ApplicationUtil;

public class StickersManagerApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ApplicationUtil.setContext(getApplicationContext());
    }

}
