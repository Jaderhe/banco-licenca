package br.gov.pr.toledo.api.domain.software.model

import com.fasterxml.jackson.annotation.JsonValue
import java.io.Serializable
import java.util.*
import javax.persistence.Embeddable

@Embeddable
data class IdSoftware(@field:JsonValue var software_id: Int) : Serializable