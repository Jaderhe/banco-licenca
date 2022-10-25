package br.gov.pr.toledo.api.domain.organ.model

import com.fasterxml.jackson.annotation.JsonValue
import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
data class IdOrgan(@field:JsonValue var organ_id: Int) : Serializable