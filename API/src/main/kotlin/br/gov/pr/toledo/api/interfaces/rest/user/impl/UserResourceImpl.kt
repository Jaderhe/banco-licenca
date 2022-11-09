package br.gov.pr.toledo.api.interfaces.rest.user.impl

import br.gov.pr.toledo.api.domain.user.model.User
import br.gov.pr.toledo.api.domain.user.service.UserService
import br.gov.pr.toledo.api.interfaces.rest.user.UserDTO
import br.gov.pr.toledo.api.interfaces.rest.user.UserResource
import br.gov.pr.toledo.api.interfaces.rest.user.UserSummaryDTO
import br.gov.pr.toledo.api.interfaces.rest.user.UserSummaryDTO.Companion.toDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/users")
class UserResourceImpl (private val service : UserService) : UserResource {
    @GetMapping
    @ApiResponses(ApiResponse(description = "ok.", responseCode = "200"))
    @Operation(description = "Retorna todas os usuários cadastrados.")
    override fun lista(): ResponseEntity<List<UserSummaryDTO>> =
        ResponseEntity.ok(service.findAll())


    @GetMapping("/{id}")
    @ApiResponses(
        ApiResponse(description = "ok.", responseCode = "200"),
        ApiResponse(description = "Caso não exista o usuário.", responseCode = "404")
    )
    @Operation(description = "Retorna o usuário a partir do ID informado.")
    override fun findById(@PathVariable id: Int): ResponseEntity<UserDTO> =
        ResponseEntity.ok(service.findById(id))

/*
    @PostMapping
    @ApiResponse(description = "ok.", responseCode = "201")
    @Operation(description = "Cria um novo usuário.")
    override fun create(@RequestBody user: User): ResponseEntity<Void> {

        val userCreated : User = service.create(user)
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userCreated.userId.user_id)
            .toUri()

        return ResponseEntity.created(uri).build()

    }*/

    @PostMapping
    @ApiResponse(description = "ok.", responseCode = "201")
    @Operation(description = "Cria um novo usuário.")
    override fun create(@RequestBody userDTO: UserDTO): ResponseEntity<Void> {

        //val user2 : User = userDTO.toModel()
        val userCreated : User = service.create(userDTO.toModel())
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(userCreated.userId.user_id)
            .toUri()

        return ResponseEntity.created(uri).build()

    }
}
