package org.wit.placemark.model

import org.wit.placemark.models.PlacemarkModel

interface PlacemarkStore {
    fun findAll(): List<PlacemarkModel>
    fun create(placemark: PlacemarkModel)
    fun update(placemark: PlacemarkModel)
}
