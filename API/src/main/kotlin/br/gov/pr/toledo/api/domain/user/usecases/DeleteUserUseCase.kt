package br.gov.pr.toledo.api.domain.user.usecases

import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User
import br.gov.pr.toledo.api.interfaces.rest.user.UserDTO

interface DeleteUserUseCase {
    fun execute(id : IdUser)
}