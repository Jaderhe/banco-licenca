package br.gov.pr.toledo.api.domain.user.service

import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User
import br.gov.pr.toledo.api.interfaces.rest.user.UserDTO
import br.gov.pr.toledo.api.interfaces.rest.user.UserSummaryDTO

interface UserService {

    fun list(): List<User>

    fun findAll(): List<UserSummaryDTO>

    fun findById(id: IdUser): User

    fun findById(id: Int): UserDTO

    fun create(user: User): User

    fun delete(id: IdUser)

}