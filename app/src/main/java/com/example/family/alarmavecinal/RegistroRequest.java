package com.example.family.alarmavecinal;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by croby on 11-11-2017.
 */

public class RegistroRequest extends StringRequest {
    private static final String REGISTER_URL ="http://127.0.0.1:8000/usuarios/";
    private Map<String,String> params;

        public RegistroRequest(String name, String userName, int edad, String password,String alarm_correo, Response.Listener<String> listener){
            super(Method.POST,REGISTER_URL,listener,null);
            params = new HashMap<>();
            params.put("alarm_correo",alarm_correo);
            params.put("password",password);
            params.put("edad",edad+"");
            params.put("name",name);

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
