package com.example.managemoney.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import com.example.managemoney.R;
import com.example.managemoney.ViewModel.FinancialActivityViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButtonAdd;
    FinancialActivityViewModel financialActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        configViews();
        configEvents();

        // instance the viewModel for use methods
        financialActivityViewModel = new ViewModelProvider(this).get(FinancialActivityViewModel.class);
    }

    private void configEvents() {
        floatingActionButtonAdd.setOnClickListener(v -> {
            Intent intent = new Intent(this, AddFinancialActivityActivity.class);
            startActivity(intent);
        });
    }

    private void configViews() {
        floatingActionButtonAdd = findViewById(R.id.floatingActionButtonAdd);
    }
}
