package br.gov.pr.toledo.api.interfaces.rest.organ.impl

import br.gov.pr.toledo.api.domain.organ.model.IdOrgan
import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.domain.organ.service.OrganService
import br.gov.pr.toledo.api.domain.user.service.UserService
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganDTO
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganResource
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganSaveDTO
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganSummaryDTO
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("/organs")
class OrganResourceImpl (private val organService: OrganService,
                         private val userService: UserService) : OrganResource {

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

    @PostMapping
    @ApiResponse(description = "ok.", responseCode = "201")
    @Operation(description = "Cria uma nova secretaria.")
    override fun create(@RequestBody organSaveDTO: OrganSaveDTO): ResponseEntity<Void> {

        val organCreated : Organ = organService.create(organSaveDTO.toModel(userService))
        val uri = ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(organCreated.organId.organ_id)
            .toUri()

        return ResponseEntity.created(uri).build()

    }

    @DeleteMapping("/{id}")
    @Operation(description = "Deleta uma secretaria.")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    override fun delete(@PathVariable("id") id: Int) {
        organService.delete(id = IdOrgan(id))
    }
}
