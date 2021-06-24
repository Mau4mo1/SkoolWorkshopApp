package com.example.homelayout.ui.account.data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.homelayout.R;
import com.example.homelayout.ui.home.HomeFragment;

public class MyDataFragment extends Fragment {
    private Button btn_change_data;
    private EditText ed_first_name;
    private EditText ed_last_name;
    private EditText ed_display_name;
    private EditText ed_email;
    private EditText ed_current_password;
    private EditText ed_new_password;
    private EditText ed_new_password_confirmation;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_my_data, container, false);
        btn_change_data = root.findViewById(R.id.button_change_my_data);
        ed_first_name = root.findViewById(R.id.edn_my_data_firsname_field);
        ed_last_name = root.findViewById(R.id.edn_my_data_lastname_field);
        ed_display_name = root.findViewById(R.id.edn_my_data_displayname_field);
        ed_email = root.findViewById(R.id.edm_my_data_email_field);
        ed_current_password = root.findViewById(R.id.edn_my_data_current_password_field);
        ed_new_password = root.findViewById(R.id.edt_my_data_new_password_field);
        ed_new_password_confirmation = root.findViewById(R.id.edt_my_data_new_password_confirmation_field);

        btn_change_data.setClickable(true);
        btn_change_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                PLACEHOLDER NEEDS TO CHANGE DATA
                getFragmentManager().beginTransaction().replace(R.id.nav_host_fragment,new HomeFragment()).addToBackStack(null).commit();
            }
        });

        return root;
    }
}
