package br.gov.pr.toledo.api.domain.organ.repository

import br.gov.pr.toledo.api.domain.organ.model.IdOrgan
import br.gov.pr.toledo.api.domain.organ.model.Organ
import org.springframework.data.jpa.repository.JpaRepository

interface OrganRepository : JpaRepository<Organ, IdOrgan> {
}