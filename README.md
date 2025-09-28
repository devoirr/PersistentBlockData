
# Persistent Block Data

A simple utility for storing persistent data chained to blocks in paper plugins using PersistentDataContainer.

The utility is literally **31 lines** long so you can just copy the code you need. If you don't wish to copy any code you can just shade the lib into your plugin, or even just install it as a separate plugin on your server.

# Usage

You can write data as if you are just interacting with PersistentDataContainer.

```kotlin
import dev.devoirr.pbd.Blocks.getPersistentData
import dev.devoirr.pbd.Blocks.setPersistentData
import org.bukkit.NamespacedKey
import org.bukkit.block.Block
import org.bukkit.persistence.PersistentDataType

val key = NamespacedKey.minecraft("current_clicks")

fun addAndReturnClicks(block: Block): Int {
    val currentClicks = block.getPersistentData(key, PersistentDataType.INTEGER) as? Int ?: 0
    val updatedClicks = currentClicks + 1

    block.setPersistentData(key, PersistentDataType.INTEGER, updatedClicks)

    return updatedClicks
}
```

It's that simple.
You need to take into account that the NamespacedKey has limited length (32768 symbols), and the lib adds blocks coordinates to the initial provided key, so don't use ridiculously long keys, otherwise it will break.
