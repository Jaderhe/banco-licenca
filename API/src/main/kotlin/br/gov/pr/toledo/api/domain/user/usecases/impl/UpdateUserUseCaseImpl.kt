package br.gov.pr.toledo.api.domain.user.usecases.impl

import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User
import br.gov.pr.toledo.api.domain.user.repository.UserRepository
import br.gov.pr.toledo.api.domain.user.usecases.UpdateUserUseCase
import org.springframework.stereotype.Service

@Service
class UpdateUserUseCaseImpl (private val userRepository: UserRepository) : UpdateUserUseCase {

    override fun execute(idUser: IdUser, transformation: (User) -> User) {
        val user = userRepository.findById(idUser).orElseThrow { RuntimeException("User not found") }
        userRepository.save(transformation(user).with(userId = idUser))
    }
}
