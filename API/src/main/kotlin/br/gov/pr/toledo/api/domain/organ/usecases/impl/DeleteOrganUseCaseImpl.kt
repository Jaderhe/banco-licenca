package br.gov.pr.toledo.api.domain.organ.usecases.impl

import br.gov.pr.toledo.api.domain.organ.model.IdOrgan
import br.gov.pr.toledo.api.domain.organ.repository.OrganRepository
import br.gov.pr.toledo.api.domain.organ.usecases.DeleteOrganUseCase
import org.springframework.stereotype.Service

@Service
class DeleteOrganUseCaseImpl (private val organRepository : OrganRepository) : DeleteOrganUseCase {

    override fun execute(id: IdOrgan) {
        val organ = organRepository.findById(id).orElseThrow{ RuntimeException("User not found") }
        return organRepository.delete(organ)
    }
}