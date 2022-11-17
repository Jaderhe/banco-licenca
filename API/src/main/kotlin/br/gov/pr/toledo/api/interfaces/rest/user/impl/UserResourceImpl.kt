package br.gov.pr.toledo.api.interfaces.rest.user.impl

import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User
import br.gov.pr.toledo.api.domain.user.service.UserService
import br.gov.pr.toledo.api.interfaces.rest.user.UserDTO
import br.gov.pr.toledo.api.interfaces.rest.user.UserResource
import br.gov.pr.toledo.api.interfaces.rest.user.UserSummaryDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/users")
class UserResourceImpl (private val userService : UserService) : UserResource {
    @GetMapping
    @ApiResponses(ApiResponse(description = "ok.", responseCode = "200"))
    @Operation(description = "Retorna todas os usuários cadastrados.")
    override fun list(): ResponseEntity<List<UserSummaryDTO>> =
        ResponseEntity.ok(userService.findAll())


    @GetMapping("/{id}")
    @ApiResponses(
        ApiResponse(description = "ok.", responseCode = "200"),
        ApiResponse(description = "Caso não exista o usuário.", responseCode = "404")
    )
    @Operation(description = "Retorna o usuário a partir do ID informado.")
    override fun findById(@PathVariable id: Int): ResponseEntity<UserDTO> =
        ResponseEntity.ok(userService.findById(id))


    @PostMapping
    @ApiResponse(description = "ok.", responseCode = "201")
    @Operation(description = "Cria um novo usuário.")
    override fun create(@RequestBody userDTO: UserDTO): ResponseEntity<Void> {

        val userCreated : User = userService.create(userDTO.toModel())
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userCreated.userId.user_id)
            .toUri()

        return ResponseEntity.created(uri).build()

    }

    @PutMapping("/{id}")
    @Operation(description = "Atualiza o usuário a partir do ID informado.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun update(@PathVariable id: Int, @RequestBody userDTO: UserDTO) {
        userService.update(id = IdUser(id), userDTO = userDTO)
    }


    @DeleteMapping("/{id}")
    @Operation(description = "Deleta um usuário.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun delete(@PathVariable("id") id: Int) {
        userService.delete(id = IdUser(id))
    }
}
