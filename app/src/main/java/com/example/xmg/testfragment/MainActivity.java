package com.example.xmg.testfragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity implements View.OnClickListener{


    private Button movieBtn, tvBtn,animeBtn;
    private List<Button> btnList = new ArrayList<Button>();
    private FragmentManager fm;
    private FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findById();

        // 進入系統默認為第一个
        fm =getSupportFragmentManager() ;
        ft = fm.beginTransaction();

        setBackgroundColorById(R.id.movie_btn);
        ft.replace(R.id.fragment_content,new FirstFragment());
        ft.commit();
    }

    private void findById() {
        movieBtn = (Button)this.findViewById(R.id.movie_btn);
        tvBtn = (Button)this.findViewById(R.id.tv_btn);
        animeBtn = (Button) this.findViewById(R.id.anime_btn);
        movieBtn.setOnClickListener(this);
        tvBtn.setOnClickListener(this);
        animeBtn.setOnClickListener(this);

        btnList.add(movieBtn);
        btnList.add(tvBtn);
        btnList.add(animeBtn);
    }

    private void setBackgroundColorById(int btnId) {
        for (Button btn : btnList) {
            if (btn.getId() == btnId){
                btn.setBackgroundColor(Color.MAGENTA);
            }else {
                btn.setBackgroundColor(Color.LTGRAY);
            }
        }
    }



    @Override
    public void onClick(View v) {
        // TODO Auto-generated methodstub
        fm = getSupportFragmentManager();
        ft = fm.beginTransaction();
        switch (v.getId()) {

            case R.id.movie_btn:
                setBackgroundColorById(R.id.movie_btn);

                ft.replace(R.id.fragment_content,new FirstFragment());
                break;

            case R.id.tv_btn:
                setBackgroundColorById(R.id.tv_btn);

                ft.replace(R.id.fragment_content,new TwoFragment());
                break;

            case R.id.anime_btn:
                setBackgroundColorById(R.id.anime_btn);

                ft.replace(R.id.fragment_content,new ThreeFragment());
                break;

            default:
                break;
        }
        // 不要忘记提交
        ft.commit();
    }

}
