package com.template_d.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Djaffar on 7/13/2017.
 */

public class CustomTextView extends TextView {

    // can also be replaced with EditText or Button

    private static final String TAG = "CustomTextView";

    public CustomTextView(Context context) {
        super(context);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context context, AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTextView);
        String customFont = typedArray.getString(R.styleable.CustomTextView_customFont);
        setCustomFont(context, customFont);
        typedArray.recycle();
    }

    public boolean setCustomFont(Context context, String asset) {
        Typeface typeface = null;
        try {
            typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" +asset);
        } catch (Exception e) {
            Log.e(TAG, "Unable to load typeface: " +e.getMessage());
            return false;
        }

        setTypeface(typeface);
        return true;
    }
}
