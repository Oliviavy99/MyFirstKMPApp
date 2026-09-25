package com.example.myfirstkmpapp

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.filter

data class News(
    val title: String,
    val category: String
)

val newsList = listOf(
    News("Kampus Gelar Seminar Teknologi", "Teknologi"),
    News("Mahasiswa Raih Prestasi Nasional", "Pendidikan"),
    News("Perkembangan AI Semakin Pesat", "Teknologi"),
    News("Kegiatan Organisasi Kampus", "Kampus"),
    News("Tips Belajar Efektif untuk Mahasiswa", "Pendidikan")
)

fun newsFlow(): Flow<News> = flow {
    var i = 0

    while (true) {
        emit(newsList[i])

        i++

        if (i == newsList.size) {
            i = 0
        }

        delay(2000)
    }
}

fun filterNews(category: String): List<News> {
    return newsList.filter {
        it.category == category
    }
}

fun newsTitleFlow(): Flow<String> {
    return newsFlow()
        .filter {
            it.category == "Teknologi"
        }
        .map {
            "Berita: ${it.title}"
        }
}

class NewsReader {

    private val _readCount = MutableStateFlow(0)

    val readCount: Flow<Int> = _readCount

    fun markAsRead() {
        _readCount.value++
    }
}