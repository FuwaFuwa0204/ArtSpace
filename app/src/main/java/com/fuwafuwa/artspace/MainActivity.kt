package com.fuwafuwa.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fuwafuwa.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    artSpace()
                }
            }
        }
    }
}

@Composable
fun artSpace(){

    var step by remember { mutableStateOf(1)}

    Column(modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally){
        when (step) {
            1-> Surface(Modifier.border(width=3.dp,color=Color.DarkGray).shadow(9.dp)){imageArea(R.drawable.demonslayer)}
            2-> Surface(Modifier.border(width=3.dp,color=Color.DarkGray).shadow(9.dp)){imageArea(R.drawable.spiritedaway)}
            3-> Surface(Modifier.border(width=3.dp,color=Color.DarkGray).shadow(9.dp)){imageArea(R.drawable.yourname)}
            4-> Surface(Modifier.border(width=3.dp,color=Color.DarkGray).shadow(9.dp)){imageArea(R.drawable.suzume)}
            5-> Surface(Modifier.border(width=3.dp,color=Color.DarkGray).shadow(9.dp)){imageArea(R.drawable.onepiece)}
            6-> Surface(Modifier.border(width=3.dp,color=Color.DarkGray).shadow(9.dp)){imageArea(R.drawable.howl)}
            7-> Surface(Modifier.border(width=3.dp,color=Color.DarkGray).shadow(9.dp)){imageArea(R.drawable.ponyo)}
            8-> Surface(Modifier.border(width=3.dp,color=Color.DarkGray).shadow(9.dp)){imageArea(R.drawable.jujutsukaisen0)}
            9-> Surface(Modifier.border(width=3.dp,color=Color.DarkGray).shadow(9.dp)){imageArea(R.drawable.weatheringwithyou)}
            10-> Surface(Modifier.border(width=3.dp,color=Color.DarkGray).shadow(9.dp)){imageArea(R.drawable.standbyme)}
        }
        Spacer(modifier = Modifier.height(25.dp))
        when (step) {
            1-> Surface(Modifier.shadow(9.dp)){nameArea(R.string.DemonSlayer_title,R.string.DemonSlayer_director)}
            2-> Surface(Modifier.shadow(9.dp)){nameArea(R.string.SpiritedAway_title,R.string.SpiritedAway_director)}
            3-> Surface(Modifier.shadow(9.dp)){nameArea(R.string.YourName_title,R.string.YourName_director)}
            4-> Surface(Modifier.shadow(9.dp)){nameArea(R.string.suzume_title,R.string.suzume_director)}
            5-> Surface(Modifier.shadow(9.dp)){nameArea(R.string.OnePiece_title,R.string.OnePiece_title)}
            6-> Surface(Modifier.shadow(9.dp)){nameArea(R.string.Howl_title,R.string.Howl_director)}
            7-> Surface(Modifier.shadow(9.dp)){nameArea(R.string.Ponyo_title,R.string.Ponyo_director)}
            8-> Surface(Modifier.shadow(9.dp)){nameArea(R.string.Jujusukaisen_title,R.string.Jujusukaisen_director)}
            9-> Surface(Modifier.shadow(9.dp)){nameArea(R.string.WeatheringWithYou_title,R.string.WeatheringWithYou_director)}
            10-> Surface(Modifier.shadow(9.dp)){nameArea(R.string.StandMyMe_title,R.string.StandMyMe_director)}
        }
        Spacer(modifier = Modifier.height(25.dp))
        when (step) {
            1-> buttonArea({ }, { step=2 })
            2-> buttonArea({ step=1 }, { step=3 })
            3-> buttonArea({ step=2 }, { step=4 })
            4-> buttonArea({ step=3 }, { step=5 })
            5-> buttonArea({ step=4 }, { step=6 })
            6-> buttonArea({ step=5 }, { step=7 })
            7-> buttonArea({ step=6 }, { step=8 })
            8-> buttonArea({ step=7 }, { step=9 })
            9-> buttonArea({ step=8 }, { step=10 })
            10-> buttonArea({ step=9 }, { })
        }

    }


}
@Composable
fun imageArea(imageId:Int,modifier: Modifier = Modifier) {

    Image(painter = painterResource(id = imageId),
        contentDescription = null,
        modifier = Modifier.width(300.dp).height(500.dp).padding(15.dp))


}
@Composable
fun nameArea(titleId:Int,directorId:Int,modifier: Modifier = Modifier) {

    Column(modifier=Modifier.padding(20.dp)){
        Text(text= stringResource(id = titleId),
             fontSize = 30.sp)
        Text(text= stringResource(id = directorId),
             fontWeight = FontWeight.Bold
        )
    }

}
@Composable
fun buttonArea(previous:()->Unit, next:()->Unit, modifier: Modifier = Modifier) {
    
    Row(modifier=modifier){
        Button(onClick = previous, modifier = Modifier.weight(1f).padding(start=15.dp)){
            Text(text= stringResource(id = R.string.previous),
                color = Color.White,
                fontWeight = FontWeight.Bold,)
        }
        Spacer(modifier = Modifier.width(20.dp))
        Button(onClick = next,modifier = Modifier.weight(1f).padding(end=15.dp)) {
            Text(text= stringResource(id = R.string.next),
                color = Color.White,
                fontWeight = FontWeight.Bold)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        artSpace()
    }
}