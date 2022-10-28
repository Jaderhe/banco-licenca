package br.gov.pr.toledo.api.domain.user.model

import br.gov.pr.toledo.api.domain.license.model.License
import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.domain.provider.model.Provider
import br.gov.pr.toledo.api.domain.software.model.Software
import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
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
    @Column(name = "email", nullable = true)
    val email: String,
    @Column(name = "password", nullable = false)
    val password: String,
    @Column(name = "isactive", nullable = false)
    val isActive: Boolean,
    @Column(name = "permission", nullable = false)
    val permission: String,
    @Column(name = "lastlogin", nullable = true, columnDefinition = "TIMESTAMP")
    val lastlogin: LocalDate?,
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    val createdAt: LocalDate,
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP")
    val updatedAt: LocalDate,
    @Column(name = "username", nullable = false)
    val username: String,

    //Auto-relationship with User
    @ManyToOne(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_1", referencedColumnName = "user_id", nullable = true)
    val userParent: User,

    //Auto-relationship with User
    @OneToMany(/*mappedBy = "userParent", */cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id_1", nullable = true)
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

    private fun copy (
        userId: IdUser = this.userId,
        name: String = this.name,
        email: String = this.email,
        password: String = this.password,
        isActive: Boolean = this.isActive,
        permission: String = this.permission,
        lastlogin: LocalDate? = this.lastlogin,
        createdAt: LocalDate = this.createdAt,
        updatedAt: LocalDate = this.updatedAt,
        username: String = this.username,
        userParent: User = this.userParent,
        users: Collection<User> = this.users,
        organs: Collection<Organ> = this.organs,
        providers: Collection<Provider> = this.providers,
        softwares: Collection<Software> = this.softwares,
        licenses: Collection<License> = this.licenses,
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
        userParent,
        users,
        organs,
        providers,
        softwares,
        licenses,
    )
}