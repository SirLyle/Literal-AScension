package com.jamieswhiteshirt.literalascension.common.features.stepladderdomains

import com.jamieswhiteshirt.literalascension.common.features.Stepladders
import com.jamieswhiteshirt.literalascension.common.features.stepladderdomains.stepladder.StepladderWood
import net.minecraft.block.Block
import net.minecraftforge.common.config.Configuration

class StepladderDomainBiomesOPlenty(config: Configuration, parent: Stepladders) : StepladderDomain("biomesoplenty", parent) {
    private val planksBlocks = arrayOf(Block.getBlockFromName("biomesoplenty:planks_0"))
    private val logBlocks = arrayOf(
            Block.getBlockFromName("biomesoplenty:log_0"),
            Block.getBlockFromName("biomesoplenty:log_1"),
            Block.getBlockFromName("biomesoplenty:log_2"),
            Block.getBlockFromName("biomesoplenty:log_3")
    )

    val SACRED_OAK = optionalBOP(config,  0, "sacred_oak")
    val CHERRY =     optionalBOP(config,  1, "cherry")
    val UMBRAN =     optionalBOP(config,  2, "umbran")
    val FIR =        optionalBOP(config,  3, "fir")
    val ETHEREAL =   optionalBOP(config,  4, "ethereal")
    val MAGIC =      optionalBOP(config,  5, "magic")
    val MANGROVE =   optionalBOP(config,  6, "mangrove")
    val PALM =       optionalBOP(config,  7, "palm")
    val REDWOOD =    optionalBOP(config,  8, "redwood")
    val WILLOW =     optionalBOP(config,  9, "willow")
    val PINE =       optionalBOP(config, 10, "pine")
    val HELLBARK =   optionalBOP(config, 11, "hellbark")
    val JACARANDA =  optionalBOP(config, 12, "jacaranda")
    val MAHOGANY =   optionalBOP(config, 13, "mahogany")
    val EBONY =      optionalBOP(config, 14, "ebony")
    val EUCALYPTUS = optionalBOP(config, 15, "eucalyptus")

    fun optionalBOP(config: Configuration, metadata: Int, name: String): StepladderWood? {
        val planksBlock = planksBlocks[metadata / 16]
        val logBlock = logBlocks[metadata / 4]
        if (planksBlock != null && logBlock != null) {
            @Suppress("DEPRECATION")
            return optionalOn(config, StepladderWood(logBlock.getStateFromMeta(metadata % 4 + 4), planksBlock.getStateFromMeta(metadata % 16), name, this))
        }
        return null
    }
}
