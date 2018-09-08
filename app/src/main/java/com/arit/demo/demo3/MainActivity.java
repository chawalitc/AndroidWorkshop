package com.arit.demo.demo3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.math.BigDecimal;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvMessage) TextView tvMessage;
    @BindView(R.id.etHeight) EditText etHeight;
    @BindView(R.id.etWelght) EditText etWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnHello)
    public void doClickHello(){
        BigDecimal height = new BigDecimal(etHeight.getText().toString());
        BigDecimal weight = new BigDecimal(etWeight.getText().toString());
        BigDecimal meter = new BigDecimal(100);
        System.out.println("weight:"+weight+" height"+height);

        BigDecimal bmiResult = new BigDecimal(0);
        bmiResult = (height.divide(meter)).multiply((height.divide(meter)));
        bmiResult = weight.divide(bmiResult, 2, BigDecimal.ROUND_HALF_UP);
        System.out.println("bmiResult:"+bmiResult);
        tvMessage.setText("Your BMI:"+bmiResult.toString());
    }

}
