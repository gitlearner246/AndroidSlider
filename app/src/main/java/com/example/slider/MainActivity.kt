package com.example.slider

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.slider.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var position = 0

    private val imageList = listOf(R.drawable.dog, R.drawable.horse, R.drawable.kitten)
    private val quoteList = listOf(
        "準備しておこう。チャンスはいつか訪れるものだ。\nエイブラハム・リンカーン",
        "楽しいから笑うのではない。笑うから楽しいのだ。\nウィリアム・ジェームズ",
        "幸せとは、健康で記憶力が悪いということだ。\nアルベルト・シュバイツァー"
    )

    private val matrix = ColorMatrix(
        floatArrayOf(
            0.393f, 0.769f, 0.189f, 0f, 0f,
            0.349f, 0.686f, 0.168f, 0f, 0f,
            0.272f, 0.534f, 0.131f, 0f, 0f,
            0f, 0f, 0f, 1f, 0f
        )
    )
    private val filter = ColorMatrixColorFilter(matrix)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        movePosition(0)

        binding.btnToLeft.setOnClickListener {
            movePosition(-1)
        }
        binding.btnToRight.setOnClickListener {
            movePosition(1)
        }
    }

    private fun movePosition(num: Int) {
        position += num

        if (position >= imageList.size) {
            position = 0
        } else if (position < 0) {
            position = imageList.size - 1
        }

        binding.textView.text = quoteList[position]
        binding.imageView.setImageResource(imageList[position])
        binding.imageView.colorFilter = filter

    }

}