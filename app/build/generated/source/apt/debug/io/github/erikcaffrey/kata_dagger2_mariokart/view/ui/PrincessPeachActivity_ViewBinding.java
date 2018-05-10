// Generated code from Butter Knife. Do not modify!
package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.widget.MarioKartLabel;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PrincessPeachActivity_ViewBinding implements Unbinder {
  private PrincessPeachActivity target;

  @UiThread
  public PrincessPeachActivity_ViewBinding(PrincessPeachActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PrincessPeachActivity_ViewBinding(PrincessPeachActivity target, View source) {
    this.target = target;

    target.peachLabel = Utils.findRequiredViewAsType(source, R.id.label_peach, "field 'peachLabel'", MarioKartLabel.class);
    target.peachImage = Utils.findRequiredViewAsType(source, R.id.picture_peach, "field 'peachImage'", ImageView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PrincessPeachActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.peachLabel = null;
    target.peachImage = null;
  }
}
