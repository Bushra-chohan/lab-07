package com.example.lab7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()

        // navigate to drivers screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // verify driver screen
        composeTestRule
            .onNodeWithText("Drivers Screen")
            .assertExists()

        // enter driver name
        composeTestRule
            .onNodeWithTag("driverNameInput")
            .performTextInput("Max")

        // add driver
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver exists
        composeTestRule
            .onNodeWithText("Max")
            .assertExists()

        // verify if clear button exists
        composeTestRule
            .onNodeWithTag("clearButton")
            .performClick()

        // verify clear button clears
        composeTestRule
            .onNodeWithText("Max")
            .assertDoesNotExist()

        // return to home exists
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify if returns to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}