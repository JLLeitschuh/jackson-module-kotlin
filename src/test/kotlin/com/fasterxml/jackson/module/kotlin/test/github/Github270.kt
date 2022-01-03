package com.fasterxml.jackson.module.kotlin.test.github

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.Test
import kotlin.test.assertEquals

class TestGithub270 {
    data class Wrapper(private val field: String) {
        @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
        val upper = (field as java.lang.String).toUpperCase()
        fun field() = field
        fun stillAField() = field
    }

    @Test
    fun testPublicFieldOverlappingFunction() {
        val json = jacksonObjectMapper().writeValueAsString(Wrapper("Hello"))
        assertEquals("""{"upper":"HELLO"}""", json)
    }
}
