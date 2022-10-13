package br.gov.pr.toledo.API.domain.license.model

import javax.persistence.*
import javax.persistence.Entity

@Entity
class License (
    @EmbeddedId
    val idLicense: IdLicense
        ) {
}