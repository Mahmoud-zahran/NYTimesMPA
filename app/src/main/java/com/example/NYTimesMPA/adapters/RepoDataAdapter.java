package com.example.NYTimesMPA.adapters;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;


import com.bumptech.glide.request.RequestOptions;
import com.example.NYTimesMPA.R;
import com.example.NYTimesMPA.databinding.ListItemBinding;
import com.example.NYTimesMPA.model.RepositoryResponse;
import com.example.NYTimesMPA.ui.MainActivity;
import com.example.NYTimesMPA.ui.fragments.DetailsFragment;


import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Mahmoud Zahran on 10, Dec,2020
 */
public class RepoDataAdapter extends RecyclerView.Adapter<RepoDataAdapter.RepoDataViewHolder> {
    private Context mContext;
    private Activity mActivity;
    private ArrayList<RepositoryResponse.Result> mList;
//    AdapterCommunictionWithActivity mAdapterCommunictionWithActivity= null ;
    private ListItemBinding binding;

    public RepoDataAdapter(/*AdapterCommunictionWithActivity adapterCommunictionWithActivity,*/MainActivity mainActivity, ArrayList<RepositoryResponse.Result> mList) {
        this.mContext = mContext;
        this.mList = mList;
        this.mActivity= mainActivity;
//        this.mAdapterCommunictionWithActivity= adapterCommunictionWithActivity;
    }

    @NonNull
    @Override
    public RepoDataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mActivity);
        binding = ListItemBinding.inflate(inflater,parent,false);
        return new RepoDataViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RepoDataViewHolder holder, int position) {
        final RepositoryResponse.Result item = mList.get(position);
        holder.itemBinding.repoAuther.setText(mList.get(position).getTitle());
        holder.itemBinding.repoName.setText(mList.get(position).getPublishedDate());
//        holder.itemBinding.langs.setText(mList.get(position).getPublishedDate());
//        holder.itemBinding.forks.setText((mList.get(position).getPublishedDate())+"");
//        holder.itemBinding.stars.setText(mList.get(position).getByline()+"");
        holder.itemBinding.discription.setText(mList.get(position).getByline());
        holder.itemBinding.maincardLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("RepoAdapter", "onClick: ");
//                Toast.makeText(mActivity, "item clicked #"+position, Toast.LENGTH_SHORT).show();
                fragmentJump(item,position);
//
            }
        });
//        boolean isExpanded= mList.get(position).isExpanded();
//        holder.itemBinding.expandableLayout.setVisibility(isExpanded? View.VISIBLE : View.GONE);

        Glide.with(mActivity).applyDefaultRequestOptions(new RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background))
                .load(mList.get(position).getMedia().get(0).getMediaMetadata().get(0).getUrl())
                .into(holder.itemBinding.repoImage);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    class RepoDataViewHolder extends RecyclerView.ViewHolder{
        private ListItemBinding itemBinding;

        public RepoDataViewHolder(ListItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }

    public  void updateList(ArrayList<RepositoryResponse.Result> updatedList){
        mList = updatedList;
        notifyDataSetChanged();
    }

    public RepositoryResponse.Result getRepoAt(int position){
        return mList.get(position);
    }

    private void fragmentJump(RepositoryResponse.Result mItemSelected,int  pos) {
        DetailsFragment mFragment =new DetailsFragment();
//        mFragment = new Fragment2();

        Bundle mBundle = new Bundle();
        mBundle.putSerializable("item_selected_key", (Serializable) mItemSelected);
        mFragment.setArguments(mBundle);
        switchContent(R.id.frameLayout, mFragment);
    }
    public void switchContent(int id, Fragment fragment) {
        if (mActivity == null)
            return;
        if (mActivity instanceof MainActivity) {
            MainActivity mainActivity = (MainActivity) mActivity;
            Fragment frag = fragment;
            mainActivity.switchContent(id, frag);
        }

    }
}
