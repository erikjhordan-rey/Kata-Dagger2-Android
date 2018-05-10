package io.github.erikcaffrey.kata_dagger2_mariokart.view.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import io.github.erikcaffrey.kata_dagger2_mariokart.R
import kotlinx.android.synthetic.main.widget_skill.view.*

class SkillView : LinearLayout {

  constructor(context: Context) : super(context)

  constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

  constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

  init {
    LayoutInflater.from(context).inflate(R.layout.widget_skill, this, true)
  }

  fun setSkill(skill: String, rank: Int) {
    label_skill.text = skill
    progress_skill.progress = rank
  }
}
