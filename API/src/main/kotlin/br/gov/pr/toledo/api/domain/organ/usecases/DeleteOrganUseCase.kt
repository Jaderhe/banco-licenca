package br.gov.pr.toledo.api.domain.organ.usecases

import br.gov.pr.toledo.api.domain.organ.model.IdOrgan

interface DeleteOrganUseCase {
    fun execute(id : IdOrgan)
}