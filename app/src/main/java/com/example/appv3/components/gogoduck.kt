package com.example.appv3.components


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.PagerDefaults
import androidx.compose.foundation.pager.PagerScope
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appv3.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ComposeSwipeablePagesTheme(navController: NavController){
    val animals = listOf(
        R.drawable.cat,
        R.drawable.duck,
    )
    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f
    ) {
        // provide pageCount
        animals.size
    }
    val scope = rememberCoroutineScope()
    Box(modifier = Modifier.fillMaxSize()){
        HorizontalPager(
            modifier = Modifier,
            state = pagerState,
            userScrollEnabled = true,
            reverseLayout = false,
            beyondBoundsPageCount = 0,
            pageSize = PageSize.Fill,
            key = {animals[it]},
            pageNestedScrollConnection = PagerDefaults.pageNestedScrollConnection(
                Orientation.Horizontal)
            ) { index ->
                Image(
                    painter = painterResource(id = animals[index]),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

        Box(modifier = Modifier
            .offset(y = -(16).dp)
            .fillMaxWidth(0.5f)
            .clip(RoundedCornerShape(100))
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
            .align(Alignment.BottomCenter)
        ){
            IconButton(onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(
                        pagerState.currentPage - 1
                    )
                }
            },
                modifier = Modifier.align(Alignment.CenterStart)) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Go back"
                )
            }
            IconButton(onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(
                        pagerState.currentPage + 1
                    )
                }
            },
                modifier = Modifier.align(Alignment.CenterEnd)
            ) {
                Icon(imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "Go forward"
                )

            }
        }

    }


}
/*
@Composable
@Preview

fun PreviewComposeSwipeablePagesTheme(){
    ComposeSwipeablePagesTheme()
}*/