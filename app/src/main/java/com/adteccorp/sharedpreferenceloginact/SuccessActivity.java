package com.adteccorp.sharedpreferenceloginact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SuccessActivity extends AppCompatActivity {
    private SharedpreferenceConfig sharedpreferenceConfig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_success );
        sharedpreferenceConfig = new SharedpreferenceConfig( getApplicationContext() );
    }

    public void logoutbtn(View view) {
        sharedpreferenceConfig.writeLoginStatus( false );
        startActivity( new Intent( SuccessActivity.this, MainActivity.class ) );
        finish();
    }
}
