package it.bsdsoftware.bsdcustomfontwidget;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Simone on 12/04/16.
 */
public class CustomFontActivity extends AppCompatActivity {

    private boolean fontSetted = false;

    @Override
    protected void onStart() {
        super.onStart();

        if(!fontSetted) {
            ViewGroup main = (ViewGroup) findViewById(android.R.id.content);
            findAllView(main);
            fontSetted = true;
        }
    }

    private void findAllView(ViewGroup viewGroup){
        int count = viewGroup.getChildCount();
        for (int i = 0; i < count; i++) {
            View view = viewGroup.getChildAt(i);
            if (view instanceof ViewGroup)
                findAllView((ViewGroup) view);
            else if (view instanceof EditText) {
                EditText edittext = (EditText) view;
                Typeface t = edittext.getTypeface();
                checkStyle(t, edittext);
            }else if (view instanceof Button) {
                Button button = (Button) view;
                Typeface t = button.getTypeface();
                checkStyle(t, button);
            }else if (view instanceof TextView) {
                TextView textView = (TextView) view;
                Typeface t = textView.getTypeface();
                checkStyle(t, textView);
            }
        }
    }

    private void checkStyle(Typeface typeface, View view){
        Typeface newTypeface = BSDFont.getInstance().normalFont;
        if(typeface!=null) {
            if (typeface.isBold() && typeface.isItalic()) {
                newTypeface = BSDFont.getInstance().italicBoldFont;
            } else if (typeface.isBold()) {
                newTypeface = BSDFont.getInstance().boldFont;
            } else if (typeface.isItalic()) {
                newTypeface = BSDFont.getInstance().italicFont;
            }
        }

        if(view instanceof EditText){
            ((EditText)view).setTypeface(newTypeface);
        }else if(view instanceof Button){
            ((Button)view).setTypeface(newTypeface);
        }else if(view instanceof TextView){
            ((TextView)view).setTypeface(newTypeface);
        }
    }
}
