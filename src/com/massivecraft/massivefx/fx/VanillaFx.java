package com.massivecraft.massivefx.fx;

import java.util.Map;
import java.util.TreeMap;

import org.bukkit.Effect;
import org.bukkit.Location;

import com.massivecraft.massivefx.Const;


public class VanillaFx extends FxAbstract
{
	protected final Effect bukkitEffect;
	
	public VanillaFx(Effect bukkitEffect, String id, boolean visual, boolean sound, Map<String, Integer> alias2datas, String description, String... names)
	{
		super(id, visual, sound, alias2datas, description, names);
		this.bukkitEffect = bukkitEffect;
	}

	@Override
	public void playAt(Location location, int data)
	{
		location.getWorld().playEffect(location, this.bukkitEffect, data, Const.fxBlockViewDistanceLimited);
	}
	
	protected final static Map<String, Integer> recordAlias;
	protected final static Map<String, Integer> potionAlias;
	static
	{
		// Alias for Vanilla Fx
		recordAlias = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		recordAlias.put("13", 2256);
		recordAlias.put("cat", 2257);
		recordAlias.put("blocks", 2258);
		recordAlias.put("chirp", 2259);
		recordAlias.put("far", 2260);
		recordAlias.put("mall", 2261);
		recordAlias.put("mellohi", 2262);
		recordAlias.put("stal", 2263);
		recordAlias.put("strad", 2264);
		recordAlias.put("ward", 2265);
		recordAlias.put("11", 2266);
		
		potionAlias = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		potionAlias.put("blue", 0);
		potionAlias.put("ocean", 0);
		potionAlias.put("&b", 0);
		potionAlias.put("mundane", 0);
		potionAlias.put("noeffect", 0);

		potionAlias.put("lightpurple", 1);
		potionAlias.put("pink", 1);
		potionAlias.put("magenta", 1);
		potionAlias.put("&d", 1);
		potionAlias.put("regeneration", 1);
		potionAlias.put("regen", 1);

		potionAlias.put("skyblue", 2);
		potionAlias.put("lightblue", 2);
		potionAlias.put("iceblue", 2);
		potionAlias.put("speed", 2);

		potionAlias.put("orange", 3);
		potionAlias.put("gold", 3);
		potionAlias.put("&6", 3);
		potionAlias.put("fireresistance", 3);
		potionAlias.put("fireres", 3);

		potionAlias.put("darkgreen", 4);
		potionAlias.put("forestgreen", 4);
		potionAlias.put("green", 4);
		potionAlias.put("&2", 4);
		potionAlias.put("poison", 4);

		potionAlias.put("redstar", 5);
		potionAlias.put("red", 5);
		potionAlias.put("&c", 5);
		potionAlias.put("heal", 5);

		potionAlias.put("darkgrey", 8);
		potionAlias.put("darkgray", 8);
		potionAlias.put("&8", 8);
		potionAlias.put("darkgrey", 8);
		potionAlias.put("grey", 8);
		potionAlias.put("weakness", 8);

		potionAlias.put("darkred", 9);
		potionAlias.put("&4", 9);
		potionAlias.put("strength", 9);

		potionAlias.put("greyblue", 10);
		potionAlias.put("grayblue", 10);
		potionAlias.put("bluegray", 10);
		potionAlias.put("bluegrey", 10);
		potionAlias.put("grey", 10);
		potionAlias.put("gray", 10);
		potionAlias.put("&7", 10);
		potionAlias.put("slowness", 10);

		potionAlias.put("darkredstar", 12);
		potionAlias.put("&4", 12);
		potionAlias.put("damage", 12);
	}
	
