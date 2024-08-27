package com.example.compose_navigation.ui.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.compose_navigation.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingUI(/*navController: NavController, OnSkipClicked: () -> Unit*/) {
    val pagerState = rememberPagerState(pageCount = { 4 })
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Black),
    ) {
        Text(text = "Skip ",
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 270.dp, top = 24.dp)
                .clickable { /*OnSkipClicked()*/ })

        HorizontalPager(
            state = pagerState, modifier = Modifier
                .fillMaxSize()
                .weight(1f)


        ) { page ->
            OnboardingScreen(page = onboardPages[page])
        }

        /* HorizontalPagerIndicator(
             pagerState = pagerState, modifier = Modifier
                 .align(Alignment.CenterHorizontally)
                 .padding(16.dp),
             activeColor = Color.White
         )*/

        AnimatedVisibility(visible = pagerState.currentPage == 3) {
            OutlinedButton(
                shape = RoundedCornerShape(20.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(start = 24.dp, top = 14.dp, end = 24.dp, bottom = 8.dp),
                onClick = {/*navController.navigate(R.id.viewOnboardingToLogin)*/ },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = colorResource(
                        id = R.color.purple_500
                    ), colorResource(id = R.color.purple_500)
                )
            ) {
                Text(
                    text = "Let's Start",
                    style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun OnboardingScreen(page: OnboardingPage) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(RoundedCornerShape(20.dp))
            .verticalScroll(scrollState)
            .background(color = Color.DarkGray)
            .padding(20.dp)

           ,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(painter = painterResource(id = page.image), contentDescription = "Step Number")
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = Modifier
                .width(70.dp)
                .height(18.dp)
                .clip(CircleShape)
                .background(color = Color(page.background)),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Step " + page.stepNumber.toString(),
                style = MaterialTheme.typography.bodySmall.copy(color = Color.White),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = page.title,
            style = MaterialTheme.typography.bodyLarge.copy(color = Color.White),
            textAlign = TextAlign.Center
        )
        if (page.stepNumber != 4) {
            Button(
                onClick = {},
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = Color(page.background)),
                modifier = Modifier
                    .width(64.dp)
                    .height(64.dp)
                    .padding(start = 0.dp, top = 24.dp, end = 0.dp, bottom = 0.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = "sign in",
                    tint = Color.White
                )
            }
        }
    }
}