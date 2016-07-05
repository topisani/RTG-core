package teamrtg.rtg.core.base.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.gen.ChunkProviderOverworld;

public class WorldTypeRTG extends WorldType {

    public WorldTypeRTG(String name) {
        super("RTGMod");
    }

    @Override
    public BiomeProvider getBiomeProvider(World world) {
        if (world.provider.getDimension() == 0) {
            return new BiomeProviderRTG(world, this);
        } else {
            return new BiomeProvider(world.getWorldInfo());
        }
    }

    @Override
    public IChunkGenerator getChunkGenerator(World world, String generatorOptions) {
        if (world.provider.getDimension() == 0) {
            return new ChunkProviderRTG(world, world.getSeed());
        } else {
            return new ChunkProviderOverworld(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions);
        }
    }

    @Override
    public float getCloudHeight() {
        return 256F;
    }
}
