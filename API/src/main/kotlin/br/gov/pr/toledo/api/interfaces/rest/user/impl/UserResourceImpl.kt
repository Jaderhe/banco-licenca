package br.gov.pr.toledo.api.interfaces.rest.user.impl

import br.gov.pr.toledo.api.domain.user.service.UserService
import br.gov.pr.toledo.api.interfaces.rest.user.UserResource
import br.gov.pr.toledo.api.interfaces.rest.user.UserSummaryDTO
import org.springframework.http.ResponseEntity
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserResourceImpl (private val service : UserService) : UserResource {
    @GetMapping
    @ApiResponses(ApiResponse(description = "ok.", responseCode = "200"))
    override fun findAll(): ResponseEntity<List<UserSummaryDTO>> = ResponseEntity.ok(service.findAll())
}
