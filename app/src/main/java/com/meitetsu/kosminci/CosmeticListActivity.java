package com.meitetsu.kosminci;

import androidx.fragment.app.Fragment;

public class CosmeticListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return new CosmeticListFragment();
    }
}
