package com.example.tictactoe;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import com.example.tictactoe.databinding.ActivityMainBinding;

import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    int count = 0;
    boolean winnerDeclared = false;

    public void buttonClicked(View view) {
        Button btn = (Button) view;
        CharSequence btnText = btn.getText();
        if (btnText == "" && !winnerDeclared) {
            if (count % 2 == 0) {
                btn.setText("X");
            } else {
                btn.setText("0");
            }
            count++;
            if (count >= 5) {
                checkWinningMove();
            }
        }
    }

    public void checkWinningMove() {
        Button btn1 = findViewById(R.id.a);
        Button btn2 = findViewById(R.id.b);
        Button btn3 = findViewById(R.id.c);
        Button btn4 = findViewById(R.id.d);
        Button btn5 = findViewById(R.id.e);
        Button btn6 = findViewById(R.id.f);
        Button btn7 = findViewById(R.id.g);
        Button btn8 = findViewById(R.id.h);
        Button btn9 = findViewById(R.id.i);
        if (btn1.getText() == btn2.getText() && btn2.getText() == btn3.getText() && btn3.getText() != "") {
            declareResult(btn1.getText());
        }
        if (btn4.getText() == btn5.getText() && btn5.getText() == btn6.getText() && btn6.getText() != "") {
            declareResult(btn4.getText());
        }
        if (btn7.getText() == btn8.getText() && btn8.getText() == btn9.getText() && btn9.getText() != "") {
            declareResult(btn7.getText());
        }
        if (btn1.getText() == btn4.getText() && btn4.getText() == btn7.getText() && btn7.getText() != "") {
            declareResult(btn1.getText());
        }
        if (btn2.getText() == btn5.getText() && btn5.getText() == btn8.getText() && btn8.getText() != "") {
            declareResult(btn2.getText());
        }
        if (btn3.getText() == btn6.getText() && btn6.getText() == btn9.getText() && btn9.getText() != "") {
            declareResult(btn3.getText());
        }
        if (btn1.getText() == btn5.getText() && btn5.getText() == btn9.getText() && btn9.getText() != "") {
            declareResult(btn1.getText());
        }
        if (btn3.getText() == btn5.getText() && btn5.getText() == btn7.getText() && btn7.getText() != "") {
            declareResult(btn3.getText());
        } else if (count == 9) {
            declareDraw();
        }
    }

    public void declareResult(CharSequence winner) {
        TextView txt1 = findViewById(R.id.result);
        String str = (String) winner;
        str += " Winner !!";
        txt1.setText(str);
        int color = Color.parseColor("#80F0F8FF");
        txt1.setBackgroundColor(color);
        winnerDeclared = true;
    }

    public void declareDraw() {
        TextView txt1 = findViewById(R.id.result);
        txt1.setText("Draw !!");
        int color = Color.parseColor("#80F0F8FF");
        txt1.setBackgroundColor(color);
    }

    public void restartGame(View view) {
        count = 0;
        winnerDeclared = false;
        TextView txt1 = findViewById(R.id.result);
        txt1.setText("");
        txt1.setBackgroundColor(0);
        Button btn1 = findViewById(R.id.a);
        Button btn2 = findViewById(R.id.b);
        Button btn3 = findViewById(R.id.c);
        Button btn4 = findViewById(R.id.d);
        Button btn5 = findViewById(R.id.e);
        Button btn6 = findViewById(R.id.f);
        Button btn7 = findViewById(R.id.g);
        Button btn8 = findViewById(R.id.h);
        Button btn9 = findViewById(R.id.i);
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
    }
}