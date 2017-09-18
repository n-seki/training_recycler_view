package com.example.seki.training_recycler_view;

import android.databinding.ObservableField;

public class Data {
    public final ObservableField<String> title = new ObservableField<>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableField<String> clickCount = new ObservableField<>();

    public Data(String title, String description) {
        this.title.set(title);
        this.description.set(description);
        this.clickCount.set(String.valueOf(0));
    }
}
