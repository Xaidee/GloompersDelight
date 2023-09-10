package xaidee.gloompersdelight.content.item.tool;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import quek.undergarden.Undergarden;
import quek.undergarden.registry.UGEffects;
import quek.undergarden.registry.UGTags;
import xaidee.gloompersdelight.GloompersDelight;
import xaidee.gloompersdelight.content.index.GDItems;

@Mod.EventBusSubscriber(modid = GloompersDelight.MOD_ID)
public class GDToolEvents {

    @SubscribeEvent
    public static void forgottenAttackEvent(LivingHurtEvent event) {
        Entity source = event.getSource().getEntity();
        float damage = event.getAmount();

        if(source instanceof Player player) {
            if(player.getMainHandItem().getItem() == GDItems.FORGOTTEN_KNIFE.get()) {
                if (ForgeRegistries.ENTITY_TYPES.getKey(event.getEntity().getType()).getNamespace().equals(Undergarden.MODID) && !event.getEntity().getType().is(Tags.EntityTypes.BOSSES)) {
                    event.setAmount(damage * 1.5F);
                }
            }
        }
    }

    @SubscribeEvent
    public static void forgottenDigEvent(PlayerEvent.BreakSpeed event) {
        Player player = event.getEntity();
        BlockState state = event.getState();

        if(player.getMainHandItem().getItem() == GDItems.FORGOTTEN_KNIFE.get()) {
            if (state != null && ForgeRegistries.BLOCKS.getKey(state.getBlock()).getNamespace().equals(Undergarden.MODID)) {
                event.setNewSpeed(event.getOriginalSpeed() * 1.5F);
            }
        }
    }

    @SubscribeEvent
    public static void utheriumAttackEvent(LivingHurtEvent event) {
        Entity source = event.getSource().getEntity();
        float damage = event.getAmount();

        if(source instanceof Player player) {
            if(player.getMainHandItem().getItem() == GDItems.UTHERIUM_KNIFE.get()) {
                if (event.getEntity().getType().is(UGTags.Entities.ROTSPAWN)) {
                    event.setAmount(damage * 1.5F);
                }
            }
        }
    }

    @SubscribeEvent
    public static void froststeelAttackEvent(LivingHurtEvent event) {
        Entity source = event.getSource().getEntity();
        if(source instanceof Player player) {
            if(player.getMainHandItem().getItem() == GDItems.FROSTSTEEL_KNIFE.get()) {
                event.getEntity().addEffect(new MobEffectInstance(UGEffects.CHILLY.get(), 600, 1, false, false));
            }
        }
    }
}
