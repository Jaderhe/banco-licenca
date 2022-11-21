package br.gov.pr.toledo.api.interfaces.rest.organ

import org.springframework.http.ResponseEntity

interface OrganResource {
    fun list(): ResponseEntity<List<OrganSummaryDTO>>

    fun findById(id: Int): ResponseEntity<OrganDTO>

    fun create(organ: OrganSaveDTO): ResponseEntity<Void>

    fun update(id: Int, organSaveDTO: OrganSaveDTO)

    fun delete(id: Int)

}