package br.gov.pr.toledo.api.domain.organ.usecases

import br.gov.pr.toledo.api.domain.organ.model.Organ

interface CreateOrganUseCase {
    fun execute(organ: Organ) : Organ
}