package io.github.erikcaffrey.kata_dagger2_mariokart.view.activity;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.widget.CompoundButton;
import butterknife.BindView;
import io.github.erikcaffrey.kata_dagger2_mariokart.R;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterFakeDataSource;
import io.github.erikcaffrey.kata_dagger2_mariokart.data.CharacterRepository;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.model.Character;
import io.github.erikcaffrey.kata_dagger2_mariokart.domain.usecase.GetCharacters;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.presenter.CharactersPresenter;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.fragment.CharacterFragment;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.adapter.CharacterPagerAdapter;
import io.github.erikcaffrey.kata_dagger2_mariokart.view.widget.CustomTransformer;
import java.util.List;

public class CharacterActivity extends BaseActivity
    implements CharactersPresenter.View, CompoundButton.OnCheckedChangeListener {

  @BindView(R.id.view_pager) ViewPager pager;

  private CharacterPagerAdapter characterPagerAdapter;
  CustomTransformer customTransformer;

  @Override protected int getLayoutResID() {
    return R.layout.activity_main;
  }

  @Override protected void onPrepareActivity() {
    super.onPrepareActivity();

    characterPagerAdapter = new CharacterPagerAdapter(getSupportFragmentManager(), dpToPixels(2, this));
    customTransformer = new CustomTransformer(pager, characterPagerAdapter);
    pager.setAdapter(characterPagerAdapter);





    CharacterFakeDataSource characterFakeDataSource = new CharacterFakeDataSource();
    CharacterRepository characterRepository = new CharacterRepository(characterFakeDataSource);
    GetCharacters getCharacters = new GetCharacters(characterRepository);
    CharactersPresenter charactersPresenter = new CharactersPresenter(getCharacters);
    charactersPresenter.setView(this);
    charactersPresenter.initialize();
  }

  @Override public void showCharacters(List<Character> characters) {
    for (Character character : characters) {
      CharacterFragment characterFragment = CharacterFragment.newInstance(character);
      characterPagerAdapter.addCharacter(characterFragment);
      characterPagerAdapter.notifyDataSetChanged();
      //shadowTransformer.enableScaling(true);
      System.out.println(character.getName());
    }
    pager.setPageTransformer(false, customTransformer);
    customTransformer.enableScaling(true);
  }

  public static float dpToPixels(int dp, Context context) {
    return dp * (context.getResources().getDisplayMetrics().density);
  }

  @Override public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

  }
}
