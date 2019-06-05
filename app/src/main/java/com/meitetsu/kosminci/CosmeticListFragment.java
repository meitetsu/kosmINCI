package com.meitetsu.kosminci;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CosmeticListFragment extends Fragment {
    private RecyclerView mCosmeticRecyclerView;
    private CosmeticAdapter mAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cosmetic_list, container, false);
        mCosmeticRecyclerView = view.findViewById(R.id.cosmetic_recycler_view);
        mCosmeticRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        CosmeticLab cl = CosmeticLab.get(getActivity());
        List<Cosmetic> cosmetics = cl.getCosmetics();
        if(mAdapter == null) {
            mAdapter = new CosmeticAdapter(cosmetics);
            mCosmeticRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.setCosmetics(cosmetics);
            mAdapter.notifyDataSetChanged();
        }
    }

    private class CosmeticHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private Cosmetic mCosmetic;
        private TextView mCompanyName;
        private TextView mCosmeticName;
        private TextView mCosmeticType;
        //private ImageView mCosmeticImage;

        public CosmeticHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_cosmetic, parent, false));
            itemView.setOnClickListener(this);

            mCompanyName = itemView.findViewById(R.id.listCompanyName);
            mCosmeticName = itemView.findViewById(R.id.listCosmeticName);
            mCosmeticType = itemView.findViewById(R.id.listCosmeticType);
            //mCosmeticImage = itemView.findViewById(R.id.listCosmeticImage);
        }

        public void bind(Cosmetic cosmetic) {
            mCosmetic = cosmetic;
            mCompanyName.setText(mCosmetic.getCompanyName());
            mCosmeticName.setText(mCosmetic.getCosmeticName());
            mCosmeticType.setText(mCosmetic.getCosmeticType());
        }

        @Override
        public void onClick(View v) {
            Intent intent = SearchActivity.newIntent(getActivity(), mCosmetic.getId());
            startActivity(intent);
        }
    }

    private class CosmeticAdapter extends RecyclerView.Adapter<CosmeticHolder> {
        private List<Cosmetic> mCosmetics;
        public CosmeticAdapter(List<Cosmetic> cosmetics) {
            mCosmetics = cosmetics;
        }

        @NonNull
        @Override
        public CosmeticHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater li = LayoutInflater.from(getActivity());
            return new CosmeticHolder(li, parent);
        }

        @Override
        public void onBindViewHolder(@NonNull CosmeticHolder holder, int position) {
            Cosmetic c = mCosmetics.get(position);
            holder.bind(c);
        }

        @Override
        public int getItemCount() {
            return mCosmetics.size();
        }

        public void setCosmetics(List<Cosmetic> cosmetics) {
            mCosmetics = cosmetics;
        }
    }

}
