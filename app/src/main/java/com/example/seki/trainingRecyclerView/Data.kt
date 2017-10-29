package com.example.seki.trainingRecyclerView

import android.databinding.ObservableField

class Data(title: String, description: String) {
    val title: ObservableField<String> = ObservableField()
    val description: ObservableField<String> = ObservableField()
    val clickCount: ObservableField<String> = ObservableField()

    init {
        this.title.set(title)
        this.description.set(description)
        this.clickCount.set(0.toString())
    }

}
