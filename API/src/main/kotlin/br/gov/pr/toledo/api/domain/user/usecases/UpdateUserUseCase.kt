package br.gov.pr.toledo.api.domain.user.usecases

import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User

interface UpdateUserUseCase {
    fun execute(idUser: IdUser, transformation: (User) -> User)
}