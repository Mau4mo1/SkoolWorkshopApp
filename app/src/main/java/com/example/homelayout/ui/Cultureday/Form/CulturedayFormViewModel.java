package com.example.homelayout.ui.Cultureday.Form;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CulturedayFormViewModel extends ViewModel {
    private MutableLiveData<String> mText;

    public CulturedayFormViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
