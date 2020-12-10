package com.example.NYTimesMPA.ui.fragments;

import android.os.Bundle;
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

import com.example.NYTimesMPA.R;
import com.example.NYTimesMPA.adapters.RepoDataAdapter;

import com.example.NYTimesMPA.databinding.FragmentDetailsBinding;

import com.example.NYTimesMPA.model.RepositoryResponse;
import com.example.NYTimesMPA.ui.AdapterCommunictionWithActivity;
import com.example.NYTimesMPA.ui.MainActivity;
import com.example.NYTimesMPA.viewmodel.RepoDataViewModel;


import java.util.ArrayList;
import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

/**
 * Created by Mahmoud Zahran on 10, Dec,2020
 */

@AndroidEntryPoint
public class DetailsFragment extends Fragment /*implements AdapterCommunictionWithActivity */{
    private FragmentDetailsBinding binding;
    private RepoDataViewModel viewModel;
    private RepoDataAdapter adapter;
    private ArrayList<RepositoryResponse.Result> repoDataList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentDetailsBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(RepoDataViewModel.class);

        initRecyclerView();
        setUpItemTouchHelper();
        observeData();

    }

    private void observeData() {

        viewModel.getFavoriteRepoList().observe(getViewLifecycleOwner(), new Observer<List<RepositoryResponse>>() {
            @Override
            public void onChanged(List<RepositoryResponse> repoData) {

                if(repoData == null || repoData.size() == 0)
                    binding.noFavoritesText.setVisibility(View.VISIBLE);
                else{
                    ArrayList<RepositoryResponse.Result> list = new ArrayList<>();
                    list.addAll(repoData.get(0).getResults());
//                    adapter.updateList(list);
                }
            }
        });
    }

    private void setUpItemTouchHelper() {
        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int swipedRepoPosition = viewHolder.getAdapterPosition();
                RepositoryResponse.Result repoData = adapter.getRepoAt(swipedRepoPosition);
//                viewModel.deleteRepo(repoData.getStatus());
                Toast.makeText(getContext(),"Repo removed from fragment_details.",Toast.LENGTH_SHORT).show();
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(binding.favoritesRecyclerView);
    }


    private void initRecyclerView() {
        binding.favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new RepoDataAdapter(/*this,*/ (MainActivity)getActivity(), repoDataList);
        binding.favoritesRecyclerView.setAdapter(adapter);
    }
   /* @Override
    public void openHomeFragment() {
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new Home())
                .commit();
    }*/
}
