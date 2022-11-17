package br.gov.pr.toledo.api.domain.organ.model

import br.gov.pr.toledo.api.domain.license.model.License
import br.gov.pr.toledo.api.domain.user.model.User
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "organ")
class Organ (
    @EmbeddedId
    @Column(name = "organ_id", nullable = false)
    val organId: IdOrgan,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    val createdAt: LocalDate,
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP")
    val updatedAt: LocalDate,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "organ_id")
    val licenses: Collection<License>,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
    ) : Serializable {
        fun with(
            organId: IdOrgan = this.organId,
            name: String = this.name,
            createdAt: LocalDate = this.createdAt,
            updatedAt: LocalDate = this.updatedAt,
            licenses: Collection<License> = this.licenses,
            user: User = this.user
        ) = copy(
            organId = organId,
            name = name,
            createdAt = createdAt,
            updatedAt = updatedAt,
            licenses = licenses,
            user = user
        )

        private fun copy(
            organId: IdOrgan,
            name: String,
            createdAt: LocalDate,
            updatedAt: LocalDate,
            licenses: Collection<License>,
            user: User
        ) = Organ(
            organId = organId,
            name = name,
            createdAt = createdAt,
            updatedAt = updatedAt,
            licenses = licenses,
            user = user
        )
    }