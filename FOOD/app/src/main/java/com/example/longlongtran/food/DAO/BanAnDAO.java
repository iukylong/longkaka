package com.example.longlongtran.food.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.longlongtran.food.Database.CreateDatabase;

/**
 * Created by LongLongTran on 1/21/2018.
 */

public class BanAnDAO {

    SQLiteDatabase database;

    public BanAnDAO(Context context) {
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open(context);
    }

    public boolean ThemBanAn(String tenbanan) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_BANAN_TENBAN, tenbanan);
        contentValues.put(CreateDatabase.TB_BANAN_TINHTRANG, "false");
        long kiemtra = database.insert(CreateDatabase.TB_BANAN, null, contentValues);
        if (kiemtra != 0) {
            return true;
        } else {
            return false;
        }
    }
}
