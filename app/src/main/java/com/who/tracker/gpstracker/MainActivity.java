package com.who.tracker.gpstracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    private final String TAG = this.getClass().getSimpleName();

    @BindView(R.id.main_input_mcc) EditText inputMcc;
    @BindView(R.id.main_input_mnc) EditText inputMnc;
    @BindView(R.id.main_input_lac) EditText inputLac;
    @BindView(R.id.main_input_cid) EditText inputCid;
    @BindView(R.id.main_spn_mcc) Spinner spinnerMcc;
    @BindView(R.id.main_spn_mnc) Spinner spinnerMnc;
    @BindView(R.id.main_spn_lac) Spinner spinnerLac;
    @BindView(R.id.main_spn_cid) Spinner spinnerCid;

    private MainPresenter presenter;
    private boolean isLacDecimal = true;
    private boolean isCidDecimal = true;
    private String mcc;
    private String mnc;
    private String lac;
    private String cid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initView();

        presenter = new MainPresenter(this);
    }

    private void initView() {
        SpinnerResponse spinnerResponse = new SpinnerResponse();
        ArrayAdapter<CharSequence> adapterMcc = ArrayAdapter.createFromResource(this,
                R.array.mcc_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterMnc = ArrayAdapter.createFromResource(this,
                R.array.mnc_array, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapterLacCid = ArrayAdapter.createFromResource(this,
                R.array.decimal_hex, android.R.layout.simple_spinner_item);

        adapterMcc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterMnc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapterLacCid.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerMcc.setAdapter(adapterMcc);
        spinnerMnc.setAdapter(adapterMnc);
        spinnerLac.setAdapter(adapterLacCid);
        spinnerCid.setAdapter(adapterLacCid);

        spinnerMcc.setOnItemSelectedListener(spinnerResponse);
        spinnerMnc.setOnItemSelectedListener(spinnerResponse);
        spinnerCid.setOnItemSelectedListener(spinnerResponse);
        spinnerLac.setOnItemSelectedListener(spinnerResponse);
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.unsubscribe();
    }

    @OnClick(R.id.main_btn_locate)
    public void locate() {
        if (isFilled()) {
            presenter.findLocation(cid, lac, mcc, mnc);
        } else {
            Toast.makeText(this, "Fill all the form", Toast.LENGTH_LONG).show();
        }
    }

    private boolean isFilled() {
        mcc = inputMcc.getText().toString();
        mnc = inputMnc.getText().toString();

        String valLac = inputLac.getText().toString();
        String valCid = inputCid.getText().toString();

        if (valLac.equals("")) {
            lac = null;
        } else if (!isLacDecimal) {
            int dec = Integer.valueOf(valLac, 16);
            lac = String.valueOf(dec);
        } else  {
            lac = inputLac.getText().toString();
        }

        if (valCid.equals("")) {
            cid = null;
        } else if (!isCidDecimal) {
            int dec = Integer.valueOf(valCid, 16);
            cid = String.valueOf(dec);
        } else {
            cid = inputCid.getText().toString();
        }
        return mcc != null && mnc != null && lac != null && cid != null;
    }

    @Override
    public void retrieveLocation(double lat, double lon) {
        Log.d(TAG, "retrieveLocation: " + lat + " " + lon);
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("lat", lat);
        intent.putExtra("lon", lon);
        startActivity(intent);
    }

    @Override
    public void errorOccur(String message) {
        Toast.makeText(this, "Something wrong\nCheck your input", Toast.LENGTH_LONG).show();
    }

    private final class SpinnerResponse implements AdapterView.OnItemSelectedListener {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            Spinner spinner = (Spinner) adapterView;
            String val = (String) adapterView.getItemAtPosition(i);
            int id = getResources().getIdentifier(val, "string", getPackageName());

            switch (spinner.getId()) {
                case R.id.main_spn_mcc:
                    inputMcc.setText(getResources().getString(id));
                    break;
                case R.id.main_spn_mnc:
                    inputMnc.setText(getResources().getString(id));
                    break;
                case R.id.main_spn_lac:
                    isLacDecimal = val.equals("Decimal");
                    break;
                case R.id.main_spn_cid:
                    isCidDecimal = val.equals("Decimal");
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    }
}