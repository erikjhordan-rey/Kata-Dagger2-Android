package io.github.erikcaffrey.kata_dagger2_mariokart.view.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

public class MarioKartLabel extends AppCompatTextView {

    private final static String SUPER_MARIO_FONT = "SuperMario256.ttf";

    public MarioKartLabel(Context context) {
        super(context);
        if (!isInEditMode()) {
            init(context);
        }
    }

    public MarioKartLabel(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (!isInEditMode()) {
            init(context);
        }
    }

    public MarioKartLabel(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (!isInEditMode()) {
            init(context);
        }
    }

    private void init(Context context) {
        this.setTypeface(getMarioKartTypeFace(context));
    }

    private Typeface getMarioKartTypeFace(Context context) {
        return Typeface.createFromAsset(context.getAssets(), SUPER_MARIO_FONT);
    }
}
