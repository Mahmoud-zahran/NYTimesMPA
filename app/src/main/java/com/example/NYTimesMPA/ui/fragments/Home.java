package com.example.NYTimesMPA.ui.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.NYTimesMPA.R;
import com.example.NYTimesMPA.adapters.RepoDataAdapter;


import com.example.NYTimesMPA.databinding.HomeBinding;
import com.example.NYTimesMPA.model.RepositoryResponse;
import com.example.NYTimesMPA.ui.AdapterCommunictionWithActivity;
import com.example.NYTimesMPA.ui.MainActivity;
import com.example.NYTimesMPA.viewmodel.RepoDataViewModel;


import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * Created by Mahmoud Zahran on 10, Dec,2020
 */

@AndroidEntryPoint
public class Home extends Fragment /*implements AdapterCommunictionWithActivity*/ {
    private static final String TAG = "Home";
    private HomeBinding binding;
    private RepoDataViewModel viewModel;
    private RepoDataAdapter adapter;
    private ArrayList<RepositoryResponse.Result> repoDataList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = HomeBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(RepoDataViewModel.class);

        initRecyclerView();
        observeData();
        setUpItemTouchHelper();
        viewModel.getRepos();

        if (!isNetworkConnected()/*||!isInternetAvailable()*/){
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConnectionLost())
                    .commit();

        }
        binding.pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
               viewModel.getRepos();// your code
                binding.pullToRefresh.setRefreshing(false);
                if (!isNetworkConnected()/*||!isInternetAvailable()*/){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConnectionLost())
                            .commit();

                }
            }
        });
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedRepoPosition = viewHolder.getAdapterPosition();
                RepositoryResponse.Result repositoryResponse = adapter.getRepoAt(swipedRepoPosition);
//                viewModel.insertRepo(repositoryResponse);
                adapter.notifyDataSetChanged();
                Toast.makeText(getContext(),"Repo added to fragment_details.",Toast.LENGTH_SHORT).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.repoRecyclerView);
    }


    private void observeData() {
        viewModel.getmRepoList().observe(getViewLifecycleOwner(), (Observer<? super ArrayList<RepositoryResponse.Result>>) new Observer<ArrayList<RepositoryResponse.Result>>() {
            @Override
            public void onChanged(ArrayList<RepositoryResponse.Result> results) {
                ArrayList<RepositoryResponse.Result> repoData= results;
                if (repoData.isEmpty()){
                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConnectionLost())
                            .commit();
                }
                Log.e(TAG, "onChanged: " + repoData.size() );
                adapter.updateList((ArrayList<RepositoryResponse.Result>) repoData);
            }
        });
            }

//            @Override
//         public void onChanged(RepositoryResponse repositoryResponse) {
//                ArrayList<RepositoryResponse.Result> repoData= repositoryResponse.getResults();
//                if (repoData.isEmpty()){
//                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new ConnectionLost())
//                            .commit();
//                }
//                Log.e(TAG, "onChanged: " + repoData.size() );
//                adapter.updateList((ArrayList<RepositoryResponse.Result>) repoData);
//            }
//        });
//    }

    private void initRecyclerView() {
        binding.repoRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RepoDataAdapter(/*this,*/ getActivity().getApplicationContext(), (ArrayList<RepositoryResponse.Result>) repoDataList);
        binding.repoRecyclerView.setAdapter(adapter);
    }
    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }
   /* @Override
    public void openHomeFragment() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Favorites())
                .commit();
    }*/
}
