// Generated code from Butter Knife. Do not modify!
package io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.widget.SkillView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CharacterDetailFragment_ViewBinding<T extends CharacterDetailFragment> implements Unbinder {
  protected T target;

  @UiThread
  public CharacterDetailFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.profileImage = Utils.findRequiredViewAsType(source, R.id.image_profile, "field 'profileImage'", ImageView.class);
    target.coverImage = Utils.findRequiredViewAsType(source, R.id.image_cover, "field 'coverImage'", ImageView.class);
    target.nameLabel = Utils.findRequiredViewAsType(source, R.id.label_name, "field 'nameLabel'", TextView.class);
    target.descriptionLabel = Utils.findRequiredViewAsType(source, R.id.label_description, "field 'descriptionLabel'", TextView.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.accelerateSkill = Utils.findRequiredViewAsType(source, R.id.skill_accelerate, "field 'accelerateSkill'", SkillView.class);
    target.steerSkill = Utils.findRequiredViewAsType(source, R.id.skill_steer, "field 'steerSkill'", SkillView.class);
    target.brakeSkill = Utils.findRequiredViewAsType(source, R.id.skill_brake, "field 'brakeSkill'", SkillView.class);
    target.reverseSkill = Utils.findRequiredViewAsType(source, R.id.skill_reverse, "field 'reverseSkill'", SkillView.class);
    target.lookBehindSkill = Utils.findRequiredViewAsType(source, R.id.skill_look_behind, "field 'lookBehindSkill'", SkillView.class);
    target.driftSkill = Utils.findRequiredViewAsType(source, R.id.skill_drift, "field 'driftSkill'", SkillView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.profileImage = null;
    target.coverImage = null;
    target.nameLabel = null;
    target.descriptionLabel = null;
    target.toolbar = null;
    target.accelerateSkill = null;
    target.steerSkill = null;
    target.brakeSkill = null;
    target.reverseSkill = null;
    target.lookBehindSkill = null;
    target.driftSkill = null;

    this.target = null;
  }
}
