package it.bsdsoftware.bsdcustomfontwidget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;

/**
 * Created by Simone on 19/04/16.
 */
public class SpinnerAdapterCF extends ArrayAdapter<SpinnerItem> {

    private int itemResource, dropdownResource;
    private Activity context;

    public SpinnerAdapterCF(Activity context, int itemResource, int dropdownResource) {
        super(context, itemResource);
        this.context = context;
        this.itemResource = itemResource;
        this.dropdownResource = dropdownResource;
        setDropDownViewResource(dropdownResource);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(itemResource, parent, false);
        TextView textView = (TextView) row.findViewById(android.R.id.text1);
        Typeface newTypeface = BSDFont.getInstance().getTypeface(textView.getTypeface());
        textView.setTypeface(newTypeface);

        SpinnerItem item = getItem(position);
        textView.setText(item.getLabel());

        return textView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View row = inflater.inflate(dropdownResource, parent, false);

        CheckedTextView checkedTextView = (CheckedTextView) row.findViewById(android.R.id.text1);
        Typeface newTypeface = BSDFont.getInstance().getTypeface(checkedTextView.getTypeface());
        checkedTextView.setTypeface(newTypeface);
        SpinnerItem item = getItem(position);
        checkedTextView.setText(item.getLabel());
        return row;
    }
}
