package br.gov.pr.toledo.api.interfaces.rest.user.impl

import br.gov.pr.toledo.api.domain.user.model.IdUser
import java.time.LocalDate

interface Mapper <D, E> {

    fun toEntity(dto: D): E
    abstract fun User(
        userId: IdUser,
        name: String,
        email: String,
        password: String,
        isActive: Boolean,
        permission: String,
        username: String,
        userParent: E,
        createdAt: LocalDate,
        updatedAt: LocalDate,
        lastlogin: E?
    ): E
}