package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui;

import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import butterknife.BindView;
import io.github.erikcaffrey.kata_dagger2_mariokart.PrincessPeachApplication;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.PrincessPeachApi;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.PrincessPeach;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.widget.MarioKartLabel;
import javax.inject.Inject;

public class PrincessPeachActivity extends BaseActivity {

  @Inject PrincessPeachApi princessPeachApi;

  @BindView(R.id.label_peach) MarioKartLabel peachLabel;
  @BindView(R.id.picture_peach) ImageView peachImage;

  @Override protected int getLayoutResID() {
    return R.layout.activity_princess_peach;
  }

  @Override protected void onPrepareActivity() {
    super.onPrepareActivity();
    initializeDagger();
    PrincessPeach princessPeach = getPrincesPeachFromApi();
    renderPrincesPeach(princessPeach);
  }

  private void renderPrincesPeach(PrincessPeach princessPeach) {
    renderName(princessPeach.getName());
    renderPicture(princessPeach.getPhoto());
  }

  private void renderName(@StringRes int name) {
    peachLabel.setText(name);
  }

  private void renderPicture(@DrawableRes int picture) {
    peachImage.setImageDrawable(ContextCompat.getDrawable(this, picture));
  }

  private PrincessPeach getPrincesPeachFromApi() {
    return princessPeachApi.getPrincesPeach();
  }

  private void initializeDagger() {
    PrincessPeachApplication application = (PrincessPeachApplication) getApplication();
    application.getPrincessPeachComponent().inject(this);
  }
}
