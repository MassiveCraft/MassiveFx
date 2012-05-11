package com.massivecraft.massivefx.fx;

import java.util.HashSet;
import java.util.Map;

import net.minecraft.server.ChunkPosition;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.Packet60Explosion;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.craftbukkit.CraftWorld;

import com.massivecraft.massivefx.Conf;

public class TntFx extends BaseFx
{
	private TntFx(String id, boolean visual, boolean sound, Map<String, Integer> alias2datas, String description, String... names)
	{
		super(id, visual, sound, alias2datas, description, names);
	}

	@Override
	public void playAt(Location location, int data)
	{
		fakeExplosion(location);
	}
	
	public static final TntFx instance = new TntFx("MASSIVEFX_TNT", true, true, null, "Non-damaging tnt explosion", "tnt", "tntexplosion", "explostion");
	
	// -------------------------------------------- //
	// TNT PACKET UTILS
	// -------------------------------------------- //
	
	public static void fakeExplosion(Location location)
	{
		HashSet<ChunkPosition> chunkPositions = new HashSet<ChunkPosition>();
		Packet60Explosion packet = new Packet60Explosion(location.getX(),location.getY(), location.getZ(), 0.1f, chunkPositions);
		CraftServer craftServer = (CraftServer) Bukkit.getServer();
		MinecraftServer minecraftServer = craftServer.getServer();
		minecraftServer.serverConfigurationManager.sendPacketNearby(location.getX(), location.getY(), location.getZ(), Conf.fxBlockViewDistanceUnlimited, ((CraftWorld)location.getWorld()).getHandle().dimension, packet);
	}
}

