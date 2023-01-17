package net.happyfrozenfire.scmplayerblocking;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SCMPlayerBlocking implements ModInitializer
{
    public static final String MOD_ID = "scm-player-blocking";

    /** This logger is used to write text to the console and the log file.
     * It is considered best practice to use your mod id as the logger's name.
     * That way, it's clear which mod wrote info, warnings, and errors.
     */
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    //TODO remove temporary test item
    public static final Item TEST_ITEM = new Item(new FabricItemSettings());

    @Override
    public void onInitialize()
    {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.

        LOGGER.info("Hello Fabric world!");

        //TODO remove temporary test item
        Registry.register(Registry.ITEM, new Identifier("scm-player-blocking", "test_item"), TEST_ITEM);
    }
}
