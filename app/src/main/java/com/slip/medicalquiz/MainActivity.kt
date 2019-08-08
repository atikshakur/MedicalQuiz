package com.slip.medicalquiz

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.slip.medicalquiz.adapter.RecyclerAdapter
import com.slip.medicalquiz.model.Flashcard
import com.slip.medicalquiz.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
    lateinit var adapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cards: ArrayList<Flashcard>

        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        viewModel.init()


        flashcardR?.layoutManager = LinearLayoutManager(this)


        viewModel.flashCards.observe(this, Observer {

            cards = it as ArrayList<Flashcard>

            adapter = RecyclerAdapter(cards)
            flashcardR.adapter = adapter
            Log.d("blah", cards.toString())
            adapter.notifyDataSetChanged()
            Log.d("Main", "called")
        })
    }
}
