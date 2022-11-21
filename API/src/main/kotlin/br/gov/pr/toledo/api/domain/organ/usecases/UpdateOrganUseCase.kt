package br.gov.pr.toledo.api.domain.organ.usecases

import br.gov.pr.toledo.api.domain.organ.model.IdOrgan
import br.gov.pr.toledo.api.domain.organ.model.Organ

interface UpdateOrganUseCase {
    fun execute(idOrgan: IdOrgan, transformation: (Organ) -> Organ)
}