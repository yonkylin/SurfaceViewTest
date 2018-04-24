package yonky.surfaceviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
ViewStub vs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.my_bt);
        vs = findViewById(R.id.my_viewstub);
//        bt.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                vs.setVisibility(View.VISIBLE);
//            }
//        });


    }
    public void myClick(View view){
        vs.setVisibility(View.VISIBLE);
    }
}
