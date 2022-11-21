package br.gov.pr.toledo.api.domain.organ.usecases.impl

import br.gov.pr.toledo.api.domain.organ.model.IdOrgan
import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.domain.organ.repository.OrganRepository
import br.gov.pr.toledo.api.domain.organ.usecases.UpdateOrganUseCase
import org.springframework.stereotype.Service

@Service
class UpdateOrganUseCaseImpl (private val organRepository: OrganRepository) : UpdateOrganUseCase {

    override fun execute(idOrgan: IdOrgan, transformation: (Organ) -> Organ) {
        val organ = organRepository.findById(idOrgan).orElseThrow { RuntimeException("User not found") }
        organRepository.save(transformation(organ).with(organId = idOrgan))
    }
}
