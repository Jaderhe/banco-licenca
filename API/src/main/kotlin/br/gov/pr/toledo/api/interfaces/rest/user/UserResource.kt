package br.gov.pr.toledo.api.interfaces.rest.user

import org.springframework.http.ResponseEntity

interface UserResource {

    fun findAll(): ResponseEntity<List<UserSummaryDTO>>

}