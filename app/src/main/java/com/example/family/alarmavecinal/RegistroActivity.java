package com.example.family.alarmavecinal;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegistroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        final EditText nombre = (EditText) findViewById(R.id.txtName);
        final EditText usuario = (EditText) findViewById(R.id.txtUsuario);
        final EditText password = (EditText) findViewById(R.id.txtPassword);
        final EditText correo = (EditText) findViewById(R.id.txtEmail);
        final EditText edad = (EditText) findViewById(R.id.txtEdad);
        final Button registro = (Button) findViewById(R.id.btnRegistrar);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String name = nombre.getText().toString();
                final String mail = correo.getText().toString();
                final String user = usuario.getText().toString();
                final int age = Integer.parseInt(edad.getText().toString());
                final String contrasena = password.getText().toString();
                Response.Listener<String> reponseListener = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {

                        try{
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");
                            if(success){
                                Intent intent = new Intent(RegistroActivity.this,LoginActivity.class);
                                RegistroActivity.this.startActivity(intent);
                            }else{
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegistroActivity.this);
                                builder.setMessage("Register Failed").setNegativeButton("Retry",null).create().show();
                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                };


                RegistroRequest registerRequest = new RegistroRequest(name,user,age,contrasena,mail,reponseListener);
                RequestQueue queue = Volley.newRequestQueue(RegistroActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}
