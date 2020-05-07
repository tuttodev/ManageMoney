package com.example.managemoney.Data.Dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.managemoney.Data.Entity.FinancialActivity;

import java.util.List;

@Dao()
public interface FinancialActivityDAO {
    @Query("SELECT * FROM FinancialActivity")
    LiveData<List<FinancialActivity>> getAllFinancialActivities();

    @Insert()
    void insertFinancialActivity(FinancialActivity financialActivity);

    @Delete()
    void deleteFinancialActivity(FinancialActivity financialActivity);
}
