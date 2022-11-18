package br.gov.pr.toledo.api.domain.organ.usecases.impl

import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.domain.organ.repository.OrganRepository
import br.gov.pr.toledo.api.domain.organ.usecases.CreateOrganUseCase
import org.springframework.stereotype.Service

@Service
class CreateOrganUseCaseImpl (private val organRepository: OrganRepository) : CreateOrganUseCase {

    override fun execute(organ: Organ) : Organ {
        if (organRepository.existsById(organ.organId)) {
            throw RuntimeException("Organ already exists")
        }
        return organRepository.save(organ)
    }
}