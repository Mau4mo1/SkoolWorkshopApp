package com.example.homelayout.ui.messagebox;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;
import com.example.homelayout.domain.Message;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.logic.MessageAdapter;
import com.example.homelayout.repositories.TinyDB;
import com.example.homelayout.ui.workshops.WorkshopsForm;

import java.util.ArrayList;
import java.util.List;

public class MessageBoxFragment extends Fragment implements MessageAdapter.RecyclerviewOnClickListener {
    private ArrayList<Object> messageList;
    private MessageAdapter messageAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Context thisContext;
    private TinyDB tinyDB;
    private final String TAG = getClass().getSimpleName();


    //These are test messages to fill the message list and test the recyclerview.

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

        MainActivity active = (MainActivity) getActivity();
        if(active.getMessage() != null){
            for(Message m : active.getMessage()){
                messageList.add(m);
            }
            active.deleteMessage();
            active.counter = 0;
        }
        saveData();

        messageAdapter = new MessageAdapter(this,messageList, tinyDB);
        recyclerView.setAdapter(messageAdapter);

        //tinyDB.clear();
        //Here the message list gets filled with test messages
//        messageList.add(testMessage1);
        return root;
    }


    public void saveData(){
        tinyDB.putListObject("MessageBox", messageList);
    }

    public void loadData(){
        messageList = tinyDB.getListObject("MessageBox",Message.class);
        if (messageList == null){
            messageList = new ArrayList<>();
        }
    }

    @Override
    public void recyclerviewClick(Message message) {
        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new MessageScreen(message)).addToBackStack(null).commit();
    }

    
}