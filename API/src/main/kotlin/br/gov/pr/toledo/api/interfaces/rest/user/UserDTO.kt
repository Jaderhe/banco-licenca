package br.gov.pr.toledo.api.interfaces.rest.user

import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User
import br.gov.pr.toledo.api.domain.user.service.UserService
import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonInclude
import com.sun.istack.Nullable
import java.time.LocalDate

data class UserDTO(
    val userId : IdUser,
    val name : String,
    val email : String,
    val isActive : Boolean,
    val permission : String,
    val username : String,
    val userParent : Int,
    val createdAt : LocalDate,
    val updatedAt : LocalDate,
    val password : String,
    @JsonIgnore
    val organs : Collection<Organ> = emptyList()
) {
    fun toModel() = User (
        userId = this.userId,
        name = this.name,
        email = this.email,
        password = this.password,
        isActive = this.isActive,
        permission = this.permission,
        null,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
        username = this.username,
        userParent = this.userParent,
        organs = this.organs
    )

    companion object {
        fun toDTO(user: User) = UserDTO(
            user.userId,
            user.name,
            user.email,
            user.isActive,
            user.permission,
            user.username,
            user.userParent,
            user.createdAt,
            user.updatedAt,
            user.password,
            user.organs
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