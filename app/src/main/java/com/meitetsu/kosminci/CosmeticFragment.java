package com.meitetsu.kosminci;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.UUID;

public class CosmeticFragment extends Fragment {
    private static final String ARG_COSM_ID = "cosmetic_id";
    private Cosmetic mCosmetic;
    //private ImageView mCosmeticImage;
    private TextView mCompanyName;
    private TextView mCosmeticName;
    private TextView mCosmeticType;
    private TextView mInci;

    public static CosmeticFragment newInstance(UUID cosmeticId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_COSM_ID, cosmeticId);
        CosmeticFragment fragment = new CosmeticFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID cosmeticId = (UUID) getArguments().getSerializable(ARG_COSM_ID);
        mCosmetic = CosmeticLab.get(getActivity()).getCosmetic(cosmeticId);
    }

    @Override
    public void onPause() {
        super.onPause();

        CosmeticLab.get(getActivity()).updateCosmetic(mCosmetic);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cosmetic, container, false);

        mCompanyName = v.findViewById(R.id.companyName);
        mCompanyName.setText(mCosmetic.getCompanyName());

        mCosmeticName = v.findViewById(R.id.cosmeticName);
        mCosmeticName.setText(mCosmetic.getCosmeticName());

        mCosmeticType = v.findViewById(R.id.cosmeticType);
        mCosmeticType.setText(mCosmetic.getCosmeticType());

        mInci = v.findViewById((R.id.inci));
        mInci.setText(mCosmetic.getInci());

        return v;
    }
}
