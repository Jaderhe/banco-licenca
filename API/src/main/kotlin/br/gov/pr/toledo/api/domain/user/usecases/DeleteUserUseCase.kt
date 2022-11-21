package br.gov.pr.toledo.api.domain.user.usecases

import br.gov.pr.toledo.api.domain.user.model.IdUser

interface DeleteUserUseCase {
    fun execute(id : IdUser)
}