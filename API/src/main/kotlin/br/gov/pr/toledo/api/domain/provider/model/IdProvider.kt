package br.gov.pr.toledo.api.domain.provider.model

import com.fasterxml.jackson.annotation.JsonValue
import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
data class IdProvider(@field:JsonValue var provider_id: Int) : Serializable