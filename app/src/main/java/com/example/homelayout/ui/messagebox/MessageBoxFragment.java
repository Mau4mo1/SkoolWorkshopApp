package com.example.homelayout.ui.messagebox;

import android.content.Context;
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
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.logic.MessageAdapter;
import com.example.homelayout.ui.workshops.WorkshopsForm;

import java.util.ArrayList;

public class MessageBoxFragment extends Fragment implements MessageAdapter.RecyclerviewOnClickListener {
    private ArrayList<Message> messageList = new ArrayList<>();
    private ArrayList<Integer> idList = new ArrayList<>();
    private MessageAdapter messageAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Context thisContext;

    //These are test messages to fill the message list and test the recyclerview.
    private Message testMessage1 = new Message(1, "Mooie titel", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
    private Message testMessage2 = new Message(2, "Mooie titel 2.0", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");

    private Message firebaseMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_message_box, container, false);

        thisContext = container.getContext();
        layoutManager = new LinearLayoutManager(thisContext);
        recyclerView = root.findViewById(R.id.rv_message_box_recyclerview);
        recyclerView.setLayoutManager(layoutManager);


        if(messageList.isEmpty()){
            messageList.add(testMessage1);
            messageList.add(testMessage2);
        }

        //Here the message list gets filled with test messages
        /*for(Message message: messageList){
            if(!idList.contains(testMessage1.getId())){
                idList.add(testMessage1.getId());
                messageList.add(testMessage1);
            }else if(!idList.contains(testMessage2.getId())){
                idList.add(testMessage2.getId());
                messageList.add(testMessage2);
            }
        }*/

        MainActivity active = (MainActivity) getActivity();
        if(active.getMessage() != null){
            for(Message m : active.getMessage()){
                messageList.add(m);
            }
        }
        messageAdapter = new MessageAdapter(this, messageList);
        recyclerView.setAdapter(messageAdapter);

        return root;
    }

    @Override
    public void recyclerviewClick(int position) {
        getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new MessageScreen(messageList.get(position))).addToBackStack(null).commit();
    }
}