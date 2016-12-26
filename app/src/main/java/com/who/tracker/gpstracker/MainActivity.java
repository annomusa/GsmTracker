package com.who.tracker.gpstracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.main_input_mcc) EditText inputMcc;
    @BindView(R.id.main_input_mnc) EditText inputMnc;
    @BindView(R.id.main_input_lac) EditText inputLac;
    @BindView(R.id.main_input_cid) EditText inputCid;

    private String mcc, mnc, lac, cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.main_btn_locate)
    public void locate() {
        if (isFilled()) {

        }
    }

    private boolean isFilled() {
        mcc = inputMcc.getText().toString();
        mnc = inputMnc.getText().toString();
        lac = inputLac.getText().toString();
        cid = inputCid.getText().toString();
        return mcc != null && mnc != null && lac != null && cid != null;
    }
}
