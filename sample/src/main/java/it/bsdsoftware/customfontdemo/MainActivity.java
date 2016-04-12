package it.bsdsoftware.customfontdemo;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import it.bsdsoftware.bsdcustomfontwidget.BSDFont;
import it.bsdsoftware.bsdcustomfontwidget.BSDFontBuilder;
import it.bsdsoftware.bsdcustomfontwidget.CustomFontActivity;

public class MainActivity extends CustomFontActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Typeface normal = Typeface.createFromAsset(getAssets(), "fonts/univers_condensed2.ttf");
        Typeface bold = Typeface.createFromAsset(getAssets(), "fonts/univers_condensed_bold.ttf");
        Typeface italic = Typeface.createFromAsset(getAssets(), "fonts/univers_condensed_italic_bold.ttf");

        BSDFont.init(new BSDFontBuilder()
                .setNormalFont(normal)
                .setBoldFont(bold)
                .setItalicFont(italic)
        );

        setContentView(R.layout.activity_main2);


    }
}
