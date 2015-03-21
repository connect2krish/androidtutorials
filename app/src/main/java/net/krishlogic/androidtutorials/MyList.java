package net.krishlogic.androidtutorials;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MyList extends Activity {

    private ListView listView;
    private ListViewAdapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_list);

        configElements();

        setAdapter();
    }

    private void configElements(){
        listView = (ListView) findViewById(R.id.mylist);
    }

    private void setAdapter(){
        List<String> list = new ArrayList<String>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        list.add("Four");

        listViewAdapter = new ListViewAdapter(this, list);
        listView.setAdapter(listViewAdapter);
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
