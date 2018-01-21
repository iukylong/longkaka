package com.example.longlongtran.food.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.longlongtran.food.DTO.NhanVienDTO;
import com.example.longlongtran.food.Database.CreateDatabase;

/**
 * Created by LongLongTran on 1/20/2018.
 */

public class NhanVienDAO {
    SQLiteDatabase database;

    public NhanVienDAO(Context context) {
        CreateDatabase createDatabase = new CreateDatabase(context);
        database = createDatabase.open(context);
    }

    public long ThemNhanVien(NhanVienDTO nhanVienDTO) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(CreateDatabase.TB_NHANVIEN_TENDN, nhanVienDTO.getTENDN());
        contentValues.put(CreateDatabase.TB_NHANVIEN_CMND, nhanVienDTO.getCMND());
        contentValues.put(CreateDatabase.TB_NHANVIEN_GIOITINH, nhanVienDTO.getGIOITINH());
        contentValues.put(CreateDatabase.TB_NHANVIEN_MATKHAU, nhanVienDTO.getMATKHAU());
        contentValues.put(CreateDatabase.TB_NHANVIEN_NGAYSINH, nhanVienDTO.getNGAYSINH());
        long kiemtra = database.insert(CreateDatabase.TB_NHANVIEN, null, contentValues);
        return kiemtra;

    }

    public boolean KiemTraNhanVien() {
        String truyvan = "SELECT * FROM " + CreateDatabase.TB_NHANVIEN;
        Cursor cursor = database.rawQuery(truyvan, null);
        if (cursor.getCount() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean KiemTraDangNhap(String tenDangNhap, String matKhau) {
        String truyvan = "SELECT * FROM " + CreateDatabase.TB_NHANVIEN + " WHERE " + CreateDatabase.TB_NHANVIEN_TENDN + " = '"
                + tenDangNhap + "' AND " + CreateDatabase.TB_NHANVIEN_MATKHAU + " = '" + matKhau + "'";
        Cursor cursor = database.rawQuery(truyvan, null);
        if (cursor.getCount() != 0) {
            return true;
        } else {
            return false;
        }
    }
}
