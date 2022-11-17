package br.gov.pr.toledo.api.interfaces.rest.organ.impl

import br.gov.pr.toledo.api.domain.organ.service.OrganService
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganDTO
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganResource
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganSummaryDTO
import br.gov.pr.toledo.api.interfaces.rest.user.UserDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/organs")
class OrganResourceImpl (private val organService: OrganService) : OrganResource {
    @GetMapping
    @ApiResponses(ApiResponse(description = "ok.", responseCode = "200"))
    @Operation(description = "Retorna todas as secretarias cadastradas.")
    override fun list(): ResponseEntity<List<OrganSummaryDTO>> =
        ResponseEntity.ok(organService.findAll())

    @GetMapping("/{id}")
    @ApiResponses(
        ApiResponse(description = "ok.", responseCode = "200"),
        ApiResponse(description = "Caso não exista a secretaria.", responseCode = "404")
    )
    @Operation(description = "Retorna a secretaria a partir do ID informado.")
    override fun findById(@PathVariable id: Int): ResponseEntity<OrganDTO> =
        ResponseEntity.ok(organService.findById(id))
}
