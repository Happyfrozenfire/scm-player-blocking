package net.happyfrozenfire.scmplayerblocking;

import net.fabricmc.api.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Client implements ClientModInitializer
{
    public static final String KEY = Main.MOD_ID + "_client";

    /**	This logger is used to write text to the console and the log file.
     * 	It is considered best practice to use your mod id as the logger's name.
     * 	That way, it's clear which mod wrote info, warnings, and errors.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(KEY);

    @Override
    public void onInitializeClient()
    {
        LOGGER.info("Initializing SCM Player Blocking Client...");

        LOGGER.info("Initialized SCM Player Blocking Client.");
    }
}
