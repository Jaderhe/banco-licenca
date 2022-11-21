package br.gov.pr.toledo.api.domain.user.usecases

import br.gov.pr.toledo.api.domain.user.model.User

interface CreateUserUseCase {
    fun execute(user: User) : User
}