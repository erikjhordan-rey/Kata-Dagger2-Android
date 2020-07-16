package io.github.erikjhordanrey.kata_dagger2.view.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import io.github.erikjhordanrey.kata_dagger2.databinding.WidgetSkillBinding

class SkillView : LinearLayout {

    private var binding = WidgetSkillBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setSkill(skill: String, rank: Int) {
        binding.labelSkill.text = skill
        binding.progressSkill.progress = rank
    }
}
