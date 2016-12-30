package io.github.erikcaffrey.kata_dagger2_mariokart;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class LabelTitle extends TextView {

    private final static String ROBOTO_BLACK = "SuperMario256.ttf";

    public LabelTitle(Context context) {
        super(context);
        if (!isInEditMode()) {
            init(context);
        }
    }

    public LabelTitle(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            init(context);
        }
    }

    public LabelTitle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            init(context);
        }
    }


    private void init(Context context) {
        this.setTypeface(getRobotoBlackTypeFace(context));
    }

    private Typeface getRobotoBlackTypeFace(Context context) {
        return Typeface.createFromAsset(context.getAssets(), ROBOTO_BLACK);
    }
}