package com.neusoft.individuation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.neusoft.simallutil.WeatherActivity;

/**
 * Created by Administrator on 2016/6/23.
 */
public class Tool_Activity extends Activity {
    String string[]={"实时天气","当前位置"};

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_tool);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(Tool_Activity.this,android.R.layout.simple_list_item_1,string);
        listView= (ListView) findViewById(R.id.lv);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Intent intent1=new Intent(Tool_Activity.this, WeatherActivity.class);
                        startActivity(intent1);
                    case 1:
                        Intent intent2=new Intent(Tool_Activity.this,WeatherActivity.class);
                }
            }
        });

    }

}
