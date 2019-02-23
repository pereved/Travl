package com.travl.guide.mvp.presenter;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.travl.guide.mvp.model.MainModel;
import com.travl.guide.mvp.presenter.list.CollectionListPresenter;
import com.travl.guide.mvp.view.CollectionsView;
import com.travl.guide.mvp.view.list.CollectionsItemView;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.subjects.PublishSubject;
import ru.terrakok.cicerone.Router;

//Created by Pereved on 18.02.2019.
@InjectViewState
public class CollectionsPresenter extends MvpPresenter<CollectionsView> {

    @Inject Router router;

    private MainModel model;
    private Scheduler mainThreadScheduler;
    public CollectionListPresenter collectionListPresenter;

    public class ListPresenter implements CollectionListPresenter {

        PublishSubject<CollectionsItemView> clickSubject = PublishSubject.create();

        @Override
        public PublishSubject<CollectionsItemView> getClickSubject() {
            return clickSubject;
        }

        @Override
        public void bindView(CollectionsItemView view) {
            //TODO: запрос строки из БД
//            Repository repository = user.getRepos().get(view.getPos());
//            view.setTitle(repository.getName());
//            view.setImage(repository.getUrl);
        }

        @Override
        public int getListCount() {
            //user == null || user.getDB() == null ? 0 : user.getDB().size();
            return 0;
        }
    }

    public CollectionsPresenter(Scheduler scheduler) {
        this.mainThreadScheduler = scheduler;
        if(model == null) this.model = new MainModel();
        collectionListPresenter = new ListPresenter();
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }
}