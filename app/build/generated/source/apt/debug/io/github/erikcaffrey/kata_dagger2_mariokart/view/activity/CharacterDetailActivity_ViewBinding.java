// Generated code from Butter Knife. Do not modify!
package io.github.erikcaffrey.kata_dagger2_mariokart.view.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CharacterDetailActivity_ViewBinding<T extends CharacterDetailActivity> implements Unbinder {
  protected T target;

  @UiThread
  public CharacterDetailActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.pager = Utils.findRequiredViewAsType(source, R.id.pager, "field 'pager'", ViewPager.class);
    target.detailProgress = Utils.findRequiredViewAsType(source, R.id.progress_detail, "field 'detailProgress'", ProgressBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.pager = null;
    target.detailProgress = null;

    this.target = null;
  }
}
