package com.example.kotlinspring.model

class Bank {
    private var accountNumber: String
    private var trust: Double
    private var transactionFee: Int

    constructor(accountNumber: String, trust: Double, transactionFee: Int) {
        this.accountNumber = accountNumber
        this.trust = trust
        this.transactionFee = transactionFee
    }

    fun getAccountNumber(): String = accountNumber

    fun setAccountNumber(accountNumber: String) {
        this.accountNumber = accountNumber
    }
}