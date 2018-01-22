package com.example.longlongtran.webview;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_Start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_Start = findViewById(R.id.btn_Start);
        btn_Start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String url = "https://google.com";
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                intent.setComponent(ComponentName.unflattenFromString("com.android.chrome"));
//                intent.addCategory("android.intent.category.LAUNCHER");
//                startActivity(intent);
                Intent intent = new Intent("com.android.chrome");
                startActivity(intent);
            }
        });
    }
}
