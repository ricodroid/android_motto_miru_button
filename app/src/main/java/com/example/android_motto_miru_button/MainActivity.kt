package com.example.android_motto_miru_button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.android_motto_miru_button.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var text1: TextView
    private lateinit var text2: TextView
    private lateinit var text3: TextView
    private lateinit var mottoMiruButton: TextView
    private lateinit var shukushouButton: TextView
    private lateinit var beforeText: String
    private lateinit var replaceText: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.textView1.text = "もっと見るボタンを作成していく〜〜🚀"
        binding.textView2.text = "雨ニモ負ケズ"
        text1 = binding.textView1
        text2 = binding.textView2
        text3 = binding.textView3
        beforeText = text3.text.toString()
        mottoMiruButton = binding.mottoMiruButton
        shukushouButton = binding.shukushouButton


        if (isLongText(text3.text)) {
            // 13文字以上なら、もっと見るボタンを表示する
            toggleMottoMiruButtonVisibility(mottoMiruButton, View.VISIBLE)
            toggleMottoMiruButtonVisibility(shukushouButton, View.INVISIBLE)
            replaceText = replaceText(text3).toString()
            text3.text = replaceText(text3)
        } else {
            toggleMottoMiruButtonVisibility(mottoMiruButton, View.INVISIBLE)
            toggleMottoMiruButtonVisibility(shukushouButton, View.VISIBLE)
        }
    }

    /**
     * テキストの最初の13文字だけを取り出して、
     * 末尾に「・・・」をつける
     *
     * @return String
     */
    private fun replaceText(text: TextView): StringBuffer {
        // 最初から13文字を取得
        val shortenedText = text.text.take(9)
        // 末尾に「・・・」を追加
        return StringBuffer(shortenedText).append("・・・")
    }

    /**
     * 13文字以上ならtrue
     * 13文字未満ならfalse
     * @return Boolean
     */
    private fun isLongText(text: CharSequence): Boolean {
        return text.length >= 9
    }

    private fun toggleMottoMiruButtonVisibility(textType: TextView,viewStatus: Int) {
        textType.visibility = viewStatus
    }

    fun onClickText(v: View) {
        when (v) {
            mottoMiruButton -> {
                println("もっと見るテキストがクリックされました！")
                text3.text = beforeText
                toggleMottoMiruButtonVisibility(mottoMiruButton, View.INVISIBLE)
                toggleMottoMiruButtonVisibility(shukushouButton, View.VISIBLE)
                mottoMiruButton.text = "縮小表示に戻す"
            }

            shukushouButton -> {
                println("縮小テキストがクリックされました！")
                text3.text = replaceText
                toggleMottoMiruButtonVisibility(shukushouButton, View.INVISIBLE)
                toggleMottoMiruButtonVisibility(mottoMiruButton, View.VISIBLE)
                mottoMiruButton.text = "...もっと見る"
            }
        }

    }

}