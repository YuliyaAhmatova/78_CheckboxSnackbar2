package com.example.a78_checkboxsnackbar2

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var toolbarMain: Toolbar
    private lateinit var checkBoxCB: CheckBox
    private lateinit var infoTV: TextView
    private lateinit var rulesTV: TextView

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        toolbarMain = findViewById(R.id.toolbarMain)
        setSupportActionBar(toolbarMain)
        title = "Правила дорожного движения"
        toolbarMain.subtitle = "версия 1"
        toolbarMain.setLogo(R.drawable.baseline_edit_road_24)

        checkBoxCB = findViewById(R.id.checkBoxCB)
        infoTV = findViewById(R.id.infoTV)
        rulesTV = findViewById(R.id.rulesTV)

        checkBoxCB.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                infoTV.text = "Правила дорожного движения"
                rulesTV.text =
                    "1. Ограничения скорости. В городе обычно 60 км/ч, но может быть снижено до 40 км/ч в жилых зонах или возле школ. На загородных дорогах обычно 90 км/ч, на автомагистралях — 110–130 км/ч.\n" +
                            "2. Порядок проезда перекрёстков. Водители на главной дороге имеют приоритет. На нерегулируемых перекрёстках при равнозначных дорогах уступают дорогу транспорту, приближающемуся справа.\n" +
                            "3. Правила обгона. Обгон запрещён на участках с двойной сплошной линией, на перекрёстках, пешеходных переходах и в местах с ограниченной видимостью.к проезда перекрёстков."
            } else {
                infoTV.text = "Информация"
                rulesTV.text = ""
            }
        }
    }

}