package net.happyfrozenfire.scmplayerblocking;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.happyfrozenfire.scmplayerblocking.json.BlockedPlayerMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

@Environment(EnvType.CLIENT)
public class Client implements ClientModInitializer
{
    public static final String KEY = Main.MOD_ID + "_client";

    /**	This logger is used to write text to the console and the log file.
     * 	It is considered best practice to use your mod id as the logger's name.
     * 	That way, it's clear which mod wrote info, warnings, and errors.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(KEY);
    
    public static BlockedPlayerMap BLOCKED_PLAYERS;
    public static String BLOCKED_PLAYERS_PATH = Main.MOD_ID + "/blocked_players.json";

    @Override
    public void onInitializeClient()
    {
        LOGGER.info("Initializing SCM Player Blocking Client...");
        
        new File(Main.MOD_ID).mkdirs();
        
        BLOCKED_PLAYERS = new BlockedPlayerMap();
        BLOCKED_PLAYERS.load(BLOCKED_PLAYERS_PATH);
        BLOCKED_PLAYERS.save(BLOCKED_PLAYERS_PATH);
        
        LOGGER.info("Initialized SCM Player Blocking Client.");
    }
}
