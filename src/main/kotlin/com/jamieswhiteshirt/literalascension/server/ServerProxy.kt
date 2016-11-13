package com.jamieswhiteshirt.literalascension.server

import com.jamieswhiteshirt.literalascension.Features
import com.jamieswhiteshirt.literalascension.common.CommonProxy
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper

class ServerProxy : CommonProxy() {
    override fun preInit(features: Features, messageHandler: SimpleNetworkWrapper) {
        super.preInit(features, messageHandler)
        features.registerServerMessages(messageHandler)
    }
}
