package com.example.to_doapp


import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.todoappch7.TodoViewModel
import com.example.todoappch7.ui.screens.TodoScreen
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TodoScreenTest {
    // This rule launches the composable in a test environment
    @get:Rule
    val composeTestRule = createComposeRule()

    // A fresh ViewModel for each Test
    private lateinit var viewModel: TodoViewModel

    @Before
    fun setUp(){
        viewModel = TodoViewModel()
        // Set the content to Display -- Same as MainActivity does
        composeTestRule.setContent {
            TodoScreen(viewModel = viewModel)
        }
    }


    @Test
    fun addTask_userTypesAndClicksAdd_taskAppearsInList(){

        //verify task does not exist yet
        composeTestRule.onNodeWithText("Buy Groceries").assertDoesNotExist()

        //act find the input field by testtag and type the text
        composeTestRule
            .onNodeWithTag("input_field")
            .performTextInput("Buy Groceries")

        // find the add button and click it
        composeTestRule
            .onNodeWithTag("add_button")
            .performClick()

        //verify the task now appears
        composeTextRule
            .onNodeWithText("Buy Groceries")
            .assertIsDisplayed()

    }

    @Test
    fun addTask_withBlankInput_taskDoesNotAppear() {

        composeTestRule
            .onNodeWithTag("input_field")
            .performTextInput("")


        composeTestRule
            .onNodeWithTag("add_button")
            .performClick()

        composeTestRule
            .onNodeWithText("0 task(s)")
            .assertIsDisplayed()


    }

}