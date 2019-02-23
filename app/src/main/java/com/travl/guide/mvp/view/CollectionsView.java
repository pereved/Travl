package com.travl.guide.mvp.view;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

//Created by Pereved on 18.02.2019.
@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface CollectionsView extends MvpView {
}