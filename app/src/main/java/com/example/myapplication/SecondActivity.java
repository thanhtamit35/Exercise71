package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ArrayList<String> data = getIntent().getStringArrayListExtra("data");

        double a = Double.parseDouble(data.get(0));
        double b = Double.parseDouble(data.get(1));

        String res = solve(a, b);

        Intent intent = new Intent(
                getApplicationContext(),
                MainActivity.class
        );

        Bundle bundle = new Bundle();
        bundle.putString("a", String.valueOf(a));
        bundle.putString("b", String.valueOf(b));
        bundle.putString("res", res);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private String solve(double a, double b) {
        if (a == 0.0) {
            return "Phương trình vô nghiệm.";
        }
        return "Phương trình có nghiệm: x = " + (-b / a);
    }
}
