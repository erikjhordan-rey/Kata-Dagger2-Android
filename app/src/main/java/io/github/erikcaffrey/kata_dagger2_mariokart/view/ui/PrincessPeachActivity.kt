package io.github.erikcaffrey.kata_dagger2_mariokart.view.ui

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import io.github.erikcaffrey.kata_dagger2_mariokart.PrincessPeachApplication
import io.github.erikcaffrey.kata_dagger2_mariokart.R
import io.github.erikcaffrey.kata_dagger2_mariokart.data.PrincessPeachApi
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.PrincessPeach
import kotlinx.android.synthetic.main.activity_princess_peach.*
import javax.inject.Inject

class PrincessPeachActivity : AppCompatActivity() {

  @Inject lateinit var princessPeachApi: PrincessPeachApi

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_princess_peach)
    initializeDagger()
  }

  override fun onResume() {
    super.onResume()
    renderPrincesPeach(princessPeachApi.princesPeach)
  }

  private fun renderPrincesPeach(princessPeach: PrincessPeach) {
    label_peach.setText(princessPeach.name)
    picture_peach.setImageDrawable(ContextCompat.getDrawable(this, princessPeach.photo))
  }

  private fun initializeDagger() {
    val application = application as PrincessPeachApplication
    application.princessPeachComponent.inject(this)
  }
}
