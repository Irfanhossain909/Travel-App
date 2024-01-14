package com.example.travelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
   private var currentImage = 0
    var places = arrayOf("Sompur Mahavihara","Bangladesh National Museum","Ahsan Manzil Museum","National Martyrs' Monument","Lalbagh Kella")

    private lateinit var mainImg : ImageView
    private lateinit var mainImgname : TextView
    private lateinit var btnNext : ImageButton
    private lateinit var btnBack : ImageButton
    private lateinit var Image : ImageView
    private lateinit var placeName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNext = findViewById(R.id.btn_next)
        btnBack = findViewById(R.id.btn_back)
        placeName = findViewById(R.id.tVName)

        btnNext.setOnClickListener{
            //i want to get the next image
            val idCurrentImageString = "pic$currentImage"
            //i have to get the integer address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            Image = findViewById(idCurrentImageInt)
            Image.alpha = 0f

            currentImage = (5+currentImage+1)%5
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            Image = findViewById(idImageToShowInt)
            Image.alpha = 1f

            placeName.text = places[currentImage]

        }

        btnBack.setOnClickListener {
            //i want to see the previous image
            val idCurrentImageString = "pic$currentImage"
            //i have to get the integer address associated with each view
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString,"id",packageName)
            Image = findViewById(idCurrentImageInt)
            Image.alpha = 0f

            currentImage = (5+currentImage-1)%5
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString,"id",packageName)
            Image = findViewById(idImageToShowInt)
            Image.alpha = 1f

            placeName.text = places[currentImage]
        }

    }
}