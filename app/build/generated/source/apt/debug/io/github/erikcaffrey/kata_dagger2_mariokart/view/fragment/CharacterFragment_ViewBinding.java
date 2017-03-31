// Generated code from Butter Knife. Do not modify!
package io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CharacterFragment_ViewBinding<T extends CharacterFragment> implements Unbinder {
  protected T target;

  @UiThread
  public CharacterFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.nameButton = Utils.findRequiredViewAsType(source, R.id.button_name, "field 'nameButton'", Button.class);
    target.profileImage = Utils.findRequiredViewAsType(source, R.id.image_profile, "field 'profileImage'", ImageView.class);
    target.positionLabel = Utils.findRequiredViewAsType(source, R.id.label_position, "field 'positionLabel'", TextView.class);
    target.cardView = Utils.findRequiredViewAsType(source, R.id.cardView, "field 'cardView'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.nameButton = null;
    target.profileImage = null;
    target.positionLabel = null;
    target.cardView = null;

    this.target = null;
  }
}
