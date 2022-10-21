package br.gov.pr.toledo.api.domain.users.model

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
    @Column(name = "email", nullable = false)
    val email: String,
    @Column(name = "password", nullable = false)
    val password: String,
    @Column(name = "isactive", nullable = false)
    val isActive: Boolean,
    @Column(name = "permission", nullable = false)
    val permission: String,
    @Column(name = "lastlogin", nullable = true)
    val lastlogin: LocalDate,
    @Column(name = "created_at", nullable = false)
    val createdAt: LocalDate,
    @Column(name = "updated_at", nullable = false)
    val updatedAt: LocalDate,
    @Column(name = "username", nullable = false)
    val username: String,

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_1", referencedColumnName = "user_id")
    val userId1: User

    //@OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)

        ) {
}