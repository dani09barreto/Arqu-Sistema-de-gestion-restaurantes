package com.example.envios_app.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.envios_app.R;


public class AuthenticatedActivity extends BasicActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected boolean isAuthenticated() {
        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        return sharedPreferences.getString("token", null) != null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isAuthenticated()) {
            startActivity(LoginActivity.createIntent(this));
        }
    }


    protected void signOut(){
        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        startActivity(LoginActivity.createIntent(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.logoutButton:
                signOut();
                break;
            case R.id.userInfo:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
