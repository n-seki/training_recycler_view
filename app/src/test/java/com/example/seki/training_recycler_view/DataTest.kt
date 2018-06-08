package com.example.seki.training_recycler_view

import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.assertThat
import org.junit.Test

class DataTest {

    companion object {
        const val TITLE = "title"
        const val DESCRIPTION = "description"
    }

    @Test fun `Dataのインスタンスが作成できること`() {
        val data = Data(TITLE, DESCRIPTION)

        assertThat(data.title.get(), `is`(TITLE))
        assertThat(data.description.get(), `is`(DESCRIPTION))
        assertThat(data.clickCount.get(), `is`(0.toString()))
    }
}