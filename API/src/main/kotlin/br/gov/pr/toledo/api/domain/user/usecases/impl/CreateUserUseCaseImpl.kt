package br.gov.pr.toledo.api.domain.user.usecases.impl

import br.gov.pr.toledo.api.domain.user.model.User
import br.gov.pr.toledo.api.domain.user.repository.UserRepository
import br.gov.pr.toledo.api.domain.user.service.UserService
import br.gov.pr.toledo.api.domain.user.usecases.CreateUserUseCase
import br.gov.pr.toledo.api.interfaces.rest.user.UserDTO
import org.springframework.stereotype.Service

@Service
class CreateUserUseCaseImpl (private val repository : UserRepository) : CreateUserUseCase {
    /*override fun execute(user: UserDTO) : User {
        if (repository.existsById(user.userId)) {
            throw RuntimeException("User already exists")
        }
        return repository.save(user)
    }*/

    override fun execute(user: User) : User {
        if (repository.existsById(user.userId)) {
            throw RuntimeException("User already exists")
        }
        return repository.save(user)
    }

}