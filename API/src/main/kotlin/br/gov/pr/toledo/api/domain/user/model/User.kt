package br.gov.pr.toledo.api.domain.user.model

import br.gov.pr.toledo.api.domain.organ.model.Organ
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "users")
class User(
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
    val lastLogin: LocalDate?,
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    val createdAt: LocalDate,
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP")
    val updatedAt: LocalDate,
    @Column(name = "username", nullable = false)
    val username: String,
    @Column(name = "user_id_1", nullable = false)
    val userParent: Int,

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val organs: Collection<Organ>
    /*
    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    val providers : Collection<Provider>,

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    val softwares: Collection<Software>,

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    val licenses: Collection<License>,*/
    ) : Serializable {

        fun with(
            userId: IdUser = this.userId,
            name: String = this.name,
            email: String = this.email,
            isActive: Boolean = this.isActive,
            permission: String = this.permission,
            username: String = this.username,
            userParent: Int = this.userParent,
            lastLogin: LocalDate? = this.lastLogin,
            createdAt: LocalDate = this.createdAt,
            updatedAt: LocalDate = this.updatedAt,
            password: String = this.password,
            organs: Collection<Organ> = this.organs
        ) = copy(
            userId = userId,
            name = name,
            email = email,
            isActive = isActive,
            permission = permission,
            username = username,
            userParent = userParent,
            lastLogin = lastLogin,
            createdAt = createdAt,
            updatedAt = updatedAt,
            password = password,
            organs = organs
        )

        private fun copy(
            userId: IdUser = this.userId,
            name: String = this.name,
            email: String = this.email,
            isActive: Boolean = this.isActive,
            permission: String = this.permission,
            username: String = this.username,
            userParent: Int = this.userParent,
            lastLogin: LocalDate? = this.lastLogin,
            createdAt: LocalDate = this.createdAt,
            updatedAt: LocalDate = this.updatedAt,
            password: String = this.password,
            organs: Collection<Organ> = this.organs
        ) = User(
            userId = userId,
            name = name,
            email = email,
            isActive = isActive,
            permission = permission,
            username = username,
            userParent = userParent,
            lastLogin = lastLogin,
            createdAt = createdAt,
            updatedAt = updatedAt,
            password = password,
            organs = organs
        )
}