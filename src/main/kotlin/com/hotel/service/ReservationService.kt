package com.hotel.service

import com.hotel.domain.*
import java.lang.Exception
import kotlin.random.Random

class ReservationService(private val paymentProcessor: PaymentProcessor) {

    fun tryBookingClientsToHotels(clients: List<Pair<Client, Bill>>, hotels: List<Hotel>): Map<Client, Room> {
        val successfulBookings = mutableMapOf<Client, Room>()

        clients.forEach { clientBillPair ->
            val client = clientBillPair.first
            val bill = clientBillPair.second
            val familySize = client.familyMembersAmount.value

            for (i in 1..3) { // Three attempts
                val hotel = hotels.random()
                val availableRoom = hotel.rooms.find { room ->
                    room.status == RoomStatus.AVAILABLE && room.capacity.value >= familySize
                }

                if (availableRoom != null && paymentProcessor.canAfford(bill, availableRoom.nightlyRate.value)) {
                    // If the client has enough funds and the room is available, make a successful booking
                    successfulBookings[client] = availableRoom
                    break // Break the loop after a successful booking
                }
            }
        }

        return successfulBookings
    }
}

class PaymentProcessor {
    fun canAfford(bill: Bill, nightlyRate: Money): Boolean {
        val nights = Random.nextInt(3, 11) // Randomly generates a number between 3 and 10.
        val totalCost = nightlyRate.amount * nights
        return bill.amount.amount >= totalCost
    }
}
