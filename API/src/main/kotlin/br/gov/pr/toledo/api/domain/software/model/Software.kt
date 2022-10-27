package br.gov.pr.toledo.api.domain.software.model

import br.gov.pr.toledo.api.domain.license.model.License
import br.gov.pr.toledo.api.domain.user.model.User
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "software")
class Software (
    @EmbeddedId
    @Column(name = "software_id", nullable = false)
    val softwareId: IdSoftware,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    val createdAt: LocalDate,
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP")
    val updatedAt: LocalDate,


    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "software_id")
    val licenses: Collection<License>,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
    ) : Serializable {

    private fun software (
        softwareId: IdSoftware,
        name: String,
        createdAt: LocalDate,
        updatedAt: LocalDate,
        licenses: Collection<License>,
        user: User
    ) = Software(softwareId, name, createdAt, updatedAt, licenses, user)
}