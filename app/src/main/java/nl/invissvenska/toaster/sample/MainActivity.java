package nl.invissvenska.toaster.sample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.Gravity;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import nl.invissvenska.toaster.Toaster;

import static android.graphics.Typeface.BOLD_ITALIC;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        findViewById(R.id.buttonNormal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.normal(getApplicationContext(), R.string.normal_toast).show();
            }
        });
        findViewById(R.id.buttonIconNormal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.normal(getApplicationContext(), R.string.normal_icon_toast,
                        getResources().getDrawable(R.drawable.ic_shipping_24)).show();
            }
        });

        findViewById(R.id.buttonWarning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.warning(getApplicationContext(), R.string.warning_toast).show();
            }
        });

        findViewById(R.id.buttonInfo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.info(getApplicationContext(), R.string.info_toast,
                        Toaster.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.buttonSuccess).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.success(getApplicationContext(), R.string.success_toast, Toaster.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.buttonError).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.error(getApplicationContext(), R.string.error_toast,
                        Toaster.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.buttonCustom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.custom(getApplicationContext(), R.string.custom_toast,
                        getResources().getDrawable(R.drawable.ic_cafe_24), R.color.colorToastCustom,
                        Toaster.LENGTH_LONG, true, true).show();
            }
        });

        findViewById(R.id.buttonGravity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.Config.getInstance()
                        .setGravity(Gravity.TOP, 0, 50)
                        .apply();
                Toaster.normal(getApplicationContext(), R.string.gravity_toast).show();
                Toaster.Config.reset();// Use this if you want to use the configuration above only once
            }
        });

        findViewById(R.id.buttonMargin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.Config.getInstance()
                        .setMargin(0f, 0.1f)
                        .apply();
                Toaster.custom(getApplicationContext(), R.string.margin_toast, null,
                        R.color.colorToastCustom2, Toaster.LENGTH_LONG, false,
                        true).show();
                Toaster.Config.reset();// Use this if you want to use the configuration above only once
            }
        });

        findViewById(R.id.buttonCustomFont).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.Config.getInstance()
                        .setToastTypeface(Typeface.createFromAsset(getAssets(), "DisplayOTF.otf"))
                        .allowQueue(false)
                        .apply();
                Toaster.custom(MainActivity.this, R.string.custom_font_toast,
                        getResources().getDrawable(R.drawable.ic_laptop_24), android.R.color.black,
                        R.color.colorFont, Toaster.LENGTH_SHORT, true, true).show();
                Toaster.Config.reset(); // Use this if you want to use the configuration above only once
            }
        });

        findViewById(R.id.buttonFormatted).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toaster.info(getApplicationContext(), getFormattedMessage()).show();
            }
        });
    }

    private CharSequence getFormattedMessage() {
        final String prefix = "Formatted ";
        final String highlight = "bold italic";
        final String suffix = " text";
        SpannableStringBuilder ssb = new SpannableStringBuilder(prefix).append(highlight).append(suffix);
        int prefixLen = prefix.length();
        ssb.setSpan(new StyleSpan(BOLD_ITALIC), prefixLen, prefixLen + highlight.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }
}