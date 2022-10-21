package br.gov.pr.toledo.api.domain.software.model

import br.gov.pr.toledo.api.domain.users.model.User
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "software")
class Software (
    @EmbeddedId
    @Column(name = "software_id")
    val softwareId: IdSoftware,
    @Column(name = "name")
    val name: String,
    @Column(name = "created_at")
    val createdAt: LocalDate,
    @Column(name = "updated_at")
    val updatedAt: LocalDate,

    /*
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "ID")
    private Teacher teacher;*/

    // finalizar relacionamento com user
    ) {
}