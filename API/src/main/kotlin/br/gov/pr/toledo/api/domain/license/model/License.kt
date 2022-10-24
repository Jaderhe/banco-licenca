package br.gov.pr.toledo.api.domain.license.model

import br.gov.pr.toledo.api.domain.license.valueobjects.LicenseSituation
import br.gov.pr.toledo.api.domain.license.valueobjects.LicenseType
import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.domain.provider.model.Provider
import br.gov.pr.toledo.api.domain.software.model.Software
import br.gov.pr.toledo.api.domain.users.model.User
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "license")
class License (
    @EmbeddedId
    @Column(name = "license_id")
    val idLicense: IdLicense,
    @Column(name = "serial_key")
    val serialKey: String,
    @Column(name = "linked")
    val linked: String,
    @Column(name = "purchase")
    val purchase: LocalDate,
    @Column(name = "expiration")
    val expiration: LocalDate,
    @Column(name = "invoice")
    val invoice: String,
    @Column(name = "commit_note")
    val commitNote: String,
    @Column(name = "note")
    val note: String,
    @Column(name = "situation")
    val situation: LicenseSituation = LicenseSituation.FREE,
    @Column(name = "type")
    val type: LicenseType,
    @Column(name = "created_at")
    val createdAt: LocalDate,
    @Column(name = "updated_at")
    val updatedAt: LocalDate,

    @ManyToOne
    @JoinColumn(name = "provider_id")
    val provider: Provider,

    @ManyToOne
    @JoinColumn(name = "software_id")
    val software: Software,

    @ManyToOne
    @JoinColumn(name = "organ_id")
    val organ: Organ,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
    ) {

    private fun license (
        idLicense: IdLicense,
        serialKey: String,
        linked: String,
        purchase: LocalDate,
        expiration: LocalDate,
        invoice: String,
        commitNote: String,
        note: String,
        situation: LicenseSituation,
        type: LicenseType,
        createdAt: LocalDate,
        updatedAt: LocalDate,
        provider: Provider,
        software: Software,
        organ: Organ,
        user: User
    ) = License(
        idLicense,
        serialKey,
        linked,
        purchase,
        expiration,
        invoice,
        commitNote,
        note,
        situation,
        type,
        createdAt,
        updatedAt,
        provider,
        software,
        organ,
        user
    )
}