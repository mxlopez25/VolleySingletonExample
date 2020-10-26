package com.reikai.volleysingletonexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Button btnDoRequest;
    ProgressDialog dialog;
    TextView tvResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        declareObjects();
        objectsFunctions();

    }

    private void declareObjects() {
        btnDoRequest = findViewById(R.id.btn_do_request);
        tvResponse = findViewById(R.id.tv_response);
    }

    private void objectsFunctions() {
        btnDoRequest.setOnClickListener(v -> {
            dialog = GlobalProgressDialog.showProgressDialog(this, "Test Dialog");
            VolleySingleton.getInstance(getApplicationContext()).addToRequestQueue(new JsonObjectRequest(
                    Request.Method.POST,
                    "http://165.22.38.63:12000/status",
                    null,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            tvResponse.setText(response.toString());
                            dialog.dismiss();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            tvResponse.setText(error.toString());
                            dialog.dismiss();
                        }
                    }
            ));
        });
    }

}