package com.example.retrofitnew;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class registerd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerd);
        final EditText teacherregh=findViewById(R.id.tchregxml);
        final EditText nameh=findViewById(R.id.namexml);
        final EditText branchh=findViewById(R.id.branchxml);
        final EditText passh=findViewById(R.id.passxml);
        final EditText desigh=findViewById(R.id.desigxml);
        final EditText phnoh=findViewById(R.id.phnoxml);
        final EditText emailh=findViewById(R.id.emailxml);
        Button submitbtn=findViewById(R.id.submitxml);
        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String teacherregstr=teacherregh.getText().toString();
                final String namestr=nameh.getText().toString();
                final String branchstr=branchh.getText().toString();
                final String passstr=passh.getText().toString();
                final String desigstr=desigh.getText().toString();
                final String phonstr=phnoh.getText().toString();
                final String emailstr=emailh.getText().toString();

                Utils utils=new Utils();
                Call<Regmodel>regmodelCall=utils.getApi().regmodel(teacherregstr,namestr,branchstr,passstr,desigstr,phonstr,emailstr);//"regmodel" name in Apis interface
                regmodelCall.enqueue(new Callback<Regmodel>() {
                    @Override
                    public void onResponse(Call<Regmodel> call, Response<Regmodel> response) {
                        Toast.makeText(registerd.this, "Response sucess", Toast.LENGTH_SHORT).show();
                        String s=response.body().getStatus();//"getstatus" class name in the regmodel java page
                        if(s.equalsIgnoreCase("success")){
                            Toast.makeText(registerd.this, "Registeration Sucess!!!", Toast.LENGTH_SHORT).show();
                            Intent a=new Intent(registerd.this,MainActivity.class);
                            startActivity(a);
                        }
                        else{
                            Toast.makeText(registerd.this, "failed", Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<Regmodel> call, Throwable t) {

                    }
                });
            }
        });
    }
}