	public static final VanillaFx CLICK2 = new VanillaFx(Effect.CLICK2, "VANILLA_CLICK2", false, true, null, "\"tock\" sound", "tock");
	public static final VanillaFx CLICK1 = new VanillaFx(Effect.CLICK1, "VANILLA_CLICK1", false, true, null, "\"tick\" sound", "tick", "click");
	public static final VanillaFx BOW_FIRE = new VanillaFx(Effect.BOW_FIRE, "VANILLA_BOW_FIRE", false, true, null, "Fire bow sound", "bow", "bowfire");
	public static final VanillaFx DOOR_TOGGLE = new VanillaFx(Effect.DOOR_TOGGLE, "VANILLA_DOOR_TOGGLE", false, true, null, "Toggle door sound", "door", "doortoggle");
	public static final VanillaFx EXTINGUISH = new VanillaFx(Effect.EXTINGUISH, "VANILLA_EXTINGUISH", false, true, null, "Extinguish fire sound", "ext", "extinguish");
	public static final VanillaFx RECORD_PLAY = new VanillaFx(Effect.RECORD_PLAY, "VANILLA_RECORD_PLAY", false, true, recordAlias, "Play record sound", "record", "recordplay");
	public static final VanillaFx GHAST_SHRIEK = new VanillaFx(Effect.GHAST_SHRIEK, "VANILLA_GHAST_SHRIEK", false, true, null, "Screaming ghast sound", "scream", "ghastshriek", "shriek", "schriek", "screem");
	public static final VanillaFx GHAST_SHOOT = new VanillaFx(Effect.GHAST_SHOOT, "VANILLA_GHAST_SHOOT", false, true, null, "Shoot fireball sound", "shoot", "ghastshoot");
	public static final VanillaFx BLAZE_SHOOT = new VanillaFx(Effect.BLAZE_SHOOT, "VANILLA_BLAZE_SHOOT", false, true, null, "Blaze shoot sound", "blazeshoot");
	public static final VanillaFx ZOMBIE_CHEW_WOODEN_DOOR = new VanillaFx(Effect.ZOMBIE_CHEW_WOODEN_DOOR, "VANILLA_ZOMBIE_CHEW_WOODEN_DOOR", false, true, null, "Chew wood sound", "wchew", "chew", "woodchew");
	public static final VanillaFx ZOMBIE_CHEW_IRON_DOOR = new VanillaFx(Effect.ZOMBIE_CHEW_IRON_DOOR, "VANILLA_ZOMBIE_CHEW_IRON_DOOR", false, true, null, "Chew iron sound", "ichew", "ironchew");
	public static final VanillaFx ZOMBIE_DESTROY_DOOR = new VanillaFx(Effect.ZOMBIE_DESTROY_DOOR, "VANILLA_ZOMBIE_DESTROY_DOOR", false, true, null, "Door break sound", "dbreak", "dbreak");
	public static final VanillaFx SMOKE = new VanillaFx(Effect.SMOKE, "VANILLA_SMOKE", true, false, null, "Tiny smoke particle", "tsmoke", "spart", "tinysmoke", "smokepart"); 
	public static final VanillaFx STEP_SOUND = new VanillaFx(Effect.STEP_SOUND, "VANILLA_STEP_SOUND", true, true, null, "Step sound and particles", "step", "stepsound");
	public static final VanillaFx POTION_BREAK = new VanillaFx(Effect.POTION_BREAK, "VANILLA_POTION_BREAK", true, true, potionAlias, "Potion break sound and particles", "potion", "potionbreak");
	public static final VanillaFx ENDER_SIGNAL = new VanillaFx(Effect.ENDER_SIGNAL, "VANILLA_ENDER_SIGNAL", true, false, null, "Ender signal particles", "ender", "endersignal", "nethersignal", "neathersignal", "netherparticles", "neatherparticles");
	public static final VanillaFx MOBSPAWNER_FLAMES = new VanillaFx(Effect.MOBSPAWNER_FLAMES, "VANILLA_MOBSPAWNER_FLAMES", true, false, null, "Mobspawner flame particles", "fire", "flames", "mobspawnerflames", "mobspawnerfire", "mobflames", "mobfire", "spawnerflames", "spawnerfire");
}

