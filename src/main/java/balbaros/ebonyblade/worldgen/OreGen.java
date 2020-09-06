package balbaros.ebonyblade.worldgen;

import java.util.Random;

import com.google.common.base.Predicate;

import balbaros.ebonyblade.init.ModBlocks;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class OreGen implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		
		switch( world.provider.getDimension() ) {
			// Nether
			case -1: {
				int blockAmount = 1 + random.nextInt(5);
				runGenerator( ModBlocks.eboniteOre.getDefaultState(), blockAmount, 10, 1, 256, BlockMatcher.forBlock( Blocks.NETHERRACK ), world,
						random, chunkX, chunkZ );
			}
			// Overworld
			case 0: {
				int blockAmount = 1 + random.nextInt(4);
				runGenerator( ModBlocks.eboniteOre.getDefaultState(), blockAmount, 5, 1, 15, BlockMatcher.forBlock( Blocks.STONE ), world,
						random, chunkX, chunkZ );
			}
			// End
			case 1: {
				break;
			}
			// Other dimensions
			default: {
				break;
			}
		}
		
	}
	
	private void runGenerator( IBlockState blockToGen, int blockAmount, int spawnChance, int minY, int maxY,
			Predicate<IBlockState> blockToReplace, World world, Random random, int chunkX, int chunkZ ) {
		if ( minY < 0 || maxY > 256 || minY > maxY ) {
			throw new IllegalArgumentException( "Illegal height arguments" );
		}
		
		WorldGenMinable generator = new WorldGenMinable( blockToGen, blockAmount, blockToReplace );
		
		int deltaY = maxY - minY + 1;
		
		for ( int i = 0; i < spawnChance; i++ ) {
			int x = chunkX * 16 + random.nextInt(16);
			int y = minY + random.nextInt(deltaY);
			int z = chunkZ * 16 + random.nextInt(16);
			
			generator.generate( world, random, new BlockPos( x, y, z ) );
		}
	}

}
