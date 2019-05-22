    package com.example.retrofitnew;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

    public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        final TextView regnoh=findViewById(R.id.regno);
        final TextView nameh=findViewById(R.id.name);
        final TextView branchh=findViewById(R.id.branch);
        final TextView desigh=findViewById(R.id.desig);
        final TextView phnoh=findViewById(R.id.phno);
        final TextView emailh=findViewById(R.id.email);
        SharedPreferences shared=getApplicationContext().getSharedPreferences("pref",MODE_PRIVATE);
        final String textnamr=shared.getString("key1",null);
        Utils utils=new Utils();
        Call<Profilemodel>profilemodelCall=utils.getApi().profilemodel(textnamr);
        profilemodelCall.enqueue(new Callback<Profilemodel>() {
            @Override
            public void onResponse(Call<Profilemodel> call, Response<Profilemodel> response) {
                if (response.isSuccessful())
                {
                    Toast.makeText(Profile.this, "Response Success", Toast.LENGTH_SHORT).show();
                    String r=response.body().getResult();
                    List<TeacherDetail>td=response.body().getTeacherDetails();
                    //String namestr=td.get(0).getTeacherName();
                    String regnostr=td.get(0).getTeacherRegNo();
                    String branchstr=td.get(0).getTeacherBranch();
                    String desigstr=td.get(0).getTeacherDesigination();
                    String phnostr=td.get(0).getTeacherPhoneNumber();
                    String emailstr=td.get(0).getTeacherEmail();
                      regnoh.setText(regnostr);
                      nameh.setText(textnamr);
                      desigh.setText(desigstr);
                      branchh.setText(branchstr);
                      phnoh.setText(phnostr);
                      emailh.setText(emailstr);

                }
                else
                {
                    Toast.makeText(Profile.this, "failed", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Profilemodel> call, Throwable t) {

            }
        });
    }
}