package br.gov.pr.toledo.api.interfaces.rest.organ

import br.gov.pr.toledo.api.domain.license.model.License
import br.gov.pr.toledo.api.domain.organ.model.IdOrgan
import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate

data class OrganDTO(
    val organId : IdOrgan,
    val name : String,
    val createdAt : LocalDate,
    val updatedAt : LocalDate,
    val user : User,
    @JsonIgnore
    val licenses : Collection<License> = emptyList()
) {
    fun toModel() = Organ (
        organId = this.organId,
        name = this.name,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
        user = this.user,
        licenses = this.licenses
    )

    companion object {
        fun toDTO(organ: Organ) = OrganDTO(
            organ.organId,
            organ.name,
            organ.createdAt,
            organ.updatedAt,
            organ.user,
            organ.licenses
        )
    }
}

data class OrganSummaryDTO(
    val organId : IdOrgan,
    val name : String,
) {
    companion object {
        fun toDTO(organ: Organ) = OrganSummaryDTO(
            organId = organ.organId,
            name = organ.name
        )
    }
}