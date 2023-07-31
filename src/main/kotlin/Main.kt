import com.hotel.domain.*
import com.hotel.service.BookingService
import com.hotel.service.PaymentProcessor
import com.hotel.service.ReservationService
import com.hotel.utils.ClientGenerator
import com.hotel.utils.HotelGenerator

fun main(args: Array<String>) {
    println("Hello World!")

    // Create a ClientGenerator instance
    val clientGenerator = ClientGenerator()

    // Generate a list of Pair<Client, Bill>
    val clientBillPairs = clientGenerator.generateClients()

    // Print the list of clients and their bills
    clientBillPairs.forEach { (client, bill) ->
        println("Client: ${client.name} -> Bill: ${bill.amount}\n")
    }

    // Create a HotelGenerator instance
    val hotelGenerator = HotelGenerator()

    // Generate a list of Hotels
    val hotels = hotelGenerator.generateHotels(5) // Generating 5 hotels

    // Print the list of hotels and their rooms
    hotels.forEach { hotel ->
        println("Hotel: ${hotel.name} -> ${hotel.guestCapacity}")
        hotel.rooms.forEach { room ->
            println("\tRoom: ${room.id}, Capacity: ${room.capacity}, Nightly Rate: ${room.nightlyRate}, Status: ${room.status}")
        }
    }

    val paymentProcessor = PaymentProcessor()
    val reservationService = ReservationService(paymentProcessor)
    val bookingService = BookingService(paymentProcessor, reservationService)

    bookingService.processBookings()

    }
