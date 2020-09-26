package icecream.parlor.domain.usecase.impl

import icecream.parlor.domain.abstraction.IceCreamsRepository
import icecream.parlor.domain.usecase.GetAllIceCreams

class GetAllIceCreamsUseCase(
    private val repository: IceCreamsRepository
) : GetAllIceCreams {
    override fun execute() = repository.getAll()
}