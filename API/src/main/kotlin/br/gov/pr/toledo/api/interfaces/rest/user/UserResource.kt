package br.gov.pr.toledo.api.interfaces.rest.user

import br.gov.pr.toledo.api.domain.user.model.User
import org.springframework.http.ResponseEntity

interface UserResource {
    fun lista(): ResponseEntity<List<UserSummaryDTO>>

    fun findById(id: Int): ResponseEntity<UserDTO>

    fun create(user: UserDTO): ResponseEntity<Void>

    fun delete(id: Int)
}