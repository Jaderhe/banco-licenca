package br.gov.pr.toledo.api.domain.user.model

import com.fasterxml.jackson.annotation.JsonValue
import java.io.Serializable
import javax.persistence.Embeddable

@Embeddable
data class IdUser(@field:JsonValue var user_id: Int) : Serializable