package com.example.artspaceapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.model.Artist
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ArtSpaceScreen()
                }
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun ArtSpaceScreen() {

    var valueIterator by mutableStateOf(0)


    var imageChangeMain by remember { mutableStateOf(0) }
    var authorChangeMain by remember { mutableStateOf(0) }


//    fun checking(image: Int? = null, author: Int? = null, art: Int? = null) {
//
//        if (image != null) {
//            when (valueIterator) {
//                0 -> imageChangeMain = R.drawable.ic_baseline_2k_24
//                1 -> imageChangeMain = R.drawable.ic_launcher_background
//                else -> imageChangeMain = R.drawable.ic_launcher_foreground
//            }
//        }
//        else if (author != null) {
//            when (valueIterator) {
//                0 -> authorChangeMain = R.string.artist
//                1 -> authorChangeMain = R.string.art_title2
//                else -> authorChangeMain = R.string.art_title3
//            }
//        } else {
//            when (valueIterator) {
//                0 -> artChangeMain = R.string.art_title
//                1 -> artChangeMain = R.string.art_title2
//                else -> artChangeMain = R.string.art_title3
//            }
//        }
//        //return rap
//    }

    fun iterateValue(
        imageChange: Int? = null,
        authorChange: Int? = null,
        artChange: Int? = null
    ): Int {
        var replace: Int
        if (imageChange != null) {
            replace = imageChange
            replace = when (valueIterator) {
                0 -> R.drawable.ic_baseline_2k_24
                1 -> R.drawable.ic_launcher_background
                else -> R.drawable.ic_launcher_foreground
            }
        } else if (authorChange != null) {
            replace = authorChange
            replace = when (valueIterator) {
                0 -> R.string.artist
                1 -> R.string.artist2
                else -> R.string.artist3
            }
        } else {
            replace = artChange ?: 0
            replace = when (valueIterator) {
                0 -> R.string.art_title
                1 -> R.string.art_title2
                else -> R.string.art_title3
            }
        }
        return replace
    }
//    fun iterateValueAuth(authorChange: Int) : Int {
//        var replace: Int
//        replace = authorChange
//        replace = when (valueIterator) {
//            0 -> R.st.ic_baseline_2k_24
//            1 -> R.drawable.ic_launcher_background
//            else -> R.drawable.ic_launcher_foreground
//        }
//
//        return replace
//    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                elevation = 22.dp, modifier = Modifier
                    .height(500.dp)
                    .width(350.dp)
                    .padding(16.dp, vertical = 56.dp)
                    .fillMaxWidth()
                    .border(BorderStroke(4.dp, color = Color.Gray), shape = RectangleShape),

                shape = MaterialTheme.shapes.medium
            ) {
                Image(
                    painter = painterResource(iterateValue(imageChangeMain) ?: 0),
                    contentDescription = stringResource(id = R.string.image_content),
                    modifier = Modifier.padding(16.dp)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Card(
                modifier = Modifier
                    .padding(top = 0.dp, bottom = 33.dp)
                    .height(140.dp)
                    .width(310.dp)
                    .fillMaxWidth(),
                elevation = 11.dp

            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = stringResource(iterateValue(artChange = imageChangeMain)),
                        fontSize = 19.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${stringResource(iterateValue(authorChange = imageChangeMain))} ${
                            stringResource(
                                id = R.string.year
                            )
                        }",
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Start
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {

                Button(onClick = {

                    if (valueIterator == 0) {
                        valueIterator = 2
                    } else {
                        valueIterator--
                        iterateValue(imageChangeMain)
                    }


                }, modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Previous"
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = {
                    if (valueIterator == 2) {
                        valueIterator = 0
                    } else {
                        valueIterator++
                        iterateValue(imageChangeMain)
                    }


                }, modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Next"
                    )
                }

            }


        }

    }
}


data class ArtSpaceState(
    var initialValueForImage: Int? = null,
    val initialValueForAuthor: Int? = null,
    val initialValueForArt: Int? = null,

    )


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {

    }
}