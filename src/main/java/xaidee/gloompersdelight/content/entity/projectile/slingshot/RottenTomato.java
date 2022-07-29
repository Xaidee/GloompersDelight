package xaidee.gloompersdelight.content.entity.projectile.slingshot;

import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import quek.undergarden.entity.projectile.slingshot.SlingshotProjectile;
import vectorwing.farmersdelight.common.entity.RottenTomatoEntity;
import vectorwing.farmersdelight.common.registry.ModEntityTypes;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class RottenTomato extends SlingshotProjectile {

    public RottenTomato(Level world, double x, double y, double z) {
        super(ModEntityTypes.ROTTEN_TOMATO.get(), x, y, z, world);
    }

    public RottenTomato(Level world, LivingEntity shooter) {
        super(ModEntityTypes.ROTTEN_TOMATO.get(), shooter, world);
    }

    public RottenTomato(EntityType<RottenTomato> type, Level world) {
        super(type, world);
        this.setDropItem(false);
    }

    @Override
    protected Item getDefaultItem() {
        return ModItems.ROTTEN_TOMATO.get();
    }

    private ParticleOptions makeParticle() {
        return new ItemParticleOption(ParticleTypes.ITEM, new ItemStack(getDefaultItem()));
    }

    @Override
    public void handleEntityEvent(byte id) {
        if (id == 3) {
            ParticleOptions iparticledata = this.makeParticle();

            for (int i = 0; i < 8; ++i) {
                this.level.addParticle(iparticledata, this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() * 2.0 - 1.0) * 0.10000000149011612, ((double)this.random.nextFloat() * 2.0 - 1.0) * 0.10000000149011612 + 0.10000000149011612, ((double)this.random.nextFloat() * 2.0 - 1.0) * 0.10000000149011612);
            }
        }
    }

    /**
    * @see RottenTomatoEntity
    */

    @Override
    protected void onHitBlock(BlockHitResult result) {
        super.onHitBlock(result);
        if (!this.level.isClientSide && this.ricochetTimes == 0) {
            this.level.broadcastEntityEvent(this, (byte)3);
            this.playSound(ModSounds.ENTITY_ROTTEN_TOMATO_HIT.get(), 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        Entity entity = result.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), 0.0F);
        this.playSound(ModSounds.ENTITY_ROTTEN_TOMATO_HIT.get(), 1.0F, (this.random.nextFloat() - this.random.nextFloat()) * 0.2F + 1.0F);
    }
}
