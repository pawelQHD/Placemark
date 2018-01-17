package org.wit.placemark.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_placemark.*
import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.Appcompat
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.design.snackbar
import org.wit.placemark.R
import org.wit.placemark.models.PlacemarkModel

class PlacemarkActivity : AppCompatActivity(), AnkoLogger {

    var placemark = PlacemarkModel()
    val placemarks = ArrayList<PlacemarkModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_placemark)

        btnAdd.setOnClickListener() {
            placemark.title = placemarkTitle.text.toString()
            placemark.description = placemarkDescription.text.toString()
            if (placemark.title.isNotEmpty() and  placemark.description.isNotEmpty()) {
                info("add Button Pressed: $placemarkTitle")
                placemarks.add(placemark)
                info("Placemark Title added to array list $placemarkTitle")
                info("Placemark Description added to array list $placemarkDescription")
            }
            else {
                toast ("Title and Description needs to be filled in")
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

            val countries = listOf("Russia", "USA", "Japan", "Australia")
            selector("Where are you from?", countries, { dialogInterface, i ->
                toast("So you're living in ${countries[i]}, right?")
            })

            /*
            val dialog = progressDialog(message = "Please wait a bit…", title = "Fetching data")
            */
            }
        }
    }
