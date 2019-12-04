package com.paperflybd.com.niceproject.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.paperflybd.com.niceproject.R;
import com.paperflybd.com.niceproject.service.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

import com.paperflybd.com.niceproject.databinding.CardItemUserBinding;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.MyViewHolder> {

    private List<User> list= new ArrayList<>();


    public void setList(List<User> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        CardItemUserBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.card_item_user, parent, false);

        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position);
        holder.binding.setUser(user);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private CardItemUserBinding binding;

        public MyViewHolder(CardItemUserBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

}
