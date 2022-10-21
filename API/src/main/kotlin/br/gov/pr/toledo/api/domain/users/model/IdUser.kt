package br.gov.pr.toledo.api.domain.users.model

import com.fasterxml.jackson.annotation.JsonValue
import java.io.Serializable
import java.util.UUID
import javax.persistence.Embeddable

@Embeddable
data class IdUser(@field:JsonValue var id: UUID = UUID.randomUUID()) : Serializable