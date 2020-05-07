package com.example.managemoney.ViewModel;

import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.managemoney.Common.MyApp;
import com.example.managemoney.Data.Dao.FinancialActivityDAO;
import com.example.managemoney.Data.Entity.FinancialActivity;
import com.example.managemoney.Data.ManageMoneyDataBase;

import java.util.List;

public class FinancialActivityViewModel extends ViewModel {

    private static FinancialActivityDAO financialActivityDAO;
    private LiveData<List<FinancialActivity>> allFinancialActivities;

    public FinancialActivityViewModel(){
        ManageMoneyDataBase db = ManageMoneyDataBase.getInstance(MyApp.getContext());
        financialActivityDAO = db.financialActivityDAO();
        allFinancialActivities = financialActivityDAO.getAllFinancialActivities();
    }

    public LiveData<List<FinancialActivity>> getAllFinancialActivities(){return allFinancialActivities;}
    public void insertFinancialActivity(FinancialActivity financialActivity){
        new insertFinancialActivityAsyncTask(financialActivityDAO).execute(financialActivity);
    }
    public static class insertFinancialActivityAsyncTask extends AsyncTask<FinancialActivity, Void, Void>{
        private static FinancialActivityDAO mFinancialActivityDAO;
        insertFinancialActivityAsyncTask(FinancialActivityDAO dao){
            mFinancialActivityDAO = dao;
        }
        @Override
        protected Void doInBackground(FinancialActivity... financialActivities) {
            mFinancialActivityDAO.insertFinancialActivity(financialActivities[0]);
            return null;
        }
    }
    public void deleteFinancialActivity(FinancialActivity financialActivity){
        new deleteFinancialActivityAsyncTask(financialActivityDAO).execute(financialActivity);
    }
    public static class deleteFinancialActivityAsyncTask extends AsyncTask<FinancialActivity, Void, Void>{
        private static FinancialActivityDAO mFinancialActivityDAO;
        deleteFinancialActivityAsyncTask(FinancialActivityDAO dao){
            mFinancialActivityDAO = dao;
        }
        @Override
        protected Void doInBackground(FinancialActivity... financialActivities) {
            mFinancialActivityDAO.deleteFinancialActivity(financialActivities[0]);
            return null;
        }
    }
}
