package com.unmus.music

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.unmus.music.tataletak.TataLetakActivity
import com.unmus.music.ui.theme.MusicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicTheme {
                Column() {
                    Button(onClick = {
                        // todo
                        val i = Intent(this@MainActivity, TataLetakActivity::class.java)
                        startActivity(i)
                    }) {

                    }

                }
            }
        }
    }

    fun TataLetakActivity(): ArrayList<User>{
        val users: ArrayList<User> = ArrayList()

        // buat objek user
        var user = User("Siti", "Papua asdfasdfaas asdfsafasd asdfsadfa sadfasdfas asdfsafa", 20)
        users.add(user)

        user = User("Maxiel", "Sorongsadfasdfa  asdfsadfasf asdfsafafsa asdfsafsafas", 30)
        users.add(user)

        user = User("Alex", "Merauke asdfsafsa asdfasfa asdfasdfsa asdfsdafafsaasdf asdfadfasadfasdf sadf", 25)
        users.add(user)

        return users
    }

    data class User(
        val name: String,
        val address: String,
        val umur: Int
    )

    @Composable
    fun Pesan(user: User){
        Row(
            modifier = Modifier.padding(all = 8.dp)
        ) {
            Image(painter =
            painterResource(id = R.drawable.foto),
                contentDescription = "Uni musamus",
                modifier = Modifier
                    // Set image size to 40 dp
                    .size(40.dp)
                    // Clip image to be shaped as a circle
                    .clip(CircleShape)
                    .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape),
                contentScale = ContentScale.Crop)
            Spacer(modifier = Modifier.width(8.dp))


            // We keep track if the message is expanded or not in this
            // variable
            var isExpanded by remember { mutableStateOf(false) }


            Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
                Text(text = user.name, color = Red)
                Spacer(modifier = Modifier.height(8.dp))
                Surface(shape = MaterialTheme.shapes.medium, elevation = 2.dp) {
                    Text(
                        text = user.address,
                        modifier = Modifier.padding(all = 4.dp),
                        // If the message is expanded, we display all its content
                        // otherwise we only display the first line
                        maxLines = if (isExpanded) Int.MAX_VALUE else 1,

                        style = MaterialTheme.typography.body2
                    )
                }
            }
        }
    }

    @Composable
    fun Greeting(name: String) {
        Text(text = "Hello $name!")
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        MusicTheme {
            Greeting("Android")
        }
    }
}