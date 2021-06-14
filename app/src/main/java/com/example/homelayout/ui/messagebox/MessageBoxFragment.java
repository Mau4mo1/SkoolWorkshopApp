package com.example.homelayout.ui.messagebox;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;
import com.example.homelayout.domain.Message;
import com.example.homelayout.logic.MessageAdapter;
import com.example.homelayout.repositories.TinyDB;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class MessageBoxFragment extends Fragment {
    private ArrayList<Object> messageList;
    private MessageAdapter messageAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Context thisContext;
    private TinyDB tinyDB;


    //These are test messages to fill the message list and test the recyclerview.
    private Message testMessage1 = new Message(1, "Hello there", "General kenobi");
    private Message testMessage2 = new Message(2, "Mooie titel 2.0", "Lorem ipsum blablablablabla 2.0");

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_message_box, container, false);

        thisContext = container.getContext();
        tinyDB = new TinyDB(thisContext);
        loadData();
        layoutManager = new LinearLayoutManager(thisContext);
        recyclerView = root.findViewById(R.id.rv_message_box_recyclerview);
        recyclerView.setLayoutManager(layoutManager);

        //Here the message list gets filled with test messages
        messageList.add(testMessage1);
//        messageList.add(testMessage1);

        MainActivity active = (MainActivity) getActivity();
        if(active.getMessage() != null){
            for(Message m : active.getMessage()){
                messageList.add(m);
            }
        }
        saveData();
        messageAdapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);
        return root;
    }


    public void saveData(){
        tinyDB.putListObject("MessageBox", messageList);
    }
    public void loadData(){
        messageList= tinyDB.getListObject("MessageBox",Message.class);
        if (messageList == null){
            messageList = new ArrayList<>();
        }
    }
}