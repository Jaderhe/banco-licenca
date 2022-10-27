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

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "organ_id")
    val licenses: Collection<License>,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
    ) : Serializable {

    private fun organ (
        organId: IdOrgan,
        name: String,
        createdAt: LocalDate,
        updatedAt: LocalDate,
        licenses: Collection<License>,
        user: User
    ) = Organ(organId, name, createdAt, updatedAt, licenses, user)
}