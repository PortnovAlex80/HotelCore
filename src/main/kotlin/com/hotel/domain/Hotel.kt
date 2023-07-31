package com.hotel.domain

import java.util.UUID

data class Hotel(
    val id: HotelId,
    val name: HotelName,
    val rating: HotelRating,
    val rooms: List<Room>, // Room class is imported from Room.kt
    val guestCapacity: GuestCapacity
) {
    val roomCount: RoomCount
        get() = RoomCount(rooms.size)
    val totalHotelCapacity: TotalHotelCapacity
        get() {
            var totalCapacity = 0
            for (room in rooms) {
                totalCapacity += room.capacity.value
            }
            return TotalHotelCapacity(totalCapacity)
        }
}

// Encapsulating classes
data class HotelId(val value: UUID)
data class HotelName(val value: String)
data class HotelRating(val value: Float)
data class RoomCount(val value: Int)
data class GuestCapacity(val value: Int)
data class TotalHotelCapacity(val value: Int)
