package com.uninorte.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.math.BigInteger;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private float n1;
    private String op = null;
    private float result = 0;
    private TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvRes = (TextView) findViewById(R.id.textView);
    }

    public void onNumericClick(View view) {
        Button b = (Button) view;
        int n = Integer.parseInt(b.getText().toString());
        result = result * 10 + n;
        tvRes.setText(String.format("%.0f", result));
    }

    public void onOpClick(View view) {
        Button b = (Button) view;
        if (op != null) {
            switch (op) {
                case "+":
                    n1 += result;
                    break;
                case "-":
                    n1 -= result;
                    break;
            }
            if (Objects.equals(b.getText().toString(), "=")) {
                result = n1;
                n1 = 0;
                op = null;
            } else {
                result = 0;
                op = b.getText().toString();
            }
        } else {
            n1 = result;
            op = b.getText().toString();
            result = 0;
        }
        tvRes.setText(String.format("%.0f", result));
    }
}
