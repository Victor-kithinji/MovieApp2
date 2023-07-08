package com.example.movie

import android.annotation.SuppressLint
import android.graphics.ImageDecoder.ImageInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movie.ui.theme.MovieTheme


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MovieTheme {
                Scaffold(

                    topBar = {
                        Row {

                            TopAppBar(
                                {
                                    Row {
                                        Text(
                                            text = "Mov",
                                            fontSize = 27.sp,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                        Text(
                                            color = Color.Red,
                                            text = "ve",
                                            fontSize = 26.sp,
                                            fontWeight = FontWeight.SemiBold
                                        )
                                    }
                                },
                                actions = {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = null
                                    )
                                },
                            )
                        }
                    }
                ) {
                    LazyColumn(
                        modifier = Modifier.padding(it),
                        contentPadding = PaddingValues(16.dp),
                        verticalArrangement = Arrangement.spacedBy(24.dp),
                    ) {
                        item {
                            Text(
                                text = "Popular Movie",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Column {
                                Spacer(modifier = Modifier.height(12.dp))
                                SlidingImage(movies = null)

                            }
                        }

                        item {
                            Text(
                                text = "Tv Shows",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Column {
                                Spacer(modifier = Modifier.height(12.dp))
                                SlidingImage(movies = null)

                            }
                        }

                        item {
                            Text(
                                text = "Continue Watching",
                                fontSize = 22.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                            Column {
                                Spacer(modifier = Modifier.height(12.dp))
                                SlidingImage(movies = null)
                            }
                        }
                    }

                }
            }
        }

    }
}
@Composable
fun SlidingImage(
    movies: List<ImageInfo>?
) {
    val movies = listOf(
        ImageInfo("Bridgerton", "Dec 16, 2022", R.drawable.bridgerton),
        ImageInfo("Treason", "Mar 16, 2023", R.drawable.treason),
        ImageInfo("You", "Dec 16, 2020", R.drawable.you),
        ImageInfo("Cobra Kai", "Oct 21, 2020", R.drawable.cobra_kai),
        ImageInfo("Money Heist", "Dec 6, 2022", R.drawable.moneyheist),
        ImageInfo("Peaky Blinders", "June 16, 2023", R.drawable.peakyblinders),
        ImageInfo("Riverdale", "May 19, 2021", R.drawable.riverdale),
        ImageInfo("Stranger Things", "Feb 20, 2022", R.drawable.strangerthings),

        )
    val movies2 = listOf(
        ImageInfo("Into The Night", "Dec 16, 2022", R.drawable.into_the_night),
        ImageInfo("Muted", "Mar 16, 2023", R.drawable.muted),
        ImageInfo("Obsession", "Dec 16, 2020", R.drawable.obsession),
        ImageInfo("Session", "Oct 21, 2020", R.drawable.session),
        ImageInfo("Sex Life", "Dec 6, 2022", R.drawable.sex_life),
        ImageInfo("The Nurse", "June 16, 2023", R.drawable.the_nurse),
        ImageInfo("Unseen", "May 19, 2021", R.drawable.unseen),
        ImageInfo("Vortex", "Feb 20, 2022", R.drawable.vortex),
    )
    LazyRow {
        items(movies) { movie ->
            Column(
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Card(
                    modifier = Modifier
                        .width(130.dp)
                        .height(190.dp),
                ) {
                    Image(
                        painter = painterResource(id = movie.imageResId),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .size(200.dp)
                            .clip(RoundedCornerShape(12.dp)),
                        contentScale = ContentScale.Crop,
                    )

                }

                Text(
                    text = movie.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = movie.date,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(top = 4.dp),
                    color = Color.LightGray,
                )
            }
        }
    }
}



