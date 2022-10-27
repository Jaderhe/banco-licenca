package br.gov.pr.toledo.api.interfaces.rest.user.impl

import br.gov.pr.toledo.api.domain.user.model.IdUser
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
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

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
}