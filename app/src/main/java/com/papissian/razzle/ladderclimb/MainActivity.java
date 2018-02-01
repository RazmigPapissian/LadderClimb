package com.papissian.razzle.ladderclimb;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText editText;
    private TextView answer;

    private BigInteger n, firstStep, secondStep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.input);
        answer = (TextView) findViewById(R.id.answer);
        button = (Button) findViewById(R.id.calculate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!editText.getText().toString().isEmpty()) {
                    n = BigInteger.valueOf(Long.parseLong(editText.getText().toString()));
                    answer.setText(calculate(n) + "");
                }
            }
        });
    }

    public BigInteger calculate(BigInteger n) {
        if (n.equals(BigInteger.ZERO))
            return BigInteger.ZERO;
        if (n.equals(BigInteger.ONE))
            return BigInteger.ONE;

        firstStep = BigInteger.ONE;
        secondStep = BigInteger.valueOf(2);

        for (int i = 3; i<=n.intValue(); i++) {
            BigInteger thirdStep = firstStep.add(secondStep);
            firstStep = secondStep;
            secondStep = thirdStep;
        }

        return secondStep;
    }
}
