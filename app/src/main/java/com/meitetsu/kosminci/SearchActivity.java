package com.meitetsu.kosminci;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;

public class SearchActivity extends SingleFragmentActivity {

    private static final String EXTRA_COSMETIC_ID = "com.meitetsu.kosminci.cosmetic_id";

    //private List<Cosmetic> mCosmetics;

    public static Intent newIntent(Context packageContext, UUID cosmeticId) {
        Intent intent = new Intent(packageContext, SearchActivity.class);
        intent.putExtra(EXTRA_COSMETIC_ID, cosmeticId);
        return intent;
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_search);
//
//
//    }

    @Override
    protected Fragment createFragment() {
        UUID cosmeticId = (UUID) getIntent().getSerializableExtra(EXTRA_COSMETIC_ID);
        return CosmeticFragment.newInstance(cosmeticId);
    }
}
