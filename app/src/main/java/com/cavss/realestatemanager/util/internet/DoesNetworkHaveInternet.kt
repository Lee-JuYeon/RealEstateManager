package com.cavss.realestatemanager.util.internet


import android.util.Log
import java.io.IOException
import java.net.InetSocketAddress
import javax.net.SocketFactory

object DoesNetworkHaveInternet {

    // Make sure to execute this on a background thread.
    fun execute(socketFactory: SocketFactory): Boolean {
        return try{
            val socket = socketFactory.createSocket() ?: throw IOException("Socket is null.")
            socket.connect(InetSocketAddress("8.8.8.8", 53), 1500)
            socket.close()
            true
        }catch (e: IOException){
            Log.e("mException", "DoesNetworkHaveInternet //No internet connection. ${e}")
            false
        }
    }
}