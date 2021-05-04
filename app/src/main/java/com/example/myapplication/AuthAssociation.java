package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AuthAssociation extends Activity {
    public static String  PREFS_NAME="mypre";
    public static String PREF_USERNAME="username";
    public static String PREF_PASSWORD="password";

    Retrofit retrofit = RetrofitFactory.getRetrofit();
    RetrofitServices retrofitServices = retrofit
            .create(RetrofitServices.class);
    @Nullable
    @BindView(R.id.sName)
    EditText Name;
    @BindView(R.id.sPassword)
    EditText Password;
    @Nullable
    @BindView(R.id.msgError)
    TextView messageError;


    @BindView(R.id.btnLogin)
    Button connecter;
    Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth_association);
        ButterKnife.bind(this);
        loadData();

        /*Name = (EditText)findViewById(R.id.sName);
        Password = (EditText)findViewById(R.id.sPassword);
        connecter = (Button)findViewById(R.id.btnLogin);*/
    }


    @OnClick(R.id.btnLogin)

    public void onClick(View v) {
        String email = Name.getText().toString();
        String password = Password.getText().toString();

        Login login = new Login(email,password);

        Call<String> call = retrofitServices.login(login);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call,Response<String> response) {

                if(response.isSuccessful()){
                    //save username and password
                    rememberMe(email,password);
                    String token = response.body();
                    Log.d("token1",token);
                    Intent  intent =new Intent(AuthAssociation.this, AssociationActivity.class);
                    startActivity(intent);
                }
            }

            @Override
            public void onFailure(Call <String> call, Throwable t) {
                t.printStackTrace();
            }
        });
//        validate(Name.getText().toString(), Password.getText().toString());
    }

    public void rememberMe(String user, String password){
        //save username and password in SharedPreferences
        getSharedPreferences(PREFS_NAME,MODE_PRIVATE)
                .edit()
                .putString(PREF_USERNAME,user)
                .putString(PREF_PASSWORD,password)
                .apply();
    }
    public void loadData(){
        Name.setText(getSharedPreferences(PREFS_NAME,MODE_PRIVATE).getString(PREF_USERNAME,""));
        Password.setText(getSharedPreferences(PREFS_NAME,MODE_PRIVATE).getString(PREF_PASSWORD,""));
//        if(Name!=null && Password!=null)
//            validate(Name.getText().toString(),Password.getText().toString());
    }
}
