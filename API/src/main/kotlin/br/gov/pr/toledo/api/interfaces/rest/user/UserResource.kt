package br.gov.pr.toledo.api.interfaces.rest.user

import br.gov.pr.toledo.api.domain.user.model.User
import org.springframework.http.ResponseEntity

interface UserResource {
    fun list(): ResponseEntity<List<UserSummaryDTO>>

    fun findById(id: Int): ResponseEntity<UserDTO>

    fun create(user: UserDTO): ResponseEntity<Void>

    fun update(id: Int, userDTO: UserDTO)

    fun delete(id: Int)
}