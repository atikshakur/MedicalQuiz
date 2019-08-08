package com.slip.medicalquiz.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import com.slip.medicalquiz.model.Flashcard;
import com.slip.medicalquiz.repo.FlashCardRepo;

import java.util.List;

public class MainActivityViewModel extends ViewModel {

    private MutableLiveData<List<Flashcard>> flashcards;
    private FlashCardRepo flashCardRepo;

    public MainActivityViewModel() {

        flashCardRepo = new FlashCardRepo();
    }

    public void init() {
        if (this.flashcards != null)
            return;
        flashcards = flashCardRepo.getFlashCards();
    }

    public LiveData<List<Flashcard>> getFlashCards() {
        return this.flashcards;
    }
}
