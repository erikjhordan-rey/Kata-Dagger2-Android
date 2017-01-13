/*
 * Copyright (C) 2017 Erik Jhordan Rey.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.erikcaffrey.kata_dagger2_mariokart.view.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import butterknife.ButterKnife;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter.Presenter;

public abstract class BaseActivity extends AppCompatActivity implements Presenter.View {

  private Toolbar toolbar;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResID());
    onPrepareSupportActionBar();
    bindViews();
    onPreparePresenter();
    onPrepareActivity();
  }

  /**
   * Toolbar will be configured like a {@link ActionBar} if exists in the layout
   * if it doesn't exist will be ignored
   */

  private void onPrepareSupportActionBar() {
    toolbar = (Toolbar) findViewById(R.id.toolbar);
    if (toolbar != null) {
      setSupportActionBar(toolbar);
      ActionBar actionBar = getSupportActionBar();
      if (actionBar != null) {
        onSetupSupportActionBar(actionBar);
      }
    }
  }

  /**
   * Called just after bindViews.
   * Override this method to configure your {@link ActionBar}
   */

  protected void onSetupSupportActionBar(@NonNull ActionBar actionBar) {

  }

  /**
   * Called just after setContentView.
   * Override this method to configure your activity or initialize views
   */

  protected void onPrepareActivity() {

  }

  /**
   * Called before to initialize all the presenter instances linked to the component lifecycle.
   * Override this method to configure your presenter with extra data if needed.
   */

  protected void onPreparePresenter() {

  }

  /**
   * Every object annotated with {@link butterknife.BindView} its gonna injected trough butterknife
   */

  private void bindViews() {
    ButterKnife.bind(this);
  }

  /**
   * @return Toolbar if you need configure directly the toolbar
   */

  @Nullable public Toolbar getBaseToolbar() {
    return toolbar;
  }

  /**
   * @return the layout id associated to the layout used in the activity.
   */

  @LayoutRes protected abstract int getLayoutResID();
}