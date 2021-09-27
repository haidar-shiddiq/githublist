package com.omellete.githublist;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListCharAdapter extends RecyclerView.Adapter<ListCharAdapter.ListViewHolder> {

    private final ArrayList<GithubUser> listChar;

    public ListCharAdapter(ArrayList<GithubUser> list) {
        this.listChar = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_char, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        GithubUser githubUser = listChar.get(position);
        holder.avatarr.setImageResource(githubUser.getAvatar());
        holder.uname.setText(githubUser.getUsername());
        holder.namee.setText(githubUser.getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.PARCEL_NIH, githubUser);
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listChar.size();
    }
    public static class ListViewHolder extends RecyclerView.ViewHolder {
        final ImageView avatarr;
        final TextView uname,namee;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            avatarr = itemView.findViewById(R.id.avatar);
            uname = itemView.findViewById(R.id.username);
            namee = itemView.findViewById(R.id.name);
        }
    }

}
