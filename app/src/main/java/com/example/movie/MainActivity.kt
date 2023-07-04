package com.example.movie

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.movie.ui.theme.MovieTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieTheme {
                Scaffold(
                    topBar = {

                        TopAppBar(
                            title = {},
                            backgroundColor = Color.White,
                            navigationIcon = {
                                Icon(
                                    modifier = Modifier.clickable {
                                    },
                                    imageVector = Icons.Default.Menu,
                                    contentDescription = null,
                                )
                            },
                            actions = {
                                Image(
                                    painter = painterResource(id = R.drawable.avatar),
                                    contentDescription = null,
                                    modifier = Modifier.clip(RoundedCornerShape(50.dp))
                                )
                            },
                        )
                    },
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    )
                    {
                        item {
                            MainActivityContent()
                        }
                    }

                }

            }
        }
    }

    @Composable
    fun MainActivityContent() {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween

        ) {
            Text(text = "Activity")
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(2.dp),
                    colors = ButtonDefaults.buttonColors(
                            Color.Blue)
                ) {
                    Text(
                        text = "Friends",
                        color = Color.Gray
                    )
                }
                Button(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .padding(2.dp),
                    colors = ButtonDefaults.buttonColors(
                        Color.Blue
                    ),
                ) {
                    Text(text = "You")
                }
            }
        }
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "G",
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(3.dp)
                    .background(Color.Gray),
            )
            Column {
                Text(text = "Gregory")
                Text(text = "Liked collection")
                Text(
                    text = "The Best of Robert Downey Jr ",
                    color = Color.Blue
                )
            }
            Text(text = "2 min")
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            Text(
                text = "S",
                modifier = Modifier
                    .clip(CircleShape)
                    .padding(3.dp)
                    .background(Color.Gray),
            )
            Column {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text(text = "Gregory")
                        Text(text = "Liked collection")
                    }
                    Text(text = "2 min")
                }

                Box(modifier = Modifier.size(20.dp)
                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.bridgerton),
                        contentDescription = null,
                        modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    )
                    Image(
                        painter = painterResource(id = R.drawable.cobra_kai),
                        contentDescription = null,
                        modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    )
                    Image(
                        painter = painterResource(id = R.drawable.image1),
                        contentDescription = null,
                        modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    )
                }
                Button(onClick = { /*TODO*/ }, modifier = Modifier
                    .fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        Color.Blue)
                ) {
                    Text(text = "2 More", color = Color.DarkGray)

                }
            }
        }
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween) {
            androidx.compose.foundation.Image(painter = painterResource(id = R.drawable.netfli),
                contentDescription = null,
                modifier = Modifier.clip(CircleShape),
            )
            Column {
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Column {
                        Text(text = "Netflix")
                        Text(text = "Posted")
                    }
                    Text(text = "1 hour")
                }
                Text(text = "Watch the official trailer")
                Box(modifier = Modifier.size(20.dp)) {
                    Image(
                        painter = painterResource(id = R.drawable.bridgerton),
                        contentDescription = "Bridgerton",
                        modifier = Modifier.clip(RoundedCornerShape(10.dp))
                    )
                }
            }
        }
    }
}