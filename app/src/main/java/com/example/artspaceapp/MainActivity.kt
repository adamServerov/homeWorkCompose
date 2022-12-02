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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
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

    var state by mutableStateOf(ArtSpaceState())

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
                    painter = painterResource(state.image ?: 0),
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
                        text = stringResource(id = R.string.art_title),
                        fontSize = 19.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "${stringResource(id = R.string.artist)} ${stringResource(id = R.string.year)}",
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
                Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Previous"
                    )
                }
                Spacer(modifier = Modifier.width(10.dp))
                Button(onClick = { /*TODO*/ }, modifier = Modifier.weight(1f)) {
                    Text(
                        text = "Next"
                    )
                }

            }


        }

    }
}


data class ArtSpaceState(
    val image: Int? = null,
    val onPreviousButClicked: () -> Unit = {},
    val onNextButClicked: () -> Unit = {},
    val artistString: String? = null,
    val artTitle: String? = null,
    val artYear: String? = null,
)


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceAppTheme {

    }
}