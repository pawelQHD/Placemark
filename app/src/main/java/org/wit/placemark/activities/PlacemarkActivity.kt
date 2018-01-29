package org.wit.placemark.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_placemark.*
import org.jetbrains.anko.*
import org.wit.placemark.R
import org.wit.placemark.main.MainApp
import org.wit.placemark.models.PlacemarkModel

class PlacemarkActivity : AppCompatActivity(), AnkoLogger {

    var placemark = PlacemarkModel()
    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placemark)
        app = application as MainApp

        btnAdd.setOnClickListener() {
            placemark.title = placemarkTitle.text.toString()
            placemark.description = placemarkDescription.text.toString()
            if (placemark.title.isNotEmpty()) {
                app.placemarks.create(placemark.copy())
                setResult(AppCompatActivity.RESULT_OK)
                finish()
            }
            if (intent.hasExtra("placemark_edit")) {
                placemark = intent.extras.getParcelable<PlacemarkModel>("placemark_edit")
                placemarkTitle.setText(placemark.title)
                placemarkDescription.setText(placemark.description)
            }
        }
        cancelBtn.setOnClickListener() {
            setResult(AppCompatActivity.RESULT_CANCELED)
            finish()
        }
    }
}
            /*toast("Hi there!")
            //toast(R.string.message)
            longToast("Wow, such duration")
            */

            /*snackbar(this, "Hi there!")
            snackbar(this, "Hello")
            longSnackbar(this, "Wow, such duration")
            snackbar(this, "Action, reaction", "Click me!") {}
            */

            /*alert("Hi, I'm Roy", "Have you tried turning it off and on again?") {
                yesButton { toast("Oh…") }
                noButton {}
            }.show()
*/
            /*
            alert(Appcompat, "Some text message").show()
            */

            /*alert {
                customView {
                    editText()
                }
            }.show()
            */

            /*
            val countries = listOf("Russia", "USA", "Japan", "Australia")
            selector("Where are you from?", countries, { dialogInterface, i ->
                toast("So you're living in ${countries[i]}, right?")
            })
            */

            /*
            val dialog = progressDialog(message = "Please wait a bit…", title = "Fetching data")
            */

