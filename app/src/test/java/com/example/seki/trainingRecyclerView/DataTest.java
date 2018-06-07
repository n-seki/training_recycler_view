package com.example.seki.trainingRecyclerView;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DataTest {

    private static final String TITLE = "test";
    private static final String DESCRIPTION = "this is test data";

    @Test
    public void dataのコンストラクタのテスト() {
        Data data = new Data(TITLE, DESCRIPTION);
        assertThat(data.getTitle().get(), is(TITLE));
        assertThat(data.getDescription().get(), is(DESCRIPTION));
        assertThat(data.getClickCount().get(), is("0"));
    }

    @Test
    public void クリックカウントが変更されること() {
        Data data = new Data(TITLE, DESCRIPTION);
        data.getClickCount().set("1");
        assertThat(data.getClickCount().get(), is("1"));
    }
}