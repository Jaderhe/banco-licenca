package br.gov.pr.toledo.api.domain.provider.model

import br.gov.pr.toledo.api.domain.license.model.License
import br.gov.pr.toledo.api.domain.user.model.User
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "provider")
class Provider (
    @EmbeddedId
    @Column(name = "provider_id", nullable = false)
    val providerId: IdProvider,
    @Column(name = "company_name", nullable = false)
    val companyName: String,
    @Column(name = "cnpj", nullable = false)
    val cnpj: String,
    @Column(name = "contact")
    val contact: String,
    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP")
    val createdAt: LocalDate,
    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP")
    val updatedAt: LocalDate,

    @OneToMany(cascade = [CascadeType.PERSIST], fetch = FetchType.LAZY)
    @JoinColumn(name = "provider_id")
    val licenses: Collection<License>,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
    ) {

    private fun provider (
        providerId: IdProvider,
        companyName: String,
        cnpj: String,
        contact: String,
        createdAt: LocalDate,
        updatedAt: LocalDate,
        licenses: Collection<License>,
        user: User
    ) = Provider(providerId, companyName, cnpj, contact, createdAt, updatedAt, licenses, user)
}