package net.ramastudio.anotheracojwt;

import android.app.Application;

import net.ramastudio.anotheracojwt.utils.Pref;


public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Pref.init(this);
    }
}
