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
    private Message testMessage1 = new Message(1, "Hello there", "Did you ever hear the tragedy of Darth Plagueis The Wise? I thought not. It’s not a story the Jedi would tell you. It’s a Sith legend. Darth Plagueis was a Dark Lord of the Sith, so powerful and so wise he could use the Force to influence the midichlorians to create life… He had such a knowledge of the dark side that he could even keep the ones he cared about from dying. The dark side of the Force is a pathway to many abilities some consider to be unnatural. He became so powerful… the only thing he was afraid of was losing his power, which eventually, of course, he did. Unfortunately, he taught his apprentice everything he knew, then his apprentice killed him in his sleep. Ironic. He could save others from death, but not himself.");
    private Message testMessage2 = new Message(2, "Lorem Ipsum Bro", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

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

        if(messageList.isEmpty()){
            messageList.add(testMessage1);
            messageList.add(testMessage2);
        }

        MainActivity active = (MainActivity) getActivity();
        if(active.getMessage() != null){
            for(Message m : active.getMessage()){
                messageList.add(m);
                active.deleteMessage(m);
            }
        }
        saveData();

        messageAdapter = new MessageAdapter(this,messageList, tinyDB);
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

    @Override
    public void recyclerviewClick(Message message) {
        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new MessageScreen(message)).addToBackStack(null).commit();
    }

    
}