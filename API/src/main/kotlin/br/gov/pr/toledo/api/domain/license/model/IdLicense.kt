package br.gov.pr.toledo.api.domain.license.model

import com.fasterxml.jackson.annotation.JsonValue
import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
data class IdLicense(@field:JsonValue var license_id: Int) : Serializable