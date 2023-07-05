package com.example.movie

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movie.ui.theme.Grayish
import com.example.movie.ui.theme.MovieTheme
import com.example.movie.ui.theme.Orange


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val movies = listOf(
                R.drawable.bridgerton,
                R.drawable.cobra_kai,
                R.drawable.moneyheist,
                R.drawable.peakyblinders,
                R.drawable.riverdale,
                R.drawable.strangerthings,
                R.drawable.treason,
                R.drawable.you
            )
            MovieTheme {
                Scaffold(
                    topBar = {
                        Column(
                            modifier = Modifier
                                .padding(horizontal = 16.dp),
                        ) {
                            TopAppBar(

                                navigationIcon = {
                                    Icon(
                                        imageVector = Icons.Default.Menu,
                                        contentDescription = null,
                                    )
                                },
                                actions = {
                                    Image(
                                        modifier = Modifier
                                            .size(40.dp)
                                            .clip(CircleShape),
                                        painter = painterResource(id = R.drawable.manurios),
                                        contentDescription = null,
                                        contentScale = ContentScale.Crop,
                                    )
                                },
                                title = {}
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                            ) {
                                Text(
                                    text = "Activity",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold

                                )
                                Row(
                                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                                ) {
                                    var selectedTab by remember {
                                        mutableStateOf("Friends")
                                    }
                                    RoundedTab(title = "Friends",
                                        selectedTab = selectedTab,
                                        onClickTab = { title -> selectedTab = title })

                                    RoundedTab(title = "You",
                                        selectedTab = selectedTab,
                                        onClickTab = { title -> selectedTab = title })

                                }

                            }
                        }
                    }
                ) {
                    LazyColumn(
                        modifier = Modifier.padding(it),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp),
                    ) {
                        item {
                            CollectionComponent(
                                circleContent = {
                                                Text(text = "G")
                                },
                                name = "Gregor",
                                time = "2 min",
                                type = "Liked Collection",
                                content = {
                                    Text(
                                        text = "The Best Of Robert Downey Jr",
                                        color = Orange,
                                        fontWeight = FontWeight.SemiBold,
                                    )
                                }
                            )
                        }
                        item {
                            CollectionComponent(
                                circleContent = {
                                    Text(text = "S")
                                },
                                name = "Stewart",
                                time = "3 min",
                                type = "liked",
                                content = {
                                    Column {
                                        Spacer(modifier = Modifier.height(12.dp))
                                        LazyRow(
                                            horizontalArrangement = Arrangement.spacedBy(8.dp),
                                        ) {
                                            items(movies) { movie ->
                                                Card(
                                                    modifier = Modifier
                                                        .width(100.dp)
                                                        .height(150.dp),
                                                ) {
                                                    Image(
                                                        modifier = Modifier.fillMaxSize(),
                                                        painter = painterResource(id = movie),
                                                        contentDescription = null,
                                                        contentScale = ContentScale.Crop,
                                                    )
                                                }
                                            }
                                        }
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Button(
                                            modifier = Modifier.fillMaxWidth(),
                                            onClick = { /*TODO*/ },
                                            shape = RoundedCornerShape(8.dp),
                                            colors = ButtonDefaults.buttonColors(
//                                                containerColor = Grayish,
                                                contentColor = Color.Gray,
                                            ),
                                        ) {
                                            Text(text = "2 more")
                                        }
                                    }
                                },
                            )
                        }
                        item {
                            CollectionComponent(
                                backgroundColor = Color.Black,
                                circleContent = {
                                                Image(
                                                    modifier = Modifier.size(24.dp),
                                                    painter = painterResource(id = R.drawable.netfli),
                                                    contentDescription = null,
                                                    contentScale = ContentScale.Crop,
                                                )
                                },
                                name = "Netflix",
                                time = "10 min",
                                type = "Posted",
                                content = {
                                    Column() {
                                        Spacer(modifier = Modifier.height(8.dp))
                                        Text(
                                            text = "Watch the official trailer for",
                                        fontWeight = FontWeight.SemiBold,
                                            fontSize = 16.sp,
                                        )

                                        Text(
                                            text = "The Irishman",
                                            color = Orange,
                                            fontWeight = FontWeight.SemiBold,
                                            fontSize = 16.sp,
                                        )
                                        Image(
                                            modifier = Modifier
                                                .height(200.dp)
                                                .clip(RoundedCornerShape(10.dp)),
                                            painter = painterResource(id = R.drawable.moneyheist),
                                            contentDescription = null,
                                            contentScale = ContentScale.Crop,
                                        )

                                    }
                                }

                            )

                        }
                    }

                }

            }
        }
    }

    @Composable
    private fun CollectionComponent(
        type : String,
        name : String,
        time :String,
        circleContent: @Composable () -> Unit,
        content: @Composable () -> Unit = {},
         backgroundColor: Color = Grayish,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            ItemComponent(
                backgroundColor = backgroundColor,
                content = {
                    circleContent()
                },
            )
            Column {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = name,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = time,
                        color = Color.Gray
                    )
                }
                Text(
                    text = type,
                    color = Color.LightGray
                )
                content()
            }
        }
    }
}

@Composable
fun ItemComponent(
    content: @Composable () -> Unit,
    backgroundColor: Color,
) {
    Box(
        modifier = Modifier
            .size(45.dp)
            .clip(CircleShape)
            .background(backgroundColor),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }

}

@Composable
fun RoundedTab(
    selectedTab: String,
    title: String,
    onClickTab: (title: String) -> Unit,
) {
    val selected = selectedTab == title
    Box(
        modifier = Modifier
            .height(40.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(
                if (selected) {
                    Orange
                } else {
                    Grayish
                },
            ).clickable {
                onClickTab(title)
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 16.dp),
            text = title,
            color = if (selected) {
                Color.White
            } else {
                Color.Black
            },
        )
    }
}