package br.gov.pr.toledo.api.interfaces.rest.user

import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User
import br.gov.pr.toledo.api.domain.user.service.UserService
import java.time.LocalDate

data class UserDTO(
    val userId : IdUser,
    val name : String,
    val email : String,
    val isActive : Boolean,
    val permission : String,
    val username : String,
    //val userId1 : User,
    val createdAt : LocalDate,
    val updatedAt : LocalDate,
    val password : String
) {

    companion object {
        fun toDTO(user: User) = UserDTO(
            user.userId,
            user.name,
            user.email,
            user.isActive,
            user.permission,
            user.username,
            //user.userId1,
            user.createdAt,
            user.updatedAt,
            user.password
        )
    }
}

data class UserSummaryDTO(
    val userId : IdUser,
    val name : String,
    val email : String,
    val isActive : Boolean,
    val permission : String,
    val username : String
) {
    companion object {
        fun toDTO(user: User) = UserSummaryDTO(
            userId = user.userId,
            name = user.name,
            email = user.email,
            isActive = user.isActive,
            permission = user.permission,
            username = user.username
        )
    }
}