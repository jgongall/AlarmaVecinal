package com.example.family.alarmavecinal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class AreaUsuarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_area_usuario);
        final EditText usuario = (EditText) findViewById(R.id.txtUsuario);
        final EditText email = (EditText) findViewById(R.id.txtEmail);
        final TextView welcome = (TextView)findViewById(R.id.txtWelcome);

    }
}
