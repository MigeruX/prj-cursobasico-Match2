package com.example.engelssoto.match2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button EasyButton = findViewById(R.id.btn_menu_easy);
        Button MediumButton = findViewById(R.id.btn_menu_medium);
        Button HardButton = findViewById(R.id.btn_menu_hard);

        EasyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, EasyActivity.class);
                startActivity(intent);
            }
        });

        MediumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, MediumActivity.class);
                startActivity(intent);
            }
        });

        HardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MenuActivity.this, HardActivity.class);
                startActivity(intent);
            }
        });
    }
}
