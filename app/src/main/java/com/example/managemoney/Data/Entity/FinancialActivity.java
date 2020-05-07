package com.example.managemoney.Data.Entity;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.time.LocalDate;

@Entity()
public class FinancialActivity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String date;
    public float value;
    public boolean isEntry;
    public String description;

    public FinancialActivity(String date, float value, boolean isEntry, String description) {
        this.date = date;
        this.value = value;
        this.isEntry = isEntry;
        this.description = description;
    }

    public boolean isEntry() {
        return isEntry;
    }

    public void setEntry(boolean entry) {
        isEntry = entry;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
