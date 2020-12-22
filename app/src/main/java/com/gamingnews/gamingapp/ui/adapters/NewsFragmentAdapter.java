package com.gamingnews.gamingapp.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gamingnews.gamingapp.databinding.ItemFragmentNewsBinding;

public class NewsFragmentAdapter extends RecyclerView.Adapter<NewsFragmentAdapter.ViewHolder> {
  //  List<> mPostList;

    // Must make a constructor which takes array of posts

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemFragmentNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // TO-DO
    }

    @Override
    public int getItemCount() {
        return 0;//mPostList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemFragmentNewsBinding binding;

        public ViewHolder(@NonNull ItemFragmentNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
