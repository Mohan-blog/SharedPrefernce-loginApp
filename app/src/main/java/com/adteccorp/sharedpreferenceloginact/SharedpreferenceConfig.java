package com.adteccorp.sharedpreferenceloginact;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedpreferenceConfig {
    private SharedPreferences prefernceconfig;
    private Context context;

    public SharedpreferenceConfig(Context context) {
        this.context = context;
        prefernceconfig= context.getSharedPreferences(context.getResources().getString( R.string.login_preference ),Context.MODE_PRIVATE );

    }
    public void writeLoginStatus(boolean status){
        SharedPreferences.Editor editor = prefernceconfig.edit();
        editor.putBoolean( context.getResources().getString( R.string.login_status ),status );
        editor.commit();

    }
    public boolean readLoginStatus(){
        boolean status =false;
        status= prefernceconfig.getBoolean( context.getResources().getString( R.string.login_status ),false );
        return status;
    }
}
