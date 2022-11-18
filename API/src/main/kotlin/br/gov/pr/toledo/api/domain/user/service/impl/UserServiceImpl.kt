package br.gov.pr.toledo.api.domain.user.service.impl

import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User
import br.gov.pr.toledo.api.domain.user.repository.UserRepository
import br.gov.pr.toledo.api.domain.user.service.UserService
import br.gov.pr.toledo.api.domain.user.usecases.CreateUserUseCase
import br.gov.pr.toledo.api.domain.user.usecases.DeleteUserUseCase
import br.gov.pr.toledo.api.domain.user.usecases.UpdateUserUseCase
import br.gov.pr.toledo.api.interfaces.rest.user.UserDTO
import br.gov.pr.toledo.api.interfaces.rest.user.UserSummaryDTO
import org.springframework.stereotype.Service

@Service
class UserServiceImpl (
    private val createUserUseCase: CreateUserUseCase,
    private val deleteUserUseCase: DeleteUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val userRepository : UserRepository
    ) : UserService {
    override fun list(): List<User> = userRepository.findAll()

    override fun findAll(): List<UserSummaryDTO> = list().map(UserSummaryDTO::toDTO)

    override fun findById(id: IdUser): User = userRepository.findById(id).orElseThrow {
        RuntimeException("User not found")
    }

    override fun findById(id: Int): UserDTO = UserDTO.toDTO(findById(IdUser(id)))

    override fun create(user: User): User = createUserUseCase.execute(user)

    override fun delete(id: IdUser) = deleteUserUseCase.execute(id)

    override fun update(id: IdUser, userDTO: UserDTO) {
        updateUserUseCase.execute(id) {
            it.with(
                name = userDTO.name,
                email = userDTO.email,
                isActive = userDTO.isActive,
                permission = userDTO.permission,
                username = userDTO.username,
                userParent = userDTO.userParent,
                lastLogin = userDTO.lastLogin,
                createdAt = userDTO.createdAt,
                updatedAt = userDTO.updatedAt,
                password = userDTO.password
            )
        }
    }
}
