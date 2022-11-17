package br.gov.pr.toledo.api.domain.organ.service.impl

import br.gov.pr.toledo.api.domain.organ.model.IdOrgan
import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.domain.organ.repository.OrganRepository
import br.gov.pr.toledo.api.domain.organ.service.OrganService
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganDTO
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganSummaryDTO
import org.springframework.stereotype.Service

@Service
class OrganServiceImpl (
    private val organRepository: OrganRepository
    ) : OrganService {

    override fun list(): List<Organ> = organRepository.findAll()

    override fun findAll(): List<OrganSummaryDTO> = list().map(OrganSummaryDTO::toDTO)

    override fun findById(id: IdOrgan): Organ = organRepository.findById(id).orElseThrow { RuntimeException("User not found") }

    override fun findById(id: Int): OrganDTO {
        return OrganDTO.toDTO(findById(IdOrgan(id)))
    }
}
