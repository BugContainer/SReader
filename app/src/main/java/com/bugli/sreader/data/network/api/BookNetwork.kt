package com.bugli.sreader.data.network.api

class BookNetwork {


    companion object {

        private var network: BookNetwork? = null

        fun getInstance(): BookNetwork {
            if (network == null) {
                synchronized(BookNetwork::class.java) {
                    if (network == null) {
                        network = BookNetwork()
                    }
                }
            }
            return network!!
        }

    }
}