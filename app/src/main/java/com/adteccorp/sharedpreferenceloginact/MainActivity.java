package com.adteccorp.sharedpreferenceloginact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SharedpreferenceConfig sharedpreferenceConfig;
    private EditText username,userpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        sharedpreferenceConfig= new SharedpreferenceConfig( getApplicationContext() );
        username =findViewById( R.id.username );
        userpassword =findViewById( R.id.password );
        if(sharedpreferenceConfig.readLoginStatus()){
            startActivity( new Intent( MainActivity.this,SuccessActivity.class ) );
            finish();
        }

    }

    public void loginbtn(View view) {

        String Username = username.getText().toString();
        String Password =userpassword.getText().toString();
        if(Username.equals(getResources().getString( R.string.user_name ) ) && Password.equals(getResources().getString( R.string.password ) )){
            startActivity( new Intent( MainActivity.this,SuccessActivity.class ) );
            sharedpreferenceConfig.writeLoginStatus(true);
            finish();

        }
        else {
            Toast.makeText( this, "Login Failed.... Please try again", Toast.LENGTH_SHORT ).show();
            username.setText( " " );
            userpassword.setText( "" );


        }

    }

}
