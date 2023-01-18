package net.happyfrozenfire.scmplayerblocking.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.happyfrozenfire.scmplayerblocking.Client;
import net.happyfrozenfire.scmplayerblocking.Main;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class BlockedPlayerMap
{
    public static class BlockedPlayerSettings
    {
        public boolean censorName = false;
        public boolean censorSkin = true;
        public boolean blockMessages = true;
        public boolean hideMessages = false;
        public boolean hidePlayer = false;
    }

    public int version = 1;
    public HashMap<String, BlockedPlayerSettings> blockedPlayers = new HashMap<>();

    public BlockedPlayerMap()
    {
    
    }
    
    
    @Environment(EnvType.CLIENT)
    /** Saves blocked_players.json
     *
     * @param path
     */
    public void save(String path)
    {
        Gson gson = new Gson();
        String content = gson.toJson(this);
        
        try
        {
            File file = new File(path);
            FileWriter writer = new FileWriter(file);
            writer.write(content);
            writer.close();
            Client.LOGGER.info("Successfully saved blocked_players.json");
        }
        catch(Exception e)
        {
            Client.LOGGER.error("FAILED TO WRITE TO FILE AT " + path, e);
        }
    }

    @Environment(EnvType.CLIENT)
    /** Loads blocked_players.json
     *
     * @param path
     */
    public void load(String path) //TODO implement
    {
        Gson gson = new Gson();
        try
        {
            File file = new File(path);
            Scanner reader = new Scanner(file);
            String content = "";
            while(reader.hasNextLine())
            {
                content += reader.nextLine();
            }
            BlockedPlayerMap other = gson.fromJson(content, BlockedPlayerMap.class);
            importSettings(other);
        }
        catch(Exception e)
        {
            Client.LOGGER.error("FAILED TO READ FILE AT " + path, e);
        }
    }
    
    /** Imports data from another instance, doing version fuckery as necessary.
     *  Essentially, it's future-proofing.
     */
    private void importSettings(@NotNull BlockedPlayerMap other)
    {
        blockedPlayers = other.blockedPlayers;
    }
    
    /** Blocks a player by their username.
     *
     * @param player A username
     */
    public void blockPlayer(String player)
    {
        blockPlayer(player, false);
    }
    
    /** Blocks a player by their username or UUID.
     *
     * @param player A username or UUID
     * @param isUUID Clarifies if player is a username or UUID
     */
    public void blockPlayer(String player, boolean isUUID)
    {
        if(!isUUID)
        {
            //TODO get UUID from username and set player to the result
        }
        
        blockedPlayers.put(player, new BlockedPlayerSettings());
    }
    
    /** Unblocks a player by their UUID
     *
     * @param player
     */
    public void unblockPlayer(String player)
    {
        blockedPlayers.remove(player);
    }
}
