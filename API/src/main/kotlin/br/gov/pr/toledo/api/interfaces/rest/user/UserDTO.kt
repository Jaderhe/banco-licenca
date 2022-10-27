package br.gov.pr.toledo.api.interfaces.rest.user

import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User

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
            user.userId,
            user.name,
            user.email,
            user.isActive,
            user.permission,
            user.username
        )
    }
}