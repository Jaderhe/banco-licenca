package br.gov.pr.toledo.api.domain.user.model

import br.gov.pr.toledo.api.domain.license.model.License
import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.domain.provider.model.Provider
import br.gov.pr.toledo.api.domain.software.model.Software
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "users")
class User (
    @EmbeddedId
    @Column(name = "user_id")
    val userId: IdUser,
    @Column(name = "name", nullable = false)
    val name: String,
    @Column(name = "email")
    val email: String,
    @Column(name = "password", nullable = false)
    val password: String,
    @Column(name = "isactive", nullable = false)
    val isActive: Boolean,
    @Column(name = "permission", nullable = false)
    val permission: String,
    @Column(name = "lastlogin", nullable = true, columnDefinition = "TIMESTAMP")
    val lastlogin: LocalDate,
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    val createdAt: LocalDate,
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP")
    val updatedAt: LocalDate,
    @Column(name = "username", nullable = false)
    val username: String,

    //Auto-relationship with User
    @ManyToOne(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_1", referencedColumnName = "user_id")
    val userId1: User,

    //Auto-relationship with User
    @OneToMany(/*mappedBy = "userId1", */cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id_1")
    val users: Collection<User>,

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val organs: Collection<Organ>,

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val providers : Collection<Provider>,

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val softwares: Collection<Software>,

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val licenses: Collection<License>,
    ) : Serializable {

    private fun user (
        userId: IdUser,
        name: String,
        email: String,
        password: String,
        isActive: Boolean,
        permission: String,
        lastlogin: LocalDate,
        createdAt: LocalDate,
        updatedAt: LocalDate,
        username: String,
        userId1: User,
        users: Collection<User>,
        organs: Collection<Organ>,
        providers: Collection<Provider>,
        softwares: Collection<Software>,
        licenses: Collection<License>,
    ) = User(
        userId,
        name,
        email,
        password,
        isActive,
        permission,
        lastlogin,
        createdAt,
        updatedAt,
        username,
        userId1,
        users,
        organs,
        providers,
        softwares,
        licenses,
    )
}