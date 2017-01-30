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

public class SkillView extends LinearLayout {

  public SkillView(Context context) {
    super(context);
  }

  public SkillView(Context context, AttributeSet attrs) {
    super(context, attrs);
  }

  public SkillView(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }

  @BindView(R.id.label_skill) TextView skillLabel;
  @BindView(R.id.progress_skill) ProgressBar skillProgress;

  @Override protected void onFinishInflate() {
    super.onFinishInflate();
    View view = LayoutInflater.from(getContext()).inflate(R.layout.widget_skill, this, true);
    ButterKnife.bind(view);
  }

  public void setSkill(String skill, int rank) {
    skillLabel.setText(skill);
    skillProgress.setProgress(rank);
  }
}
