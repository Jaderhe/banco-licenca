package br.gov.pr.toledo.api.domain.organ.service.impl

import br.gov.pr.toledo.api.domain.organ.model.IdOrgan
import br.gov.pr.toledo.api.domain.organ.model.Organ
import br.gov.pr.toledo.api.domain.organ.repository.OrganRepository
import br.gov.pr.toledo.api.domain.organ.service.OrganService
import br.gov.pr.toledo.api.domain.organ.usecases.CreateOrganUseCase
import br.gov.pr.toledo.api.domain.organ.usecases.DeleteOrganUseCase
import br.gov.pr.toledo.api.domain.organ.usecases.UpdateOrganUseCase
import br.gov.pr.toledo.api.domain.user.service.UserService
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganDTO
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganSaveDTO
import br.gov.pr.toledo.api.interfaces.rest.organ.OrganSummaryDTO
import org.springframework.stereotype.Service

@Service
class OrganServiceImpl (
    private val createOrganUseCase: CreateOrganUseCase,
    private val deleteOrganUseCase: DeleteOrganUseCase,
    private val updateOrganUseCase: UpdateOrganUseCase,
    private val organRepository: OrganRepository,
    private val userService: UserService
    ) : OrganService {

    override fun list(): List<Organ> = organRepository.findAll()

    override fun findAll(): List<OrganSummaryDTO> = list().map(OrganSummaryDTO::toDTO)

    override fun findById(id: IdOrgan): Organ = organRepository.findById(id).orElseThrow {
        RuntimeException("Organ not found")
    }

    override fun findById(id: Int): OrganDTO = OrganDTO.toDTO(findById(IdOrgan(id)))

    override fun create(organ: Organ): Organ =  createOrganUseCase.execute(organ)

    override fun delete(id: IdOrgan) = deleteOrganUseCase.execute(id)

    override fun update(id: IdOrgan, organSaveDTO: OrganSaveDTO) {
        updateOrganUseCase.execute(id) {
            it.with(
                name = organSaveDTO.name,
                createdAt = organSaveDTO.createdAt,
                updatedAt = organSaveDTO.updatedAt,
                licenses = organSaveDTO.licenses,
                user = organSaveDTO.user.toModel(userService)
            )
        }
    }
}
