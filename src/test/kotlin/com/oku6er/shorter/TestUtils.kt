package com.oku6er.shorter

import org.mockito.Mockito

/**
 * Help method for Mockito.when method.
 * */
fun <T> whenever(call: T) = Mockito.`when`(call)