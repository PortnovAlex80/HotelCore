package com.hotel.utils

import com.hotel.domain.*
import java.util.*

class ClientGenerator {

    fun generateClients(min: Int = 20, max: Int = 100): List<Pair<Client, Bill>> {
        val random = Random()
        val numberOfClients = random.nextInt(max - min) + min

        return (1..numberOfClients).map {
            val clientId = UUID.randomUUID()
            val billId = UUID.randomUUID()
            val bill = Bill(BillId(billId), Money.from(random.nextInt(401) + 500))

            Pair(
                Client(
                    id = ClientId(clientId),
                    name = ClientName("Client $it"),
                    phone = ClientPhone("+1 555 123 45 $it"), // Generate some random phone number
                    billLink = bill.id,
                    familyMembersAmount = FamilyMembersAmount(random.nextInt(4) + 1)
                ),
                bill
            )
        }
    }
}
