package balbaros.ebonyblade.init;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

import balbaros.ebonyblade.Reference;
import balbaros.ebonyblade.blocks.BlockBasic;

@Mod.EventBusSubscriber( modid = Reference.MOD_ID )
public class ModBlocks {
	
	static Block eboniteOre;
	static Item itemEboniteOre;
	
	public static void initBlocks() {
		eboniteOre = new BlockBasic( "ebonite_ore", Material.ROCK ).setCreativeTab( CreativeTabs.BUILDING_BLOCKS ).setHardness( 3.0f ).setLightLevel( 1.0f );
		eboniteOre.setHarvestLevel( "pickaxe", 3);
	}
	
	public static void initItemBlocks() {
		itemEboniteOre = new ItemBlock( eboniteOre ).setRegistryName( eboniteOre.getRegistryName() );
	}
	
	
	@SubscribeEvent
	public static void registerBlocks( RegistryEvent.Register<Block> event ) {
		IForgeRegistry<Block> r = event.getRegistry();
		r.register( eboniteOre );
	}
	
	// TODO doesn't work :(
	@SubscribeEvent
	public static void registerItemBlocks( RegistryEvent.Register<Item> event ) {
		IForgeRegistry<Item> r = event.getRegistry();
		
		r.register( new ItemBlock( eboniteOre ).setRegistryName( eboniteOre.getRegistryName() ) );
	}
	
	// TODO also doesn't work :(
	@SubscribeEvent
	public static void registerRenders( ModelRegistryEvent event ) {
		//for ( Block block : MOD_BLOCKS ) {
			Item itemEboniteOre = Item.getItemFromBlock( eboniteOre );
			ModelLoader.setCustomModelResourceLocation( itemEboniteOre, 0, new ModelResourceLocation( itemEboniteOre.getRegistryName(), "inventory" ) );
		//}
	}
	
	
	

}
