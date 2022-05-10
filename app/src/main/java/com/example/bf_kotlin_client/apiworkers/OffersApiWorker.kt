package com.example.bf_kotlin_client.apiworkers

import com.android.volley.Request
import com.example.bf_kotlin_client.dtos.entities.Buyer
import com.example.bf_kotlin_client.dtos.entities.Offer
import com.example.bf_kotlin_client.utils.GlobalVariables
import com.google.gson.Gson

class OffersApiWorker {

    private var globalVariables = GlobalVariables.instance

    fun getAllBuyers(successCallbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/buyers/getAllRequests"

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction
        )
    }

    fun getAllSellers(successCallbackFunction: (String) -> Unit) {
        val httpMethod = Request.Method.GET
        val url = "http://151.248.113.116:8080/sellers/getAllRequests"

        val httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithoutBody(
            httpMethod,
            url,
            successCallbackFunction
        )
    }

    fun createBuyer(offer: Offer, successCallbackFunction: (String?) -> Unit){

        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/buyers/createNewRequest"
        var request = Gson().toJson(offer)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }

    fun createSeller(offer: Offer, successCallbackFunction: (String?) -> Unit){

        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/sellers/createNewRequest"
        var request = Gson().toJson(offer)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }
    fun updateBuyers(offer: Offer, successCallbackFunction: (String?) -> Unit){

        var httpMethod = Request.Method.PUT
        var url = "http://151.248.113.116:8080/buyers/updateRequest"
        var request = Gson().toJson(offer)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }

    fun updateSellers(offer: Offer, successCallbackFunction: (String?) -> Unit){

        var httpMethod = Request.Method.PUT
        var url = "http://151.248.113.116:8080/sellers/updateRequest"
        var request = Gson().toJson(offer)

        var httpWorker = globalVariables.httpWorker

        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request,
        )
    }
    fun deleteBuyers(offer: Offer, successCallbackFunction: (String?) -> Unit){

        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/buyers/deleteRequest"
        var request = Gson().toJson(offer)
        var httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request
        ) {
            it.message

        }
    }

    fun deleteSellers(offer: Offer, successCallbackFunction: (String?) -> Unit){

        var httpMethod = Request.Method.POST
        var url = "http://151.248.113.116:8080/sellers/deleteRequest"
        var request = Gson().toJson(offer)
        var httpWorker = globalVariables.httpWorker
        httpWorker.makeStringRequestWithBody(
            httpMethod,
            url,
            successCallbackFunction,
            request
        ) {
            it.message

        }
    }
}