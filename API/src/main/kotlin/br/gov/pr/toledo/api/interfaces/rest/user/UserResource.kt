package br.gov.pr.toledo.api.interfaces.rest.user

import org.springframework.http.ResponseEntity

interface UserResource {
    fun lista(): ResponseEntity<List<UserSummaryDTO>>

    fun findById(id: Int): ResponseEntity<UserDTO>
}