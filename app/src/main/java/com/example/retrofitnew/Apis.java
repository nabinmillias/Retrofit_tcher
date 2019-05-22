package com.example.retrofitnew;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Apis {
    @GET("register.php?")
    Call<Regmodel> regmodel(@Query("teacher_regno")String teacherreg,@Query("name")String name,@Query("branch")String branch,@Query("password")String Password,@Query("desigination")String desig,@Query("phonenumber")String phno,@Query("email")String email);
    @GET("login.php?")
    Call<Loginmodel>login(@Query("teacher_regno")String teacherlog,@Query("password")String logpass);
    @GET("viewprofile.php?")
    Call<Profilemodel>profilemodel(@Query("teacher_regno")String techerpro);
}
