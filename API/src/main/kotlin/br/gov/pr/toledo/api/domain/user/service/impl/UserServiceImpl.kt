package br.gov.pr.toledo.api.domain.user.service.impl

import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User
import br.gov.pr.toledo.api.domain.user.repository.UserRepository
import br.gov.pr.toledo.api.domain.user.service.UserService
import br.gov.pr.toledo.api.interfaces.rest.user.UserDTO
import br.gov.pr.toledo.api.interfaces.rest.user.UserSummaryDTO
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (
    private val repository : UserRepository
    ) : UserService {
    override fun list(): List<User> = repository.findAll()

    override fun findAll(): List<UserSummaryDTO> = list().map(UserSummaryDTO::toDTO)

    override fun findById(id: IdUser): User = repository.findById(id).orElseThrow { RuntimeException("User not found") }

    override fun findById(id: Int): UserDTO {
        return UserDTO.toDTO(findById(IdUser(id)))
    }

}
