package br.gov.pr.toledo.api.domain.license.model

import javax.persistence.*

@Entity
@Table(name = "license")
class License (
    @EmbeddedId
    @Column(name = "license_id")
    val idLicense: IdLicense
        ) {
}