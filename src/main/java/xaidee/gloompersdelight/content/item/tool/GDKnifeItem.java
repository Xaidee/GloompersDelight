package xaidee.gloompersdelight.content.item.tool;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import quek.undergarden.registry.UGItemGroups;
import quek.undergarden.registry.UGItemTiers;
import quek.undergarden.registry.UGItems;
import vectorwing.farmersdelight.common.item.KnifeItem;
import xaidee.gloompersdelight.content.index.GDItemGroups;
import xaidee.gloompersdelight.content.index.GDItems;

import javax.annotation.Nullable;
import java.util.List;

public class GDKnifeItem extends KnifeItem {

    public GDKnifeItem(Tier tier, float attackDamage, float attackSpeed) {
        super(tier, attackDamage, attackSpeed, new Properties()
                .stacksTo(1)
                .defaultDurability(tier.getUses())
                .tab(GDItemGroups.GROUP)
                .rarity(isForgotten(tier))
        );
    }

    @Override
    public void appendHoverText(ItemStack stack, @Nullable Level world, List<Component> tooltip, TooltipFlag flag) {
        if(stack.getItem() == GDItems.UTHERIUM_KNIFE.get()) {
            tooltip.add(new TranslatableComponent("tooltip.utheric_sword").withStyle(ChatFormatting.RED));
        }
        if(stack.getItem() == GDItems.FROSTSTEEL_KNIFE.get()) {
            tooltip.add(new TranslatableComponent("tooltip.froststeel_sword").withStyle(ChatFormatting.AQUA));
        }
        if(stack.getItem() == GDItems.FORGOTTEN_KNIFE.get()) {
            tooltip.add(new TranslatableComponent("tooltip.forgotten_sword").withStyle(ChatFormatting.GREEN));
            tooltip.add(new TranslatableComponent("tooltip.forgotten_tool").withStyle(ChatFormatting.GREEN));
        }
    }

    public static Rarity isForgotten(Tier tier) {
        if (tier == UGItemTiers.FORGOTTEN) {
            return UGItems.FORGOTTEN;
        }
        return Rarity.COMMON;
    }
}
