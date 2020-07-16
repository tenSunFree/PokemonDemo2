package com.home.pokemondemo2.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.lifecycle.ViewModelProvider;

import com.home.pokemondemo2.databinding.FragmentHomeBinding;
import com.home.pokemondemo2.viewmodel.HomeViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeFragment extends androidx.fragment.app.Fragment {

    private FragmentHomeBinding binding;
    private HomeViewModel viewModel;
    private HomeAdapter adapter;

    @androidx.annotation.Nullable
    @Override
    public android.view.View onCreateView(@androidx.annotation.NonNull LayoutInflater inflater,
                                          @androidx.annotation.Nullable ViewGroup container, @androidx.annotation.Nullable android.os.Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@androidx.annotation.NonNull android.view.View view, @androidx.annotation.Nullable android.os.Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewModel();
        initRecyclerView();
    }

    private void initViewModel() {
        viewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel.getEntityList().observe(getViewLifecycleOwner(), list -> {
            if (list.size() == 0) viewModel.requestData();
            adapter.updateList(list);
        });
        viewModel.getResponseList().observe(getViewLifecycleOwner(),
                list -> adapter.updateList(list));
    }

    private void initRecyclerView() {
        adapter = new HomeAdapter();
        binding.recyclerView.setAdapter(adapter);
    }
}
