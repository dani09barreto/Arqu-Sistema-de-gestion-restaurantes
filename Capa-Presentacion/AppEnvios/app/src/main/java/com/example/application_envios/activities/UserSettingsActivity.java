package com.example.application_envios.activities;


import android.os.Bundle;

import com.example.application_envios.databinding.ActivityUserSettingsBinding;

public class UserSettingsActivity extends AuthenticatedActivity {
    private ActivityUserSettingsBinding binding;
    private static final String BASE_URL = "http://172.20.10.4:8190/api/users/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserSettingsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();

    }
}