package com.example.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExitFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExitFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageView imageView;
    Button button;
    ObjectAnimator scale,rotation,scaleDownX, scaleDownY;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button menu_exit;




    public ExitFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExitFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ExitFragment newInstance(String param1, String param2) {
        ExitFragment fragment = new ExitFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_exit, container, false);

        final Button button = rootView.findViewById(R.id.exit_button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                System.exit(1);
            }
        });

        //ObjectAnimator animation
        imageView=rootView.findViewById(R.id.card_animation);
        rotation= ObjectAnimator.ofFloat(imageView,"rotation",0f,1440f);
        scaleDownX = ObjectAnimator.ofFloat(imageView, "scaleX", 0.1f);
        scaleDownY = ObjectAnimator.ofFloat(imageView, "scaleY", 0.1f);


        rotation.setDuration(1500);
        scaleDownX.setDuration(1500);
        scaleDownY.setDuration(1500);
        AnimatorSet scaleDown = new AnimatorSet();
        scaleDown.play(scaleDownX).with(scaleDownY).with(rotation);
        scaleDown.start();

        return rootView;
    }
}