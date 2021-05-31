package com.example.homelayout.ui.Cultureday.MainPage;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CulturedayMainViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CulturedayMainViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
