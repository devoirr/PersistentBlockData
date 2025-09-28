package dev.devoirr.pbd

import org.bukkit.NamespacedKey
import org.bukkit.block.Block
import org.bukkit.persistence.PersistentDataType

object Blocks {

    fun Block.getPersistentData(key: NamespacedKey, dataType: PersistentDataType<*, *>): Any? {
        val newKey = createKey(key)
        return chunk.persistentDataContainer.get(newKey, dataType)
    }

    @Suppress("UNCHECKED_CAST")
    fun <P, C> Block.setPersistentData(
        key: NamespacedKey,
        dataType: PersistentDataType<P, C>,
        value: C,
    ) {
        val newKey = createKey(key)
        chunk.persistentDataContainer.set(newKey, dataType, value as (C & Any))
    }

    fun Block.hasPersistentData(key: NamespacedKey) = chunk.persistentDataContainer.has(createKey(key))

    // The limit for key length in paper is 32768 (Short.MAX_VALUE)
    // so adding coordinates really shouldn't cause problems.
    private fun Block.createKey(key: NamespacedKey): NamespacedKey {
        val namespace = key.namespace
        val keyValue = key.key

        val newKeyValue = "${keyValue}_${x}_${y}_${z}"

        val newKey = NamespacedKey(namespace, newKeyValue)
        return newKey
    }

}