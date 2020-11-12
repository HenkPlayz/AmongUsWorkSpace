package net.mcreator.amongus.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.Direction;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.entity.player.PlayerEntity;

import net.mcreator.amongus.AmongUsModElements;

import java.util.Map;
import java.util.HashMap;

@AmongUsModElements.ModElement.Tag
public class EmergencyButtonUpdateTickProcedure extends AmongUsModElements.ModElement {
	public EmergencyButtonUpdateTickProcedure(AmongUsModElements instance) {
		super(instance, 3);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure EmergencyButtonUpdateTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure EmergencyButtonUpdateTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure EmergencyButtonUpdateTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure EmergencyButtonUpdateTick!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			TileEntity _ent = world.getTileEntity(new BlockPos((int) x, (int) (y + 1), (int) z));
			int _amount = (int) 100;
			if (_ent != null)
				_ent.getCapability(CapabilityEnergy.ENERGY, Direction.DOWN).ifPresent(capability -> capability.receiveEnergy(_amount, false));
		}
	}

	@SubscribeEvent
	public void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		PlayerEntity entity = event.getPlayer();
		if (event.getHand() != entity.getActiveHand())
			return;
		int i = event.getPos().getX();
		int j = event.getPos().getY();
		int k = event.getPos().getZ();
		World world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
