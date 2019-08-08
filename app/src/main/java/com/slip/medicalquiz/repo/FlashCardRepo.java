package com.slip.medicalquiz.repo;

import android.arch.lifecycle.MutableLiveData;
import android.util.Log;
import com.slip.medicalquiz.model.Flashcard;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class FlashCardRepo {

    private Api api;
    private static final String TAG = "HeroRepository";

    public FlashCardRepo() {}


    public MutableLiveData<List<Flashcard>> getFlashCards() {

        final MutableLiveData<List<Flashcard>> data = new MutableLiveData<>();

        api = RetrofitClient.getInstance().create(Api.class);

        Call<List<Flashcard>> call = api.getFlashCards();

        call.enqueue(new Callback<List<Flashcard>>() {
            @Override
            public void onResponse(Call<List<Flashcard>> call, Response<List<Flashcard>> response) {
                if(response.body() != null)
                    data.setValue(response.body());
                Log.d(TAG, response.body().toString());
                if (response.isSuccessful())
                    Log.d(TAG, "onResponse: successful");
            }

            @Override
            public void onFailure(Call<List<Flashcard>> call, Throwable t) {
                Log.d(TAG, "onFailed: failed");
                Log.d(TAG, t.getMessage());
            }
        });
        return data;
    }
}
