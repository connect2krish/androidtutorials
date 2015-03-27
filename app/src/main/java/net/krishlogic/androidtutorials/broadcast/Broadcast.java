package net.krishlogic.androidtutorials.broadcast;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import net.krishlogic.androidtutorials.R;

public class Broadcast extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast);

        Button button = (Button) findViewById(R.id.broadcastBtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                broadcastIntent(v);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.broadcast, menu);
        return true;
    }

    public void broadcastIntent(View view) {
        Intent intent = new Intent();
        intent.setAction("net.krishlogic.androidtutorials.BROADCAST_INTENT");
        sendBroadcast(intent);
    }
}
