package br.gov.pr.toledo.api.domain.user.repository

import br.gov.pr.toledo.api.domain.user.model.IdUser
import br.gov.pr.toledo.api.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, IdUser> {
}