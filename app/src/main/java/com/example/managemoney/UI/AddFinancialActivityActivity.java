package com.example.managemoney.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;

import com.example.managemoney.Data.Entity.FinancialActivity;
import com.example.managemoney.R;
import com.example.managemoney.UI.Fragment.DatePickerFragment;
import com.example.managemoney.ViewModel.FinancialActivityViewModel;

import java.util.Date;

public class AddFinancialActivityActivity extends AppCompatActivity {

    private EditText etDate, etValue, etDescription;
    private Switch switchIsEntry;
    private Button btnRegister;
    private FinancialActivityViewModel financialActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_financial_activity);
        financialActivityViewModel = new ViewModelProvider(this).get(FinancialActivityViewModel.class);
        getSupportActionBar().hide();

        configViews();
        configEvents();
    }

    private void configViews() {
        etDate = findViewById(R.id.editTextDate);
        etValue = findViewById(R.id.editTextValue);
        switchIsEntry = findViewById(R.id.switchIsEntry);
        btnRegister = findViewById(R.id.buttonRegisterFinancialActivity);
        etDescription = findViewById(R.id.editTextDescription);
    }

    private void configEvents() {
        etDate.setOnClickListener(view -> {
            showDatePickerDialog();
        });

        btnRegister.setOnClickListener(view -> {
            String date = etDate.getText().toString();
            float value = Float.parseFloat(etValue.getText().toString());
            boolean isEntry = switchIsEntry.isChecked();
            String description = etDescription.getText().toString();

            FinancialActivity financialActivity = new FinancialActivity(date, value, isEntry, description);

            financialActivityViewModel.insertFinancialActivity(financialActivity);
            finish();
        });
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance((datePicker, year, month, day) -> {
            // +1 because January is zero
            final String selectedDate = day + "/" + (month+1) + "/" + year;
            etDate.setText(selectedDate);
        });
        newFragment.show(this.getSupportFragmentManager(), "datePicker");
    }
}
