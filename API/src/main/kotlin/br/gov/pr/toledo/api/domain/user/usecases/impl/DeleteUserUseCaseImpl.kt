package br.gov.pr.toledo.api.domain.user.usecases.impl

import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User
import br.gov.pr.toledo.api.domain.user.repository.UserRepository
import br.gov.pr.toledo.api.domain.user.service.UserService
import br.gov.pr.toledo.api.domain.user.usecases.CreateUserUseCase
import br.gov.pr.toledo.api.domain.user.usecases.DeleteUserUseCase
import br.gov.pr.toledo.api.interfaces.rest.user.UserDTO
import org.springframework.stereotype.Service

@Service
class DeleteUserUseCaseImpl (private val userRepository : UserRepository) : DeleteUserUseCase {

    override fun execute(id: IdUser) {

        val user = userRepository.findById(id).orElseThrow { RuntimeException("User not found") }
        return userRepository.delete(user)
    }
}