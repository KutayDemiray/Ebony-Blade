package balbaros.ebonyblade.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockOre extends BlockBasic {
	
	static final int DEFAULT_MIN_DROP = 1;
	static final int DEFAULT_MAX_DROP = 1;
	
	public Item drop;
	public int minDrop;
	public int maxDrop;
	
	public BlockOre( String name, Material material, Item drop, int minDrop, int maxDrop ) {
		super(name, material);
		this.drop = drop;
		this.minDrop = minDrop;
		this.maxDrop = Math.max(minDrop, maxDrop);
	}
	
	public BlockOre( String name, Material material ) {
		this( name, material, null, DEFAULT_MIN_DROP, DEFAULT_MAX_DROP );
	}
	
	public BlockOre( String name, Material material, Item drop ) {
		this( name, material, drop, DEFAULT_MIN_DROP, DEFAULT_MAX_DROP );
	}
	
	@Override
	public Item getItemDropped( IBlockState state, Random random, int fortune ) {
		return drop==null?Item.getItemFromBlock( this ):drop;
	}
	
	@Override
	public int quantityDropped( Random random ) {
		return this.minDrop + random.nextInt( maxDrop - minDrop + 1 );
	}
	
	@Override
	public int quantityDroppedWithBonus( int fortune, Random random ) {
		
		if ( fortune > 0 && Item.getItemFromBlock( this ) != this.getItemDropped( this.getDefaultState(), random, fortune ) ) {
			
			int i = Math.max( random.nextInt( fortune + 2 ) - 1, 0 );
			
			return this.quantityDropped( random ) * ( i + 1 );
			
		}
		else {
			return this.quantityDropped( random );
		}
		
	}

}
