package com.slip.medicalquiz.repo;

import com.slip.medicalquiz.model.Flashcard;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface Api {

    @GET("maw")
    Call<List<Flashcard>> getFlashCards();
}
