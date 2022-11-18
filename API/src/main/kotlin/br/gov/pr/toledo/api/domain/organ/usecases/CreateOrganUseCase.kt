package br.gov.pr.toledo.api.domain.organ.usecases

import br.gov.pr.toledo.api.domain.organ.model.Organ
import org.springframework.stereotype.Service

@Service
interface CreateOrganUseCase {

    fun execute(organ: Organ) : Organ

}