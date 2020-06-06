package nl.invissvenska.toaster;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Toaster.Config.getInstance()
//                .setGravity(Gravity.START, 950,0)
                .setMargin(40f, 0f)
                .apply();

        findViewById(R.id.buttonNormal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toaster.normal(getApplicationContext(), "Toast Normal", Toaster.LENGTH_LONG).show();
            //    Toaster.Config.reset();
            }
        });

        findViewById(R.id.buttonWarning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.warning(getApplicationContext(), "Toast Warning", Toaster.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.buttonInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.info(getApplicationContext(), "Toast Info", Toaster.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.buttonSuccess).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.success(getApplicationContext(), "Toast Success", Toaster.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.buttonError).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.error(getApplicationContext(), "Toast Error", Toaster.LENGTH_LONG).show();
            }
        });
    }
}