package com.example.to_doapp

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertTrue
import org.junit.Before
import org.junit.Test

class TodoViewModelTest {

    private lateinit var viewModel: TodoViewModel

    @Before
    fun setUp(){
        viewModel = TodoViewModel()
    }

    @Test
    fun add_Task_withValidTitle_appearsInList(){
        viewModel.addTask("do Exercise")

        assertEquals(1, viewModel.getTaskCount())
        assertTrue(viewModel.containsTask("do Exercise"))
    }

    fun add_Task_withBlankTitle_isIgnored(){
        viewModel.addTask("")

        assertEquals(0, viewModel.getTaskCount())
    }

    fun add_Task_withEmptyString_isIgnored(){
        viewModel.addTask()

    }

    fun add_Task_titleIsTrimmed(){

    }
}