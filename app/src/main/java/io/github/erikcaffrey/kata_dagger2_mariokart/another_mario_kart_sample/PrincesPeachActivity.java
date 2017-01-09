package io.github.erikcaffrey.kata_dagger2_mariokart.another_mario_kart_sample;

import android.support.v4.content.ContextCompat;
import android.widget.ImageView;
import butterknife.BindView;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.ui.BaseActivity;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.widget.MarioKartLabel;
import javax.inject.Inject;

/**
 * 08/01/17.
 */

public class PrincesPeachActivity extends BaseActivity {

  @Inject PrincesPeachApi princesPeachApi;

  @BindView(R.id.label_peach) MarioKartLabel peachLabel;
  @BindView(R.id.picture_peach) ImageView peachImage;

  @Override protected int getLayoutResID() {
    return R.layout.activity_princes_peach;
  }

  @Override protected void onPrepareActivity() {
    super.onPrepareActivity();
    initializeDagger();
    PrincesPeach princesPeach = getPrincesPeachFromApi();
    renderPrincesPeach(princesPeach);
  }

  private void renderPrincesPeach(PrincesPeach princesPeach) {
    renderName(princesPeach.getName());
    renderPicture(princesPeach.getPhoto());
  }

  private void renderName(String name) {
    peachLabel.setText(name);
  }

  private void renderPicture(int picture) {
    peachImage.setImageDrawable(ContextCompat.getDrawable(this, picture));
  }

  private PrincesPeach getPrincesPeachFromApi() {
    return princesPeachApi.getPrincesPeach();
  }

  private void initializeDagger() {
    PrincesPeachApplication application = (PrincesPeachApplication) getApplication();
    application.getPrincesPeachComponent().inject(this);
  }
}
