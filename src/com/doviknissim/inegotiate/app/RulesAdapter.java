package com.doviknissim.inegotiate.app;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.gdata.util.common.base.StringUtil;
import java.io.File;
import java.util.ArrayList;

public class RulesAdapter extends ArrayAdapter<RuleObject> {
    private ArrayList<RuleObject> _rulesDataItems;
    private Activity context;

    public RulesAdapter(Activity context, int textViewResourceId, ArrayList<RuleObject> ruleDataItems) {
        super(context, textViewResourceId, ruleDataItems);
        this.context = context;
        this._rulesDataItems = ruleDataItems;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            view = ((LayoutInflater) getContext().getSystemService("layout_inflater")).inflate(C0185R.layout.list_item2, null);
        }
        RuleObject rule = (RuleObject) this._rulesDataItems.get(position);
        if (rule != null) {
            TextView typeTextView = (TextView) view.findViewById(C0185R.id.toptext);
            typeTextView.setText("Type:  " + rule.getRuleType());
            typeTextView.setTextColor(Color.parseColor("#ff9900"));
            TextView actionTextView = (TextView) view.findViewById(C0185R.id.middletext);
            actionTextView.setText("Action:  " + rule.getAction());
            actionTextView.setTextColor(Color.parseColor("#ff9900"));
            TextView appliedToTextView = (TextView) view.findViewById(C0185R.id.bottomtext);
            String appliedTo = "Impacts: ";
            if (rule.getProductId() >= 0) {
                appliedTo = new StringBuilder(String.valueOf(appliedTo)).append(rule.getProductName()).toString();
                if (rule.getContactId() >= 0) {
                    appliedTo = new StringBuilder(String.valueOf(appliedTo)).append(", ").append(rule.getContactName()).toString();
                }
            } else if (rule.getContactId() >= 0) {
                appliedTo = new StringBuilder(String.valueOf(appliedTo)).append(rule.getContactName()).toString();
            }
            appliedToTextView.setText(appliedTo);
            appliedToTextView.setTextColor(Color.parseColor("#ff9900"));
            TextView rangeTextView = (TextView) view.findViewById(C0185R.id.belowbottomtext);
            rangeTextView.setText("Range: " + rule.getRuleRangeLower() + " - " + rule.getRuleRangeUpper());
            rangeTextView.setTextColor(Color.parseColor("#ff9900"));
            String url = rule.getPicturePath();
            if (!(url == null || url.equals(StringUtil.EMPTY_STRING))) {
                File imgFile = new File(url);
                if (imgFile.exists()) {
                    ((ImageView) view.findViewById(C0185R.id.icon)).setImageBitmap(ImageUtilities.getRoundedCornerBitmap(BitmapFactory.decodeFile(imgFile.getAbsolutePath()), 20));
                }
            }
        }
        return view;
    }
}
