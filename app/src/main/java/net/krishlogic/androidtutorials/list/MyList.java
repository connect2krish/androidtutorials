package net.krishlogic.androidtutorials.list;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import net.krishlogic.androidtutorials.R;
import net.krishlogic.androidtutorials.broadcast.Broadcast;
import net.krishlogic.androidtutorials.camera.CameraApp;
import net.krishlogic.androidtutorials.email.Email;
import net.krishlogic.androidtutorials.sms.SMS;

import java.util.ArrayList;
import java.util.List;


public class MyList extends Activity {

    private ListView listView;
    private ListViewAdapter listViewAdapter;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_list);

        mContext = this;

        configElements();

        setAdapter();
    }

    private void configElements(){
        listView = (ListView) findViewById(R.id.mylist);
    }

    private void setAdapter(){
        List<String> list = new ArrayList<String>();
        list.add("Broadcast");
        list.add("Send SMS");
        list.add("Send Email");
        list.add("Camera");

/*
        list.add("Content Provider");
        list.add("Drag and Drop");
        list.add("Notifications");
        list.add("Phone Calls");
        list.add("Animations");
*/
        listViewAdapter = new ListViewAdapter(this, list);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=null;

                switch(position){
                    case 0:
                        intent = new Intent(mContext, Broadcast.class);
                        startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(mContext, SMS.class);
                        startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(mContext, Email.class);
                        startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(mContext, CameraApp.class);
                        startActivity(intent);
                        break;

                    default:
                        Toast.makeText(mContext, "N/A",Toast.LENGTH_SHORT);
                }
            }
        });

    }

    public class ListViewAdapter extends BaseAdapter {

        List<String> list;
        private Context mContext;

        public ListViewAdapter(Context context, List<String> list){
            this.list = list;
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public String getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.adapter_my_list, parent, false);

            final TextView textView = (TextView) view.findViewById(R.id.text);

            textView.setText(list.get(position));

            return view;
        }
    }
}
