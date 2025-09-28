package dev.devoirr.pbd

import net.kyori.adventure.text.Component
import org.bukkit.plugin.java.JavaPlugin

class PBDLoader : JavaPlugin() {

    override fun onEnable() = componentLogger.info(
        Component.text("PBD Enabled!")
    )

    override fun onDisable() = componentLogger.info(
        Component.text("PBD Disabled!")
    )

}