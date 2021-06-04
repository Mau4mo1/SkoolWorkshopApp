package com.example.homelayout.ui.Cultureday.Form;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.homelayout.MainActivity;
import com.example.homelayout.R;

public class culturedayFormFragment extends Fragment {
    private Button btn_boek_nu_cdf;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cultureday, container, false);
        btn_boek_nu_cdf = root.findViewById(R.id.button_meer_informatie_cd);
        btn_boek_nu_cdf.setClickable(true);
//        btn_boek_nu_cdf.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                 new AlertDialog.Builder(context)
////                        .setMessage("Minimaal bedraf voor een cultuurdag is €1255,50, boek meer workshops of boek deze los")
////
//                        // Specifying a listener allows you to take an action before dismissing the dialog.
//                        // The dialog is automatically dismissed when a dialog button is clicked.
//                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
//                            public void onClick(DialogInterface dialog, int which) {
//                                // Continue with delete operation
//                            }
//                        });
////            }
//        });

        return root;
//        1255,5 minimaal
//        Subtotaal
//        Prijs workshops
//        Prijs extra (grafiti)
//        Datum
    }
}
