package com.home.pokemondemo2.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.home.pokemondemo2.databinding.FragmentHomeAdapterItemBinding;
import com.home.pokemondemo2.model.db.HomeEntity;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeAdapterViewHolder> {

    private java.util.List<HomeEntity> list;

    @androidx.annotation.NonNull
    @Override
    public HomeAdapterViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent,
                                                    int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        FragmentHomeAdapterItemBinding binding =
                FragmentHomeAdapterItemBinding.inflate(inflater, parent, false);
        return new HomeAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@androidx.annotation.NonNull HomeAdapterViewHolder holder,
                                 int position) {
        holder.binding.textViewTitle.setText(list.get(position).getTitle());
        holder.binding.textViewContent.setText(list.get(position).getContent());
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    public void updateList(java.util.List<HomeEntity> updatedList) {
        list = updatedList;
        notifyDataSetChanged();
    }

    static class HomeAdapterViewHolder extends RecyclerView.ViewHolder {
        private FragmentHomeAdapterItemBinding binding;

        public HomeAdapterViewHolder(FragmentHomeAdapterItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
