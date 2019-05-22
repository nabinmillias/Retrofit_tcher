package com.example.retrofitnew;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         final EditText eclogin=findViewById(R.id.logec);
         final EditText passj=findViewById(R.id.passlog);
        Button lobtn=findViewById(R.id.logbtn);
        TextView reghere=findViewById(R.id.regiloxml);
        lobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String t_reg=eclogin.getText().toString();
                final String t_pass=passj.getText().toString();
                SharedPreferences shared=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
                SharedPreferences.Editor editor=shared.edit();
                editor.putString("key1",t_reg);
                editor.apply();
                Utils utils=new Utils();
                Call<Loginmodel>loginmodelCall=utils.getApi().login(t_pass,t_reg);
                loginmodelCall.enqueue(new Callback<Loginmodel>() {
                    @Override
                    public void onResponse(Call<Loginmodel> call, Response<Loginmodel> response) {
                        Intent a=new Intent(MainActivity.this,Profile.class);
                       String st=response.body().getStatus();
                       String re=response.body().getRegNo();

                       if (st.equalsIgnoreCase("success"))
                       {
                           if (t_reg.equals(re))
                           {
                               Toast.makeText(MainActivity.this, "sigin sucess", Toast.LENGTH_SHORT).show();
                               startActivity(a);
                           }
                           else {
                               Toast.makeText(MainActivity.this, "invalid regno", Toast.LENGTH_SHORT).show();
                           }

                       }
else{
                           Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();

                       }
                       }


                    @Override
                    public void onFailure(Call<Loginmodel> call, Throwable t) {

                    }
                });
            }
        });
    }

    public void register(View view) {
        Intent f=new Intent(MainActivity.this,registerd.class);
        startActivity(f);
    }
}
