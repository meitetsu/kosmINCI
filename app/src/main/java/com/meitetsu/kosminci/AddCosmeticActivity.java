package com.meitetsu.kosminci;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class AddCosmeticActivity extends AppCompatActivity {

    private Cosmetic mCosmetic;
    private EditText mSetCompany;
    private EditText mSetName;
    private EditText mSetType;
    private EditText mSetInci;

    @Nullable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_cosmetic);

//        mSetCompany = findViewById(R.id.setCompany);
//        //mSetCompany.setText(mCosmetic.getCompanyName());
//        mSetCompany.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                mCosmetic.setCompanyName(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        mSetName = findViewById(R.id.setName);
//        //mSetName.setText(mCosmetic.getCosmeticName());
//        mSetName.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                mCosmetic.setCosmeticName(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        mSetType = findViewById(R.id.setType);
//        //mSetType.setText(mCosmetic.getCosmeticType());
//        mSetType.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                mCosmetic.setCosmeticType(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
//
//        mSetInci = findViewById(R.id.setInci);
//        //mSetInci.setText(mCosmetic.getInci());
//        mSetInci.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                mCosmetic.setInci(s.toString());
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        });
    }
}
