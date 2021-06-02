package com.example.homelayout.ui.workshops;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class WorkshopsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public WorkshopsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("");
    }

    public LiveData<String> getText() {
        return mText;
    }
}