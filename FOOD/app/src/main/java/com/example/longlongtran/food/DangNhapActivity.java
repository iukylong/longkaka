package com.example.longlongtran.food;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.longlongtran.food.DAO.NhanVienDAO;

/**
 * Created by LongLongTran on 1/21/2018.
 */

public class DangNhapActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnDongYDN, btnDangKyDN;
    EditText edTenDangNhapDN, edMatKhauDN;
    NhanVienDAO nhanVienDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dangnhap);
        init();
        HienThiButtonDangKyVSDongY();
    }

    public void init() {
        btnDongYDN = findViewById(R.id.btnDongYDN);
        btnDangKyDN = findViewById(R.id.btnDangKy);
        edTenDangNhapDN = findViewById(R.id.edTenDangNhapDN);
        edMatKhauDN = findViewById(R.id.edMatKhauDN);
        btnDangKyDN.setVisibility(View.GONE);
        nhanVienDAO = new NhanVienDAO(this);
        btnDangKyDN.setOnClickListener(this);
        btnDongYDN.setOnClickListener(this);
    }

    private void HienThiButtonDangKyVSDongY() {
        boolean kiemtra = nhanVienDAO.KiemTraNhanVien();
        if (kiemtra) {
            btnDangKyDN.setVisibility(View.GONE);
            btnDongYDN.setVisibility(View.VISIBLE);
        } else {
            btnDangKyDN.setVisibility(View.VISIBLE);
            btnDongYDN.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        HienThiButtonDangKyVSDongY();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnDongYDN:
                DangNhap();
                break;
            case R.id.btnDangKy:
                DangKy();
                break;
        }
    }

    /**
     * handle login of app
     */
    private void DangNhap() {
        String tenDangNhap = edTenDangNhapDN.getText().toString();
        String matKhau = edMatKhauDN.getText().toString();
        boolean kiemtra = nhanVienDAO.KiemTraDangNhap(tenDangNhap, matKhau);
        if (kiemtra) {
            Toast.makeText(DangNhapActivity.this, R.string.dangnhapthanhcong, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(DangNhapActivity.this, R.string.dangnhapthatbai, Toast.LENGTH_SHORT).show();
        }
    }

    private void DangKy() {
        Intent intent = new Intent(DangNhapActivity.this, DangKyActivity.class);
        startActivity(intent);
    }
}
