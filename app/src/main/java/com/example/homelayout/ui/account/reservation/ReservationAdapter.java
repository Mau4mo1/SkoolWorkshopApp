package com.example.homelayout.ui.account.reservation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.logic.MessageAdapter;

import java.io.Serializable;

public class ReservationAdapter extends RecyclerView.Adapter<ReservationAdapter.ReservationViewHolder> implements Serializable {
    @NonNull
    @Override
    public ReservationAdapter.ReservationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //      Log.d(TAG, "onCreateViewHolder() is aangeroepen.");

        Context context = parent.getContext();

        int layoutIdForListItem = R.layout.fragment_my_reservation_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new ReservationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ReservationAdapter.ReservationViewHolder holder, int position) {
        Message message = messageList.get(position);
        holder.mTitle.setText(String.valueOf(message.getTitle()));
        holder.mText.setText(String.valueOf(message.getMessageText()));
        holder.imageButton.setOnClickListener(new View.OnClickListener() {​​​​​​​​
            @Override
            public void onClick(View v) {​​​​​​​​
                messageList.remove(position);
                messageObjList.addAll(messageList);
                tinyDB.clear();
                tinyDB.putListObject("MessageBox", messageObjList);
                notifyDataSetChanged();
            }
        });


    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ReservationViewHolder extends RecyclerView.ViewHolder{
        private TextView id;
        private TextView date;
        private TextView status;
        private TextView kost;
        private Button detail;

        public ReservationViewHolder(@NonNull View view){
            super(view);
        }
    }
}
