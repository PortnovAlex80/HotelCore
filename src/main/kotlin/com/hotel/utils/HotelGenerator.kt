package com.hotel.utils

import com.hotel.domain.*
import java.util.UUID
import kotlin.random.Random

class HotelGenerator {
    private val hotelNames = listOf("The Ritz", "Hotel California", "The Grand Budapest Hotel", "The Plaza", "Hotel Transylvania")

    fun generateHotels(hotelCount: Int): List<Hotel> {
        val hotels = mutableListOf<Hotel>()

        for (i in 1..hotelCount) {
            val hotelName = HotelName(hotelNames.random())
            val hotelId = HotelId(UUID.randomUUID())
            val rating = HotelRating(Random.nextFloat() * 5) // Random rating between 0 and 5
            val rooms = generateRooms()
            val guestCapacity = GuestCapacity(rooms.sumBy { it.capacity.value })

            val hotel = Hotel(hotelId, hotelName, rating, rooms, guestCapacity)
            hotels.add(hotel)
        }

        return hotels
    }

    private fun generateRooms(): List<Room> {
        val rooms = mutableListOf<Room>()
        val roomCount = Random.nextInt(50, 100) // Random room count between 50 and 100

        for (i in 1..roomCount) {
            val roomId = RoomId(UUID.randomUUID())
            val roomCapacity = RoomCapacity(Random.nextInt(1, 5)) // Random room capacity between 1 and 4
            val nightlyRate = NightlyRate(Money.from(Random.nextInt(250, 300))) // Random nightly rate between 50 and 200
            val roomStatus = RoomStatus.values().random() // Random room status

            val room = Room(roomId, roomCapacity, nightlyRate, roomStatus)
            rooms.add(room)
        }

        return rooms
    }
}
