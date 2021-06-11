package com.example.homelayout.ui.messagebox;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homelayout.R;
import com.example.homelayout.domain.Message;
import com.example.homelayout.logic.MessageAdapter;

import java.util.ArrayList;

public class MessageBoxFragment extends Fragment implements MessageAdapter.RecyclerviewOnClickListener {
    private ArrayList<Message> messageList = new ArrayList<>();
    private MessageAdapter messageAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Context thisContext;

    //These are test messages to fill the message list and test the recyclerview.
    private Message testMessage1 = new Message(1, "Mooie titel", "Lorem ipsum blablablablabla");
    private Message testMessage2 = new Message(2, "Mooie titel 2.0", "Lorem ipsum blablablablabla 2.0");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_message_box, container, false);

        thisContext = container.getContext();
        layoutManager = new LinearLayoutManager(thisContext);
        recyclerView = root.findViewById(R.id.rv_message_box_recyclerview);
        recyclerView.setLayoutManager(layoutManager);

        //Here the message list gets filled with test messages
        messageList.add(testMessage1);
        messageList.add(testMessage1);

        messageAdapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);

        /*int position = 1;
        for (Message movie : messageList) {
            if (mTitleText.getText().toString().equals(movie.getTitle())) {
                position = filmList.indexOf(movie);
            }
        }
        Message message = messageList.get(position);*/

        return root;
    }

    @Override
    public void recyclerviewClick(int position) {

    }
}