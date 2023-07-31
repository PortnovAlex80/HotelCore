package com.hotel.service

import com.hotel.domain.*
import com.hotel.utils.ClientGenerator
import com.hotel.utils.HotelGenerator

class BookingService(
    private val paymentProcessor: PaymentProcessor,
    private val reservationService: ReservationService
) {
    fun processBookings() {
        // Generate clients and hotels
        val clientGenerator = ClientGenerator()
        val hotelGenerator = HotelGenerator()

        val clientBillPairs = clientGenerator.generateClients()
        val hotels = hotelGenerator.generateHotels(hotelCount = 5) // Generate 5 hotels

        // Try to reserve rooms for all clients
        val bookings = reservationService.tryBookingClientsToHotels(clientBillPairs, hotels)

        // Print out the results
        bookings.forEach { (client, room) ->
            println("Client ${client.name.value} successfully booked room ${room.id.value}")
        }
    }

}
