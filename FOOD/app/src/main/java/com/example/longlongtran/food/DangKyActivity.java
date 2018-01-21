package com.example.longlongtran.food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.longlongtran.food.DAO.NhanVienDAO;
import com.example.longlongtran.food.DTO.NhanVienDTO;
import com.example.longlongtran.food.Database.CreateDatabase;
import com.example.longlongtran.food.FragmentApp.DatePickerFragment;

public class DangKyActivity extends AppCompatActivity implements View.OnClickListener, View.OnFocusChangeListener {

    EditText edTenDangNhapDK, edMatKhauDK, edNgaySinhDK, edCMNDDK;
    Button btnDongYDK, btnThoatDK;
    RadioGroup rgGioiTinh;
    String sGioiTinh;
    NhanVienDAO nhanVienDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangky);
        init();
    }

    public void init() {
        edTenDangNhapDK = findViewById(R.id.edTenDangNhapDK);
        edMatKhauDK = findViewById(R.id.edMatKhauDK);
        edNgaySinhDK = findViewById(R.id.edNgaySinhDK);
        edCMNDDK = findViewById(R.id.edCMNDDK);
        btnDongYDK = findViewById(R.id.btnDongYDK);
        btnThoatDK = findViewById(R.id.btnThoatDK);
        rgGioiTinh = findViewById(R.id.rgGioiTinh);
        btnDongYDK.setOnClickListener(this);
        btnThoatDK.setOnClickListener(this);
        edNgaySinhDK.setOnFocusChangeListener(this);
        nhanVienDAO = new NhanVienDAO(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDongYDK:
                String sTenDangNhap = edTenDangNhapDK.getText().toString();
                String sMatKhau = edMatKhauDK.getText().toString();
                switch (rgGioiTinh.getCheckedRadioButtonId()) {
                    case R.id.rdNam:
                        sGioiTinh = "Nam";
                        break;
                    case R.id.rdNu:
                        sGioiTinh = "Nu";
                        break;
                }
                String sNgaySinh = edNgaySinhDK.getText().toString();
                int sCMND = Integer.valueOf(edCMNDDK.getText().toString());
                if (sTenDangNhap == null && sTenDangNhap.equals("")) {
                    Toast.makeText(DangKyActivity.this, R.string.loinhaptendangnhap, Toast.LENGTH_LONG).show();
                } else if (edMatKhauDK == null && sMatKhau.equals("")) {
                    Toast.makeText(DangKyActivity.this, R.string.loinhapmatkhau, Toast.LENGTH_LONG).show();
                } else {
                    NhanVienDTO nhanVienDTO = new NhanVienDTO();
                    nhanVienDTO.setTENDN(sTenDangNhap);
                    nhanVienDTO.setMATKHAU(sMatKhau);
                    nhanVienDTO.setCMND(sCMND);
                    nhanVienDTO.setNGAYSINH(sNgaySinh);
                    nhanVienDTO.setGIOITINH(sGioiTinh);
                    nhanVienDAO.ThemNhanVien(nhanVienDTO);
                    long kiemtra = nhanVienDAO.ThemNhanVien(nhanVienDTO);
                    if (kiemtra != 0) {
                        Toast.makeText(DangKyActivity.this, R.string.themthanhcong, Toast.LENGTH_LONG).show();
                        finish();
                    } else {
                        Toast.makeText(DangKyActivity.this, R.string.themthatbai, Toast.LENGTH_LONG).show();
                    }
                }
                break;
            case R.id.btnThoatDK:
                finish();
                break;
        }
    }


    @Override
    public void onFocusChange(View view, boolean b) {
        int id = view.getId();
        switch (id) {
            case R.id.edNgaySinhDK:
                if (b) {
                    DatePickerFragment datePickerFragment = new DatePickerFragment();
                    datePickerFragment.show(getFragmentManager(), "Ngày Sinh");
                }
                break;
        }
    }
}
