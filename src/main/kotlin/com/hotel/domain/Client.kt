package com.hotel.domain

import java.util.UUID

data class Client(
    val id: ClientId,
    val name: ClientName,
    val phone: ClientPhone,
    val billLink: BillId,
    val familyMembersAmount: FamilyMembersAmount
)

data class ClientName(val value: String)
data class ClientPhone(val value: String)
data class BillLink(val value: String)
data class ClientId(val value: UUID)
data class FamilyMembersAmount(val value: Int)




