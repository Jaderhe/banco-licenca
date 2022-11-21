package br.gov.pr.toledo.api.interfaces.rest.organ

import br.gov.pr.toledo.api.domain.license.model.License
import br.gov.pr.toledo.api.domain.organ.model.IdOrgan
import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.domain.organ.service.OrganService
import br.gov.pr.toledo.api.domain.user.service.UserService
import br.gov.pr.toledo.api.interfaces.rest.user.UserDTO
import br.gov.pr.toledo.api.interfaces.rest.user.UserSummaryDTO
import com.fasterxml.jackson.annotation.JsonIgnore
import java.time.LocalDate

data class OrganDTO(
    val organId : IdOrgan,
    val name : String,
    val createdAt : LocalDate,
    val updatedAt : LocalDate,
    val user : UserSummaryDTO,
    @JsonIgnore
    val licenses : Collection<License> = emptyList()
) {

    companion object {
        fun toDTO(organ: Organ) = OrganDTO(
            organ.organId,
            organ.name,
            organ.createdAt,
            organ.updatedAt,
            UserSummaryDTO.toDTO(organ.user),
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

data class OrganSaveDTO(
    val organId : IdOrgan,
    val name : String,
    val createdAt : LocalDate,
    val updatedAt : LocalDate,
    val user : UserSummaryDTO,
    @JsonIgnore
    val licenses : Collection<License> = emptyList()
) {

    fun toModel(userService: UserService) = Organ (
        organId = this.organId,
        name = this.name,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt,
        licenses = this.licenses,
        user = userService.findById(this.user.userId)
    )
}