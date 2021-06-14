package com.example.homelayout.ui.messagebox;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.homelayout.R;
import com.example.homelayout.domain.Message;

public class MessageScreen extends Fragment {
    private Message message;
    private TextView mTitle;
    private TextView mText;

    public MessageScreen(Message message){
        this.message = message;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_message_screen, container, false);

        mTitle = (TextView) root.findViewById(R.id.tv_message_box_item_title);
        mText = (TextView) root.findViewById(R.id.tv_message_box_item_text);

        mTitle.setText(message.getTitle());
        mText.setText(message.getMessageText());

        return root;
    }
}