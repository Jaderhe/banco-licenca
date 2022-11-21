package br.gov.pr.toledo.api.domain.organ.service

import br.gov.pr.toledo.api.domain.organ.model.IdOrgan
import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganDTO
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganSaveDTO
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganSummaryDTO

interface OrganService {

    fun list(): List<Organ>

    fun findAll(): List<OrganSummaryDTO>

    fun findById(id: IdOrgan): Organ

    fun findById(id: Int): OrganDTO

    fun create(organ: Organ): Organ

    fun delete(id: IdOrgan)

    fun update(id: IdOrgan, organSaveDTO: OrganSaveDTO)
}