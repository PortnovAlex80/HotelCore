package com.hotel.domain

import java.util.UUID

data class Room(
    val id: RoomId,
    val capacity: RoomCapacity,
    val nightlyRate: NightlyRate,
    var status: RoomStatus
)

enum class RoomStatus {
    AVAILABLE, BOOKED
}

// Encapsulating classes
data class RoomId(val value: UUID)
data class RoomCapacity(val value: Int)
data class NightlyRate(val value: Money) // Assuming that Money is already defined
