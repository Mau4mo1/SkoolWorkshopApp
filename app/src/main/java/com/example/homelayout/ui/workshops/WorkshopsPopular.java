package com.example.homelayout.ui.workshops;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.homelayout.R;
import com.example.homelayout.controller.TranslationsController;
import com.example.homelayout.controller.WorkshopController;
import com.example.homelayout.domain.TranslationsObject;
import com.example.homelayout.domain.Workshops;
import com.example.homelayout.domain.WorkshopsObject;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CheckedOutputStream;

public class WorkshopsPopular extends Fragment implements WorkshopController.WorkshopsControllerListener , TranslationsController.TranslationsControllerListener {
    private LinearLayoutManager workshopLayoutManager;
    private List<WorkshopsObject> workshopsObjectList;
    private List<TranslationsObject> translationsObjectsList;
    private RecyclerView workshopRecyclerView;
    private List<WorkshopsObject> workshopsObjectListWithTranslations = new ArrayList<>();
    private Context context;
    private String category;
    private View root;
    private TranslationsController.TranslationsControllerListener translationsListener;

    public WorkshopsPopular() {
        this.category = category;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        root = inflater.inflate(R.layout.workshops_recycler_view, container, false);
        context = container.getContext();
        translationsListener = this::onTranslationsAvailable;

        new WorkshopController(this).loadWorkshopsByCategory("Dans");

        return root;
    }

    @Override
    public void onWorkshopsAvailable(List<WorkshopsObject> workshopsObjectList) throws SQLException {
        this.workshopsObjectList = workshopsObjectList;
        for (WorkshopsObject i : workshopsObjectList) {
            new TranslationsController(translationsListener).loadTranslations(i.getId(), i);
        }
    }

    @Override
    public void onTranslationsAvailable(WorkshopsObject workshopsObject) throws SQLException {
        workshopsObjectListWithTranslations.add(workshopsObject);
        if (workshopsObjectListWithTranslations.size() == workshopsObjectList.size()) {
            workshopLayoutManager = new LinearLayoutManager(context);
            workshopRecyclerView = root.findViewById(R.id.rv_workshops_recycler_view);
            workshopRecyclerView.setLayoutManager(workshopLayoutManager);
            workshopRecyclerView.setHasFixedSize(true);
            workshopRecyclerView.setAdapter(new WorkshopCategoryAdapter(workshopsObjectListWithTranslations, context));
        }
    }
}
