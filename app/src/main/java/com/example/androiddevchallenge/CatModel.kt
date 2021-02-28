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

class CatModel {
    fun getCats(): List<Cat> {
        val dummyDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Mauris tincidunt odio dolor, at efficitur diam luctus quis. Proin varius enim sed est varius, eget porta sem pretium. Quisque dui tortor, porttitor at auctor vitae, varius id risus. In accumsan bibendum condimentum. Quisque tortor quam, feugiat id tristique tempor, aliquet a lorem."
        return listOf(
            Cat(
                id = 1,
                name = "Casimiro",
                photo = R.drawable.cat1,
                male = true,
                description = dummyDescription,
                age = 3
            ),
            Cat(
                id = 2,
                name = "Cookie",
                photo = R.drawable.cat2,
                male = true,
                description = dummyDescription,
                age = 5
            ),
            Cat(
                id = 3,
                name = "Lorenzo",
                photo = R.drawable.cat3,
                male = true,
                description = dummyDescription,
                age = 2
            ),
            Cat(
                id = 4,
                name = "Kiki",
                photo = R.drawable.cat4,
                male = true,
                description = dummyDescription,
                age = 4
            ),
            Cat(
                id = 5,
                name = "Waffle",
                photo = R.drawable.cat5,
                male = true,
                description = dummyDescription,
                age = 5
            ),
            Cat(
                id = 6,
                name = "Lady Cat",
                photo = R.drawable.cat6,
                male = true,
                description = dummyDescription,
                age = 14
            ),
            Cat(
                id = 7,
                name = "Saalem",
                photo = R.drawable.cat7,
                male = true,
                description = dummyDescription,
                age = 10
            ),
        )
    }
}
