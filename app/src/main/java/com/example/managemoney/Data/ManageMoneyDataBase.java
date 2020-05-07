package com.example.managemoney.Data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.managemoney.Common.Constants;
import com.example.managemoney.Common.MyApp;
import com.example.managemoney.Data.Dao.FinancialActivityDAO;
import com.example.managemoney.Data.Entity.FinancialActivity;

@Database(entities = {FinancialActivity.class}, version = 2, exportSchema = false)
public abstract class ManageMoneyDataBase extends RoomDatabase {

    public abstract FinancialActivityDAO financialActivityDAO();
    private static ManageMoneyDataBase INSTANCE;

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE FinancialActivity "
                    + " ADD COLUMN description TEXT");
        }
    };

    public static ManageMoneyDataBase getInstance(final Context context){
        if(INSTANCE == null){
            INSTANCE = Room
                    .databaseBuilder(context.getApplicationContext(), ManageMoneyDataBase.class, Constants.DB_NAME)
                    .build();
        }

        return INSTANCE;
    }
}
