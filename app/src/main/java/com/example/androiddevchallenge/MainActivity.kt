/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp()
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    val catModel = CatModel()
    val catList = catModel.getCats()
    val selectedCat: MutableState<Cat> = mutableStateOf(Cat())
    Scaffold(
        topBar = {
            AppTopBar()
        },
        content = {
            Surface(color = MaterialTheme.colors.background) {
                CatsList(catList) {
                    selectedCat.value = it
                }
            }
            if (selectedCat.value.id != 0)
                CatDescriptionDialog(selectedCat)
        }
    )
}
@Composable
fun AppTopBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.background,
        contentColor = MaterialTheme.colors.primary
    ) {
        Row(
            Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                "MichiZone",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Icon(
                painter = painterResource(id = R.drawable.ic_favorite),
                contentDescription = "Heart Icon",
                tint = MaterialTheme.colors.primary
            )
        }
    }
}

@Composable
fun CatsList(cats: List<Cat>, catSelected: (Cat) -> Unit) {
    LazyColumn(
        Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        items(cats) { cat ->
            CatItemCard(cat, catSelected)
        }
    }
}

@Composable
fun CatItemCard(cat: Cat, catSelected: (Cat) -> Unit) {
    val image = painterResource(id = cat.photo)
    Card(
        Modifier
            .clickable(onClick = { catSelected(cat) })
            .padding(vertical = 4.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = image,
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .padding(2.dp)
                    .height(70.dp)
                    .width(70.dp)
                    .fillMaxSize()
                    .clip(CircleShape)
            )
            Column(Modifier.padding(horizontal = 16.dp)) {
                Text(
                    cat.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Text(
                    "Age: " + cat.age + " months",
                    fontSize = 14.sp
                )
            }
        }
    }
}

@Composable
fun CatDescriptionDialog(selectedCat: MutableState<Cat>) {
    Dialog(
        onDismissRequest = { selectedCat.value = Cat() },
        content = {
            Card(
                Modifier
                    .padding(40.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15))
            ) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painterResource(id = selectedCat.value.photo),
                        contentDescription = "",
                        contentScale = ContentScale.FillBounds,
                        modifier = Modifier
                            .height(250.dp)
                            .fillMaxWidth()
                    )
                    Text(
                        text = selectedCat.value.name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 24.sp
                    )
                    Row(
                        Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                        Text(
                            text = "Age: " + selectedCat.value.age + " months",
                            fontSize = 20.sp
                        )
                        val catGender = if (selectedCat.value.male) "Male" else "Female"
                        Text(
                            text = "Gender: $catGender",
                            fontSize = 20.sp
                        )
                    }
                    Text(
                        text = selectedCat.value.description,
                        Modifier.padding(16.dp),
                        fontSize = 16.sp
                    )
                }
            }
        }
    )
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
