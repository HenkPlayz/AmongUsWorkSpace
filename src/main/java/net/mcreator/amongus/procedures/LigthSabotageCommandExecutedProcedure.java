package net.mcreator.amongus.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.amongus.AmongUsModElements;

import java.util.Map;

@AmongUsModElements.ModElement.Tag
public class LigthSabotageCommandExecutedProcedure extends AmongUsModElements.ModElement {
	public LigthSabotageCommandExecutedProcedure(AmongUsModElements instance) {
		super(instance, 4);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure LigthSabotageCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.BLINDNESS, (int) 200, (int) 2));
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 200, (int) 1));
	}
}
