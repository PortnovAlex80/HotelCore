package com.hotel.domain

import java.util.UUID

data class Money private constructor(val amount: Int) {
    companion object {
        fun from(amount: Int): Money {
            if (amount < 0) {
                throw IllegalArgumentException("Money amount cannot be negative")
            }
            return Money(amount)
        }
    }
}

data class Bill(val id: BillId, val amount: Money)

data class BillId(val value: UUID)
