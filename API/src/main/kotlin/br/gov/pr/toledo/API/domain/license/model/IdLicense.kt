package br.gov.pr.toledo.API.domain.license.model

import com.fasterxml.jackson.annotation.JsonValue
import java.io.Serializable
import javax.persistence.Embeddable

@Embeddable
data class IdLicense(@field:JsonValue var id: Int) : Serializable