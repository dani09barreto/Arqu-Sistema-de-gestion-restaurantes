package com.example.application_envios.activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.example.application_envios.R;

public class AuthenticatedActivity extends BasicActivity{

    protected boolean isAuthenticated(){
        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        return sharedPreferences.getString("token", null) != null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    protected void signOut(){
        sharedPreferences = getSharedPreferences("session", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("token");
        editor.apply();
        startActivity(LogInActivity.createIntent(this));
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.logoutButton:
                signOut();
                break;
            case R.id.userButtom:
                startActivity(new Intent(this, UserSettingsActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isAuthenticated()) {
            startActivity(LogInActivity.createIntent(this));
        }
    }
}
