package io.github.erikcaffrey.kata_dagger2_mariokart.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;

public class AbilitieView extends LinearLayout {

  public AbilitieView(Context context) {
    super(context);
  }

  public AbilitieView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public AbilitieView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @BindView(R.id.label_abilitie) TextView abilitieLabel;
  @BindView(R.id.progress_abilitie) ProgressBar abilitieProgress;

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    View view = LayoutInflater.from(getContext()).inflate(R.layout.widget_abilitie, this, true);
    ButterKnife.bind(view);
  }

  public void initAbilitie(String abilitie, int rank) {
    abilitieLabel.setText(abilitie);
    abilitieProgress.setProgress(rank);
  }
}
