package com.example.compose_navigation.ui.onboarding

import android.graphics.Color
import androidx.annotation.DrawableRes
import com.example.compose_navigation.R

data class OnboardingPage(
    val background: Int,
    val title: String,
    val stepNumber: Int,
    @DrawableRes val image: Int
)
val onboardPages = listOf(
    OnboardingPage(
        background = Color.BLACK,
        title = "Personalize Your Mental Health State With AI",
        stepNumber = 1,
        image = androidx.core.R.drawable.ic_call_answer
    ),
    OnboardingPage(
        background = Color.BLACK,
        title = "Intelligent Mood Tracking & Emotion Insights",
        stepNumber = 2,
        image = androidx.core.R.drawable.ic_call_answer
    ),
    OnboardingPage(
        background = Color.BLACK,
        title = "Mindful Resources That Makes You Happy",
        stepNumber = 3,
        image = androidx.core.R.drawable.ic_call_answer
    ),
    OnboardingPage(
        background = Color.BLACK,
        title = "Loving & Supportive Community",
        stepNumber = 4,
        image =androidx.core.R.drawable.ic_call_answer
    )
)