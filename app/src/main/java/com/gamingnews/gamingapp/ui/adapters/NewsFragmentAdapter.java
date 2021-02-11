package com.gamingnews.gamingapp.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gamingnews.gamingapp.R;
import com.gamingnews.gamingapp.databinding.ItemFragmentNewsBinding;
import com.gamingnews.gamingapp.models.Item;

import java.util.List;

public class NewsFragmentAdapter extends RecyclerView.Adapter<NewsFragmentAdapter.ViewHolder> {

    List<Item> mPostList;
    Context mContext;

    // Must make a constructor which takes array of posts
    public NewsFragmentAdapter(List<Item> mPostList, Context mContext) {
        this.mPostList = mPostList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemFragmentNewsBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.binding.postTitleNews.setText(mPostList.get(position).getTitle());
        holder.binding.postPublisherLogo.setBackgroundResource(R.drawable.ign);
        loadImg(holder, position);
        holder.binding.postPublisherName.setText(mPostList.get(position).getCreator());
    }

    @Override
    public int getItemCount() {
        if (mPostList != null) {
            return mPostList.size();
        }
        return 0;
    }


    private void loadImg(@NonNull ViewHolder holder, int position) {
        if (mPostList.get(position).getEnclosureImgObject().getImageEnclosureUrl() == "" && mPostList.get(position).getMediaImgObject().getMediaImageUrl() == "") {
            holder.binding.postImageNews.setBackgroundResource(R.drawable.test_post_img);
        } else if (mPostList.get(position).getMediaImgObject().getMediaImageUrl().length() > 0) {
            Glide
                    .with(mContext)
                    .load(mPostList.get(position).getMediaImgObject().getMediaImageUrl())
                    .fitCenter()
                    .into(holder.binding.postImageNews);

        } else {
            Glide
                    .with(mContext)
                    .load(mPostList.get(position).getEnclosureImgObject().getImageEnclosureUrl())
                    .fitCenter()
                    .into(holder.binding.postImageNews);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemFragmentNewsBinding binding;

        public ViewHolder(@NonNull ItemFragmentNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
