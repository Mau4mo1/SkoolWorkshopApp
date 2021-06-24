package com.example.homelayout.logic;
import android.content.Context;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homelayout.R;
import com.example.homelayout.domain.Message;
import com.example.homelayout.repositories.TinyDB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> implements Serializable {
    private final String TAG = getClass().getSimpleName();
    public List<Message> messageList;
    public ArrayList<Object> messageObjList = new ArrayList<>();
    private RecyclerviewOnClickListener listener;
    private TinyDB tinyDB;

    public MessageAdapter(RecyclerviewOnClickListener listener, List messageList, TinyDB tinyDB) {
        this.listener = listener;
        this.messageList = messageList;
        this.tinyDB = tinyDB;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//      Log.d(TAG, "onCreateViewHolder() is aangeroepen.");

        Context context = parent.getContext();

        int layoutIdForListItem = R.layout.fragment_message_box_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        return new MessageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MessageViewHolder holder, int position) {
        //     Log.d(TAG, "onBind is aangeroepen");

        Message message = messageList.get(position);
        holder.mTitle.setText(String.valueOf(message.getTitle()));
        holder.mText.setText(String.valueOf(message.getMessageText()));
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageList.remove(position);
                messageObjList.addAll(messageList);
                tinyDB.clear();
                tinyDB.putListObject("MessageBox", messageObjList);
                messageObjList.clear();
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {

        if (null == messageList) {
        Log.d(TAG, "getItemCount(): Er zijn 0 items.");
            return 0;
        }

        Log.d(TAG, "getItemCount(): Er zijn " + messageList.size() + " items.");
        return messageList.size();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitle;
        private TextView mText;
        private ImageButton imageButton;
        private ConstraintLayout clMessageBoxItem;
        public Message messageItem;

        public MessageViewHolder(@NonNull View view) {
            super(view);

            Log.d(TAG, "ViewHolder constructor is aangeroepen.");

            mTitle = (TextView) view.findViewById(R.id.tv_message_box_title);
            mText = (TextView) view.findViewById(R.id.tv_message_box_description);
            imageButton = (ImageButton) view.findViewById(R.id.ib_delete_message);
            clMessageBoxItem = (ConstraintLayout) itemView.findViewById(R.id.cl_message_box_item);

            clMessageBoxItem.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    listener.recyclerviewClick(messageItem= (Message) messageList.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface RecyclerviewOnClickListener{

        void recyclerviewClick(Message message);
    }
}


