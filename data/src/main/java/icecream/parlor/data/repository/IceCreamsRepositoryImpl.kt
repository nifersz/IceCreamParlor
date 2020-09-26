package icecream.parlor.data.repository

import icecream.parlor.data.datasource.IceCreamsNetworkDataSource
import icecream.parlor.domain.abstraction.IceCreamsRepository

class IceCreamsRepositoryImpl(
    private val networkDataSource: IceCreamsNetworkDataSource
) : IceCreamsRepository {
    override fun getAll() = networkDataSource.getData()
}