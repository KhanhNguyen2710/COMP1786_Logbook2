package com.example.look_book_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    String[] imageList;
    int i  ;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);

        imageList = getResources().getStringArray(R.array.imageList);
        loadAndDisplayImage(i);



       Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i++;
                if(i == imageList.length){
                    i = imageList.length -1 ;
                }else{
                    loadAndDisplayImage(i);

                }

            }
        });

        Button prevButton = findViewById(R.id.prevButton);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i--;
                if(i < 0 ){
                    i = 0;
                }else{
                    loadAndDisplayImage(i);

                }
            }
        });
    }

    private void loadAndDisplayImage(int index) {
        String imageName = imageList[index];
        int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());

        if (resID != 0) {
//            Picasso.get().load(resID).into(imageView);
            imageView.setImageResource(resID);
        }
    }

}
